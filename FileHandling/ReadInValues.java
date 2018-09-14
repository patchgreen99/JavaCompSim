import java.io.*;

public class ReadInValues {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        double x = 1.0;
        double y = 1.0;
        String title = "";

        FileReader datafile = new FileReader("parameters.txt");

        BufferedReader in = new BufferedReader(datafile);
        String line;
        while ((line = in.readLine()) != null) {
            if (line.startsWith("First parameter")) {
                x = Double.valueOf(line.substring(16)).doubleValue();
                y = Double.valueOf(in.readLine()).doubleValue();
                title = String.valueOf(in.readLine());
            }
        }

        in.close();
        datafile.close();

        System.out.println("Title : " + title);
        System.out.println();
        System.out.println("read in x as " + x);
        System.out.println("and y as " + y);

        FileWriter outputfile = new FileWriter("x.txt");
        BufferedWriter out = new BufferedWriter(outputfile);
        String s = "Product of x and y is " + x * y;
        out.write(s, 0, s.length());
        out.close();
        outputfile.close();

    }
}