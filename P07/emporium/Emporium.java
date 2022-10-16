package emporium;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.ArrayList;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class Emporium {
    
    public Emporium() {
        ;
    }

    public Emporium(BufferedReader in) {
        ;
    }

    public void save(BufferedWriter out) {
        ;
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
