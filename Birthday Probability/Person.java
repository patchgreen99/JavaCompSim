import java.util.Random;



public class Person{
	
	private int birthday;
	
	public Person(){
		birthday = randomInts();
		}
	
	public static int randomInts(){
		Random r = new Random();
		return r.nextInt(364) + 1;	
	}
	
	public int getBirthaday(){
		return birthday;
	}
	
	
}