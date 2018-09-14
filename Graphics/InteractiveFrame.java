import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class GuiFrame extends JFrame {

    // Panels to be added to the Frame
    DrawingPanel p1;
    ControlPanel p2;

    // constructor
    public GuiFrame() {
        // create panels
        p1 = new DrawingPanel();
        p2 = new ControlPanel();

        // specify layout manager for the Frame
        // note that BorderLayout is the default layout manager 
	// so this line is not really neccessary in this case
        getContentPane().setLayout(new BorderLayout());

        // add panels to the Frame, using the layout manager
        getContentPane().add(p1, BorderLayout.CENTER);
        getContentPane().add(p2, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ControlPanel extends JPanel {

    // Components to be added to the control panel
    JLabel l1;
    JTextField t1;
    JButton b1;


    // constructor
    public ControlPanel() {
        setBackground(Color.gray);

	// label with some text
 	l1 = new JLabel("Enter starting value:");
        // text field 20 columns wide
        t1 = new JTextField(20);
        // button with text
        b1 = new JButton("Start");

        // add components to control panel
	add(l1);
        add(t1);
        add(b1);
    }
}

// Create sub-class of Panel for custom drawing
//
class DrawingPanel extends JPanel {

    // constructor
    public DrawingPanel() {
        setBackground(Color.red);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(50, 50, 100, 100);
    }

    // in order for the layout manager to work
    // we have to override the getPreferredSize method
    public Dimension getPreferredSize() {
        setSize(400, 400);
        return getSize();
    }

}

class SPanels {

    public static void main(String[] args) {
        
	JFrame testGui = new GuiFrame();

        // set size of GUI according to size of the Panels
        testGui.pack();
	// set location on screen
	testGui.setLocation(200,100);
        // and make it visible
        testGui.setVisible(true);
    }
}