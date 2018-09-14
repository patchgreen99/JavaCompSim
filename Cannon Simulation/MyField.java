import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyField extends JFrame {

    // size of frame
    int X = 1500;
    int Y = 750;
    JLabel msg;
    MyBall pan;
    
    //construct MyField
    public MyField() {
        setBackground(Color.green);
        setTitle("Cannon Simulation");
        
        // make window close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);}});
        
        // set size of frame
        setSize(X, Y);
        
        //add label
        msg = new JLabel();
        getContentPane().add("North",msg);
        
        // add the ball
        pan = new MyBall();
        getContentPane().add(pan);}
    
   //update methods
    public void updateMessage(String a){
    	msg.setText(a);}

    public void moveBall(int xScreen, int yScreen) {
        pan.moveBall(xScreen,yScreen);}
}
