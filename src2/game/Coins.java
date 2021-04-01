package game;

import java.awt.Color;
import java.awt.Graphics;

public class Coins extends GameObject{

	public Coins(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 3;
	}
	public void update() {
		x-=speed;
	}
	public void draw(Graphics g) {
	    g.setColor(Color.YELLOW);
	    g.fillRect(x, y, width, height);
		
	}
}
