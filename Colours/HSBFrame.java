/*
 *
 * Application to illustrate Custom Colours
 * Uses HSB colour space to draw rectangles 
 * across the screen
 *
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class HSBFrame extends JFrame {

    // number of rectangles to be drawn
    int n;

    // constructor
    public HSBFrame(int n) {

        // add panel
        getContentPane().add(new HSBPanel(n));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}

class HSBPanel extends JPanel {

    // number of rectangles to be drawn
    int n;

    // constructor
    public HSBPanel(int n) {
        // set the background colour
        setBackground(Color.black);

        // set number of rectangles to be drawn
        this.n = n;
    }

    public void paintComponent(Graphics g) {
        // get current size of Gui
        Dimension d = getSize();

        // determine size of repeat
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
         * this method uses the hsb color model to set the colour depending on
         * ratio of i to n
         * 
         * hue h is specified here between 0.0 and 1.0 this gives a colour on
         * the colour wheel between red at 0.0 ( = 0 degrees on the wheel) and
         * red again at 1.0 ( = 360 degrees on the wheel)
         * 
         * saturation s is in the range 0.0 to 1.0 corresponding to the %
         * difference from neutral grey
         * 
         * brightness is ialso between 0.0 and 1.0 this gives the % illumination
         * 
         */

        float h, s, b;
        h = (float) i / (float) n;
        s = 1.0f;
        b = 1.0f;
        return (Color.getHSBColor(h, s, b));
    }
}

public class SHSBColPanel {

    static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // read in number of rectangles
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

        HSBFrame hsbGui = new HSBFrame(n);
        // set size of Gui
        hsbGui.setSize(500, 500);

        // make Gui visible
        hsbGui.setVisible(true);
    }
}