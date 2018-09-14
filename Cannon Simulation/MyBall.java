import java.awt.*;

import javax.swing.*;

class MyBall extends JPanel {

    // default coordinates
    int x = 0;
    int y = 0;

    public MyBall() {
        setBackground(Color.white);}
    
    // Create cannon ball
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillOval(x,y,4,4);
        //Create Field
        g.setColor(Color.green);
        g.fillRect(0, 604, 1400, 200);}
    
    //move ball method
    public void moveBall(int Xscreen, int Yscreen) {
        // plot new coordinates of cannon ball
            x = Xscreen;
            y = Yscreen;
        try {
        	// wait a while to smooth the display
            Thread.sleep(100);}
        catch (InterruptedException e) {}
        repaint();}
    
}
