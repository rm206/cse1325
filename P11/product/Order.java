package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import person.Customer;

public class Order {

    public Order() {
        servings = null;
        customer = null;
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(BufferedReader in) throws IOException {
        int noOfServings = Integer.parseInt(in.readLine());
        for (int i = 0; i < noOfServings; i++) {
            addServing(new Serving(in));
        }
        customer = new Customer(in);
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + servings.size() + "\n");
        for (Serving s : servings) {
            s.save(out);
        }
    }

    public void addServing(Serving serving) {
        if (servings == null)
            servings = new ArrayList<>();
        servings.add(serving);
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        String toret = "";

        if (servings != null) {
            for (Serving s : servings)
                toret += s.toString() + "\n";
            toret += "Total price : ";
            toret += this.price();
        }

        if (customer != null)
            toret += customer.toString();
        
        return toret;
    }

    public double price() {
        double totalPrice = 0;

        if (servings != null)
            for (Serving s : servings)
                totalPrice += s.price();

        return totalPrice;
    }

    private ArrayList<Serving> servings;
    private Customer customer;
}
