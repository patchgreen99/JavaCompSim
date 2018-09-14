import java.io.*;

public class Input{
	private double xo;
	private double yo;
	private double v;
	private double theta;
	private double u;
	
		
	public Input(){
		xo =0;
		yo =0;
		v =0;
		theta =0;
		u =0;}
	
	public void Inputdata(){
        BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("parameters.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        String str = null;
		try {
			str = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String[] ar=str.split(",");
        	xo = (Double.parseDouble(ar[0]));
        	yo = (Double.parseDouble(ar[1]));
        	v = (Double.parseDouble(ar[2]));
        	theta = (Double.parseDouble(ar[3]));
        	u = (Double.parseDouble(ar[4]));
            }
	
    public double getx() {
	return xo;}
    public double gety() {
	return yo;}
    public double getv() {
	return v;}
    public double gettheta() {
	return theta;}
    public double getu() {
	return u;}
   
}
