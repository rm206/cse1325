import java.util.Objects;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Polynomial{
    public static boolean log = false;   // Set true to print log messages
    private static Object lock1 = new Object();

        public static void LOG(String s) {
            synchronized(lock1) {
                if(log) System.err.println("==> " + s);
            }
        }

    public Polynomial(double ... d) { // accept any number of parameters into d[]
        if(d.length % 2 > 0) throw new RuntimeException("Odd number of Polynomial parameters: " + d.length);
        for(int i=0; i<d.length; i += 2) addTerm(d[i], d[i+1]); 
    }
    
    public Polynomial(BufferedReader br) throws IOException {
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) terms.add(new Term(br));
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + terms.size() + "\n");
        for(Term term : terms) term.save(bw);
    }

    public void addTerm(double coefficient, double exponent) {
        terms.add(new Term(coefficient, exponent));
    }

    public double eval(double x) {
        double y = 0;
        for(Term term : terms) y += term.eval(x);
        return y;
    }

    public void solve(double min, double max, int nthreads, double slices, double precision) {
        roots.clear();
        // solveRecursive(min, max, 1, slices, precision, 0);
        if (nthreads == 1) {
            solveRecursive(min, max, 1, slices, precision, 0);
        }
        else {
            try {
                Thread[] threads = new Thread[nthreads];
                for(int i=0; i< nthreads; ++i) {
                    final double minIn = min + (i * (max-min) / 10);
                    final double maxIn = min + ((i+1) * (max-min) / 10);
                    final int threadIDIn = i;
                    final double slicesIn = slices/nthreads;
                    final double precisionIn = precision;
                    threads[i] = new Thread(() -> solveRecursive(minIn, maxIn, threadIDIn, slicesIn, precisionIn, 0));
                    threads[i].start();
                }
                for(int i=0; i< nthreads; ++i) {
                    threads[i].join();
                }
            }
            catch (InterruptedException e) {
                System.err.println("Abort: " + e);
            }
        }
    }

    public Object[] roots() {
        return roots.toArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Term term : terms) sb.append(term.toString());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(o.getClass() != getClass()) return false;
        Polynomial p = (Polynomial) o;
        if(p.terms.size() != this.terms.size()) return false;
        for(int i=0; i<terms.size(); ++i)
            if(!p.terms.get(i).equals(terms.get(i))) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms);
    }

    private static final double MAX_RECURSIONS = 20;

    private void solveRecursive(double min, double max, int threadID, double slices, double precision, int recursion) {
        LOG("ThreadID " + threadID + " recursion " + recursion + " at [" + min + "," + max + "]");    
        double delta = (max - min) / slices;
        double x1 = min;
        double y1 = eval(min);
        double x2 = x1 + delta;
        double y2;

        while(x1 < max) {
            y2 = eval(x2);
            if(Math.signum(y1) != Math.signum(y2)) {
                if((Math.abs(eval(x1+x2)/2) > precision) && (Math.abs(x2 - x1) > precision) && (recursion < MAX_RECURSIONS)) {
                    solveRecursive(x1, x2, threadID, Math.min(slices, (x2-x1)/precision), precision, recursion+1); // recurse for more precision
                } else {
                    synchronized(lock1) {
                        roots.add((x1+x2)/2);
                    }
                }
            }
            x1 = x2; 
            x2 = x1 + delta;
            y1 = y2;
        }
    }

    private ArrayList<Term> terms = new ArrayList<>();
    private ArrayList<Double> roots = new ArrayList<>();
    
}
