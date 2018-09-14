import java.io.IOException;

import javax.swing.*;

public class Mandelbrot {
	public static void main (String args[])throws IOException {
		JFrame f = new JFrame ("Mandelbrot Set");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//print pixels on frame
		Pattern p = new Pattern();
		f.add(p);
		f.setSize(600,600);
		f.setVisible(true);
		
		
	}

}


