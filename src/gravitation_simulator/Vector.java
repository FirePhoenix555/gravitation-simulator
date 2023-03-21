package gravitation_simulator;

public class Vector {
	
	double x, y;
	double t, r;
	
	public Vector() {
		x = 0;
		y = 0;
	}
	
	private Vector(double x_, double y_) {
		x = x_;
		y = y_;
		t = Math.atan2(y, x);
		r = Math.sqrt(x*x + y*y);
	}
	
	public static Vector xy(double x_, double y_) {
		return new Vector(x_, y_);
	}
	
	public static Vector rt(double r_, double t_) {
		double x_ = r_ * Math.cos(t_);
		double y_ = r_ * Math.sin(t_);
		
		return new Vector(x_, y_);
	}
	
	public void add(Vector v) {
		x += v.x;
		y += v.y;
		t = Math.atan2(y, x);
		r = Math.sqrt(x*x + y*y);
	}
	
	public Vector scale(double s) {
//		System.out.println(y*s);
//		System.out.println(y);
		return new Vector((float) x*s, (float) y*s);
	}
	
	public static double dot(Vector a, Vector b) {
		return a.x * b.x + a.y * b.y;
	}
	
	public static double crossMag(Vector a, Vector b) {
		return a.r * b.r * Math.sin(Math.abs(a.t - b.t));
	}
	
	public static double getDir(int x1, int y1, int x2, int y2) {
		return Math.atan2(y2 - y1, x2 - x1);
	}
	
}
