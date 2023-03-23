package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class Planet {
	
	public static final double density = 300000;
	
	double x, y;
	double r;
	
	int displayRadius = 20;
	
	double mass;
	
	public Planet(int x_, int y_, double r_) {
		x = x_;
		y = y_;
		r = r_;
		
		mass = 1.9891 * Math.pow(10,30);//density * Math.PI * r*r; // 2d volume = area
	}
	
	
	public void draw(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillOval((int) x - displayRadius, (int) y - displayRadius, displayRadius*2, displayRadius*2);
	}
}
