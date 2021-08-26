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
		speed2=8;
		jumpSpeed=200;
		if (needImage) {
		    loadImage ("images.png");
		}
		// TODO Auto-generated constructor stub
	}
	
	
void draw(Graphics g) {
	super.draw(g);
     if (gotImage) {
    		g.drawImage(image, x, y, width, height, null);
    	} else {
    		g.setColor(Color.BLUE);
    		g.fillRect(x, y, width, height);
    	}

}
void jumpUp() {
	
	x+=jumpSpeed;
	//for (int i = 0; i < 2; i++) {
		//x+=jumpSpeed;
	//}
	update();
}
void left() {
	x-=speed2;
	update();
}
void right() {
	x+=speed2;
	update();
}
void up() {
	y-=speed;	
	update();
}
void down() {
	y+=speed;
	update();
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
void update(){
collisionBox.setBounds(x, y, width, height);
}
}
