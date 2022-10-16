package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Scoop {
    
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
    }

    // public Scoop (BufferedReader in) {
    //     ;
    // }
    
    public void addMixIn(MixIn mixin) {
        if(mixins == null) {
            mixins = new ArrayList<>();
        }
        mixins.add(mixin);
    }

    public void save(BufferedWriter out) {
        ;
    }

    @Override
    public String toString() {
        if (mixins != null) {
            String toReturn = flavor + " with ";
            for (MixIn m : mixins) {
                toReturn += "" + m + " ";
            }
            return toReturn;
        }

        else
            return "" + flavor;
    }
    
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}