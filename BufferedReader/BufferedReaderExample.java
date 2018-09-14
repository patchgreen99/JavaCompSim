import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
 
public class BufferedReaderExample {
 
	public static void main(String[] args) {
 //new FileReader("C:\\testing.txt") instead of inputStream
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
 
	}
}