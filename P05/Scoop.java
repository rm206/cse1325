import java.util.ArrayList;

public class Scoop {
    
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
    }
    
    public void addMixIn(MixIn mixin) {
        if(mixins.isEmpty()) {
            mixins = new ArrayList<>();
        }
        mixins.add(mixin);
    }

    @Override
    public String toString() {
        if (!mixins.isEmpty()) {
            String toReturn = flavor + " with ";
            for (MixIn m : mixins) {
                toReturn += "" + m + " ";
            }
            return toReturn;
        }

        return "" + flavor;
    }
    
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}
