/**
 * 
 * @author Rajat
 * Purpose: Defines 2D rectangle class.
 * Date: Apr 8, 2016
 */
public class MyRectangle2D {

	private double x, y; // center coordinates of rectangle.
	private double width, height; // Width and height of the rectangle.

	public MyRectangle2D() {
		x = y = 0;
		width = height = 1;
	}

	public MyRectangle2D(double x, double y, double w, double h) {
		setX(x);
		setY(x);
		setWidth(w);
		setHeight(h);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Returns area of the rectangle.
	public double getArea() {
		return width * height;
	}

	// returns perimeter of the rectangle.
	public double getPerimeter() {
		return 2 * (width + height);
	}

	// Returns true if the specified point (x, y) is inside this rectangle.
	public boolean contains(double xs, double ys) {
		//System.out.println("width: "+width+" height: "+height);
		//System.out.println("x: "+x+" xs: "+xs);
		//System.out.println("y: "+y+" ys: "+ys);
		return Math.abs(xs-this.x) < width / 2 && Math.abs(ys-this.y)< height / 2;
	}

	// Returns true if the specified rectangle is inside this rectangle.
	public boolean contains(MyRectangle2D r) {
		return contains(r.x - r.width / 2, r.y + r.height / 2) &&
			      contains(r.x - r.width / 2, r.y - r.height / 2) &&
			      contains(r.x + r.width / 2, r.y + r.height / 2) &&
			      contains(r.x + r.width / 2, r.y - r.height / 2);
	}

	// Returns true if the specified rectangle overlaps with this rectangle.
	public boolean overlaps(MyRectangle2D r) {
		return Math.abs(this.x - r.x) <= (this.width + r.width) / 2 &&
			      Math.abs(this.y - r.y) <= (this.height + r.height) / 2;
	}

}
