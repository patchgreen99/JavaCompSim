import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class MyPanel extends JPanel {
	private Polygon shape;
	private double axisSize = 500;
	private double scaleFactor =30;
	
	
	public MyPanel(Polygon a){
		setBackground(Color.LIGHT_GRAY);
		shape= a;}
	
	public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        for(int i=0;i<shape.getEdges().length;i++){
        	g.drawLine((int)(shape.getVertices()[i].getx()*scaleFactor+(axisSize/2)),(int)((axisSize/2)-shape.getVertices()[i].gety()*scaleFactor),(int)((axisSize/2)+Vector2D.sumVector(shape.getVertices()[i],shape.getEdges()[i]).getx()*scaleFactor),(int)((axisSize/2)-Vector2D.sumVector(shape.getVertices()[i],shape.getEdges()[i]).gety()*scaleFactor));
       }
	}

}