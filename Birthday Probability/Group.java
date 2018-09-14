
import java.io.BufferedReader;
	import java.io.File;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.Random;


	
public class Group {
	
	private int size;
	private int[] birthdays;

	public Group(int many){
		birthdays = new int[many];
		for(int i=0;i<many;i++){
			Person a = new Person();
			birthdays[i]=a.getBirthaday();
		}
		
	}
	
	public int[] getBirthdays(){
		return birthdays;
	}
	

		static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		public static void main(String[] args) throws IOException {
			
		//Input information and check input	Num of People
	
			System.out.print("Enter the number of people:");
			int n = 0;
			boolean isIntger = false;
			while (!isIntger){
				try{
					isIntger = true;
					String nString = keyboard.readLine();
					n = Integer.parseInt(nString);
				} catch(NumberFormatException e){	
					isIntger = false;
					System.out.print("The number of people must be a whole number. Please re - enter the number of people:");
				}
				if(n == 1 || n < 0){
					System.out.print("The number of people must be 2 or more. Please re - enter the number of people:");
					isIntger = false;
				}
			}
			

			//Input information and check input	Num of trials
			
			System.out.print("Enter the number of trials:");
			int T = 0;
			isIntger = false;
			while (!isIntger){
				try{
					isIntger = true;
					String TString = keyboard.readLine();
					T = Integer.parseInt(TString);
				} catch(NumberFormatException e){	
					isIntger = false;
					System.out.print("The number of trials must be a whole number. Please re - enter the number of people:");
				}
				if(T < 1){
					System.out.print("The number of trials must be 2 or more. Please re - enter the number of people:");
					isIntger = false;
				}
			}
			
			Group a = new Group(n);
			
			int t = 0;
			for(int i = 0; i < T; i++){
				Arrays.sort(a.getBirthdays());
				Loop:
					for(int j = 0; j < a.getBirthdays().length-1; j++){
						if(a.getBirthdays()[j] == a.getBirthdays()[j+1]){
							t++;
							break Loop;
						}
					}
			}
			
			//output to file
			
			
			System.out.println(t);
			double p = (double)t/T;
			System.out.print("Enter the name of the output file:");
			String fileName = keyboard.readLine();
			fileName += ".txt";
			PrintWriter output = new PrintWriter(new File(fileName));
			output.println("for a group of " + n + " people, the probability that two of them have a birthday on the same day is: " + p);
			output.close();
		}

		


		




	
	
}