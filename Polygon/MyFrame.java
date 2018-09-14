import javax.swing.JFrame;


public class MyFrame extends JFrame{
	
	
	private MyPanel panel;
	
	public MyFrame(Polygon a){
		setSize(500,500);
		MyPanel panel = new MyPanel(a);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(panel);
		
	}

}
