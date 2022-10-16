package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class MixIn {

    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }

    public MixIn(BufferedReader in) {
        ;
    }

    public void save(BufferedWriter out) {
        ;
    }

    @Override
    public String toString() {
        if (amount != MixInAmount.Normal) {
            return "" + flavor + "{" + amount + "}";
        }

        return "" + flavor;
    }
    
    private MixInFlavor flavor;
    private MixInAmount amount;
}
