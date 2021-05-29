package game;

import java.util.Random;

import javax.swing.JFrame;

public class SubwaySurfers {
	JFrame frame;
	GamePanel gp;
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 700;

	public SubwaySurfers() {
		this.frame = new JFrame();
		this.gp = new GamePanel();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubwaySurfers sS = new SubwaySurfers();
		sS.setup();
		
	}

	public void setup() {
		frame.add(gp);
		frame.addKeyListener(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
