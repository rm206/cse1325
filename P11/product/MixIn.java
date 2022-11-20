package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {

    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }

    public MixIn(BufferedReader in) throws IOException{
        this.flavor = new MixInFlavor(in);
        this.amount = MixInAmount.valueOf(in.readLine());
    }

    public void save(BufferedWriter out) throws IOException {
        flavor.save(out);
        out.write("" + amount + "\n");
    }

    @Override
    public String toString() {
        if (amount != MixInAmount.Normal) {
            return "" + flavor + "{" + amount + "}";
        }

        return "" + flavor;
    }

    public double price() {
        if (amount == MixInAmount.Light)
            return flavor.price() * 0.8;
        if (amount == MixInAmount.Extra)
            return flavor.price() * 1.2;
        if (amount == MixInAmount.Drenched)
            return flavor.price() * 2;
        return flavor.price();
    }
    
    private MixInFlavor flavor;
    private MixInAmount amount;
}
