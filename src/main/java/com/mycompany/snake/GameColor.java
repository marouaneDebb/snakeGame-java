
package com.mycompany.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public  class GameColor extends JFrame implements ActionListener{
    private JButton snakecolor;
    private JButton backgroungcolor;
    private JButton applecolor;
    private JButton backcolor;
    
    public GameColor() {
        
        super("Snake Game");
        setTitle("Game Menu");
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

        snakecolor = new JButton("snake color");
        snakecolor.setPreferredSize(buttonSize);
        snakecolor.setFocusPainted(false);
        snakecolor.setForeground(Color.WHITE);
        snakecolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        snakecolor.setFont(new Font("Arial", Font.BOLD, 14));
        snakecolor.setBounds(282, 60, 200, 80);
        snakecolor.setBorderPainted(false);
        snakecolor.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
               
                snakecolor.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                snakecolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        

        
        backgroungcolor = new JButton("background color");
        backgroungcolor.setPreferredSize(buttonSize);
        backgroungcolor.setForeground(Color.WHITE);
        backgroungcolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backgroungcolor.setFont(new Font("Arial", Font.BOLD, 14));
        backgroungcolor.setBounds(282, 160, 200, 80);
        backgroungcolor.setBorderPainted(false);
        backgroungcolor.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                backgroungcolor.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                backgroungcolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
        
        
        applecolor = new JButton("apple color");
        applecolor.setPreferredSize(buttonSize);
        applecolor.setForeground(Color.WHITE);
        applecolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        applecolor.setFont(new Font("Arial", Font.BOLD, 14));
        applecolor.setBounds(282, 260, 200, 80);
        applecolor.setBorderPainted(false);
        applecolor.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                applecolor.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                applecolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
            
        backcolor = new JButton("back to settings");
        backcolor.setPreferredSize(buttonSize);
        backcolor.setForeground(Color.WHITE);
        backcolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backcolor.setFont(new Font("Arial", Font.BOLD, 14));
        backcolor.setBounds(282, 360, 200, 80);
        backcolor.setBorderPainted(false);
        backcolor.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                backcolor.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
               backcolor.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
        
        
        
        
        Container contentPane = getContentPane();
        
        getContentPane().setBackground(Color.BLACK);
       
        GridBagConstraints c = new GridBagConstraints();
        
         
        snakecolor.addActionListener(this);
        backgroungcolor.addActionListener(this);
        applecolor.addActionListener(this);
        backcolor.addActionListener(this);
        
        
        getContentPane().add(snakecolor);
        getContentPane().add(backgroungcolor);
        getContentPane().add(applecolor);
        getContentPane().add(backcolor);
       
        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
        
    
         backgroungcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                GamePanel.bbb=changebackgroundcolor();
                
            }
        });
         backcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Options op = new Options();
                dispose();
            }
        });
         snakecolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            GamePanel.ddd=changesnakecolor();
            }
            
            
            
            
            
        });
         applecolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                GamePanel.ccc=changebackgroundcolor();
                
            }
        });
         
         
        
    }
    public static java.awt.Color changesnakecolor(){
            Color selectedColor = JColorChooser.showDialog(null, "Choose Color", Color.GREEN);
                if (selectedColor != null) {
                return selectedColor;
                }
                return null;
        }
        public static java.awt.Color changeapplecolor(){
            Color selectedColor = JColorChooser.showDialog(null, "Choose Color", Color.RED);
                if (selectedColor != null) {
                return selectedColor;
                }
                return null;
        }
        public static java.awt.Color changebackgroundcolor(){
            Color selectedColor = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
                if (selectedColor != null) {
                
                return selectedColor;
                }
                return null;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    

    
    
}
