package emporium;

import java.util.ArrayList;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class Emporium {
    
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
        return mixInFlavors.toArray();
    }

    public Object[] iceCreamFlavors() {
        return iceCreamFlavors.toArray();
    }

    public Object[] scoops() {
        return scoops.toArray();
    }
    
    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Scoop> scoops;
}