import java.io.*;
import java.util.ArrayList;

public class Output {


	public static void outputdataX(ArrayList<Integer> values){


		FileWriter valuesx;
		try {
			valuesx = new FileWriter("XValues.txt");
			BufferedWriter out = new BufferedWriter(valuesx);
			String newLine = System.getProperty("line.separator");
			for(int i = 0 ; i<values.size(); i++){
				out.write(+values.get(i)+ " " +newLine);}
			out.close();
			valuesx.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void outputdataY(ArrayList<Integer> values){

		FileWriter valuesy;
		try {
			valuesy = new FileWriter("YValues.txt");
			BufferedWriter out = new BufferedWriter(valuesy);
			String newLine = System.getProperty("line.separator");
			for(int i = 0 ; i<values.size(); i++){
				String s =  +values.get(i)+ " " +newLine ;
				out.write(s);}
			out.close();
			valuesy.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void outputdataZ(ArrayList<Double> values){


		FileWriter valuesz;
		try {
			valuesz = new FileWriter("ZValues.txt");
			BufferedWriter out = new BufferedWriter(valuesz);
			String newLine = System.getProperty("line.separator");
			for(int i = 0 ; i<values.size(); i++){
				out.write(+values.get(i)+ " " +newLine);}
			out.close();
			valuesz.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
