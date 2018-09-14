/*
 *
 * Application to illustrate Custom Colours
 * Uses RGB colour space to draw 25 rectangles across the screen
 *
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RGBFrame extends JFrame {

    public RGBFrame(int n) {
        JPanel p = new DrawingPanel(n);

        // add panel
        getContentPane().add(p);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class DrawingPanel extends JPanel {

    // number of rectangles to be drawn
    int n;

    // constructor
    public DrawingPanel(int n) {
        // set the background colour
        setBackground(Color.black);

        // set number of rectangles to be drawn
        this.n = n;
    }

    // in order for the layout manager to work
    // we have to override the getPreferredSize method
    public Dimension getPreferredSize() {
        setSize(400, 400);
        return getSize();
    }

    public void paintComponent(Graphics g) {
        // get current size of Gui
        Dimension d = getSize();

        // determine size of repeat unit
        int w = d.width / n;
        int h = d.height / n;

        // paint background
        super.paintComponent(g);

        // paint rectangles across screen
        int x, y;
        for (int i = 0; i < n; ++i) {
            g.setColor(colour(i, n));
            x = w * i;
            y = (int) (h * ((n - 1) / 2.0f));
            g.fillRect(x, y, w, h);
        }
    }

    private Color colour(int i, int n) {
        /*
         * this method uses the rgb color model to set the colour depending on
         * rati of i to n In this case only the green component is used
         * 
         */
        float r, g, b;
        r = 0.0f;
        g = (float) i / (float) n;
        b = 0.0f;
        return (new Color(r, g, b));

    }
}

public class SRGBColPanel {

    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // read in number of rectangles from command line
        int n = 0;
        boolean valid = true;
        System.out.println("How many rectangles?");
        do {
            try {
                n = new Integer(keyboard.readLine()).intValue();
                valid = true;
            }
            catch (NumberFormatException e) {
                System.out.println("please enter integer");
                valid = false;
            }
        } while (!valid);

        RGBFrame rgbGui = new RGBFrame(n);

        // set size of Gui
        rgbGui.setSize(500, 500);

        rgbGui.pack();

        // make Gui visible
        rgbGui.setVisible(true);
    }
}