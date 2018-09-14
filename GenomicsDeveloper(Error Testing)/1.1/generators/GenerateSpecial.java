/*
Generates a triangle of random non-negative integers 500 lines long.
Prints to STDout. 
Author:	Joel Hutton.
Date:  	12/04/2014
*/
import java.io.IOException;
import java.io.PrintWriter;

//Generates a random 500 line triangle of non-negative integers.
public class GenerateSpecial {

	public static void main(String args[]){
		String[] lines = new String[500];
		for(int i=0; i< 500; i ++){
			String line = "";
			for(int j=0; j<= i; j ++){
				//Add 1 to eliminate zeroes.
				line += Integer.toString(j) + " ";
			}
			System.out.println(line);
		}
	}
}
