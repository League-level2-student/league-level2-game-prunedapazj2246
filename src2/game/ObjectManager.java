package game;

import java.util.ArrayList;
import java.util.Random;

public class ObjectManager{
BobThePersonWhoRuns bob2;
ArrayList<Trains>trains= new ArrayList<Trains>();
ArrayList<Benches>benches= new ArrayList<Benches>();
ArrayList<Coins>coins= new ArrayList<Coins>();
Random r = new Random();
public ObjectManager(BobThePersonWhoRuns bob2) {
	this.bob2=bob2;
}
public void addTrains() {
	trains.add(new Trains(r.nextInt(SubwaySurfers.WIDTH),0,50,50));
}
public void addBenches() {
	benches.add(new Benches(r.nextInt(SubwaySurfers.WIDTH),0,50,50));
}
public void addCoins() {
	coins.add(new Coins(r.nextInt(SubwaySurfers.WIDTH),0,50,50));
}
}