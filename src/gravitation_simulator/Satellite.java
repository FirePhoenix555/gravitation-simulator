package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class Satellite {
	
	public static final float dt = 0.01f;
	
	int r;
	float mass;
	
	Vector x, v, a;
	
	public Satellite(int x_, int y_, int r_) {
		r = r_;
		mass = (float) (Math.PI * r*r);
		
		x = new Vector(x_, y_);
		v = new Vector(0, 0);
		a = new Vector(0, 0);
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval((int) x.x - r, (int) x.y - r, r*2, r*2);
	}
	
	public void update() {
		v.scale(dt);
		a.scale(dt);
		x.add(v);
		v.add(a);
	}
}
