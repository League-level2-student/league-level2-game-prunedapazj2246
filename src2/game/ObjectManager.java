package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
BobThePersonWhoRuns bob2;
ArrayList<Trains>trains= new ArrayList<Trains>();
ArrayList<Benches>benches= new ArrayList<Benches>();
ArrayList<Coins>coins= new ArrayList<Coins>();
Random r = new Random();
public ObjectManager(BobThePersonWhoRuns bob2) {
	this.bob2=bob2;
}
public void addTrains() {
	trains.add(new Trains(1500,r.nextInt(SubwaySurfers.HEIGHT),100,70));
}
public void addBenches() {
	benches.add(new Benches(1500,r.nextInt(SubwaySurfers.HEIGHT),60,60));
}
public void addCoins() {
	coins.add(new Coins(1500,r.nextInt(SubwaySurfers.HEIGHT),70,70));
}


public void update() {
for(Trains t:trains) {
	t.update();
	if(t.x<SubwaySurfers.WIDTH) {
	t.isActive=false;	
	}
}	
for(Benches b:benches) {
	b.update();
	if(b.x<SubwaySurfers.WIDTH) {
		b.isActive=false;	
		}
}
for(Coins c:coins) {
	c.update();
	if(c.x<SubwaySurfers.WIDTH) {
		c.isActive=false;	
		}
}
}
public void draw(Graphics g) {
bob2.draw(g);	

for(Trains t:trains) {
t.draw(g);	
}

for(Benches b:benches) {
b.draw(g);	
}

for(Coins c:coins) {
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
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addTrains();
	addBenches();
	addCoins();
}

}