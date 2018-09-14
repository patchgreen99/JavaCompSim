/*
 *
 * Application to illustrate the use of the repaint method
 *
 * It draws a circle and moves it across the screen
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class AnimPanel extends JPanel {

    // size of frame
    int X = 300;
    int Y = 300;

    // size of circle
    int w = 20;
    int h = 20;

    // initial co-ordinates of circle
    int x = 0;
    int y = Y / 2;

    public AnimPanel() {
        setBackground(Color.blue);
    }

    // over-ride paintComponent() method of JFrame class to paint
    // graphics objects
    public void paintComponent(Graphics g) {
        // paint the background
        super.paintComponent(g);
        // Draw a circle on the screen
        g.setColor(Color.yellow);
        g.fillOval(x, y, w, h);
    }

    // get x coord for painting on JLabel
    public int getx() {
        return x;
    }

    public void moveCircle() {
        // size and width of frame
        Dimension d = getSize();
        int W = d.width;
        // increment for moving circle on screen
        int incr = 3;
        // calculate new x co-ordinates for circle
        if (x < W) {
            x += incr;
        }
        else {
            x = 0;
        }
        // wait a while to smooth the display
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
        }
        repaint();
    }
}

class ThisFrame extends JFrame {

    // size of frame
    int X = 300;

    int Y = 300;

    // Shows postion of circle
    JLabel positionLabel;

    AnimPanel pan;

    public ThisFrame() {
        setBackground(Color.blue);
        setTitle("Moving Circle");
        // this code enables you to close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // set size of frame
        setSize(X, Y);
        // and set its position on the screen
        setLocation(300, 150);

        pan = new AnimPanel();
        getContentPane().add(pan);
        this.positionLabel = new JLabel(" ");
        this.positionLabel.setHorizontalAlignment(JLabel.CENTER);
        this.getContentPane().add("South", positionLabel);
    }

    public void moveCircle() {
        pan.moveCircle();
        positionLabel.setText("X-position : " + pan.getx());
    }

}

class SMovingShape {

    public static void main(String[] args) {
        ThisFrame f = new ThisFrame();
        f.setVisible(true);
        for (int i = 0; i < 1000; ++i) {
            f.moveCircle();
        }
    }
}