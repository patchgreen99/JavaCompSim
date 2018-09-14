import java.io.*;
import java.util.Scanner;


public class Testing {
    public static void main (String args[])throws IOException {
	Console myConsole = System.console();
	Scanner s = new Scanner(System.in);

	//Create an array of complex numbers
	Complexnum[] complexArray = new Complexnum[2];
   	
	//Produce exactly 2 complex numbers
	for(int i=0; i<complexArray.length; i++){
		System.out.println("Enter the real part followed by the imaginary part of your complex numbers"+i+"");
		double R = s.nextDouble();
		double I = s.nextDouble();
		//Create object Complex Number
		complexArray[i] = new Complexnum(R,I);
		System.out.println("Complex Number "+i+ " = " + complexArray[i].toString());}
	
	//set tolerance value
	double ti = 0.001;
	   do{String inti = myConsole.readLine("Enter tolerance less than 0.001 :  ");
	    ti = Double.parseDouble(inti.trim());}while( ti >= 0.001 );
	   
	//Magnitude test 
	for(int i=0;i<complexArray.length; i++){
    String inMag = myConsole.readLine("Enter magnitude of "+i+"=  ");
	double mag = Double.parseDouble(inMag.trim());
	boolean a = Testers.testMagnitude(complexArray[i],mag,ti);		
	System.out.println(a);}
	
	// Sum test
	System.out.println("Enter the real and imaginary parts of the sum of the complex numbers");
	double rs = s.nextDouble();
	double is = s.nextDouble();
		boolean b = Testers.testSum(complexArray[0],complexArray[1],rs,is,ti);		
		System.out.println(b);
		
	//Product test
		System.out.println("Enter the real and imaginary parts of the product of the complex numbers");
		double rP = s.nextDouble();
		double iP = s.nextDouble();
		boolean c = Testers.testProduct(complexArray[0],complexArray[1],rP,iP,ti);		
		System.out.println(c);
		
		// Get test
		for(int i=0;i<complexArray.length; i++){
			System.out.println("Enter the real and imaginary parts of complex Number "+i+":  ");
			double d = s.nextDouble();
			double e = s.nextDouble();
		    //String inMag = myConsole.readLine("Enter real and imaginary parts of complex Numeber "+i+":  ");
			boolean a = Testers.testGet(complexArray[i],d,e,ti);		
			System.out.println(a);}		
}
}


