package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	@Override
	public void paintComponent(Graphics g){
g.setColor(Color.CYAN);
g.fillRect(10, arg1, arg2, arg3);
	}
}
