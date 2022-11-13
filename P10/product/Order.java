package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
    
    public Order(BufferedReader in) throws IOException {
        int noOfServings = Integer.parseInt(in.readLine());
        for(int i = 0 ; i < noOfServings ; i++) {
            servings.add(new Serving(in));
        }
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + servings.size() + "\n");
        for(Serving s : servings) {
            s.save(out);
        }
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    private ArrayList<Serving> servings;
}
