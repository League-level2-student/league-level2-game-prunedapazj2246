package game;

import java.awt.Color;
import java.awt.Graphics;

public class BobThePersonWhoRuns extends GameObject{

	public BobThePersonWhoRuns(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void draw(Graphics g) {
	 g.setColor(Color.BLUE);
     g.fillRect(x, y, width, height);
}
}
