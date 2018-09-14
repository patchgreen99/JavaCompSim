/*
 *
 * Application to illustrate use of JPanel
 * for custom painting
 *
 */

import java.awt.*;
import javax.swing.*;

class PaintPanel extends JPanel {

    public PaintPanel() {
    }

    // do custom painting in the paintComponent method
    public void paintComponent(Graphics g) {
        // paint background
        super.paintComponent(g);

        // draw circle
        g.setColor(Color.red);
        g.fillOval(75, 75, 50, 50);
    }
}

class MyFrame extends JFrame {

    // constructor
    public MyFrame() {
        // panel for custom painting
        PaintPanel painting = new PaintPanel();

        // Add panel to content pane
        getContentPane().add(painting);

    }
}

class SPaint {

    public static void main(String[] args) {
        MyFrame m = new MyFrame();
        // set size of GUI
        m.setSize(200, 200);

        // and make it visible
        m.setVisible(true);
    }
}

