package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class Planet {
	
	public static final double density = 1;
	
	int x, y, r;
	
	float mass;
	
	public Planet(int x_, int y_, int r_) {
		x = x_;
		y = y_;
		r = r_;
		
		mass = (float) (density * Math.PI * r*r); // 2d volume = area
	}
	
	
	public void draw(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillOval(x - r, y - r, r*2, r*2);
	}
}
