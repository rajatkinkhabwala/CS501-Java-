/**
 * 
 * @author Rajat
 * Purpose: A class for a system of linear equations.
 * Date: Mar 11, 2016
 */
public class C8E11LinearEquation {

	private double a, b, c, d, e, f;
	private double x1, y1, x2, y2, x3, y3, x4, y4;
	C8E11LinearEquation(double A, double B, double C, double D, double E, double F) throws Exception{
			setA(A); 
			setB(B); 
			setC(C); 
			setD(D); 
			setE(E); 
			setF(F); 
			//b = B; c = C; d = D; e = E; f = F;
	}

	C8E11LinearEquation(double X1, double Y1, double X2, double Y2, double X3, double Y3, double X4, double Y4) {
		x1 = X1; y1 = Y1; x2 = X2; y2 = Y2; x3 = X3; y3 = Y3; x4 = X4; y4 = Y4; 
	}
	
	boolean isSolvable() {
		if ((a * d - b * c) == 0)
			return false;
		else
			return true;
	}
	
	public void setA(double A) throws Exception
	{
		a = A;
	}
	public void setB(double B) throws Exception
	{
		b = B;
	}
	public void setC(double C) throws Exception
	{
		c = C;
	}
	public void setD(double D) throws Exception
	{
		d = D;
	}
	public void setE(double E) throws Exception
	{
		e = E;
	}
	public void setF(double F) throws Exception
	{
		f = F;
	}
	double getX() {
		double x = (e * d - b * f) / (a * d - b * c);
		return x;
	}

	double getY() {
		double y = (a * f - e * c) / (a * d - b * c);
		return y;
	}
	
	boolean intersectCheck() {
		if((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4) == 0)
			return false;
		else
			return true;
	}
	
	double getXp() {
		return ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4));
	}

	double getYp() {
		return ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4));
	}
}
