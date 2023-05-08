
package com.mycompany.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Menu extends JFrame implements ActionListener {
    JButton startButton, optionsButton, quitButton,scoreButton;
     
     static int R=100,G=178,B=54;
    
    public Menu() {
        setTitle("Snake Game");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
      
       
    
        
        
        JPanel P1 = new JPanel();
        P1.setPreferredSize(new Dimension(800, 500));
        ImageIcon icon = new ImageIcon("5.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, P1.getWidth(), P1.getHeight());
        P1.add(label);
        P1.setPreferredSize(new Dimension(800, 500));
        getContentPane().add(P1);
      
        
      
        
        Dimension buttonSize = new Dimension(100, 50);
        
        
        
        startButton = new JButton("Start Game");
        startButton.setPreferredSize(buttonSize);
        startButton.setFocusPainted(false);
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(R, G, B));
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setBounds(282, 80, 200, 80);
        startButton.setBorderPainted(false);
        startButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                startButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                startButton.setBackground(new Color(R, G, B));
            }
        });
        

        
        optionsButton = new JButton("Options");
        optionsButton.setPreferredSize(buttonSize);
        optionsButton.setForeground(Color.WHITE);
        optionsButton.setBackground(new Color(R, G, B));
        optionsButton.setFont(new Font("Arial", Font.BOLD, 14));
        optionsButton.setBounds(282, 180, 200, 80);
        optionsButton.setBorderPainted(false);
        optionsButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                optionsButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                optionsButton.setBackground(new Color(R, G, B));
            }
        });
        
        scoreButton = new JButton("top score");
        scoreButton.setPreferredSize(buttonSize);
        scoreButton.setForeground(Color.WHITE);
        scoreButton.setBackground(new Color(R, G, B));
        scoreButton.setFont(new Font("Arial", Font.BOLD, 14));
        scoreButton.setBounds(282, 280, 200, 80);
        scoreButton.setBorderPainted(false);
        scoreButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                scoreButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                
                scoreButton.setBackground(new Color(R, G, B));
            }
        });
        
        
        
        quitButton = new JButton("Quit");
        quitButton.setPreferredSize(buttonSize);
        quitButton.setForeground(Color.WHITE);
        quitButton.setBackground(new Color(R, G, B));
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        quitButton.setBounds(282, 380, 200, 80);
        quitButton.setBorderPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
               
                quitButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                quitButton.setBackground(new Color(R, G, B));
            }
        });
        
        Container contentPane = getContentPane();
        
        getContentPane().setBackground(Color.BLACK);
       
        GridBagConstraints c = new GridBagConstraints();
        
        
        startButton.addActionListener(this);
        optionsButton.addActionListener(this);
        quitButton.addActionListener(this);
        scoreButton.addActionListener(this);
        
        
        getContentPane().add(startButton);
        getContentPane().add(optionsButton);
        getContentPane().add(quitButton);
        getContentPane().add(scoreButton);
        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            GameFrame gameFrame = new GameFrame();
            Snake sn = new Snake();
            try {
                Sound.stopMusic("AAAA.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else if (e.getSource() == optionsButton) {
            Options opt = new Options();
            dispose();
            
            
        } else if (e.getSource() == quitButton) {
            System.out.println("Goodbye!");
            System.exit(0);
        }else if (e.getSource() == scoreButton) {
            ScoreButton opt = new ScoreButton();
            dispose();
        }
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}