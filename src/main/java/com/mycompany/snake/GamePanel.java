package com.mycompany.snake;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.Timer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 700;
	static final int UNIT_SIZE = 30;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	static  int DELAY = 35;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	static int bodyParts = 6;
        static LinkedList<Integer> scoreList = new LinkedList<Integer>();
        static int topScore=0;
        static int tries=0;
	int applesEaten;
	static int appleX;
	static int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
        static Color  bbb=Color.black;
        static Color  ddd=Color.green;
        static Color  ccc=Color.red;
        
	JButton gameoverbutton;
	GamePanel(){
		random = new Random();
                gameoverbutton = new JButton("back to menu");
                gameoverbutton.addActionListener(this);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(bbb);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
                if(running) {}
                else{
                this.add(gameoverbutton);
                gameoverbutton.setVisible(false);
                }
		startGame();
	}
        
        
        
	public void startGame() {
		newApple();
		running = true;
                try {
                     
                    if(Sound.M==1){
                Sound.restartMusic("MR SNAKE");
                
                    }else{Snake.clip.stop();
                    Snake.clip.close();
                    }
                    
                   
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
		timer = new Timer(DELAY,this);
		timer.start();
                
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		
		if(running) {
			
                        Snake sn = new Snake();
                        Snake.clip.loop(Clip.LOOP_CONTINUOUSLY);
			g.setColor(ccc);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
			for(int i = 0; i< bodyParts;i++) {
				if(i == 0) {
					g.setColor(ddd);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(ddd);
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
			g.setColor(ccc);
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		}
		else{
                    gameOver(g);
                    
                    Thread thread = new Thread(() -> {
                    try {
                        Sound.restartMusic("_Bonnie's Lullaby_ HD Version - FNAF 3 Minigame Music.wav");
                        Thread.sleep(3000);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(gameoverbutton);
                        frame.dispose();
                        Menu menu = new Menu();  
                        Sound.restartMusic("AAAA.wav");
                        }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                    Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
        thread.start();                   
                    }		
	}
	public void newApple(){
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move(){
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
                        if (topScore<=applesEaten){
                        topScore=applesEaten;
                        }
			newApple();
		}
	}
	public void checkCollisions() {
		//checks if head collides with body
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
                                scoreList.add(applesEaten);
                                tries=tries+1;
                                bodyParts=6;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
                        scoreList.add(applesEaten);
                        tries=tries+1;
                        bodyParts=6;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
                        scoreList.add(applesEaten);
                        tries=tries+1;
                        bodyParts=6;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
                        scoreList.add(applesEaten);
                        tries=tries+1;
                        bodyParts=6;
		}
		//check if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
                        scoreList.add(applesEaten);
                        tries=tries+1;
                        bodyParts=6;
		}
		
		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		//Score
		g.setColor(Color.red);
                
                
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
                if (e.getSource() == gameoverbutton) {
                Menu menu = new Menu();
                
            }
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}
}