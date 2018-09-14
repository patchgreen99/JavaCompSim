
public class GridCell {
	
	private Complexnum z;
	private Complexnum c;
	private int N = 0;
	
	//object storing pixels information
	public GridCell(double cR, double cI,int n ){
	c = new Complexnum(cR,cI);
	//Initially Z = 0+0i so after 1 iteration z = c
	z = new Complexnum(cR,cI);
	N=n;
	}
	
	//get methods
	public Complexnum getC(){
		return c;}
	public Complexnum getZ(){
		return z;}
	public int getN(){
		return N;}
	
	//set methods
	public void setz(Complexnum Z){
		z = Z;}
	
	public static Complexnum iteration(Complexnum Z, Complexnum C ){ 
	return Complexnum.getSum(Complexnum.getProduct(Z, Z),C);}
	
	public static GridCell checkN(GridCell current){
		int iterations = 0;
		// if n never gets set its a converging series so it should have the highest value for n
		int n = 255;
		while(iterations<255){
		Complexnum zed = GridCell.iteration(current.getZ(),current.getC()); 
		//save iterated complex number z
		current.setz(zed);
		iterations++;
		// check if it is still within the set
			if(current.getZ().getMag()>2){
				n = iterations;
				break;
				}
		}
		return new GridCell(current.getC().getR(),current.getC().getI(),n);
	}

}


