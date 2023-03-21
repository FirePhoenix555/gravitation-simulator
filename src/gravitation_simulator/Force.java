package gravitation_simulator;

public class Force extends Vector {
	
	public static final double G = 6.67 * Math.pow(10, -11);
	
	public Force(double r_, double t_) {
		super();
		
		x = r_ * Math.cos(t_);
		y = r_ * Math.sin(t_);
		t = t_;
		r = r_;
	}
}
