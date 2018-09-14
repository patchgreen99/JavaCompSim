import java.io.*;

public class Copy {

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader(new File("somemoretext.txt"));
        FileWriter out = new FileWriter(new File("copyofsometext.txt"));
        int c;

        while ((c = in.read()) != -1) {
            out.write(c);
        }
        out.close();
        in.close();
    }
}