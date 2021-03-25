package game;

public class GameObject {
int x;
int y;
int width;
int height;
int speed = 0;
int jumpY=0;
int jumpX=0;
boolean isActive = true;

public GameObject(int x, int y, int width, int height) {
this.x=x;
this.y=y;
this.width=width;
this.height=height;
}

void update() {
	
}
}
