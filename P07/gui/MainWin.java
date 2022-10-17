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

import emporium.Emporium;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class MainWin extends JFrame {

    public MainWin(String MainWintitle) {

        super(MainWintitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

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
        JMenuItem viewScoop = new JMenuItem("Scoop");

        JMenu create = new JMenu("Create");
        JMenuItem createIceCreamFlavor = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMixInFlavor = new JMenuItem("Mixin Flavor");
        JMenuItem createScoop = new JMenuItem("Scoop");

        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        open.addActionListener(event -> onOpenClick());

        viewIceCreamFlavor.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMixInFlavor.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewScoop.addActionListener(event -> view(Screen.SCOOPS));

        createIceCreamFlavor.addActionListener(event -> onCreateIceCreamFlavorClcik());
        createMixInFlavor.addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());

        about.addActionListener(event -> onAboutClick());

        file.add(save);
        file.add(saveAs);
        file.add(open);
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

        Image createScoopButtonIcon = null;
        try {
            createScoopButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/createScoopButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            createScoopButton = new JButton();
            createScoopButton.setActionCommand("Create Scoop");
            createScoopButton.setToolTipText("Create Scoop");
            createScoopButton.setIcon(new ImageIcon(createScoopButtonIcon));
            createScoopButton.setBorder(null);
            createScoopButton.setPreferredSize(new Dimension(32, 32));
            createScoopButton.addActionListener(event -> onCreateScoopClick());
            createScoopButton.setEnabled(false);
            toolbar.add(createScoopButton);
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

        Image viewScoopsButtonIcon = null;
        try {
            viewScoopsButtonIcon = ImageIO
                    .read(getClass().getResource("/gui/viewScoopsButtonIcon.png"));
        } catch (IOException i) {
            ;
        } finally {
            viewScoopsButton = new JButton();
            viewScoopsButton.setActionCommand("View Scoops");
            viewScoopsButton.setToolTipText("View Scoops");
            viewScoopsButton.setIcon(new ImageIcon(viewScoopsButtonIcon));
            viewScoopsButton.setBorder(null);
            viewScoopsButton.setPreferredSize(new Dimension(32, 32));
            viewScoopsButton.addActionListener(event -> view(Screen.SCOOPS));
            toolbar.add(viewScoopsButton);
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
                    createScoopButton.setEnabled(emporium.iceCreamFlavors() != null);
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

    public void onCreateScoopClick() {
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
                emporium.addScoop(scoopToAdd);
        }
        view(Screen.SCOOPS);
    }

    public void onAboutClick() {
        String onAboutString = "<HTML>" +
                "<body style=\"text-align : center\">" +
                "<h1><p>MAVS Ice Cream Emporium</p><h1>" +
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
                "</body>" +
                "</HTML>";

        JOptionPane.showMessageDialog(this, onAboutString, "About MICE", JOptionPane.PLAIN_MESSAGE, null);
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
                if (!magicCookie.equals(MAGIC_COOKIE))
                    throw new RuntimeException("Not a MICE file");
                String fileVersion = br.readLine();
                if (!fileVersion.equals(FILE_VERSION))
                    throw new RuntimeException("Incompatible MICE file format");

                emporium = new Emporium(br);
                view(Screen.SCOOPS);
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

    private JButton saveButton;
    private JButton saveAsButton;
    private JButton openButton;
    private JButton createIceCreamFlavorButton;
    private JButton createMixInFlavorButton;
    private JButton createScoopButton;
    private JButton viewIceCreamFlavorsButton;
    private JButton viewMixInFlavorsButton;
    private JButton viewScoopsButton;

    private File filename;
    private String FILE_VERSION = "1.0";
    private String MAGIC_COOKIE = "ICECREAMYUMYUM";
}