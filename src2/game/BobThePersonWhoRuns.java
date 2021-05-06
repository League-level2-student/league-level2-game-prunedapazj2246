package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BobThePersonWhoRuns extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public BobThePersonWhoRuns(int x, int y, int width, int height) {
		    super(x, y, width, height);
		speed=160;
		jumpY=70;
		jumpX=40;
		if (needImage) {
		    loadImage ("images.png");
		}
		// TODO Auto-generated constructor stub
	}
	
	
void draw(Graphics g) {
	// g.setColor(Color.BLUE);
    // g.fillRect(x, y, width, height);
     if (gotImage) {
    		g.drawImage(image, x, y, width, height, null);
    	} else {
    		g.setColor(Color.BLUE);
    		g.fillRect(x, y, width, height);
    	}

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
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}
}
