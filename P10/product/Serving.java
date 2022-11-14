package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;

import product.Container;
import product.Scoop;
import product.MixIn;

public class Serving {
    
    public Serving() {
        this.container = null;
    }
    
    public Serving(Container container) {
        this.container = container;
    }
    
    public Serving(BufferedReader in) throws IOException {
        this.container = new Container(in);

        int arrayListNoOfElements = Integer.parseInt(in.readLine());
        for(int i = 0 ; i < arrayListNoOfElements ; i++) {
            addScoop(new Scoop(in));
        }

        arrayListNoOfElements = Integer.parseInt(in.readLine());
        for(int i = 0 ; i < arrayListNoOfElements ; i++) {
            addTopping(new MixIn(in));
        }
    }

    public void save(BufferedWriter out) throws IOException{
        container.save(out);

        out.write("" + scoop.size() + "\n");
        for (Scoop s : scoop) {
            s.save(out);
        }

        out.write("" + topping.size() + "\n");
        for (MixIn m : topping) {
            m.save(out);
        }
    }

    public void addScoop(Scoop scoop) {
        if(this.scoop == null) {
            this.scoop = new ArrayList<>();
        }
        this.scoop.add(scoop);
    }

    public void addTopping(MixIn topping) {
        if(this.topping == null) {
            this.topping = new ArrayList<>();
        }
        this.topping.add(topping);
    }

    @Override
    public String toString() {
        String toret = "";
        toret += container.toString() + " ";
        for(Scoop s : scoop) {
            toret += s.toString() + " ";
        }
        toret += "Toppings : ";
        for(MixIn m : topping) {
            toret += m.toString() + " ";
        }
        return toret;
    }
    
    private Container container;
    private ArrayList<Scoop> scoop;
    private ArrayList<MixIn> topping;
}
