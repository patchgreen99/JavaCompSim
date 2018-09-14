import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


public class Test {
	public static void main (String args[])throws IOException {
		Console myConsole = System.console();
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.println("How many vertices?");
		int v = s.nextInt();
		Vector2D[] edge = new Vector2D[v];
		
		for(int i=0;i<v;i++){
		System.out.println("Enter x coordinate followed by y coordinate");
		double x = s.nextDouble();
		double y = s.nextDouble();
		
		edge[i] = new Vector2D(x,y);}
		
		Polygon a = new Polygon(edge);
		
		MyFrame frame = new MyFrame(a);
		frame.setVisible(true);
		
		System.out.printf("convex ? "+a.convex());
		
	}
}

