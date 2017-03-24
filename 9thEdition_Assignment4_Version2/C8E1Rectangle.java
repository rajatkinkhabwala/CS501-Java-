/**
 * 
 * @author Rajat
 * Purpose: This class represents a rectangle.
 * Date: Mar 9, 2016
 */
public class C8E1Rectangle {

	double width = 1; //Width of the rectangle
	double height = 1; //Height of the rectangle
	private String errorMessage = "";
	
	//No argument constructor to create default rectangle.
	C8E1Rectangle() {
	}
	
	//A constructor that creates a rectangle with the specified width and height.
	C8E1Rectangle(double newWidth, double newHeight) throws Exception {
		setWidth(newWidth);
		setHeight(newHeight);
		
	}
	
	public void setWidth(double newWidth) throws Exception
	{
		if(validate(newWidth)) {
			Exception e = new Exception(errorMessage);
        	throw e;	
		}
		else
			width = newWidth;
	}
	public void setHeight(double newHeight) throws Exception
	{
		if(validate(newHeight)) {
			Exception e = new Exception(errorMessage);
        	throw e;	
		}
		else
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
	
	public String getErrorMessage() { System.out.println("1"+errorMessage); return errorMessage; }
		
	//Validation method.
	boolean validate(double value) throws Exception{
		if(value < 0){
			errorMessage = "Width or height cannot be negative.";
			return true;
		}
		else if(value ==0) {
			errorMessage = "Width or height cannot be 0.";
			return true;
		}
		else
			return false;	
	}
}
