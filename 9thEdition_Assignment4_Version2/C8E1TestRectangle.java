import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat Purpose: To test the C8E1Rectangle class with creating 1
 *         objects. Date: Mar 9, 2016
 */
public class C8E1TestRectangle {
	public static void main(String[] args) {
		String programDescription = "This program tests the Rectangle class by creating an object of it with given width and height";
		String result = "";
		boolean continueProgram = true;
		JOptionPane.showMessageDialog(null, programDescription,
				"Program description", JOptionPane.INFORMATION_MESSAGE);
		while (continueProgram) {
			try {
				String inputString = JOptionPane
						.showInputDialog(
								null,
								"Enter the width and height of the rectangle separated with spaces.",
								"Input", JOptionPane.QUESTION_MESSAGE);
				String[] splitInput = inputString.split(" ");
				double width = Double.parseDouble(splitInput[0]);
				double height = Double.parseDouble(splitInput[1]);
				C8E1Rectangle rectangle = new C8E1Rectangle(width, height);
				//error = rectangle.getErrorMessage();
				double perimeter = rectangle.getPerimeter();
				double area = rectangle.getArea();
				result = " - The width, height, area and perimeter of the first rectangle are "
						+ width
						+ ", "
						+ height
						+ ", "
						+ area
						+ " and "
						+ perimeter + " respectively.";

				JOptionPane.showMessageDialog(null, result, "Result",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Exception caught.\nMessage: "+e.getMessage(),
						"Exception", JOptionPane.ERROR_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane
					.showConfirmDialog(
							null,
							"Do you want to repeat the program?",
							"Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}
	}
}
