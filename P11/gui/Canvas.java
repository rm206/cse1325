/***************************************************************************************
*    Baselined and modified

*    Title: Canvas
*    Author: George Rice
*    Date: 10/17/2022
*    Availability: https://github.com/prof-rice/cse1325-prof/15/code_from_slides/03-turtle/src/Canvas.java
*
***************************************************************************************/

package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Canvas extends JPanel {
    private final static int border = 25;

    public Canvas() {
        turtle = new Turtle();
        turtle.pen(Turtle.Pen.DOWN);

        for (int i = 1; i < 300; i += 1) {
            turtle.forward(i);
            turtle.turn(61);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(750, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle size = getBounds();
        g.translate(size.width / 2, size.height / 2);

        turtle.paintComponent(g);

        g.setFont(new Font("SansSerif", Font.BOLD, 50));
        g.drawString("Rishabh Mediratta", -215, 0);

        try {
            BufferedImage miceLogo = ImageIO.read(new File("gui/ice-cream-shop.png"));
            g.drawImage(miceLogo, -130, 230, null);
        } catch (IOException e) {
        }
    }

    private Turtle turtle;
}
