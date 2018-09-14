public class Vector2D {
	
	private double xcoor;
	private double ycoor;
	
	public Vector2D(double x, double y){
		xcoor = x;
		ycoor = y;
	}
	
	public double magnitude(){
		return Math.sqrt(xcoor*xcoor + ycoor*ycoor);
	}
	public double getx(){
		return xcoor;
	}
	public double gety(){
		return ycoor;
	}
	
	public static double dotProduct(Vector2D a, Vector2D b){
		return a.getx()*b.getx() + a.gety()*b.gety();
	}
	
	public static Vector2D differenceVector(Vector2D a, Vector2D b){
		return new Vector2D(a.getx()-b.getx(),a.gety()-b.gety());
	}
	
	public static double perpendicularDotProduct(Vector2D a, Vector2D b){
		return a.getx()*b.gety()-a.gety()*b.getx();
	}
	
	public static Vector2D sumVector(Vector2D a, Vector2D b){
		return new Vector2D(a.getx()+b.getx(),a.gety()+b.gety());
	}

}
