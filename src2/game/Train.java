package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Train extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Train(int x, int y, int width, int height) {
		super(x, y, width, height);
	speed =1;
	if (needImage) {
	    loadImage ("79-799993_train-engine-clipart-cartoon-train-side-view-png.jpg");
	}
	}
	
	public void update() {
		x-=speed;
		super.update();
	}
	public void draw(Graphics g) {
		super.draw(g);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
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
