/*
 * Author: Rajat
 * Purpose: To calculate the average of given numbers.
 */

//import scanner from Util package.
import java.util.Scanner;
public class C2E3ComputeAverage {
	
	public static void main(String args[]) {
		//Create new scanner object for input.
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter three numbers: ");
		double valueOne =  scanner.nextDouble();
		double valueTwo =  scanner.nextDouble();
		double valueThree =  scanner.nextDouble();
		
		//Calculate the average of the given input numbers.
		double average = (valueOne + valueTwo + valueThree)/3;
		
		//Print the computed average of the numbers.
		System.out.print("Average of the three numbers, " + valueOne + ' ' + valueTwo + ' ' + valueThree + ' ' + "is: "+ average);
	}
}
