/*
 * Author: Rajat
 
 * Purpose: To calculate the area of the triangle with given coordinates.
 */

import javax.swing.JOptionPane;
public class C2E15AreaOfATriangle {

	public static void main(String args[]) {
		
		//Display message box with the description.
		JOptionPane.showMessageDialog(null,"Enter the co11ordinates (x1,y1), (x2,y2), (x3,y3) of the triangle to compute the area. ","Exercise Description",JOptionPane.INFORMATION_MESSAGE );
		
		//Display Input dialog box for intake of values and store in respective variables.
		try{
				double x1=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for x1 coordinate: ","x1",JOptionPane.QUESTION_MESSAGE));
				double y1=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for y1 coordinate: ","y1",JOptionPane.QUESTION_MESSAGE));
				double x2=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for x2 coordinate: ","x2",JOptionPane.QUESTION_MESSAGE));
				double y2=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for y2 coordinate: ","y2",JOptionPane.QUESTION_MESSAGE));
				double x3=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for x3 coordinate: ","x3",JOptionPane.QUESTION_MESSAGE));
				double y3=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the value for y3 coordinate: ","y3",JOptionPane.QUESTION_MESSAGE));
				
				
				
				//Calculating the length of the sides of the triangle.
				double side1 = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
				double side2 = Math.sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
				double side3 = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
				
				//Calculating the semi-perimeter of the triangle.
				double s = (side1 + side2 + side3)/2; 
				
				//Calculating the area of the given triangle.
				double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
				
				//Display the message dialog box with the are of the triangle.
				JOptionPane.showMessageDialog(null,"The area of the triangle with ("+ x1 +","+y1+"),("+x2+","+y2+"),("+x3 + ","+y3+") as coordinates is : " + area,"Result",JOptionPane.INFORMATION_MESSAGE );
			} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Exception Occured. Please retry the execution.","Exception",JOptionPane.WARNING_MESSAGE );
		}
	}
}
