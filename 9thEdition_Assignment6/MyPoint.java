/**
 * 
 * @author Rajat
 * Purpose: This class represents a point with (x,y) as coordinates.
 * Date: Apr 8, 2016
 */
public class MyPoint {

	private double x,y;
	
	public MyPoint() {
		x = y = 0;
	}
	
	public MyPoint(double X, double Y) {
		this.x = X;
		this.y = Y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	//Returns the distance from this point to another point with specified x- and y-coordinates.
	public double distance(double x2, double y2) {
	    return Math.sqrt((Math.pow((this.x - x2), 2) + Math.pow((this.y - y2), 2)));
	}
	
	//Returns the distance from this point to another point of the MyPoint type.
	public double distance(MyPoint other) {
        return other.distance(this.x, this.y);
    }
}
