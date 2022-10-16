package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class MixInFlavor extends Item {

    public MixInFlavor(String name, String description, int cost, int price) {
        super(name, description, cost, price);
    }

    // public MixInFlavor(BufferedReader in) {
    //     ;
    // }

    public void save(BufferedWriter out) {
        ;
    }
}