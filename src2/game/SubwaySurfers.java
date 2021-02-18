package game;

import javax.swing.JFrame;

public class SubwaySurfers {
	JFrame frame;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 1200;

	public SubwaySurfers() {
		this.frame = new JFrame();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubwaySurfers sS = new SubwaySurfers();
		sS.setup();
	}

	public void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
