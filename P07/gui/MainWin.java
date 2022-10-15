package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;
import javax.imageio.ImageIO;

import emporium.Emporium;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class MainWin extends JFrame {

    public MainWin(String MainWintitle) {

        super(MainWintitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu view = new JMenu("View");
        JMenuItem viewIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMixInFlavor = new JMenuItem("Mix In Flavor");
        JMenuItem viewScoop = new JMenuItem("Scoop");

        JMenu create = new JMenu("Create");
        JMenuItem createIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixInFlavor = new JMenuItem("Mixin Flavor");
        JMenuItem createScoop = new JMenuItem("Scoop");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());

        viewIceCreamFlavor.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMixInFlavor.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewScoop.addActionListener(event -> view(Screen.SCOOPS));

        createIceCreamFlavor.addActionListener(event -> onCreateIceCreamFlavorClcik());
        createMixInFlavor.addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());

        about.addActionListener(event -> onAboutClick());

        file.add(quit);

        view.add(viewIceCreamFlavor);
        view.add(viewMixInFlavor);
        view.add(viewScoop);

        create.add(createIceCreamFlavor);
        create.add(createMixInFlavor);
        create.add(createScoop);

        help.add(about);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        add(display, BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar("Tool bar");

        // <a href="https://www.flaticon.com/free-icons/save" title="save icons">Save icons created by Yogi Aprelliyanto - Flaticon</a>
        Image saveButtonIcon = null;
        try {
            saveButtonIcon = ImageIO.read(getClass().getResource("/gui/saveButtonIcon.png"));
        }
        catch (IOException i) {
            ;
        }
        finally {            
            JButton saveButton = new JButton();
            saveButton.setActionCommand("Save");
            saveButton.setToolTipText("Save");
            saveButton.setIcon(new ImageIcon(saveButtonIcon));
            saveButton.setBorder(null);
            saveButton.setPreferredSize(new Dimension(32,32));
            saveButton.addActionListener(event -> onSaveClick());
            toolbar.add(saveButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        /* 
        This dosen't work
        saveButton = new JButton(new ImageIcon("saveButtonIcon.png"));
        saveButton.setActionCommand("Save");
        saveButton.setToolTipText("Save");
        saveButton.setPreferredSize(new Dimension(32,32));
        toolbar.add(saveButton);
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();
        */

        // <a href="https://www.flaticon.com/free-icons/save" title="save icons">Save icons created by Freepik - Flaticon</a>
        Image saveAsButtonIcon = null;
        try {
            saveAsButtonIcon = ImageIO.read(getClass().getResource("/gui/saveAsButtonIcon.png"));
        }
        catch (IOException i) {
            ;
        }
        finally {            
            JButton saveAsButton = new JButton();
            saveAsButton.setActionCommand("Save As");
            saveAsButton.setToolTipText("Save As");
            saveAsButton.setIcon(new ImageIcon(saveAsButtonIcon));
            saveAsButton.setBorder(null);
            saveAsButton.setPreferredSize(new Dimension(32,32));
            saveAsButton.addActionListener(event -> onSaveAsClick());
            toolbar.add(saveAsButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        // <a href="https://www.flaticon.com/free-icons/open-folder" title="open folder icons">Open folder icons created by Freepik - Flaticon</a>
        Image openButtonIcon = null;
        try {
            openButtonIcon = ImageIO.read(getClass().getResource("/gui/openButtonIcon.png"));
        }
        catch (IOException i) {
            ;
        }
        finally {            
            JButton openButton = new JButton();
            openButton.setActionCommand("Save As");
            openButton.setToolTipText("Save As");
            openButton.setIcon(new ImageIcon(openButtonIcon));
            openButton.setBorder(null);
            openButton.setPreferredSize(new Dimension(32,32));
            openButton.addActionListener(event -> onOpenClick());
            toolbar.add(openButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        // <a href="https://www.flaticon.com/free-icons/ice-cream" title="ice cream icons">Ice cream icons created by Freepik - Flaticon</a>
        // create ice cream flavor

        // <a href="https://www.flaticon.com/free-icons/syrup" title="syrup icons">Syrup icons created by surang - Flaticon</a>
        // create mix in flavors

        // <a href="https://www.flaticon.com/free-icons/scoop" title="scoop icons">Scoop icons created by kornkun - Flaticon</a>
        // create scoop flavors

        // <a href="https://www.flaticon.com/free-icons/dessert" title="dessert icons">Dessert icons created by berkahicon - Flaticon</a>
        // view ice cream flavors

        // <a href="https://www.flaticon.com/free-icons/topping" title="topping icons">Topping icons created by Freepik - Flaticon</a>
        // view mix in flavors

        // <a href="https://www.flaticon.com/free-icons/food-and-restaurant" title="food and restaurant icons">Food and restaurant icons created by Freepik - Flaticon</a>
        // view scoops

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        setVisible(true);
    }

    public void onQuitClick() {
        System.exit(0);
    }

    public void onCreateIceCreamFlavorClcik() {
        class createIceCreamFlavorDialog extends JDialog {
            private final static int width = 400;
            private final static int height = 400;

            private boolean canceled;

            private JTextField nameOfFlavor;
            private JTextField descriptionOfFlavor;
            private JTextField priceOfFlavor;
            private JTextField costOfFlavor;

            createIceCreamFlavorDialog(Frame aFrame) {
                super(aFrame, "Create Ice Cream Flavor", true);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                canceled = true;
                setSize(width, height);
                setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 1;
                constraints.weighty = 0;
                constraints.insets = new Insets(2, 5, 2, 5);
                constraints.fill = GridBagConstraints.BOTH;
                constraints.anchor = GridBagConstraints.LINE_START;
                GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
                constraintsLabel.weightx = 0;

                JLabel name = new JLabel("Name");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 0;
                add(name, constraintsLabel);
                nameOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.weighty = 1;
                add(nameOfFlavor, constraints);

                JLabel description = new JLabel("Description");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 1;
                add(description, constraintsLabel);
                descriptionOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weighty = 1;
                add(descriptionOfFlavor, constraints);

                JLabel price = new JLabel("Price");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 2;
                add(price, constraintsLabel);
                priceOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.weighty = 1;
                add(priceOfFlavor, constraints);

                JLabel cost = new JLabel("Cost");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 3;
                add(cost, constraintsLabel);
                costOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 3;
                constraints.weighty = 1;
                add(costOfFlavor, constraints);

                JPanel panel = new JPanel();
                JButton okButton = new JButton("OK");
                okButton.addActionListener(event -> {
                    canceled = false;
                    setVisible(false);
                });
                panel.add(okButton);

                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(event -> {
                    canceled = true;
                    setVisible(false);
                });
                panel.add(cancelButton);

                constraints.gridx = 0;
                constraints.gridy = 4;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                add(panel, constraints);

                pack();
                setVisible(true);
                emporium.addIceCreamFlavor(
                        new product.IceCreamFlavor(nameOfFlavor.getText(), descriptionOfFlavor.getText(),
                                Integer.valueOf(priceOfFlavor.getText()), Integer.valueOf(costOfFlavor.getText())));
                view(Screen.ICE_CREAM_FLAVORS);
            }

        }
        createIceCreamFlavorDialog cicfd = new createIceCreamFlavorDialog(this);
    }

    public void onCreateMixInFlavorClick() {
        class createMixInFlavorDialog extends JDialog {
            private final static int width = 400;
            private final static int height = 400;

            private boolean canceled;

            private JTextField nameOfFlavor;
            private JTextField descriptionOfFlavor;
            private JTextField priceOfFlavor;
            private JTextField costOfFlavor;

            createMixInFlavorDialog(Frame aFrame) {
                super(aFrame, "Create MixIn Flavor", true);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                canceled = true;
                setSize(width, height);
                setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 1;
                constraints.weighty = 0;
                constraints.insets = new Insets(2, 5, 2, 5);
                constraints.fill = GridBagConstraints.BOTH;
                constraints.anchor = GridBagConstraints.LINE_START;
                GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
                constraintsLabel.weightx = 0;

                JLabel name = new JLabel("Name");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 0;
                add(name, constraintsLabel);
                nameOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.weighty = 1;
                add(nameOfFlavor, constraints);

                JLabel description = new JLabel("Description");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 1;
                add(description, constraintsLabel);
                descriptionOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weighty = 1;
                add(descriptionOfFlavor, constraints);

                JLabel price = new JLabel("Price");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 2;
                add(price, constraintsLabel);
                priceOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.weighty = 1;
                add(priceOfFlavor, constraints);

                JLabel cost = new JLabel("Cost");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 3;
                add(cost, constraintsLabel);
                costOfFlavor = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 3;
                constraints.weighty = 1;
                add(costOfFlavor, constraints);

                JPanel panel = new JPanel();
                JButton okButton = new JButton("OK");
                okButton.addActionListener(event -> {
                    canceled = false;
                    setVisible(false);
                });
                panel.add(okButton);

                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(event -> {
                    canceled = true;
                    setVisible(false);
                });
                panel.add(cancelButton);

                constraints.gridx = 0;
                constraints.gridy = 4;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.CENTER;
                add(panel, constraints);

                pack();
                setVisible(true);
                emporium.addMixInFlavor(
                        new product.MixInFlavor(nameOfFlavor.getText(), descriptionOfFlavor.getText(),
                                Integer.valueOf(priceOfFlavor.getText()), Integer.valueOf(costOfFlavor.getText())));
                view(Screen.MIX_IN_FLAVORS);
            }

        }
        createMixInFlavorDialog cminfd = new createMixInFlavorDialog(this);
    }

    public void onCreateScoopClick() {
        product.Scoop scoopToAdd = new product.Scoop(null);
        product.IceCreamFlavor iceCreamFlavorForScoop = (product.IceCreamFlavor) JOptionPane.showInputDialog(
                this,
                "Pick Ice Cream flavor",
                "New Scoop",
                JOptionPane.QUESTION_MESSAGE,
                null,
                emporium.iceCreamFlavors(),
                null);
        if (iceCreamFlavorForScoop != null) {
            scoopToAdd = new Scoop(iceCreamFlavorForScoop);
        }
        if (iceCreamFlavorForScoop != null) {
            product.MixInFlavor mixInFlavorForScoop = null;
            do {
                mixInFlavorForScoop = (product.MixInFlavor) JOptionPane.showInputDialog(
                        this,
                        "Pick Mix In flavor",
                        "New Scoop",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        emporium.mixInFlavors(),
                        null);
                if (mixInFlavorForScoop != null) {
                    product.MixInAmount mixInAmountForScoop = (product.MixInAmount) JOptionPane.showInputDialog(
                            this,
                            "Pick Mix In Amount",
                            "New Scoop",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            product.MixInAmount.values(),
                            null);

                    product.MixIn mixInForScoop = new product.MixIn(mixInFlavorForScoop, mixInAmountForScoop);
                    scoopToAdd.addMixIn(mixInForScoop);
                }

            } while (mixInFlavorForScoop != null);

            if (scoopToAdd != null)
                emporium.addScoop(scoopToAdd);
        }
        view(Screen.SCOOPS);
    }

    public void onAboutClick() {
        String onAboutString = "<HTML>" +
        "<h1><p style=\"text-align:center\">MAVS Ice Cream Emporium</p><h1>"+
        "<h3><p style=\"text-align:center\">Copyright 2022 by Rishabh Mediratta<p></h3>"+
        "</HTML>";
        JOptionPane.showMessageDialog(this, onAboutString, "About MICE", JOptionPane.PLAIN_MESSAGE, null);
    }

    public void onSaveClick() {
        ;
    }

    public void onSaveAsClick() {
        ;
    }

    public void onOpenClick() {
        ;
    }

    private void view(Screen screen) {
        String to_display_string_1 = new String("");
        String to_display_string_2 = new String("");

        if (screen == Screen.ICE_CREAM_FLAVORS) {
            to_display_string_1 = "";
            to_display_string_2 = "";
            to_display_string_1 += "<HTML><h1>ICE CREAM FLAVORS</h1><br/>";
            if (emporium.iceCreamFlavors() != null)
                for (int i = 0; i < emporium.iceCreamFlavors().length; i++) {
                    to_display_string_2 += String.format("<h2>%s</h2>", (emporium.iceCreamFlavors()[i]).toString());
                }
            to_display_string_2 += "</HTML>";
            display.setText(to_display_string_1 + to_display_string_2);
        }
        if (screen == Screen.MIX_IN_FLAVORS) {
            to_display_string_1 = "";
            to_display_string_2 = "";
            to_display_string_1 += "<HTML><h1>MIXIN FLAVORS</h1><br/>";
            if (emporium.mixInFlavors() != null)
                for (int i = 0; i < emporium.mixInFlavors().length; i++) {
                    to_display_string_2 += String.format("<h2>%s</h2>", (emporium.mixInFlavors()[i]).toString());
                }
            to_display_string_2 += "</HTML>";
            display.setText(to_display_string_1 + to_display_string_2);
        }

        if (screen == Screen.SCOOPS) {
            to_display_string_1 = "";
            to_display_string_2 = "";
            to_display_string_1 += "<HTML><h1>SCOOPS</h1><br/>";
            if (emporium.scoops() != null)
                for (int i = 0; i < emporium.scoops().length; i++) {
                    to_display_string_2 += String.format("<h2>%s</h2>", (emporium.scoops()[i]).toString());
                }
            to_display_string_2 += "</HTML>";
            display.setText(to_display_string_1 + to_display_string_2);
        }
    }

    private enum Screen {
        ICE_CREAM_FLAVORS,
        MIX_IN_FLAVORS,
        SCOOPS
    }

    private JLabel display = new JLabel();

    private Emporium emporium = new Emporium();

    JButton saveButton;
    // JButton saveAsButton;

}