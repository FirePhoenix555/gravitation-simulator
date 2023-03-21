package gravitation_simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameHandler extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final double scale = 150000000000d/200;// 20000000; // meters per pixel
	
	final int width = 500, height = 500;
	final static int fps = 30; // how often the game updates
	
	Thread gameThread;
	
	MouseHandler mh = new MouseHandler();
	
	Planet p = new Planet(width/2, height/2, (int) (695700000/scale));
	Satellite s = new Satellite(p, width/2 + 200, height / 2, (int) (6378100/scale));
	
	public GameHandler() {
		setPreferredSize(new Dimension(width, height));
		setDoubleBuffered(true);
		addMouseListener(mh);
		setFocusable(true);
		
		initialize();
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void initialize() {
		this.setBackground(Color.black);
	}

	@Override
	public void run() {
		double loopInterval = 1000000000/fps;
		double nextLoopTime = System.nanoTime() + loopInterval;
		
		while (gameThread != null) {
			update();
			repaint();
			
			try {
				double remainingTime = (nextLoopTime - System.nanoTime())/1000000;
				if (remainingTime < 0) remainingTime = 0;
				Thread.sleep((long) remainingTime);
				nextLoopTime += loopInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void update() {
		mh.updateMouseLocation(this);
		
		double distToPlanet = Math.sqrt((s.x.x - p.x)*(s.x.x - p.x) + (s.x.y - p.y)*(s.x.y - p.y))*scale;
		
		double magnitude = (Force.G * p.mass * s.mass) / (distToPlanet*distToPlanet);
		double direction = Vector.getDir((int) s.x.x, (int) s.x.y, p.x, p.y);
		Force f = new Force(magnitude, direction);
//		System.out.println(magnitude/scale);
		s.applyForce(f);
		s.update();
	}
	
	@Override
	public void paintComponent(Graphics g_) {
		super.paintComponent(g_);
		
		Graphics2D g = (Graphics2D) g_;
		
		p.draw(g);
		s.draw(g);
	
		g.dispose();
	}
}