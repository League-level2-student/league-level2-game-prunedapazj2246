package game;

import java.awt.Rectangle;

public class GameObject {
	Rectangle collisionBox;
int x;
int y;
int width;
int height;
int speed = 0;
int speed2 =0;
int jumpY=0;
int jumpX=0;
boolean isActive = true;

public GameObject(int x, int y, int width, int height) {
this.x=x;
this.y=y;
this.width=width;
this.height=height;
collisionBox = new Rectangle(x,y,width,height);
}

void update() {
	collisionBox.setBounds(x, y, width, height);
}
}
