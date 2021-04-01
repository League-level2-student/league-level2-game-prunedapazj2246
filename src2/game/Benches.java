package game;

import java.awt.Color;
import java.awt.Graphics;

public class Benches extends GameObject{

	public Benches(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 1;
	}


public void update() {
	x-=speed;
}
public void draw(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(x, y, width, height);
	
}
}
