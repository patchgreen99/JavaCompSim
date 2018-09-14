import java.io.*;
import ptolemy.plot.*;

public class TrafficChart{
	

	
	public static void main (String args[])throws IOException {
		
Plot myPlot = new Plot();

        //initial values
		
		int numCells = 20;
		int iterations = 10;
		double[] X = {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1};
		double[] Y = new double[X.length];
		
		Traffic A = new Traffic(numCells,iterations,X.length,X,Y);
		Traffic.main(args);
		
			
		for(int exp=0 ; exp<X.length; exp++){
			System.out.print("Density = "+A.getx()[exp]+"\n");
			System.out.print("Final Average speed = "+A.gety()[exp]+"\n");
                        myPlot.addPoint(0, A.getx()[exp],A.gety()[exp],true);}
	
   // A frame to display the plot
	    PlotFrame myFrame = new PlotFrame("Traffic", myPlot);
	    // Set the frame size
	    myFrame.setSize(800, 600);
	    // Display the frame and the graph
	    myFrame.setVisible(true);	   
	}}
