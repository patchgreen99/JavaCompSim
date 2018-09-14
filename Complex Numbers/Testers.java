
import java.io.*;
import java.util.Scanner ;	

	public class Testers {
		
		//test get
		public static boolean testGet(Complexnum c1, double j,double k,double tol){
			 boolean iwork = false;
			  if (Math.abs(c1.getR() - j) < tol && Math.abs(c1.getI() - k) < tol ){ 
				  iwork = true;}
			return iwork;
		}	
		//test toString 
		public static boolean testtoString(Complexnum c1, String test){
			 boolean iwork = false;
			  if (c1.toString().equals(test)) {
			    iwork = true;}
			return iwork;
		}	

		//test magnitude
		public static boolean testMagnitude(Complexnum c1, double i,double tol) {
			 boolean iwork = false;
			  if (Math.abs(c1.getMag() - i) < tol){ 
				  iwork = true;}
			return iwork;
		}
		//test sum
		public static boolean testSum(Complexnum c1,Complexnum c2, double real, double ima,double tol){
			boolean jwork = false;
			Complexnum testsum = new Complexnum(real,ima);
				 if ((Math.abs(Complexnum.getSum(c1, c2).getR() - testsum.getR()) < tol )&& (Math.abs(Complexnum.getSum(c1, c2).getI() - testsum.getI()) < tol)){ 
					 jwork = true;}
			return jwork;
		}
		//test product
		public static boolean testProduct(Complexnum c1,Complexnum c2, double real,double ima,double tol){
			boolean kwork = false;
			Complexnum testproduct = new Complexnum(real,ima);
			 if ((Math.abs(Complexnum.getProduct(c1, c2).getR() - testproduct.getR()) < tol) && (Math.abs(Complexnum.getProduct(c1, c2).getI() - testproduct.getI())) < tol){ 
				 kwork = true;}
			return kwork;
		}
	}
	