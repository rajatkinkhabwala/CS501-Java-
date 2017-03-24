import javax.swing.JOptionPane;

/**
* 
* @author Rajat
* Purpose: To find whether the given point is inside/outside or on the given rectangle.
* Date: 2-20-2016
*/
public class C3E28PointOverlapRectangle {

	public static void main(String[] args) {
		String programDescription = "This program is used to test if the given point is inside, outside, or on the boundary of the rectangle whose details are given";
		boolean continueProgram = true;
		while(continueProgram){
			try{
				//To display the information to the user about the program.
				JOptionPane.showMessageDialog(null, programDescription, "Program Description", JOptionPane.INFORMATION_MESSAGE);
				
				//Input height, width, x , y coordinates from user.
				String input = JOptionPane.showInputDialog(null, "Enter the rectangle's center x-coordinate, y-coordinate  and its width and height separated with spaces","User Input",JOptionPane.QUESTION_MESSAGE);	
				//Separate the input given by user using space delimiter.
				String[] inputDetails = input.split(" ");
				
				double x = Double.parseDouble(inputDetails[0]);
				double y = Double.parseDouble(inputDetails[1]);
				double width = Double.parseDouble(inputDetails[2]);
				double height = Double.parseDouble(inputDetails[3]);
				
				//Create the rectangle vertices A(x1, y1) B(x2, y2) C(x3, y3) D(x4, y4) using the above details.
				double x1 = x - (width/2);
				double y1 = y + (height/2);
				double x2 = x + (width/2);
				double y2 = y + (height/2);
				double x3 = x + (width/2);
				double y3 = y - (height/2);
				double x4 = x - (width/2);
				double y4 = y - (height/2);
				
				//Input P(xp, yp) of the point whose position is to be found.
				String inputPoint = JOptionPane.showInputDialog(null, "Enter the point coordinates whose position is to be found, separated with spaces.","User Input",JOptionPane.QUESTION_MESSAGE);
				String[] pointInputDetails = inputPoint.split(" ");
				
				double xp = Double.parseDouble(pointInputDetails[0]);
				double yp = Double.parseDouble(pointInputDetails[1]);
				
				//Area of triangle PAB.
				double areaOfPAB = Math.abs(xp * (y1 - y2) + x1 * (y2 - yp) + x2 * (yp - y1))/2;
				//Area of triangle PBC.
				double areaOfPBC = Math.abs(xp * (y2 - y3) + x2 * (y3 - yp) + x3 * (yp - y2))/2;
				//Area of triangle PCD.
				double areaOfPCD = Math.abs(xp * (y3 - y4) + x3 * (y4 - yp) + x4 * (yp - y3))/2;
				//Area of triangle PDA.
				double areaOfPDA = Math.abs(xp * (y1 - y4) + x1 * (y4 - yp) + x4 * (yp - y1))/2;
				
				double sumOfAreas = areaOfPAB + areaOfPBC + areaOfPCD + areaOfPDA;
				double areaOfrectangle = width * height;
				
				String result;
				
				if((areaOfPAB == 0 || areaOfPBC == 0 || areaOfPCD == 0 || areaOfPDA == 0)) {
					//Point lies inside the rectangle On the rectangle edges.
					result = "on the boundary of the rectangle";
				}
				else {
					if(sumOfAreas == areaOfrectangle){
						//Point lies inside the rectangle
						result = "inside the rectangle";
					}
					else {
						//Point lies outside the rectangle
						result = "outside the rectangle";
					}	
				}
				
				//Display result.
				result = "Point P("+xp+", "+yp+") "+"lies "+ result+" whose center is ("+x+", "+y+")"+", width "+ width + " and height "+height;
				JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e) {
				//Display warning box if any exception occurs.
				JOptionPane.showMessageDialog(null, "Exception occured. Please try executing the program again with correct input.", "Exception", JOptionPane.WARNING_MESSAGE);
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
