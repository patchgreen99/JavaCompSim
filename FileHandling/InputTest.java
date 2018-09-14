public class InTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In file = new In("http://www.gutenberg.org/files/39063/39063-0.txt");
		while (!file.isEmpty()) {
		    String line = file.readLine();
		    if (line.contains("mountain")) {
		        System.out.println(line);
		    }
		}
	}
}
