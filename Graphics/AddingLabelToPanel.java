/*
 *
 * Application to illustrate Swing
 *
 * This displays "hello world"
 *
 */

import java.awt.event.*;

import javax.swing.*;

class HelloPanel extends JPanel {

    // component to be added to the panel
    JLabel msg;

    // constructor
    public HelloPanel() {
        // initialise label
        msg = new JLabel("Hello World", JLabel.CENTER);

        // add label to the panel
        add(msg);
    }
}

class HelloGui extends JFrame {

    // constructor
    public HelloGui() {
        // Create panel
        HelloPanel contents = new HelloPanel();

        // Panel is not added directly to top-level container
        // Instead, it is added to the content pane
        getContentPane().add(contents);

        // this code enables you to close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class SHelloWorld {

    public static void main(String[] args) {
        HelloGui testGui = new HelloGui();

        // set size of GUI
        testGui.setSize(200, 100);

        // and make it visible
        testGui.setVisible(true);
    }
}