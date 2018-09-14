import java.io.*;

public class Output {
	
	public static void outputdata(double Tf, double R){
        FileWriter outputfile;
		try {
			outputfile = new FileWriter("output.txt");
	        BufferedWriter out = new BufferedWriter(outputfile);
	        String s = "Time of flight = " +Tf+ "   Range = "+R ;
	        out.write(s);
	        out.close();
	        outputfile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}