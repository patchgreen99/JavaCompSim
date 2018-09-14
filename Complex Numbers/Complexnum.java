import java.io.*;
import java.lang.Math;

public class Complexnum {
	
    //define object 
    private double inRe, inIm ;
    
    public Complexnum(double Re, double Im ) {
	inRe = Re;
	inIm = Im;
    }
    //default object
    public Complexnum() {
	inRe = 0;
	inIm = 0;
    }
    //2 String method
    public String toString(){
	return inRe+"+"+inIm+"i";
    }	
    //Get options
    public double getR() {
	return inRe;
    }
    public double getI() {
	return inIm;
    } 
    //Magnitude
    public double getMag() {
	double Mag = Math.sqrt(inRe*inRe + inIm*inIm);
    	return Mag;
    }
    //Sum
    public static Complexnum getSum(Complexnum c1, Complexnum c2){
	double SumR = c1.getR() + c2.getR();
	double SumI = c1.getI() + c2.getI();
	return new Complexnum(SumR,SumI);
    }
    //Multiply
    public static Complexnum getProduct(Complexnum c1, Complexnum c2){
    	double PR = c1.getR()*c2.getR() - c1.getI()*c2.getI();
	double PI = c2.getR()*c1.getI() + c2.getI()*c1.getR();
	return new Complexnum(PR,PI);
    }
}
