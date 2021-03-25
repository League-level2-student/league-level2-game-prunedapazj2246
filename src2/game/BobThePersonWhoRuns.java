package game;

import java.awt.Color;
import java.awt.Graphics;

public class BobThePersonWhoRuns extends GameObject{

	public BobThePersonWhoRuns(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=160;
		jumpY=70;
		jumpX=40;
		// TODO Auto-generated constructor stub
	}
void draw(Graphics g) {
	 g.setColor(Color.BLUE);
     g.fillRect(x, y, width, height);
}
void jumpUp() {
	y-=jumpY;
	x+=jumpX;
	y+=jumpY;
	x+=jumpX;
	for (int i = 0; i < 2; i++) {
		x-=jumpX;
	}
}
void left() {
	y-=speed;
}
void right() {
	y+=speed;
}
}
