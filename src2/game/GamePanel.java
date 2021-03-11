package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer frameDraw;
    

	
	Font titleFont;
    Font directions;
	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    
    public GamePanel(){
    	this.titleFont = new Font("Arial", Font.PLAIN, 48);
    	this.directions = new Font("Arial",Font.PLAIN,24);
    this.frameDraw=new Timer(1000/60,this);
    frameDraw.start();
    }
    
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		    g.setFont(titleFont);
		    g.setColor(Color.RED);
		    g.drawString("Subway Surfers", 600, 100);
		    g.setFont(directions);
		    g.setColor(Color.RED);
		    g.drawString("Press enter to play the game", 600, 300);
		    g.setFont(directions);
		    g.setColor(Color.RED);
		    g.drawString("Press space for instructions", 600, 500);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	 public void updateMenuState() {  
		 
	 }
	 public void updateGameState() {  
		 
	 }
	public void updateEndState()  {  
		 
	 }
	
	public void drawMenuState(Graphics g) { 
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT);
	}
	public void drawGameState(Graphics g) {  
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT);
	}
	public void drawEndState(Graphics g)  {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState==MENU) {
			updateMenuState();
		}else if(currentState==GAME) {
		updateGameState();
	}else if (currentState==END) {
		updateEndState();
	}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState==END)
				currentState=MENU;
		}else {
			currentState++;
		}
		
		if(currentState == GAME) {
			if(arg0.getKeyCode()==KeyEvent.VK_UP) {
				System.out.println("UP");
			}
			else if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
			}
			else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
				System.out.println();
			}
		}
			
		if(currentState==MENU) {
			if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
				JOptionPane.showMessageDialog(null, "Use the left and right arrow keys "
						+ "to switch lanes and the up arrow key to jump.");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
