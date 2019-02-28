

/*
 This file can be donwloaded from -  https://github.com/hogum/underG/archive/master.zip

 How to run this file
    - Load it up in your IDE, save and run the MAIN
      method present.
    - Alternatively, if you are a fan of the terminal
    run:  $ javac GridBoxes.java
          $ java createGUI

*/

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBoxes extends JPanel {
    /*
    Creates a GUI panel that uses Graphics to fill
    a line grid.

    * This child is the Panel *container* in which we shall draw the grids
    * in.
    * */

    private int panelWidth;
    private int panelHeight;
    private int gridRows, gridColumns;
    private int rowCount;

    public GridBoxes(int width, int height, int rowNumber, int columnNumber) {
        this.setSize(width, height); // Allow user to specify a preferred panel size
        this.gridRows = rowNumber; // Number of grid Rows
        this.gridColumns = columnNumber; // number of grid columns
    }

    @Override
    public void paint(Graphics g) {
        /*
        * Uses the Graphics abstract class to draw the
        * required grid lines on the panel/
        * */

        // To start drawing grids (x1, y1, x2, y2)
        // we use dimension of the panel
        // Get its width and height

        panelWidth = super.getSize().width;
        panelHeight = super.getSize().height;

        // Divide the height of the panel
        // into an equal number of the columns
        // we want to add

        int heightCount = panelHeight / gridRows;

        // Loop through the "subdivided panel"
        // drawing a vertical line in each
        for (int i = 0; i <= gridRows; i++) {
            /*
            * Draws the rows (Horizontal Lines)
            * */

            // Change the drawline color to blue
            g.setColor(Color.BLUE);
            // x axis do not change
            // Lines are drawn from left to right of the panel
            // Hence x1 = 0 and x2 = "panelWidth"(rightMostSide of the panel)

            g.drawLine(0, i * heightCount, panelWidth, i * heightCount);
        }

        //"Subdivide" the panel again to equal size of
        // the columns to draw.

        rowCount = panelWidth / gridColumns;
        for (int i = 0; i <= gridColumns; i++) {
            /*
            * Loop through again. This time drawing the VERTICAL LINES
            * */

            g.setColor(Color.RED); // Chage graphics color to red

            // The y axis remains constant
            // Lines are drawn from the top to the bottom of the panel

            g.drawLine(i * rowCount, 0, i * rowCount, panelHeight);
        }
    }

}
    class createGUI extends JFrame {
        public createGUI(String name) {
            // Pass in frame title in when calling child class
            super(name);
        }

        public void setFrame() {
            // Create the frame
            // and add the "now drawn" panel

            // Here's where we pass in the number for grid rows and columns
            super.getContentPane().add(new GridBoxes(200, 200, 7, 7));
            super.setSize(600, 500);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setVisible(true);
        }

        public static void main(String[] args) {
            new createGUI("Lincoln's Grid").setFrame();
        }
    }
