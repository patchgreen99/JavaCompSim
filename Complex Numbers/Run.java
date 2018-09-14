
import java.io.*;
import java.util.Scanner ;	
public class Run {
    public static void main (String args[])throws IOException {
	Console myConsole = System.console();

	//Create an array of complex numbers
	Complexnum[] complexArray = new Complexnum[2];

	    	
	//Produce exactly 2 complex numbers
	for(int i=0; i<complexArray.length; i++){
	    //read data in
	    String myR1 = myConsole.readLine("Real part =  ");
	    String myI1 = myConsole.readLine("Imaginary part = ");
		
	    //Default statement if no input
	    if(myR1.equals("")&&myI1.equals("")){
	    	complexArray[i] = new Complexnum();
		System.out.println("Complex Number "+i+ " = " + complexArray[i].toString());}

	    else{	
		//Read strings
		double R = Double.parseDouble(myR1.trim());
		double I = Double.parseDouble(myI1.trim());
		//Create object Complexnum
		complexArray[i] = new Complexnum(R,I);
		System.out.println("Complex Number "+i+ " = " + complexArray[i].toString());}
	}
	
	//Print Magnitude
	System.out.printf("Magnitude of 0 = %.4f \n",complexArray[0].getMag());
	System.out.printf("Magnitude of 1 = %.4f \n",complexArray[1].getMag());
		   
	//Print Sum
	System.out.println("Sum =" + Complexnum.getSum(complexArray[0],complexArray[1]).toString());
			   
	//print Product
	System.out.println("Product =" + Complexnum.getProduct(complexArray[0],complexArray[1] ).toString());
    }
}