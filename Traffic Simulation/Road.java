import java.io.*;
import java.util.Scanner;

public class Road {
	public static void main (String args[])throws IOException {
		Scanner in = new Scanner(System.in);	

	int N = 10;
	int[] roadold = new int[N];
	int[] roadnew = new int[N];
	
	//Initialise cars
	for(int i=0; i<roadold.length ; i++ ){
		roadold[i] = (int) Math.floor(Math.random()*2);}
	
	for(int t=0; t<14 ; t++){
		
	    //print road
		for(int k=0; k<roadold.length ; k++ ){
			System.out.print(roadold[k]+" ");}
		System.out.println("\n");
		
		//start
		if(roadold[0]==1){
			if(roadold[1]==0){
				roadnew[0]=0;}
			}else{roadnew[0]=1;}
		if(roadold[0]==0){
			if(roadold[roadold.length-1]==1){
			roadnew[0]=1;}
			}else{roadnew[0]=0;}
		

		
		//road program
		for(int j=1; j<(roadold.length-1) ; j++ ){
		if(roadold[j]==1){
			if(roadold[j+1]==0){
				roadnew[j]=0;}
			}else{roadnew[j]=1;}
		if(roadold[j]==0){
			if(roadold[j-1]==1){
			roadnew[j]=1;}
			}else{roadnew[j]=0;}}
		
		
		//finish
		if(roadold[roadold.length-1]==1){
			if(roadold[0]==0){
				roadnew[roadnew.length-1]=0;}
			}else{roadnew[0]=0;}
		if(roadold[roadold.length-1]==0){
			if(roadold[roadold.length-2]==1){
			roadnew[roadold.length-1]=1;}
			}else{roadnew[roadold.length-1]=0;}
		
		//set new positions
		for(int n=0; n<roadold.length ; n++ ){
			roadold[n]=roadnew[n];}
	
	}
	
}}