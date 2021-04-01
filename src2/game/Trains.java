package game;

import java.awt.Color;
import java.awt.Graphics;

public class Trains extends GameObject{

	public Trains(int x, int y, int width, int height) {
		super(x, y, width, height);
	speed =2;	
	}
	
	public void update() {
		x-=speed;
	}
	public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
		
	}
}
