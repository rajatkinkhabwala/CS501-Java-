/*
 * Author: Rajat
 * Purpose: To calculate the next month interest from the given balance and annual rate.
 */

import javax.swing.JOptionPane;
public class C2E20CalculateInterest {
	
	public static void main(String args[]) {
		//Message dialog box with the description included.
		JOptionPane.showMessageDialog(null, "Enter balance and interest rate (e.g., 3 for 3%) to calculate the next month Interest :", "Exercise Description", JOptionPane.INFORMATION_MESSAGE);
		try{
			//Display Input dialog box for respective inputs.
			double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the balance: ", "Balance Amount", JOptionPane.QUESTION_MESSAGE));
			double annualInterestRate = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the Annual Interest Rate: ", "Annual Interest Rate", JOptionPane.QUESTION_MESSAGE));
			
			//Calculate the next month interest
			double interest = balance * (annualInterestRate/1200);
			
			//Display the computed next month interest on the message box.
			JOptionPane.showMessageDialog(null, "Next month interest from the given balance and annual rate is : "+interest, "Result", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Exception Occured. Please retry the execution.","Exception",JOptionPane.WARNING_MESSAGE );
		}
	}
}
