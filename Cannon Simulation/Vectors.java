

public class Vectors {
	
	private double x0 = 0; // in m
	private double y0 = 0; // in m
	private double v = 0; // in m/s
	private double angle = 0; //in radians
	private double t = 0; // in s
	private double u = 0;
	private double mass = 1; // in kg
	
	public Vectors(double X0,double Y0,double V,double Angle,double T,double U){
		x0 = X0;
		y0 = Y0;
		v = V;
		angle = Angle;
		t = T;
		u = U;}
	
	public double getx(){
		double x=0;
		if(u==0){
			x = x0 + v*Math.cos(angle)*t;}
		else{
			x = x0 - (mass*v*Math.cos(angle)*(Math.exp(-(u*t)/mass) - 1)/u);}
		return x;}
	
	public double gety(){
		double y=0;
		if(u==0){
			y = y0 + v*Math.sin(angle)*t - 0.5*9.81*t*t;}
		else{
			y = y0 - (9.81*mass*t)/u - (mass/u)*((9.81*mass/u)+v*Math.sin(angle))*(Math.exp(-(u*t)/mass) - 1);}
		return y;}
	
	public double getvelocity(){
		double velocity = 0;
		if(u==0){
			double velocityx = v*Math.cos(angle);
			double velocityy = v*Math.sin(angle) - 9.81*t;
			velocity = Math.sqrt(velocityx*velocityx+velocityy*velocityy);}
		else{
			double velocityx = v*Math.cos(angle)*Math.exp(-(u*t)/mass);
			double velocityy = -(9.81*mass/u)+((9.81*mass/u)+v*Math.sin(angle))*Math.exp(-(u*t)/mass);
			velocity = Math.sqrt(velocityx*velocityx+velocityy*velocityy);}
		return velocity;}
	
	public static double round(double a){
		double nodp = 2;
		return Math.floor(a*Math.pow(10,nodp))/Math.pow(10,nodp);}	
}
