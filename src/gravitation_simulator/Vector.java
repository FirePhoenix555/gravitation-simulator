package gravitation_simulator;

public class Vector {
	
	float x, y;
	double t, r;
	
	public Vector(float x_, float y_) {
		x = x_;
		y = y_;
		t = Math.atan2(y, x);
		r = Math.sqrt(x*x + y*y);
	}
	
	public Vector(double r_, double t_) {
		x = (int) (r_ * Math.cos(t_));
		y = (int) (r_ * Math.sin(t_));
		t = t_;
		r = r_;
	}
	
	public void add(Vector v) {
		x += v.x;
		y += v.y;
		t = Math.atan2(y, x);
		r = Math.sqrt(x*x + y*y);
	}
	
	public void scale(float s) {
		x *= s;
		y *= s;
		t = Math.atan2(y, x);
		r = Math.sqrt(x*x + y*y);
	}
	
	public static double dot(Vector a, Vector b) {
		return a.x * b.x + a.y * b.y;
	}
	
	public static double crossMag(Vector a, Vector b) {
		return a.r * b.r * Math.sin(Math.abs(a.t - b.t));
	}
	
}
