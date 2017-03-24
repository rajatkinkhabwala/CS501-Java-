import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: Test program to test MyPoint class.
 * Date: Apr 8, 2016
 */
public class C10E4MyPoint {

	public static void main(String[] args) throws Exception {
		double x1, y1, x2, y2;
		boolean continueProgram = true;
		while (continueProgram) {
			try {
				String result = "";
				String input = JOptionPane
						.showInputDialog(
								null,
								"Enter the values x1, y1, x2, y2 separated with spaces to find the distance between points (x1,y1) and (x2,y2).",
								"Input", JOptionPane.QUESTION_MESSAGE);
				String[] inputPoints = input.split(" ");
				if (inputPoints.length != 4) {
					Exception e = new Exception(
							"Incorrect input. Please retry.");
					throw e;
				}
				x1 = Double.parseDouble(inputPoints[0]);
				y1 = Double.parseDouble(inputPoints[1]);
				x2 = Double.parseDouble(inputPoints[2]);
				y2 = Double.parseDouble(inputPoints[3]);
				MyPoint pointA = new MyPoint(x1, y1);
				MyPoint pointB = new MyPoint(x2, y2);
				result = "Distance between pointA (" + x1 + ", " + y1
						+ ") and pointB (" + x2 + ", " + y2 + ") is: "
						+ pointA.distance(pointB);
				JOptionPane.showMessageDialog(null, result, "Result",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Exception caught.\nMessage: " + e.getMessage(),
						"Exception", JOptionPane.ERROR_MESSAGE);
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
