package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
BobThePersonWhoRuns bob2;
ArrayList<Train>trains= new ArrayList<Train>();
ArrayList<Bench>benches= new ArrayList<Bench>();
ArrayList<Coin>coins= new ArrayList<Coin>();
Random r = new Random();
public ObjectManager(BobThePersonWhoRuns bob2) {
	this.bob2=bob2;
}
public void addTrains() {
	//trains.add(new Trains(1500,r.nextInt(500)+200,100,70));
	
	if(r.nextInt(3)==0) {
	trains.add(new Train(1500,250,50,50));
	}
	else if(r.nextInt(3)==1) {
	trains.add(new Train(1500,415,50,50));
	}
	else {
	trains.add(new Train(1500,580,50,50));
	}
}
public void addBenches() {
//	benches.add(new Benches(1500,r.nextInt(500)+200,60,60));
	if(r.nextInt(3)==0) {
		benches.add(new Bench(1500,250,50,50));
	}
	else if(r.nextInt(3)==0) {
		benches.add(new Bench(1500,415,50,50));
	}else {
	benches.add(new Bench(1500,580,50,50));
	}
}
public void addCoins() {
	//coins.add(new Coins(1500,r.nextInt(500)+200,70,70));
	if(r.nextInt(3)==0) {
		coins.add(new Coin(1500,250,50,50));
	}
	else if(r.nextInt(3)==1) {
		coins.add(new Coin(1500,415,50,50));
	}
	else{
	coins.add(new Coin(1500,580,50,50));
	}
}


public void update() {
for(Train t:trains) {
	t.update();
	if(t.x<SubwaySurfers.WIDTH) {
	t.isActive=false;	
	}
}	
for(Bench b:benches) {
	b.update();
	if(b.x<SubwaySurfers.WIDTH) {
		b.isActive=false;	
		}
}
for(Coin c:coins) {
	c.update();
	if(c.x<SubwaySurfers.WIDTH) {
		c.isActive=false;	
		}
}


//purgeObjects();
checkCollision();
}
public void draw(Graphics g) {
bob2.draw(g);	

for(Train t:trains) {
t.draw(g);	
}

for(Bench b:benches) {
b.draw(g);	
}

for(Coin c:coins) {
c.draw(g);	
}
}

public void purgeObjects() {
	for (int i = 0; i < trains.size(); i++) {
		
	if(!trains.get(i).isActive) {
		trains.remove(i);
	}
	}
	
	for (int i = 0; i < benches.size(); i++) {
		if(!benches.get(i).isActive) {
			benches.remove(i);
		}	
	}
	
	for (int i = 0; i < coins.size(); i++) {
		if(!coins.get(i).isActive) {
			coins.remove(i);
		}
	}
}

public void checkCollision() {
	for (int i = 0; i < trains.size(); i++) {
		trains.get(i).isActive=true;
		if(bob2.collisionBox.intersects(trains.get(i).collisionBox)) {
			System.out.println("player dies dies");
			trains.get(i).isActive=false;
			bob2.isActive=false;
			break;
			}
}for (int i = 0; i < benches.size(); i++) {
	benches.get(i).isActive=true;
	if(bob2.collisionBox.intersects(benches.get(i).collisionBox)) {
		System.out.println("player dies");
		benches.get(i).isActive=false;
		bob2.isActive=false;
		break;
		}
}for (int i = 0; i < coins.size(); i++) {
	coins.get(i).isActive=true;
	if(bob2.collisionBox.intersects(coins.get(i).collisionBox)) {
		System.out.println("coin collected");
		coins.get(i).isActive=false;
		break;
	}
}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addTrains();
	addBenches();
	addCoins();
}

}