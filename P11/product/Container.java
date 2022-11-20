package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Container {

    public Container(String name, String description, int maxScoops) {
        this.name = name;
        this.description = description;
        this.maxScoops = maxScoops;
    }

    public Container(BufferedReader in) throws IOException {
        name = in.readLine();
        description = in.readLine();
        maxScoops = Integer.parseInt(in.readLine());
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + name + "\n");
        out.write("" + description + "\n");
        out.write("" + maxScoops + "\n");
    }

    public int maxScoops() {
        return this.maxScoops;
    }

    @Override
    public String toString() {
        return "" + name + "(Max " + maxScoops + " Scoops)";
    }

    private String name;
    private String description;
    private int maxScoops;
}