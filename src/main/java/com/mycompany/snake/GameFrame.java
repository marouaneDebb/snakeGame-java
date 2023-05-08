package com.mycompany.snake;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	GameFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setUndecorated(true);
                this.setVisible(true);	
		this.add(new GamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
                
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
                
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}