package emporium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class Emporium {

    public Emporium() {
        ;
    }

    public Emporium(BufferedReader in) throws IOException {
        int temp = Integer.parseInt(in.readLine());
        System.out.println("before mixin reading number of mixin flavors = " + temp);
        for (int j = 0; j < temp; j++) {
            System.out.println("starting mix in reading");
            addMixInFlavor(new MixInFlavor(in));
        }

        temp = Integer.parseInt(in.readLine());
        System.out.println("before icecream flavor reading number of icecream flavors = " + temp);
        for (int j = 0; j < temp; j++) {
            System.out.println("starting icecream flavior reading");
            addIceCreamFlavor(new IceCreamFlavor(in));
        }

        temp = Integer.parseInt(in.readLine());
        System.out.println("before scoops reading number of scoops = " + temp);
        for (int j = 0; j < temp; j++) {
            System.out.println("starting scoops readin");
            addScoop(new Scoop(in));
        }
    }

    public void save(BufferedWriter out) throws IOException {
        if (mixInFlavors.size() > 0) {
            out.write("" + mixInFlavors.size() + "\n");
            for (product.MixInFlavor m : mixInFlavors) {
                m.save(out);
            }
        }

        if (iceCreamFlavors.size() > 0) {
            out.write("" + iceCreamFlavors.size() + "\n");
            for (product.IceCreamFlavor i : iceCreamFlavors) {
                i.save(out);
            }
        }

        if (scoops.size() > 0) {
            out.write("" + scoops.size() + "\n");
            for (product.Scoop s : scoops) {
                s.save(out);
            }
        }
    }

    public void addMixInFlavor(MixInFlavor flavor) {
        if (mixInFlavors == null)
            mixInFlavors = new ArrayList<>();
        mixInFlavors.add(flavor);
    }

    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        if (iceCreamFlavors == null)
            iceCreamFlavors = new ArrayList<>();
        iceCreamFlavors.add(flavor);
    }

    public void addScoop(Scoop scoop) {
        if (scoops == null)
            scoops = new ArrayList<>();
        scoops.add(scoop);
    }

    public Object[] mixInFlavors() {
        if (mixInFlavors == null)
            return null;
        return mixInFlavors.toArray();
    }

    public Object[] iceCreamFlavors() {
        if (iceCreamFlavors == null)
            return null;
        return iceCreamFlavors.toArray();
    }

    public Object[] scoops() {
        if (scoops == null)
            return null;
        return scoops.toArray();
    }

    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Scoop> scoops;
}
