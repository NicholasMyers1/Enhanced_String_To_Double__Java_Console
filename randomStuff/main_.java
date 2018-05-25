package randomStuff;
import java.util.Scanner;
public class main_{
	private static double doubleFromString=0.d;
	private static String userInputString="";
	public static Scanner scn=new Scanner(System.in);
	public static void main(String[] argv){
		System.out.println("Enter a string to be converted to a double value. 'This string can contain non-numbers and they will be filtered out.'");
			System.out.print("String: ");
				userInputString=scn.nextLine();
		doubleFromString=functions.stringToDouble(userInputString);//convert a string to a double value;
		System.out.println("Enhanced String to double: (doubleFromString=functions.stringToDouble(userInputString)): "+doubleFromString);
		//System.out.print("Regular String to double: (Double.parseDouble(userInputString)): ");System.out.print(Double.parseDouble(userInputString));
	}
}