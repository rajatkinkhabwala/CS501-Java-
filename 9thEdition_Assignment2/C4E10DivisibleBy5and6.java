import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: Program that displays all the numbers from 100 to 1,000, 
 * 			ten per line, that are divisible by 5 and 6. Numbers are 
 * 			separated by exactly one space.
 * Date: 02/17/2016
 */
public class C4E10DivisibleBy5and6 {

	public static void main(String[] args) {
		String programDescription = "This program displays all the numbers from 100 to 1,000, ten per line, that are divisible by 5 and 6. \nNumbers are separated by exactly one space.";
		//This variable is used to store the numbers which are divisible by 5 and 6.
		String displayNumbers;
		//This variable is used to maintain the count of numbers in the line.
		int counter;
		boolean continueProgram = true;
		
			while(continueProgram) {
				try {
					displayNumbers = "";
					counter = 0;
					//Display the program description to the user.
					JOptionPane.showMessageDialog(null, programDescription, "Program Description", JOptionPane.INFORMATION_MESSAGE);
					for(int i = 100; i <= 1000; i++) {
						if(i % 5 == 0 && i % 6 == 0) {
							displayNumbers = displayNumbers+" "+i;
							counter++;
						}
						
						if(counter == 10) {
							displayNumbers = displayNumbers +'\n';
							counter = 0;
						}
					}
					//Display the result of numbers.
					JOptionPane.showMessageDialog(null, "Numbers from 100 to 1000 that are divisible by 5 and 6 : \n" + displayNumbers, "Result", JOptionPane.INFORMATION_MESSAGE);
					
			}
			catch(Exception e) {
				//Display warning box if any exception occurs.
				JOptionPane.showMessageDialog(null, "Exception occured. Please try executing the program again.", "Exception", JOptionPane.WARNING_MESSAGE);
			}		
			//Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to repeat the program?", "Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if(confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}

}
