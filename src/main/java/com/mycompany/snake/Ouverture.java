
package com.mycompany.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ouverture extends JFrame implements ActionListener {
    JButton ouvertureButton;

     static int R=100,G=178,B=54;
    
    public Ouverture() {
        setTitle("Snake Game");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        
        JPanel P1 = new JPanel();
        P1.setPreferredSize(new Dimension(800, 500));
        ImageIcon icon = new ImageIcon("6.jpeg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, P1.getWidth(), P1.getHeight());
        P1.add(label);
        P1.setPreferredSize(new Dimension(800, 500));
        getContentPane().add(P1);
      
        
      
        
        Dimension buttonSize = new Dimension(80, 40);
        
        
        
        ouvertureButton = new JButton("Start Game");
        ouvertureButton.setPreferredSize(buttonSize);
        ouvertureButton.setFocusPainted(false);
        ouvertureButton.setForeground(Color.WHITE);
        ouvertureButton.setBackground(new Color(R, G, B));
        ouvertureButton.setFont(new Font("Arial", Font.BOLD, 14));
        ouvertureButton.setBounds(60, 400, 120, 50);
        ouvertureButton.setBorderPainted(false);
        ouvertureButton.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                ouvertureButton.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                ouvertureButton.setBackground(new Color(R, G, B));
            }
        });
        
        Container contentPane = getContentPane();
        
        getContentPane().setBackground(Color.BLACK);
       
        GridBagConstraints c = new GridBagConstraints();
        
        
        ouvertureButton.addActionListener(this);
        
        
        
        getContentPane().add(ouvertureButton);
       
        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ouvertureButton) {
            Menu menu = new Menu();
           
            dispose();
        } 
    }
    
    public static void main(String[] args) {
        Ouverture OV = new Ouverture();
    }
}