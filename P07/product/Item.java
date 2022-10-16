package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Item {

    public Item(String name, String description, int cost, int price) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
    }

    public Item(BufferedReader in) {
        ;
    }

    public void save(BufferedWriter out) {
        ;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public int price() {
        return this.price;
    }

    public int cost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private String name;
    private String description;
    private int cost;
    private int price;
}
