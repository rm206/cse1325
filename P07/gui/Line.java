/***************************************************************************************
*    Baselined and modified

*    Title: Canvas
*    Author: George Rice
*    Date: 10/17/2022
*    Availability: https://github.com/prof-rice/cse1325-prof/15/code_from_slides/03-turtle/src/Line.java
*
***************************************************************************************/

package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;

public class Line {
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.BLACK);
        colorList.add(Color.ORANGE);
        colorList.add(Color.RED);
    }

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public void paintComponent(Graphics g) {
        g.setColor(colorList.get(rand.nextInt(colorList.size())));
        g.drawLine(x1, y1, x2, y2);
    }

    private ArrayList<Color> colorList = new ArrayList<>(); 
    Random rand = new Random();
}
