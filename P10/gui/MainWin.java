package gui;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.management.RuntimeErrorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BoxLayout;
import emporium.Emporium;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;
import product.Order;
import product.Container;
import product.Serving;

public class MainWin extends JFrame {

    public MainWin(String MainWintitle) {

        super(MainWintitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        filename = new File("untitled.mice");

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");

        JMenu view = new JMenu("View");
        JMenuItem viewIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMixInFlavor = new JMenuItem("Mix In Flavor");

        JMenu create = new JMenu("Create");
        JMenuItem createIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixInFlavor = new JMenuItem("Mixin Flavor");
        JMenuItem createOrder = new JMenuItem("Order");
        JMenuItem createContainer = new JMenuItem("Container");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        open.addActionListener(event -> onOpenClick());

        viewIceCreamFlavor.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMixInFlavor.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        createIceCreamFlavor.addActionListener(event -> onCreateIceCreamFlavorClcik());
        createMixInFlavor.addActionListener(event -> onCreateMixInFlavorClick());
        createOrder.addActionListener(event -> onCreateOrderClick());
        createContainer.addActionListener(event -> onCreateContainerClick());

        about.addActionListener(event -> onAboutClick());

        file.add(save);
        file.add(saveAs);
        file.add(open);
        file.add(quit);

        view.add(viewIceCreamFlavor);
        view.add(viewMixInFlavor);

        create.add(createIceCreamFlavor);
        create.add(createMixInFlavor);
        create.add(createOrder);
        create.add(createContainer);

        help.add(about);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        add(display, BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar("Tool bar");

        Image saveButtonIcon = null;
        try {
            saveButtonIcon = ImageIO.read(getClass().getResource("/gui/saveButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            saveButton = new JButton();
            saveButton.setActionCommand("Save File");
            saveButton.setToolTipText("Save File");
            saveButton.setIcon(new ImageIcon(saveButtonIcon));
            saveButton.setBorder(null);
            saveButton.setPreferredSize(new Dimension(32, 32));
            saveButton.addActionListener(event -> onSaveClick());
            toolbar.add(saveButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        /*
         * This dosen't work
         * 
         * saveButton = new JButton(new ImageIcon("saveButtonIcon.png"));
         * saveButton.setActionCommand("Save");
         * saveButton.setToolTipText("Save");
         * saveButton.setPreferredSize(new Dimension(32,32));
         * toolbar.add(saveButton);
         * toolbar.add(Box.createHorizontalStrut(25));
         * toolbar.addSeparator();
         */

        Image saveAsButtonIcon = null;
        try {
            saveAsButtonIcon = ImageIO.read(getClass().getResource("/gui/saveAsButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            saveAsButton = new JButton();
            saveAsButton.setActionCommand("Save File As");
            saveAsButton.setToolTipText("Save File As");
            saveAsButton.setIcon(new ImageIcon(saveAsButtonIcon));
            saveAsButton.setBorder(null);
            saveAsButton.setPreferredSize(new Dimension(32, 32));
            saveAsButton.addActionListener(event -> onSaveAsClick());
            toolbar.add(saveAsButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image openButtonIcon = null;
        try {
            openButtonIcon = ImageIO.read(getClass().getResource("/gui/openButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            openButton = new JButton();
            openButton.setActionCommand("Open File");
            openButton.setToolTipText("Open File");
            openButton.setIcon(new ImageIcon(openButtonIcon));
            openButton.setBorder(null);
            openButton.setPreferredSize(new Dimension(32, 32));
            openButton.addActionListener(event -> onOpenClick());
            toolbar.add(openButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image createIceCreamFlavorButtonIcon = null;
        try {
            createIceCreamFlavorButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/createIceCreamFlavorButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            createIceCreamFlavorButton = new JButton();
            createIceCreamFlavorButton.setActionCommand("Create Ice Cream Flavor");
            createIceCreamFlavorButton.setToolTipText("Create Ice Cream Flavor");
            createIceCreamFlavorButton.setIcon(new ImageIcon(createIceCreamFlavorButtonIcon));
            createIceCreamFlavorButton.setBorder(null);
            createIceCreamFlavorButton.setPreferredSize(new Dimension(32, 32));
            createIceCreamFlavorButton.addActionListener(event -> onCreateIceCreamFlavorClcik());
            toolbar.add(createIceCreamFlavorButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image createMixInFlavorButtonIcon = null;
        try {
            createMixInFlavorButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/createMixInFlavorButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            createMixInFlavorButton = new JButton();
            createMixInFlavorButton.setActionCommand("Create MixIn Flavor");
            createMixInFlavorButton.setToolTipText("Create MixIn Flavor");
            createMixInFlavorButton.setIcon(new ImageIcon(createMixInFlavorButtonIcon));
            createMixInFlavorButton.setBorder(null);
            createMixInFlavorButton.setPreferredSize(new Dimension(32, 32));
            createMixInFlavorButton.addActionListener(event -> onCreateMixInFlavorClick());
            toolbar.add(createMixInFlavorButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image createContainerButtonIcon = null;
        try {
            createContainerButtonIcon = ImageIO.read(getClass().getResource("/gui/createContainerButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            createContainerButton = new JButton();
            createContainerButton.setActionCommand("Create Container");
            createContainerButton.setToolTipText("Create Container");
            createContainerButton.setIcon(new ImageIcon(createContainerButtonIcon));
            createContainerButton.setBorder(null);
            createContainerButton.setPreferredSize(new Dimension(32, 32));
            createContainerButton.addActionListener(event -> onCreateContainerClick());
            toolbar.add(createContainerButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image createOrderButtonIcon = null;
        try {
            createOrderButtonIcon = ImageIO.read(getClass().getResource("/gui/createOrderButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            createOrderButton = new JButton();
            createOrderButton.setActionCommand("Create Order");
            createOrderButton.setToolTipText("Create Order");
            createOrderButton.setIcon(new ImageIcon(createOrderButtonIcon));
            createOrderButton.setBorder(null);
            createOrderButton.setPreferredSize(new Dimension(32, 32));
            createOrderButton.addActionListener(event -> onCreateOrderClick());
            toolbar.add(createOrderButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image viewIceCreamFlavorsButtonIcon = null;
        try {
            viewIceCreamFlavorsButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/viewIceCreamFlavorsButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            viewIceCreamFlavorsButton = new JButton();
            viewIceCreamFlavorsButton.setActionCommand("View Ice Cream Flavors");
            viewIceCreamFlavorsButton.setToolTipText("View Ice Cream Flavors");
            viewIceCreamFlavorsButton.setIcon(new ImageIcon(viewIceCreamFlavorsButtonIcon));
            viewIceCreamFlavorsButton.setBorder(null);
            viewIceCreamFlavorsButton.setPreferredSize(new Dimension(32, 32));
            viewIceCreamFlavorsButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
            toolbar.add(viewIceCreamFlavorsButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image viewMixInFlavorsButtonIcon = null;
        try {
            viewMixInFlavorsButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/viewMixInFlavorsButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            viewMixInFlavorsButton = new JButton();
            viewMixInFlavorsButton.setActionCommand("View MixInFlavors");
            viewMixInFlavorsButton.setToolTipText("View MixIn Flavors");
            viewMixInFlavorsButton.setIcon(new ImageIcon(viewMixInFlavorsButtonIcon));
            viewMixInFlavorsButton.setBorder(null);
            viewMixInFlavorsButton.setPreferredSize(new Dimension(32, 32));
            viewMixInFlavorsButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
            toolbar.add(viewMixInFlavorsButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image viewContainerButtonIcon = null;
        try {
            viewContainerButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/viewContainerButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            viewContainerButton = new JButton();
            viewContainerButton.setActionCommand("View Containers");
            viewContainerButton.setToolTipText("View Containers");
            viewContainerButton.setIcon(new ImageIcon(viewContainerButtonIcon));
            viewContainerButton.setBorder(null);
            viewContainerButton.setPreferredSize(new Dimension(32, 32));
            viewContainerButton.addActionListener(event -> view(Screen.CONTAINERS));
            toolbar.add(viewContainerButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

        Image viewOrderButtonIcon = null;
        try {
            viewOrderButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/viewOrderButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            viewOrderButton = new JButton();
            viewOrderButton.setActionCommand("View Orders");
            viewOrderButton.setToolTipText("View Orders");
            viewOrderButton.setIcon(new ImageIcon(viewOrderButtonIcon));
            viewOrderButton.setBorder(null);
            viewOrderButton.setPreferredSize(new Dimension(32, 32));
            viewOrderButton.addActionListener(event -> view(Screen.ORDERS));
            toolbar.add(viewOrderButton);
        }
        toolbar.add(Box.createHorizontalStrut(25));
        toolbar.addSeparator();

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
                nameOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.weighty = 1;
                add(nameOfFlavor, constraints);

                JLabel description = new JLabel("Description");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 1;
                add(description, constraintsLabel);
                descriptionOfFlavor = new JTextField(20);
                descriptionOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weighty = 1;
                add(descriptionOfFlavor, constraints);

                JLabel price = new JLabel("Price");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 2;
                add(price, constraintsLabel);
                priceOfFlavor = new JTextField(20);
                priceOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.weighty = 1;
                add(priceOfFlavor, constraints);

                JLabel cost = new JLabel("Cost");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 3;
                add(cost, constraintsLabel);
                costOfFlavor = new JTextField(20);
                costOfFlavor.setText("");
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
                if (!canceled && !nameOfFlavor.getText().equals("") && !descriptionOfFlavor.getText().equals("") &&
                        !priceOfFlavor.getText().equals("") && !costOfFlavor.getText().equals("")) {
                    emporium.addIceCreamFlavor(
                            new product.IceCreamFlavor(nameOfFlavor.getText(), descriptionOfFlavor.getText(),
                                    Integer.valueOf(priceOfFlavor.getText()),
                                    Integer.valueOf(costOfFlavor.getText())));
                    createOrderButton.setEnabled(emporium.iceCreamFlavors() != null);
                }
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
                nameOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.weighty = 1;
                add(nameOfFlavor, constraints);

                JLabel description = new JLabel("Description");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 1;
                add(description, constraintsLabel);
                descriptionOfFlavor = new JTextField(20);
                descriptionOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weighty = 1;
                add(descriptionOfFlavor, constraints);

                JLabel price = new JLabel("Price");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 2;
                add(price, constraintsLabel);
                priceOfFlavor = new JTextField(20);
                priceOfFlavor.setText("");
                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.weighty = 1;
                add(priceOfFlavor, constraints);

                JLabel cost = new JLabel("Cost");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 3;
                add(cost, constraintsLabel);
                costOfFlavor = new JTextField(20);
                costOfFlavor.setText("");
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
                if (!canceled && !nameOfFlavor.getText().equals("") && !descriptionOfFlavor.getText().equals("") &&
                        !priceOfFlavor.getText().equals("") && !costOfFlavor.getText().equals("")) {
                    emporium.addMixInFlavor(
                            new product.MixInFlavor(nameOfFlavor.getText(), descriptionOfFlavor.getText(),
                                    Integer.valueOf(priceOfFlavor.getText()),
                                    Integer.valueOf(costOfFlavor.getText())));
                }
                view(Screen.MIX_IN_FLAVORS);
            }

        }
        createMixInFlavorDialog cminfd = new createMixInFlavorDialog(this);
    }

    public product.Scoop onCreateScoop() {
        product.Scoop scoopToAdd = new product.Scoop();
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
                return scoopToAdd;
        }

        return null;
    }

    public void onCreateContainerClick() {
        class createContainerDialog extends JDialog {
            private final static int width = 400;
            private final static int height = 400;

            private boolean canceled;

            private JTextField nameOfContainer;
            private JTextField descriptionOfContainer;
            private JTextField maxscoops;

            createContainerDialog(Frame aFrame) {
                super(aFrame, "Create Container", true);
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
                nameOfContainer = new JTextField(20);
                nameOfContainer.setText("");
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.weighty = 1;
                add(nameOfContainer, constraints);

                JLabel description = new JLabel("Description");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 1;
                add(description, constraintsLabel);
                descriptionOfContainer = new JTextField(20);
                descriptionOfContainer.setText("");
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weighty = 1;
                add(descriptionOfContainer, constraints);

                JLabel price = new JLabel("Max Scoops");
                constraintsLabel.gridx = 0;
                constraintsLabel.gridy = 2;
                add(price, constraintsLabel);
                maxscoops = new JTextField(20);
                maxscoops.setText("");
                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.weighty = 1;
                add(maxscoops, constraints);

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
                if (!canceled && !nameOfContainer.getText().equals("") && !descriptionOfContainer.getText().equals("")
                        &&
                        !maxscoops.getText().equals("")) {
                    emporium.addContainer(
                            new product.Container(nameOfContainer.getText(), descriptionOfContainer.getText(),
                                    Integer.valueOf(maxscoops.getText())));
                }
                view(Screen.CONTAINERS);
            }

        }
        createContainerDialog ccd = new createContainerDialog(this);
    }

    public product.Serving onCreateServingClick() {
        product.Serving servingToAdd = new product.Serving();
        product.Container containerForServing = (product.Container) JOptionPane.showInputDialog(
                this,
                "Pick Container",
                "New Serving",
                JOptionPane.QUESTION_MESSAGE,
                null,
                emporium.containers(),
                null);
        if (containerForServing != null) {
            servingToAdd = new Serving(containerForServing);
        }
        if (containerForServing != null) {
            ArrayList<product.Scoop> scoopForServingList = new ArrayList<>();
            product.Scoop scoopForServing = null;
            do {
                scoopForServing = onCreateScoop();
                if(scoopForServing != null)
                    scoopForServingList.add(scoopForServing);
            } while (scoopForServing != null);

            if (scoopForServingList.size() > 0) {
                for (product.Scoop s : scoopForServingList) {
                    servingToAdd.addScoop(s);
                }

                product.MixInFlavor toppingMixInFlavorForServing = null;
                do {
                    toppingMixInFlavorForServing = (product.MixInFlavor) JOptionPane.showInputDialog(
                            this,
                            "Pick Mix In flavor for topping in serving",
                            "New Serving",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            emporium.mixInFlavors(),
                            null);
                    if (toppingMixInFlavorForServing != null) {
                        product.MixInAmount toppingMixInAmountForServing = (product.MixInAmount) JOptionPane.showInputDialog(
                                this,
                                "Pick Mix In Amount for toppin in serving",
                                "New Serving",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                product.MixInAmount.values(),
                                null);
    
                        product.MixIn mixInForScoop = new product.MixIn(toppingMixInFlavorForServing, toppingMixInAmountForServing);
                        servingToAdd.addTopping(mixInForScoop);
                    }
    
                } while (toppingMixInFlavorForServing != null);

                return servingToAdd;
            }
        }

        return null;
    }

    public void onCreateOrderClick() {
        product.Serving tempServing = null;
        product.Order orderToAdd = null;
        do {
            tempServing = onCreateServingClick();
            if(tempServing != null) {
                if (orderToAdd == null)
                    orderToAdd = new Order();
                orderToAdd.addServing(tempServing);
            }
        } while(tempServing != null);

        if (orderToAdd != null)
            emporium.addOrder(orderToAdd);
    }

    public void onAboutClick() {
        String onAboutString = "<HTML>" +
                "<body style=\"text-align : center\">" +
                "<div style=\"font-size : 20px\"><h1><p><b>MAVS Ice Cream Emporium<b></p><h1></div>" +
                "<h3><p>Copyright 2022 by Rishabh Mediratta<p></h3>" +
                "<a href=\"https://www.flaticon.com/free-icons/save\" title=\"save icons\">Save icons created by Yogi Aprelliyanto - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/save\" title=\"save icons\">Save icons created by Freepik - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/open-folder\" title=\"open folder icons\">Open folder icons created by Freepik - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/ice-cream\" title=\"ice cream icons\">Ice cream icons created by Freepik - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/syrup\" title=\"syrup icons\">Syrup icons created by surang - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/scoop\" title=\"scoop icons\">Scoop icons created by kornkun - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/dessert\" title=\"dessert icons\">Dessert icons created by berkahicon - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/dessert\" title=\"dessert icons\">Dessert icons created by berkahicon - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/topping\" title=\"topping icons\">Topping icons created by Freepik - Flaticon</a>"
                +
                "<br/>" +
                "<a href=\"https://www.flaticon.com/free-icons/food-and-restaurant\" title=\"food and restaurant icons\">Food and restaurant icons created by Freepik - Flaticon</a>"
                +
                "<a href=\"https://www.flaticon.com/free-icons/ice-cream-shop\" title=\"ice cream shop icons\">Ice cream shop icons created by Smashicons - Flaticon</a>"
                +
                "<a href=\"https://www.flaticon.com/free-icons/stock\" title=\"stock icons\">Stock icons created by Freepik - Flaticon</a>"
                +
                "<a href=\"https://www.flaticon.com/free-icons/ice-cream\" title=\"ice cream icons\">Ice cream icons created by amonrat rungreangfangsai - Flaticon</a>"
                +
                "</body>" 
                +
                "</HTML>";

        JDialog about = new JDialog(this, "About MICE");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
        about.add(new Canvas());
        // try {
        // BufferedImage miceLogo = ImageIO.read(new File("gui/ice-cream-shop.png"));
        // about.add(new JLabel(new ImageIcon(miceLogo), JLabel.CENTER));
        // } catch(IOException e) {
        // }
        about.add(new JLabel(onAboutString, JLabel.CENTER));
        about.add(Box.createVerticalStrut(10));
        about.pack();
        about.setVisible(true);
    }

    public void onOpenClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter miceFiles = new FileNameExtensionFilter("Mice files", "mice");
        fc.addChoosableFileFilter(miceFiles);
        fc.setFileFilter(miceFiles);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if (!magicCookie.equals(MAGIC_COOKIE)) {
                    throw new RuntimeException("Not a MICE file");
                }
                String fileVersion = br.readLine();
                if (!fileVersion.equals(FILE_VERSION))
                    throw new RuntimeException("Incompatible MICE file format");

                emporium = new Emporium(br);
                view(Screen.ICE_CREAM_FLAVORS);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cannot open " + filename + '\n' + e, "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            emporium.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot open " + filename + '\n' + e, "Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter miceFiles = new FileNameExtensionFilter("Mice files", "mice");
        fc.addChoosableFileFilter(miceFiles);
        fc.setFileFilter(miceFiles);

        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();
            if (!filename.getAbsolutePath().endsWith(".mice"))
                filename = new File(filename.getAbsolutePath() + ".mice");
            onSaveClick();
        }
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
        if (screen == Screen.CONTAINERS) {
            to_display_string_1 = "";
            to_display_string_2 = "";
            to_display_string_1 += "<HTML><h1>CONTAINERS</h1><br/>";
            if (emporium.containers() != null)
                for (int i = 0; i < emporium.containers().length; i++) {
                    to_display_string_2 += String.format("<h2>%s</h2>", (emporium.containers()[i]).toString());
                }
            to_display_string_2 += "</HTML>";
            display.setText(to_display_string_1 + to_display_string_2);
        }
        if (screen == Screen.ORDERS) {
            to_display_string_1 = "";
            to_display_string_2 = "";
            to_display_string_1 += "<HTML><h1>ORDERS</h1><br/>";
            if (emporium.orders() != null)
                for (int i = 0; i < emporium.orders().length; i++) {
                    to_display_string_2 += String.format("<h2>%s</h2>", (emporium.orders()[i]).toString());
                }
            to_display_string_2 += "</HTML>";
            display.setText(to_display_string_1 + to_display_string_2);
        }
    }

    private enum Screen {
        ICE_CREAM_FLAVORS,
        MIX_IN_FLAVORS,
        CONTAINERS,
        ORDERS
    }

    private JLabel display = new JLabel();

    private Emporium emporium = new Emporium();

    private JButton saveButton;
    private JButton saveAsButton;
    private JButton openButton;
    private JButton createIceCreamFlavorButton;
    private JButton createMixInFlavorButton;
    private JButton createContainerButton;
    private JButton createOrderButton;
    private JButton viewIceCreamFlavorsButton;
    private JButton viewMixInFlavorsButton;
    private JButton viewOrderButton;
    private JButton viewContainerButton;

    private File filename;
    private String FILE_VERSION = "1.0";
    private String MAGIC_COOKIE = "ICECREAMYUMYUM";
}