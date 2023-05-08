package com.mycompany.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Options extends JFrame implements ActionListener {
    JButton speedButton, colorButton, soundButton,backButton;

public Options() {
        setTitle("Snake Game");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        speedButton = new JButton("Game speed");
        colorButton = new JButton("change colors");
        soundButton = new JButton("sound options ");
        backButton = new JButton("back to menu ");
       
        setTitle("Game Menu");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel P1 = new JPanel();
       
        ImageIcon icon = new ImageIcon("5.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, P1.getWidth(), P1.getHeight());
        P1.add(label);
        P1.setPreferredSize(new Dimension(800, 500));
        //P1.setBackground(Color.BLACK);
       
        
        
        
        Dimension buttonSize = new Dimension(100, 50);

        
        
        
        
        speedButton = new JButton("game speed");
        speedButton.setPreferredSize(buttonSize);
        speedButton.setFocusPainted(false);
        speedButton.setForeground(Color.WHITE);
        speedButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        speedButton.setFont(new Font("Arial", Font.BOLD, 14));
        speedButton.setBounds(282, 60, 200, 80);
        speedButton.setBorderPainted(false);
        speedButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
               
                speedButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                
                speedButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        

        
        colorButton = new JButton("change color");
        colorButton.setPreferredSize(buttonSize);
        colorButton.setForeground(Color.WHITE);
        colorButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        colorButton.setFont(new Font("Arial", Font.BOLD, 14));
        colorButton.setBounds(282, 160, 200, 80);
        colorButton.setBorderPainted(false);
        colorButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                colorButton.setBackground(new Color(0, 51, 10));
                
            }
            public void mouseExited(MouseEvent e) {
        
                colorButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
        
        
        soundButton = new JButton("sound settings");
        soundButton.setPreferredSize(buttonSize);
        soundButton.setForeground(Color.WHITE);
        soundButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        soundButton.setFont(new Font("Arial", Font.BOLD, 14));
        soundButton.setBounds(282, 260, 200, 80);
        soundButton.setBorderPainted(false);
        soundButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                soundButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
 
                soundButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
        
        backButton = new JButton("go back to menu");
        backButton.setPreferredSize(buttonSize);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(282, 360, 200, 80);
        backButton.setBorderPainted(false);
        backButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                backButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                
                backButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        Container contentPane = getContentPane();
        getContentPane().setBackground(Color.BLACK);
        GridBagConstraints c = new GridBagConstraints();
        
        speedButton.addActionListener(this);
        colorButton.addActionListener(this);
        soundButton.addActionListener(this);
        backButton.addActionListener(this);
        
        getContentPane().add(speedButton);
        getContentPane().add(colorButton);
        getContentPane().add(soundButton);
        getContentPane().add(backButton);
        
       
        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
        
    
        
        
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
        Menu menu = new Menu();
        dispose();
            }
         else if (e.getSource() == soundButton) {
            Sound soun = new Sound();
          dispose();
     
        } else if (e.getSource() == colorButton) {
          GameColor colo = new GameColor();
          dispose();
        }else if (e.getSource() == speedButton) {
          
          GameSpeed speed = new GameSpeed();
          dispose();
       
            
        }
    }
}
    
    