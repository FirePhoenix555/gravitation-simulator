package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class Satellite {
	
	public static final double spf = 1f/GameHandler.fps; // seconds per frame
	public static final double dt = 31536000/20 * spf; // sped up by factor
	
	public static final double density = 5510000000d;
	
	double r;
	int displayRadius;
	double mass;
	
	Vector x, v, a;
	
	public Satellite(Planet p, double x_, double y_, double r_) {
		r = r_;
		displayRadius = 5;
		mass = 6 * Math.pow(10, 24);//density * 4/3f * Math.PI * r*r*r;
		
		double distToPlanet = GameHandler.scale*Math.sqrt((x_ - p.x)*(x_ - p.x) + (y_ - p.y)*(y_ - p.y));
		
		x = Vector.xy(x_, y_);
		v = Vector.xy(0, Math.sqrt((Force.G * p.mass) / distToPlanet));
		a = Vector.xy(0, 0);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval((int) x.x - displayRadius, (int) x.y - displayRadius, displayRadius*2, displayRadius*2);
	}
	
	public void update() {
//		System.out.println(dt/GameHandler.scale*v.y);
		x.add(v.scale(dt/GameHandler.scale));
//		x.add(Vector.xy(-250, -250));
//		x = x.scale(1/dt);
//		x.add(Vector.xy(250, 250));
		v.add(a.scale(dt));
//		v = v.scale(1/dt);
//		System.out.println(v.y);
//		System.out.println("--");
		
//		a = new Vector();
	}
	
	public void applyForce(Force f) {
//		System.out.println(dt*f.x/mass);
//		a.add(f.scale(1/mass));
		a=f.scale(1/mass);
	}
}
