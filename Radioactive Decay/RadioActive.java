import java.io.*;
import java.util.Scanner;


	public class RadioActive {
	    public static void main (String args[])throws IOException {
	    Scanner in = new Scanner(System.in);
   
	  //initialise variables
	  int size = 0; 
	  double halflife = 0;
	  int totalT=80;
	  int deltaT=1;
	  
      //input
	  System.out.print("Enter size of the grid of atoms followed by the half life \n");
	  size = in.nextInt();
	  halflife = in.nextDouble();
	  double prob = Math.log(2)*deltaT/halflife ;
	  
	  //Create Atom array
	  Atom[][] AtomArray = new Atom[size][size];
	  
	  //create an array of half lives
	  double[] half = new double[10];
	  
	  //Create a variable to store the current atom as an object
	  Atom current_atom;
	  
	  //Index for the data value half life
	  int halflifeindex = 0;
	  
	  //Experiment counter
	  for(int run=0 ; run<10 ; run++){ 
		  
		  //fill array ,each atom with life 1 and identical probability of decay
		  System.out.println();  //Space
		  for(int i=0; i<AtomArray.length; i++){
			  for(int j=0; j<AtomArray.length; j++){
			  AtomArray[i][j] = new Atom(prob,1);}}
	  
	  // initialise variable to check whether half life has already been recorded
	  int once = 1;
	  
	  //initialise time
	  int t = deltaT;
	  
	 //Decay Program
	  while(t <= totalT){
		  int numberalive = 0;
		  
		     for (int row=0; row<size; row++){
			     for (int col=0; col<size; col++){
			    	 //simulate decay
			    	 current_atom = Atom.checkdecay(AtomArray[row][col]);
			    	 //Count live atoms
			    	 if(current_atom.getlife()==1){numberalive++;}
			    	 //Print atom
			         System.out.print((int) current_atom.getlife() + " ");
			         //assign the new atom to its place in the array
			         AtomArray[row][col] = current_atom;}
	            //create new line every row to create a square array in the terminal
		        System.out.println("\n");}   
		     
		  //Print number of atoms still alive followed by a space
		  System.out.println(numberalive+" atoms still alive at "+t+" seconds \n");
		  System.out.println();
		  
		  //Save half life
		  if(numberalive <= size*size/2 && once==1){
			  once=0;
		      half[halflifeindex] = t;}
		  
		  //print half life
		  System.out.println("halflife = "+half[halflifeindex]+"\n");

          //next time interval
          t=t+deltaT;
		  }
	  
	  //experiment counter
	  halflifeindex++;
	  }
	  
	  //Results
	  System.out.println("mean halflife = "+HalfLife.mean(half));
	  System.out.println("uncertainty = "+HalfLife.uncertainty(half));
	  
	  for(int k=0 ; k <half.length ; k++){
	  System.out.println(half[k]);}
	  
	  
	  System.exit(0);
	  
}}	
	
	

	