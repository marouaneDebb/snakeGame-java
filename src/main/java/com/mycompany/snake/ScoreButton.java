package com.mycompany.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Iterator;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.basic.BasicButtonUI;

public class ScoreButton extends JFrame implements ActionListener {
    JButton backButton;
    

public ScoreButton() {
    setTitle("Snake Game");
    setSize(800, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    

    JPanel panel = new JPanel(new FlowLayout());
    
    StringBuilder sb = new StringBuilder("<html>");
    
    sb.append("<br>");
    sb.append("top score: ");
    sb.append(String.valueOf(GamePanel.topScore));
    sb.append("<br>");
    sb.append("<br>");
    if(GamePanel.tries>=1){
    sb.append("previous scores: ");
    sb.append("<br>");
    sb.append("<br>");}
    

    panel.setPreferredSize(new Dimension(800, 500));
    panel.setBackground(Color.GREEN.darker().darker().darker().darker());
    
    Dimension buttonSize = new Dimension(100, 50);
    

    backButton = new JButton("go back to menu");
        backButton.setPreferredSize(buttonSize);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(295, 360, 200, 80);
        backButton.setBorderPainted(false);
        backButton.setUI(new BasicButtonUI() {
        @Override
        protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
            // paint the text without the border
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(c.getForeground());
            g2.setFont(c.getFont());
            g2.drawString(text, textRect.x, textRect.y + textRect.height - g2.getFontMetrics().getDescent());
        }
    });
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
        backButton.addActionListener(this);
        Iterator<Integer> scoreListInv = GamePanel.scoreList.descendingIterator();
        
        while (scoreListInv.hasNext()) {
            Integer element = scoreListInv.next();
            sb.append("player 1 : ");
            sb.append(String.valueOf(element));
            sb.append("<br>");
            
        }
        sb.append("<html>");
        JLabel label1 = new JLabel(sb.toString());
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setPreferredSize(new Dimension(400, 300));

        
        panel.add(label1);
        getContentPane().add(backButton);

        add(panel);
        setResizable(false);
        pack();
        setVisible(true);


        
    
        
        
    }

public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
        Menu menu = new Menu();
        dispose();
            }
         
            
        }
   
    
}
    










