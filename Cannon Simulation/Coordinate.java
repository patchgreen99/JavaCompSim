import java.io.IOException;

public class  Coordinate{
	public static void main (String args[])throws IOException {

		//Update data
		Input data = new Input();
		data.Inputdata();
		double initialx = data.getx();
		double initialy = data.gety();
		double V = data.getv();
		double theta = data.gettheta();
		double drag = data.getu();
		double ttotal = 10;
		
		MyField f = new MyField();

		// the accuracy depends on the frame size I decided to work to 2 decimal places
		double tintervals = 0.01;

		Vectors[] ball = new Vectors[(int) (ttotal/tintervals)];

		for(int t=0;t<10000;t++){
			//call vectors for balls position
			ball[t] = new Vectors(initialx,initialy,V,(theta/180)*Math.PI,t*tintervals,drag);

			//save time of flight
			// t statement so it doesn't just record the start position
			if(ball[t].gety()<=0 && t != 0 ){
				double Tflight = t*tintervals-0.01;
				Output.outputdata(Tflight, Vectors.round(ball[t].getx()));
				break;}
			
			//print position vector
			f.updateMessage("("+Vectors.round(ball[t].getx())+","+Vectors.round(ball[t].gety())+")");
            
			//move the balls position
			int a = (int) Math.round(Vectors.round(ball[t].getx())*100);
			int b = (int) Math.round(Vectors.round(ball[t].gety())*100);
			f.moveBall(a-2, 600 - b);
			
			//Update changes
			f.setVisible(true);
			
			//print final coordinates
			System.out.print("t= "+Vectors.round(t*tintervals)+"   Position = "+Vectors.round(ball[t].getx())+","+Vectors.round(ball[t].gety())+"    Velocity = "+Vectors.round(ball[t].getvelocity()));
			System.out.println("\n");
		}


	}}