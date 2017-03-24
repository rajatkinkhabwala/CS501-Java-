import javax.swing.JOptionPane;

/**
 * @author Rajat
 * Purpose: Displays whether the list given by user is sorted or not. 
 * Date: Feb 27, 2016
 */
public class C6E19SortedList {

	public static void main(String[] args) {
		boolean continueProgram = true;
		int numberOfElements; // No. of elements the list contains.
		while (continueProgram) {
			try {
				// Display program description to the user.
				JOptionPane
						.showMessageDialog(
								null,
								"This program displays whether given input of list of elements are in sorted order or not.",
								"Program Description",
								JOptionPane.INFORMATION_MESSAGE);
				// Input from the user - No of elements in the list followed by the respective elements.
				String inputFromUSer = JOptionPane
						.showInputDialog(
								null,
								"Enter the number of the elements in the list followed by the elements, separated with spaces.",
								"Input", JOptionPane.QUESTION_MESSAGE);
				String[] inputNoOfElementsAndList = inputFromUSer.split(" ");
				numberOfElements = Integer
						.parseInt(inputNoOfElementsAndList[0]);

				// Check no.of elements given and count of elements entered.
				if ((inputNoOfElementsAndList.length - 1) == numberOfElements) {
					// List which contains the elements.
					int[] listOfElements = new int[numberOfElements];
					String elementsString = "";
					for (int i = 1; i < inputNoOfElementsAndList.length; i++) {
						listOfElements[i - 1] = Integer
								.parseInt(inputNoOfElementsAndList[i]);
						elementsString = elementsString
								+ inputNoOfElementsAndList[i] + " ";
					}

					if (isSorted(listOfElements))
						JOptionPane.showMessageDialog(null, "The given list "
								+ elementsString
								+ " is already sorted in ascending order.",
								"Result", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "The given list "
								+ elementsString
								+ " is not sorted in ascending order.",
								"Result", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"The no.of elements in the list are not equal to the input given for no.of elements.",
									"Input error", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e) {
				// Display warning box if any exception occurs.
				JOptionPane
						.showMessageDialog(
								null,
								"Exception occured. Please try executing the program again with correct input.",
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

	/*
	 * This method take the elements as input and returns whether they are
	 * already in ascending order or not.
	 */
	public static boolean isSorted(int[] listOfNumbers) {
		for (int i = 1; i < listOfNumbers.length; i++) {
			if (listOfNumbers[i - 1] > listOfNumbers[i])
				return false;
		}
		return true;

	}
}
