package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

import emporium.Emporium;

public class MainWin extends JFrame {

    public MainWin(String MainWintitle) {

        super(MainWintitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

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

        quit.addActionListener(event -> onQuitClick());

        viewIceCreamFlavor.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMixInFlavor.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewScoop.addActionListener(event -> view(Screen.SCOOPS));

        createIceCreamFlavor.addActionListener(event -> onCreateIceCreamFlavorClcik());
        createMixInFlavor.addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());

        file.add(quit);

        view.add(viewIceCreamFlavor);
        view.add(viewMixInFlavor);
        view.add(viewScoop);

        create.add(createIceCreamFlavor);
        create.add(createMixInFlavor);
        create.add(createScoop);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);

        setJMenuBar(menubar);

        add(display, BorderLayout.CENTER);

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

    }

    private void view(Screen screen) {
        String to_display_string = new String("");
        if (screen == Screen.ICE_CREAM_FLAVORS)
            for (Object i : emporium.iceCreamFlavors())
                to_display_string += i.toString()+"\n";
            display.setText("<HTML><h1>ICE CREAM FLAVORS</h1></HTML>\n" + to_display_string);
        if (screen == Screen.MIX_IN_FLAVORS)
            display.setText("mxiin");
        if (screen == Screen.SCOOPS)
            display.setText("Scoops");
    }

    private enum Screen {
        ICE_CREAM_FLAVORS,
        MIX_IN_FLAVORS,
        SCOOPS
    }

    private JLabel display = new JLabel();

    private Emporium emporium = new Emporium();

}

// // ///////////// //////////////////////////////////////////////////////////
// // T O O L B A R
// // Add a toolbar to the PAGE_START region below the menu
// JToolBar toolbar = new JToolBar("Nim Controls");

// // Add a New Game stock icon
// JButton anewB = new JButton(UIManager.getIcon("FileView.fileIcon"));
// anewB.setActionCommand("New Game");
// anewB.setToolTipText("Create a new game, discarding any in progress");
// anewB.setBorder(null);
// toolbar.add(anewB);
// anewB.addActionListener(event -> onNewGameClick());

// // A "horizontal strut" is just a space of the specified pixel width
// toolbar.add(Box.createHorizontalStrut(25));

// // Create the 3 buttons using the icons provided
// button1 = new JButton(new ImageIcon("button1.png"));
// button1.setActionCommand("Select one stick");
// button1.setToolTipText("Select one stick");
// toolbar.add(button1);
// button1.addActionListener(event -> onButtonClick(1));

// button2 = new JButton(new ImageIcon("button2.png"));
// button2.setActionCommand("Select two sticks");
// button2.setToolTipText("Select two sticks");
// toolbar.add(button2);
// button2.addActionListener(event -> onButtonClick(2));

// button3 = new JButton(new ImageIcon("button3.png"));
// button3.setActionCommand("Select three sticks");
// button3.setToolTipText("Select three sticks");
// toolbar.add(button3);
// button3.addActionListener(event -> onButtonClick(3));

// toolbar.add(Box.createHorizontalStrut(25));

// // Create a toggle button to enable or disable the computer player
// computerPlayer = new JToggleButton(new ImageIcon("freepik_robot.png"));
// computerPlayer.setActionCommand("Enable computer player");
// computerPlayer.setToolTipText("Enable for computer to be Player 2");
// computerPlayer.setBorder(null);
// toolbar.add(computerPlayer);
// computerPlayer.addActionListener(event -> onComputerPlayerClick());

// // "Horizontal glue" expands as much as possible, pushing the "X" to the
// right
// toolbar.add(Box.createHorizontalGlue());

// // Create a custom Quit button (not available in Swing stock icons)
// JButton quitB = new JButton("X");
// quitB.setActionCommand("Quit");
// quitB.setToolTipText("Exit game");
// quitB.setBorder(null);
// toolbar.add(quitB);
// quitB.addActionListener(event -> onQuitClick());
// toolbar.addSeparator();

// getContentPane().add(toolbar, BorderLayout.PAGE_START);

// // /////////////////////////// ////////////////////////////////////////////
// // S T I C K S D I S P L A Y
// // Provide a text entry box to show the remaining sticks
// sticks = new JLabel();
// sticks.setFont(new Font("SansSerif", Font.BOLD, 18));
// add(sticks, BorderLayout.CENTER);

// // S T A T U S B A R D I S P L A Y ////////////////////////////////////
// // Provide a status bar for game messages
// msg = new JLabel();
// add(msg, BorderLayout.PAGE_END);

// protected void onAboutClick() { // Display About dialog
// JDialog about = new JDialog();
// about.setLayout(new FlowLayout());
// about.setTitle("The Game of Nim");

// try {
// BufferedImage myPicture = ImageIO.read(new
// File("128px-Pyramidal_matches.png"));
// JLabel logo = new JLabel(new ImageIcon(myPicture));
// about.add(logo);
// } catch (IOException e) {
// }

// JLabel title = new JLabel("<html>"
// + "<p><font size=+4>Nim</font></p>"
// + "</html>");
// about.add(title);

// JLabel artists = new JLabel("<html>"
// + "<p>Version 1.3J</p>"
// + "<p>Copyright 2017-2020 by George F. Rice</p>"
// + "<p>Licensed under Gnu GPL 3.0</p>"
// + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
// + "<p><font
// size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
// + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial
// purposes with attribution</p>"
// + "<p><font
// size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
// + "</html>");
// about.add(artists);

// JButton ok = new JButton("OK");
// ok.addActionListener(event -> about.setVisible(false));
// about.add(ok);

// about.setSize(450, 400);
// about.setVisible(true);
// }
