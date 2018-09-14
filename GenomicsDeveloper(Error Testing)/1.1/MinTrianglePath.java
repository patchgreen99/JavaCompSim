/*
Finds shortest path through a triangle of non-negative integers and prints out solution.
Reads from STDin, validates triangle, finds solution then prints to STDout. This program
will find a path with the lowest possible sum, but there may be other equal solutions. 
If there are multiple paths of the same value, only one will be returned.Run with:
java MinTrianglePath < [plaintext input file]
Test files are in ./testFiles, classes to generate triangles are in ./generators

Author:	Joel Hutton.
Date:  	12/04/2014
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class MinTrianglePath {

	
	public static void main(String args[]){
		//Starts a timer so the program can report the time taken.
		double start = System.currentTimeMillis();
		Triangle tri = new Triangle();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		//Takes input line by line from STDin and adds it to a Triangle object
		//'tri' in order to build up the triangle.
		try{
			while((input=br.readLine())!=null){
				tri.addLine(input);
			}

		}
		catch(IOException io){
			io.printStackTrace();
		}
		//Main algorithm, to find shortest path. Outputs the string detailing the
		//shortest path.
		System.out.println(tri.solve());
		double finish = System.currentTimeMillis();
		double timeaken = finish - start;
		System.out.println(Integer.toString(tri.size()) + " lines in " + Double.toString(timeTaken + "ms");
	}
}
