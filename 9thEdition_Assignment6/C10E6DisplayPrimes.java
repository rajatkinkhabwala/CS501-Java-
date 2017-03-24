import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: To display all the prime numbers less than 120 in descending order. 
 * Date: Apr 8, 2016
 */
public class C10E6DisplayPrimes {

	public static void main(String[] args) {
		String programDescription = "This program displays all the prime numbers less than 120 in descending order.";
		int count = 0;
		String result;
		boolean continueProgram = true;
		while (continueProgram) {
			try {
				result = "";
				// Show the program description to the user.
				JOptionPane.showMessageDialog(null, programDescription,
						"Program Description", JOptionPane.INFORMATION_MESSAGE);

				StackOfIntegers stack = new StackOfIntegers(35);
				for (int i = 2; i < 120; i++) {
					for (int j = 1; j <= i; j++) {
						if (i % j == 0)
							count++;
					}
					// Add the number into the stack if it is prime.
					if (count == 2) {
						stack.push(i);
					}
					count = 0;
				}

				while (!stack.empty()) {
					result = result + "   " + stack.pop();
				}
				// Display the result.
				JOptionPane.showMessageDialog(null,
						" Prime Numbers under 120 in descending order:\n\n"
								+ result, "Result",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// Display warning box if any exception occurs.
				JOptionPane
						.showMessageDialog(
								null,
								"Exception occured. Please try executing the program again.",
								"Exception", JOptionPane.WARNING_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,
					"Do you want to repeat the program?",
					"Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}

}
