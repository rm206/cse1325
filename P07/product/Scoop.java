package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Scoop {
    
    public Scoop() {
        this.flavor = null;
    }
    
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
    }

    public Scoop (BufferedReader in) throws IOException{
        flavor = new IceCreamFlavor(in);
        int arrayListNoOfElements = Integer.parseInt(in.readLine());
        for(int i = 0 ; i < arrayListNoOfElements ; i++) {
            addMixIn(new MixIn(in));
        }
    }
    
    public void addMixIn(MixIn mixin) {
        if(mixins == null) {
            mixins = new ArrayList<>();
        }
        mixins.add(mixin);
    }

    public void save(BufferedWriter out) throws IOException{
        flavor.save(out);
        out.write("" + mixins.size() + "\n");
        for (MixIn m : mixins) {
            m.save(out);
        }
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