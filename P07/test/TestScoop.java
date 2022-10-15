package test;

import product.IceCreamFlavor; 
import product.MixInFlavor; 
import product.MixInAmount; 
import product.MixIn; 
import product.Scoop;

public class TestScoop {

    public static void main(String[] args) {
        try {
            IceCreamFlavor flavor = new IceCreamFlavor("Vanilla", "Luscious creamy vanilla bean ice cream", 195, 35);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            MixInFlavor mixInFlavor = new MixInFlavor("Snickers", "Moderately chopped Snickers bars", 99, 35);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Scoop scoop = new Scoop(new IceCreamFlavor("Vanilla", "Luscious creamy vanilla bean ice cream", 195, 35));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Scoop scoop = new Scoop(new IceCreamFlavor("Vanilla", "Luscious creamy vanilla bean ice cream", 195, 35));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Scoop scoop = new Scoop(new IceCreamFlavor("Vanilla", "Luscious creamy vanilla bean ice cream", 195, 35));
            scoop.addMixIn(new MixIn(new MixInFlavor("Snickers", "Moderately chopped Snickers bars", 99, 35), MixInAmount.Extra));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            Scoop scoop = new Scoop(new IceCreamFlavor("Vanilla", "Luscious creamy vanilla bean ice cream", 195, 35));
            scoop.addMixIn(new MixIn(new MixInFlavor("Snickers", "Moderately chopped Snickers bars", 99, 35), MixInAmount.Extra));
            scoop.addMixIn(new MixIn(new MixInFlavor("Chocolate Chips", "Mini chips of semi-sweet chocolate", 79, 24), MixInAmount.Normal));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}