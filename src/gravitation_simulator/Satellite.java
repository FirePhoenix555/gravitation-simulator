package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class Satellite {
	
	public static final double spf = 1f/GameHandler.fps; // seconds per frame
	public static final double dt = 31536000/20 * spf; // sped up by factor
	
	int r;
	double mass;
	
	Vector x, v, a;
	
	public Satellite(Planet p, float x_, float y_, int r_) {
		r = r_;
		mass = 5.97219 * Math.pow(10, 24); //Math.PI * r*r;
		
		double distToPlanet = 150000000000d;//Math.sqrt((x_ - p.x)*(x_ - p.x) + (y_ - p.y)*(y_ - p.y));
		
		x = Vector.xy(x_, y_);
		v = Vector.xy(0, spf/GameHandler.scale*Math.sqrt((Force.G * p.mass) / distToPlanet));
		a = Vector.xy(0, 0);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		int r1 = 5;
		g.fillOval((int) (x.x - r1), (int) (x.y - r1), r1*2, r1*2);
	}
	
	public void update() {
		System.out.println(v.y);
		x.add(v.scale(1));
//		x.add(Vector.xy(-250, -250));
//		x = x.scale(1/dt);
//		x.add(Vector.xy(250, 250));
		v.add(a.scale(1));
//		v = v.scale(1/dt);
//		System.out.println(v.y);
//		System.out.println("--");
		
//		a = new Vector();
	}
	
	public void applyForce(Force f) {
//		System.out.println(a.x);
		a.add(f.scale(1/mass));
	}
}
