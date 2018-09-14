import java.io.IOException;


public class Traffic {

	private static int numCells;
	private static int iterations;
	private static int numOfExperiments;
	private static double[] x;
	private static double[] y;

	public Traffic(int cells,int iter,int experiments, double[] xvalues, double[] yvalues){
		numCells= cells;
		iterations= iter;
		numOfExperiments=experiments;
		x = xvalues;
		y =yvalues;
		}
	
	public void sety(double[] yvalues){
	y=yvalues;	
	}
	
	public static void main(String args[])throws IOException {
		for(int exp=0 ; exp<numOfExperiments; exp++){

			double dense = x[exp];
			double numCars = (dense*numCells) ;

			double[] averageV = new double[iterations];
			Cell[] roadnew = new Cell[numCells];
			Cell[] roadold = new Cell[numCells];

			//set the cars randomly with fixed density
			roadold = Cell.setRoad(numCells,numCars);

			//timer
			for(int t=0; t<iterations ; t++){

				//print road
				for(int k=0; k<roadold.length ; k++ ){
					System.out.print(roadold[k].getcar()+" ");}
				System.out.println("\n");

				//Iterations
				roadnew = Cell.oneTimeStep(numCells,roadold);

				//Calculate average velocity for each run
				int numMoved=Cell.carsMoved(roadold, roadnew);

				// average speed in cells per iteration
				averageV[t]= numMoved/(numCars);
				//System.out.print("Number of cars moved = "+numMoved+"\n");
				//System.out.print("Average speed = "+averageV[t]+"\n");


				//set new positions
				for(int n=0; n<roadold.length ; n++ ){
					roadold[n]=roadnew[n];}
			}


			//save the total average
			y[exp]=Cell.mean(averageV);	
	}
	}
	
	public double[] getx(){
		return x;}

	public double[] gety(){
		return y;}
	
	
	

}