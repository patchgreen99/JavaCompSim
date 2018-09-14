import java.awt.*;
import javax.swing.JPanel;

public class Pattern extends JPanel {
	
	public static double range = 4;
	public static double xinitial = -2.0;
	public static double yinitial =  2.0;
	
	//method for creating graphics in screen
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		
		//set background
		this.setBackground(Color.WHITE);
		
		//manual resize
		Dimension size = getSize();
		int sizex = size.width;
		int sizey = size.height;
		
		//create pixels
		GridCell[][] pixel = new GridCell[sizex][sizey];
		
		double intervalsx = range/sizex;
		double intervalsy = range/sizey;

	    //initialise coordinates of pixels
			for(int x=0; x<sizex; x++ ){
				for(int y=0; y<sizey; y++ ){
					pixel[x][y] = new GridCell((xinitial + intervalsx*x),(yinitial - intervalsy*y),255);}}
			
			
		//paint pixels
		for(int x=0; x<sizex; x++ ){
			for(int y=0; y<sizey; y++ ){
				int currentN = GridCell.checkN(pixel[x][y]).getN();
		g.setColor(new Color(currentN,currentN,currentN));
		g.fillRect(x,y,1,1);
		}}
		
	}
	}

	




