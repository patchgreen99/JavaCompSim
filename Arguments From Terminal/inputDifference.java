public class inputDifference{
	public static void main(String[] args){
		double num1;
		double num2;
		num1 = Double.parseDouble(args[0]);
		num2 = Double.parseDouble(args[1]);
		System.out.println(Math.abs(num1 - num2));
	}
}
