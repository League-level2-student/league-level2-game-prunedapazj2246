package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    BobThePersonWhoRuns bob = new BobThePersonWhoRuns(20,415,70,80);
    
    ObjectManager ob= new ObjectManager(bob);
    
    Timer frameDraw;
    Timer trainsSpawn= new Timer(20000, ob);
Timer benchesSpawn = new Timer(10000, ob);
Timer coinsSpawn=new Timer(15000, ob);

    Font titleFont;
    Font directions;

    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;

    public GamePanel() {
        this.titleFont = new Font("Arial", Font.PLAIN, 48);
        this.directions = new Font("Arial", Font.PLAIN, 24);
        this.frameDraw = new Timer(1000 / 60, this);
        frameDraw.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (currentState == MENU) {
            drawMenuState(g);
        } else if (currentState == GAME) {
            drawGameState(g);
        } else if (currentState == END) {
            drawEndState(g);
        }
    }

    public void updateMenuState() {

    }

    public void updateGameState() {
ob.update();
if(!bob.isActive) {
	currentState=END;
}
    }

    public void updateEndState() {

    }

    public void drawMenuState(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.RED);
        g.drawString("Subway Surfers", 600, 100);
        g.setFont(directions);
        g.setColor(Color.RED);
        g.drawString("Press enter to play the game", 600, 300);
        g.setFont(directions);
        g.setColor(Color.RED);
        g.drawString("Press space for instructions", 600, 500);
    }

    public void drawGameState(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, SubwaySurfers.WIDTH, 200);
        g.setColor(Color.BLACK);
        g.fillRect(0, 200, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT-200);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 360, SubwaySurfers.WIDTH, 10);
        g.fillRect(0, 520, SubwaySurfers.WIDTH, 10);
        g.fillRect(0, 690, SubwaySurfers.WIDTH, 20);
        ob.draw(g);
        String score =String.valueOf(ob.getScore());
        g.setFont(directions);
        g.setColor(Color.white);
        g.drawString(score, 10, 20);
    }

    public void drawEndState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SubwaySurfers.WIDTH, SubwaySurfers.HEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("You lost you suck", 600, 100);
        g.setFont(directions);
        g.setColor(Color.WHITE);
        g.drawString("you got "+ ob.getScore() +" coins" , 600, 300);
        g.setFont(directions);
        g.setColor(Color.WHITE);
        g.drawString("press enter to restart", 600, 500);
    }

    public void startGame() {
        
        trainsSpawn.start();
        
        benchesSpawn.start();
        
        coinsSpawn.start();
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        if (currentState == MENU) {
            updateMenuState();
        } else if (currentState == GAME) {
            updateGameState();
        } else if (currentState == END) {
            updateEndState();
        }
        // System.out.println("action");
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println(arg0.getKeyCode());
        if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("enter");
            if (currentState == END) {
                currentState = MENU;
                bob=new BobThePersonWhoRuns(20,415,70,80);
                System.out.println("restart");
                ob=new ObjectManager(bob);
                benchesSpawn.addActionListener(ob);
                coinsSpawn.addActionListener(ob);
                trainsSpawn.addActionListener(ob);
            } else {
                currentState++;
            }
        }
        if (currentState == GAME) {
            if (arg0.getKeyCode() == KeyEvent.VK_UP) {
                System.out.println("UP");
                bob.up();
                if(bob.y<96) {
                    bob.y=255;
                 }
            } else if (arg0.getKeyCode()==KeyEvent.VK_DOWN){
                System.out.println("DOWN");
                bob.down();
                if(bob.y>575) {
                    bob.y=575;
                }
            }else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            
                System.out.println("LEFT");
                bob.left();
                if(bob.x<=0) {
                	bob.x=0;
                }
                
            } else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
                System.out.println("RIGHT");
                bob.right();
                if(bob.x+70>=SubwaySurfers.WIDTH) {
                	bob.x=SubwaySurfers.WIDTH-70;
                }
            }
            else if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
            	System.out.println("JUMP");
            	bob.jumpUp();
            	 if(bob.x>=SubwaySurfers.WIDTH) {
                 	bob.x=SubwaySurfers.WIDTH;
                 }
            }
            startGame();
        }

        if (currentState == MENU) {
            if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
                JOptionPane.showMessageDialog(null,
                        "The object of the game is to get as may coins as possible. Use the up and down keys to switch lanes and the right and left keys to move across the map. Make sure you dont hit any cars or train or you will die!");
            }
        }
        if(currentState == END) {
            trainsSpawn.stop();
            benchesSpawn.stop();
            coinsSpawn.stop();
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



