import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: To solve the 2x2 linear equations using Cramer�s rule.
 * Date: 2-17-2016
 */
public class C3E3CramerRule {

	public static void main(String[] args) {
		String linearEquation = "ax + by = e"+'\n'+"cx + dy = f";
		double a, b, c, d, e, f, x, y;
		boolean continueProgram = true;
		String result;
		while(continueProgram) {
			try {
				
					//To display the information to the user about the program.
					JOptionPane.showMessageDialog(null, "To solve the following system of linear equation Using Cramer�s rule: \n"+linearEquation, "Program Description", JOptionPane.INFORMATION_MESSAGE);
				
					//To get the inputs from the user.
					String input = JOptionPane.showInputDialog(null, "Enter a, b, c, d, e, f numbers separated with spaces","User Input",JOptionPane.QUESTION_MESSAGE);	
					//Separate the input given by user using space delimiter.
					String[] inputNumbers = input.split(" ");
		
					//To display error message, if the inputs given by the user are more than 6 numbers.
					if(inputNumbers.length > 6) {
						JOptionPane.showMessageDialog(null,"Error in input. Please enter 6 numbers i.e. a, b, c, d, e, f separated with spaces. "+'\n'+"Please retry the execution.","Error",JOptionPane.WARNING_MESSAGE);
					}
					else {
						a = Double.parseDouble(inputNumbers[0]);
						b = Double.parseDouble(inputNumbers[1]);
						c = Double.parseDouble(inputNumbers[2]);
						d = Double.parseDouble(inputNumbers[3]);
						e = Double.parseDouble(inputNumbers[4]);
						f = Double.parseDouble(inputNumbers[5]);
						
						//Check if the linear equations has solution. If not display the respective message to the user.
						if((a*d - b*c) == 0)
							JOptionPane.showMessageDialog(null, "The equation has no solution", "No Solution", JOptionPane.INFORMATION_MESSAGE);
						else {
							x = (e*d - b*f)/(a*d - b*c);
							y = (a*f - e*c)/(a*d - b*c);
							result = "The solution for the given linear equations "+a+"x + "+b+"y = "+e+" and "+c+"x +"+d+"y = "+f+", (x, y) is: ("+ x + ", " + y + ")";
							JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.PLAIN_MESSAGE);
						}
					}	
					
					
			}
			catch(Exception exp) {
				JOptionPane.showMessageDialog(null,"Exception Occured.", "Exception",JOptionPane.WARNING_MESSAGE);
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
