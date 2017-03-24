import javax.swing.JOptionPane;

/**
 * 
 * @author Rajat
 * Purpose: To display the area, perimeter and check different methods in MyRectangle2D class.
 * Date: Apr 8, 2016
 */
public class C10E13Rectangle2D {

	public static void main(String[] args) {
		String programDescription = "This program :\n 1. Displays area and perimeter of the given rectangle.\n "
									+"2. Verifies whether given point lies inside the given rectangle.\n"
									+" 3. Verifies whether a specified rectangle is inside the given rectangle.\n"
									+" 4. Verifies whether a specified rectangle overlaps the given rectangle\n";
		String result = "";
		boolean continueProgram = true;
		
		JOptionPane.showMessageDialog(null, programDescription,
				"Program description", JOptionPane.INFORMATION_MESSAGE);
		while (continueProgram) {
			try {
				String inputFirstRectangle = JOptionPane.showInputDialog(null,"Enter the center(x,y) coordinates x, y, width and height of the BASIC RECTANGLE, \nThe values entered must be separated with spaces.","Initial Rectangle",JOptionPane.QUESTION_MESSAGE);
				String[] basicRectangle = inputFirstRectangle.split(" ");
				double xc = Double.parseDouble(basicRectangle[0]);
				double yc = Double.parseDouble(basicRectangle[1]);
				double basicW = Double.parseDouble(basicRectangle[2]);
				double basicH = Double.parseDouble(basicRectangle[3]);
				MyRectangle2D basicRec = new MyRectangle2D(xc,  yc, basicW, basicH);
				
				/* 
				 * Inner section starts
				 */
				boolean continueInnerProgram = true;
				while (continueInnerProgram) {
					int option = Integer.parseInt(JOptionPane.showInputDialog(null,
							"1. Display area and perimeter of the given basic rectangle."+"\n2. Verify whether given point lies inside the basic rectangle."+"\n3. Verify whether a specified rectangle is inside the given basic rectangle."+"\n4. Verify whether a specified rectangle overlaps the given basic rectangle."+"\n\nSelect the option which needs to be executed.", "Select Choice",
							JOptionPane.QUESTION_MESSAGE));
					switch (option) {
					//Display area and perimeter of the given basic rectangle.
					case 1:
								JOptionPane.showMessageDialog(null, "Area and perimeter of the basic Rectanle, center ("+xc+", "+yc+") width "+basicW+", height "+basicH+" is: "+basicRec.getArea()+" and "+basicRec.getPerimeter()+" respectively.", "Result", JOptionPane.INFORMATION_MESSAGE);
							break;
							
							//Verify whether given point lies inside the basic rectangle
							case 2:
								String input1 = JOptionPane
										.showInputDialog(
												null,
												"Enter point x, y to test if it lies inside basic rectangle.",
												"Input", JOptionPane.QUESTION_MESSAGE);
								String[] inputStringArray = input1.split(" ");
								double xp = Double.parseDouble(inputStringArray[0]);
								double yp = Double.parseDouble(inputStringArray[1]);
								boolean check1 = basicRec.contains(xp, yp);
								if(check1)
									JOptionPane.showMessageDialog(null, "Point P("+xp+", "+yp+") lies inside the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
								else
									JOptionPane.showMessageDialog(null, "Point P("+xp+", "+yp+") does not lies inside the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
								
								break;
							
							//Verify whether a specified rectangle is inside the given basic rectangle.
							case 3:
								String input2 = JOptionPane
								.showInputDialog(
										null,
										"Enter the center(x,y) coordinates x, y, width and height of the test Rectangle, entered values separated must be with spaces.",
										"Rectangle Inside Rectangle?", JOptionPane.QUESTION_MESSAGE);
								String[] inputArray2 = input2.split(" ");
								double x2 = Double.parseDouble(inputArray2[0]);
								double y2 = Double.parseDouble(inputArray2[1]);
								double W2 = Double.parseDouble(inputArray2[2]);
								double H2 = Double.parseDouble(inputArray2[3]);
								boolean check2 = basicRec.contains(new MyRectangle2D(x2, y2, W2, H2));
								if(check2)
									JOptionPane.showMessageDialog(null, "Rectanle with center ("+x2+", "+y2+") width "+W2+", height "+H2+" lies inside the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
								else
									JOptionPane.showMessageDialog(null, "Rectanle with center ("+x2+", "+y2+") width "+W2+", height "+H2+" does not lies inside the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
								break;
								
							//Verify whether a specified rectangle overlaps the given basic rectangle.
							case 4:
							String input3 = JOptionPane
							.showInputDialog(
									null,
									"Enter the center(x,y) coordinates x, y, width and height of the Rectangle to test overlap condition, entered values separated must be with spaces.",
									"Rectangle Overlaps Rectangle?", JOptionPane.QUESTION_MESSAGE);
							String[] inputArray3 = input3.split(" ");
							double x3 = Double.parseDouble(inputArray3[0]);
							double y3 = Double.parseDouble(inputArray3[1]);
							double W3 = Double.parseDouble(inputArray3[2]);
							double H3 = Double.parseDouble(inputArray3[3]);
							
							boolean check3 = basicRec.overlaps(new MyRectangle2D(x3, y3, W3, H3));
							if(check3)
								JOptionPane.showMessageDialog(null, "Rectanle with center ("+x3+", "+y3+") width "+W3+", height "+H3+" overlaps the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, "Rectanle with center ("+x3+", "+y3+") width "+W3+", height "+H3+" does not overlap the Basic Rectangle.", "Result", JOptionPane.INFORMATION_MESSAGE);
							
							break;
						}//switch ends

					// Ask user if the program needs to be re-executed.
					int confirmInnerOption = JOptionPane.showConfirmDialog(null,
							"Do you want to test with multiple test points and rectangles?",
							"Repeat confirmation", JOptionPane.YES_NO_OPTION);
					if (confirmInnerOption == 0)
						continueInnerProgram = true;
					else
						continueInnerProgram = false;
				}//Inner while loop ends.
				
				/*
				 * Inner section ends
				 */
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Exception caught.\nMessage: " + e.getMessage(),
						"Exception", JOptionPane.ERROR_MESSAGE);
			}
			// Ask user if the program needs to be re-executed.
			int confirmOption = JOptionPane.showConfirmDialog(null,
					"Do you want to repeat the program with different basic Rectangle?",
					"Repeat confirmation", JOptionPane.YES_NO_OPTION);
			if (confirmOption == 0)
				continueProgram = true;
			else
				continueProgram = false;
		}

	}

}
