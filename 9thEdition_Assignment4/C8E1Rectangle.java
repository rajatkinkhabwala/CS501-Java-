/**
 * 
 * @author Rajat
 * Purpose: This class represents a rectangle.
 * Date: Mar 9, 2016
 */
public class C8E1Rectangle {

	double width = 1; //Width of the rectangle
	double height = 1; //Height of the rectangle
	
	//No argument constructor to create default rectangle.
	C8E1Rectangle() {
	}
	
	//A constructor that creates a rectangle with the specified width and height.
	C8E1Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	//Return area of the rectangle.
	double getArea() {
		return width * height;
	}
	
	//Return perimeter of the rectangle.
	double getPerimeter() {
		return 2 * (width + height);
	}
}
