package emporium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Container;
import product.Order;

public class Emporium {

    public Emporium() {
        ;
    }

    public Emporium(BufferedReader in) throws IOException {
        int temp = Integer.parseInt(in.readLine());
        for (int j = 0; j < temp; j++) {
            addMixInFlavor(new MixInFlavor(in));
        }

        temp = Integer.parseInt(in.readLine());
        for (int j = 0; j < temp; j++) {
            addIceCreamFlavor(new IceCreamFlavor(in));
        }

        temp = Integer.parseInt(in.readLine());
        for (int j = 0; j < temp; j++) {
            addContainer(new Container(in));
        }

        temp = Integer.parseInt(in.readLine());
        for (int j = 0; j < temp; j++) {
            addOrder(new Order(in));
        }
    }

    public void save(BufferedWriter out) throws IOException {
        if (mixInFlavors.size() > 0) {
            out.write("" + mixInFlavors.size() + "\n");
            for (product.MixInFlavor m : mixInFlavors) {
                m.save(out);
            }
        }

        if (iceCreamFlavors.size() > 0) {
            out.write("" + iceCreamFlavors.size() + "\n");
            for (product.IceCreamFlavor i : iceCreamFlavors) {
                i.save(out);
            }
        }

        if (containers.size() > 0) {
            out.write("" + containers.size() + "\n");
            for (product.Container c : containers) {
                c.save(out);
            }
        }

        if (orders.size() > 0) {
            out.write("" + orders.size() + "\n");
            for (product.Order o : orders) {
                o.save(out);
            }
        }
    }

    public void addMixInFlavor(MixInFlavor flavor) {
        if (mixInFlavors == null)
            mixInFlavors = new ArrayList<>();
        mixInFlavors.add(flavor);
    }

    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        if (iceCreamFlavors == null)
            iceCreamFlavors = new ArrayList<>();
        iceCreamFlavors.add(flavor);
    }

    public void addContainer(Container container) {
        if (containers == null)
            containers = new ArrayList<>();
        containers.add(container);
    }

    public void addOrder(Order order) {
        if (orders == null)
            orders = new ArrayList<>();
        orders.add(order);
    }

    public Object[] mixInFlavors() {
        if (mixInFlavors == null)
            return null;
        return mixInFlavors.toArray();
    }

    public Object[] iceCreamFlavors() {
        if (iceCreamFlavors == null)
            return null;
        return iceCreamFlavors.toArray();
    }

    public Object[] containers() {
        if (containers == null)
            return null;
        return containers.toArray();
    }

    public Object[] orders() {
        if(orders == null)
            return null;
        return orders.toArray();
    }

    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Container> containers;
    private ArrayList<Order> orders;
}
