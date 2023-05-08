package com.mycompany.snake;

import static com.mycompany.snake.GamePanel.DELAY;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class GameSpeed extends JFrame implements ActionListener {
    
    private JButton backspeed;
     static int a=50;

    static JLabel valueLabel;
    static JSlider slider;
    public GameSpeed() {
        super("game Speed Panel ");
        
        
        setTitle("Snake Game");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel P1 = new JPanel();
        P1.setPreferredSize(new Dimension(800, 500));
        
        
        P1.setPreferredSize(new Dimension(800, 500));
        ImageIcon icon = new ImageIcon("5.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, P1.getWidth(), P1.getHeight());
        P1.add(label);
        P1.setPreferredSize(new Dimension(800, 500));
        getContentPane().add(P1);
        
        
        
        
        Dimension buttonSize = new Dimension(100, 50);
        
      
       
       Container contentPane = getContentPane();
       contentPane.setLayout(new BorderLayout());
        
        getContentPane().setBackground(Color.BLACK);
       
        GridBagConstraints c = new GridBagConstraints();
       
       

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 90,a);
        
        
        slider.setBounds(235, 150, 300, 50);
        slider.setForeground(Color.RED);
        slider.putClientProperty("JSlider.isFilled", Boolean.TRUE);
        
        

        valueLabel = new JLabel("Value: " + slider.getValue());
        valueLabel.setPreferredSize(buttonSize);
        slider.setPreferredSize(buttonSize);
        valueLabel.setForeground(Color.white);
        valueLabel.setBackground(Color.RED);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 18));
        valueLabel.setBounds(230, 70, 200, 80);
        

        
        

        
        
        backspeed = new JButton("go back");
        backspeed.setPreferredSize(buttonSize);
        backspeed.setForeground(Color.WHITE);
        backspeed.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backspeed.setFont(new Font("Arial", Font.BOLD, 14));
        backspeed.setBounds(282, 250, 200, 80);
        backspeed.setBorderPainted(false);
        backspeed.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                backspeed.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                backspeed.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        

        
        backspeed.addActionListener(this);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                valueLabel.setText("Value: " + slider.getValue());
                GamePanel.DELAY=100-GameSpeed.slider.getValue();
                a=GameSpeed.slider.getValue();
            }
        });
        
        
        getContentPane().add(backspeed);
        getContentPane().add(valueLabel);
        getContentPane().add(slider);
        
        

        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
    }
    
    

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == backspeed) {
            Options op = new Options();
            dispose();
        }
    }

   
}