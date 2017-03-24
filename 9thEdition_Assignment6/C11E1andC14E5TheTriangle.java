import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: 
 * Date: Apr 8, 2016
 */
public class C11E1andC14E5TheTriangle {

	public static void main(String[] args) {
		boolean continueProgram = true;
		String programDescription = "This program displays the AREA, PERIMETER, COLOR of the given triangle, \nand also true or false to indicate whether it is FILLED or not.";
		while (continueProgram) {
			try {
				JOptionPane.showMessageDialog(null, programDescription,
						"Program description", JOptionPane.INFORMATION_MESSAGE);
				String result = "";
				String input = JOptionPane
						.showInputDialog(
								null,
								"Enter three sides of the triangle, a color, and a Boolean value to indicate whether the triangle is filled.\nThe values entered must be separated with spaces.",
								"Input", JOptionPane.QUESTION_MESSAGE);
				String[] inputPoints = input.split(" ");
				//System.out.println(Boolean.getBoolean(inputPoints[4]));
				//System.out.println(inputPoints[4].equals("false"));
				if (!inputPoints[4].equals("true") && !inputPoints[4].equals("false")) {
					Exception e = new Exception(
							"Incorrect input. Please enter true or false to indicate whether the triangle is filled.");
					throw e;
				}
				double s1 = Double.parseDouble(inputPoints[0]);
				double s2 = Double.parseDouble(inputPoints[1]);
				double s3 = Double.parseDouble(inputPoints[2]);
				if(s1+s2 <= s3 || s2+s3 <= s1 || s1+s3 <= s2) {
					IllegalTriangleException tExp = new IllegalTriangleException("In a triangle, the sum of any two sides must be greater than the other side.");
					throw tExp;
				}
				String color = inputPoints[3];
				//System.out.println(Boolean.parseBoolean(inputPoints[4]));
				boolean filled = Boolean.parseBoolean(inputPoints[4]);
				TheTriangle triangle = new TheTriangle(s1, s2, s3, color, filled);
				result = triangle.toString()+"\n"
						+"Area of the triangle is: "+triangle.getArea()+"\n"
						+"Perimeter of the above triangle is: "+triangle.getPerimeter()+"\n"
						+"Color of the triangle: "+triangle.getColor()+"\n"
						+"Triangle filled? "+triangle.isFilled()+"\n";
				JOptionPane.showMessageDialog(null, result, "Result",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Exception caught. Please retry with different input.\nMessage: " + e.getMessage(),
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
