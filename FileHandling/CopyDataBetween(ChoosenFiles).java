import java.io.*;

public class Copy2 {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String inFile;
        String outFile;

        System.out.println("What is the source file to copy from?");

        inFile = keyboard.readLine();
        FileReader in = new FileReader(new File(inFile));

        System.out.println("What is the target file to copy to?");

        outFile = keyboard.readLine();
        FileWriter out = new FileWriter(new File(outFile));

        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
    }
}