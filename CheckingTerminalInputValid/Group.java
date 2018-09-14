import java.io.*;

public class Group {
	
	private double size;
	
	public Group(double mySize){
		size = mySize;
	}
	public Group(){
		size=0;
	}
	
	public double birthdayProbability(){
		double probability = 1-Math.exp((-this.size*(this.size-1))/(2.0*365.0));
		return probability;
	}
	
	
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	 public static void main (String args[])throws IOException {
		
		     int groupSize=0;
		     boolean notInteger = false;
		   do{
				try{
				System.out.print("Enter the size of your group: ");
				    notInteger=false;
				    String myString = keyboard.readLine();
				    groupSize = Integer.parseInt(myString);
				  }
				  catch(NumberFormatException e)
				  {
				    notInteger=true;
				  }
		   }while(notInteger==true || groupSize<0);
			  
				 
				  
				  String outFile;
			        System.out.println("What is the target file ?");

			        outFile = keyboard.readLine();
			        FileWriter out = new FileWriter(new File(outFile));
			        
			        if(groupSize==0){
						  for(int i=1;i<51;i++){
							  Group a = new Group(i);
							  out.write("probability of at least two people with the same birthday is " + a.birthdayProbability());
						  }
					  }else{
					  
						  Group a = new Group(groupSize);
						  out.write("probability of at least two people with the same birthday is " + a.birthdayProbability());
					  }
			        out.close();
}
}

