import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: Test program to solve the linear equation class.
 * Date: Mar 11, 2016
 */
public class C8E11n12TestLinearEquation {

	public static void main(String[] args) {
		double a, b, c, d, e, f;
		double x1, y1, x2, y2, x3, y3, x4, y4;
		String result = "";
		boolean continueProgram = true;
		while (continueProgram) {
			try {
				int option = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Solve the linear Equation. \n2. Find the Point of Intersection. \n\n Select the program (1 or 2) you want to execute?", "Input",
						JOptionPane.QUESTION_MESSAGE));
				switch (option) {
				case 1:
					String input1 = JOptionPane
							.showInputDialog(
									null,
									"Enter a, b, c, d, e, f numbers separated with spaces",
									"Input", JOptionPane.QUESTION_MESSAGE);
					String[] inputStringArray = input1.split(" ");
					a = Double.parseDouble(inputStringArray[0]);
					b = Double.parseDouble(inputStringArray[1]);
					c = Double.parseDouble(inputStringArray[2]);
					d = Double.parseDouble(inputStringArray[3]);
					e = Double.parseDouble(inputStringArray[4]);
					f = Double.parseDouble(inputStringArray[5]);
					C8E11LinearEquation linear = new C8E11LinearEquation(a, b,
							c, d, e, f);
					if (linear.isSolvable()) {
						// Solution exists.
						result = "The solution for the given linear equations "
								+ a + "x + " + b + "y = " + e + " and " + c
								+ "x +" + d + "y = " + f + ", (x, y) is: ("
								+ linear.getX() + ", " + linear.getY() + ")";
						JOptionPane.showMessageDialog(null, result, "Result",
								JOptionPane.PLAIN_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,
								"The equation has no solution.", "Result",
								JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					String input2 = JOptionPane
					.showInputDialog(
							null,
							"Enter (x1, y1) (x2, y2) of first line and (x3, y3) (x4, y4) of second line separated with spaces",
							"Input", JOptionPane.QUESTION_MESSAGE);
					String[] inputArray = input2.split(" ");
					x1 = Double.parseDouble(inputArray[0]);
					y1 = Double.parseDouble(inputArray[1]);
					x2 = Double.parseDouble(inputArray[2]);
					y2 = Double.parseDouble(inputArray[3]);
					x3 = Double.parseDouble(inputArray[4]);
					y3 = Double.parseDouble(inputArray[5]);
					x4 = Double.parseDouble(inputArray[6]);
					y4 = Double.parseDouble(inputArray[7]);
					C8E11LinearEquation linearEq = new C8E11LinearEquation(x1, y1, x2, y2, x3, y3, x4, y4);
					if (linearEq.intersectCheck()) {
						// Solution exists.
						result = "The point of intersection for line ("+x1+", "+y1+") ("+x2+", "+y2+") and line ("+x3+", "+y3+") ("+x4+", "+y4+") is: ("+linearEq.getXp()+", "+linearEq.getYp()+")";
						JOptionPane.showMessageDialog(null, result, "Result",
								JOptionPane.PLAIN_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null,
								"Given two lines do not intersect.", "Result",
								JOptionPane.INFORMATION_MESSAGE);
					
					break;
				}

			} catch (Exception ex) {
				//ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Exception Occured. Please retry with correct input.",
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
