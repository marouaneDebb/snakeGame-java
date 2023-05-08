
package com.mycompany.snake;
import static com.mycompany.snake.Snake.audioStream;
import static com.mycompany.snake.Snake.clip;
import static com.mycompany.snake.Snake.file;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Sound extends JFrame implements ActionListener {
    private JButton musicon;
    private JButton musicoff;
    private JButton backspeed;
    static int M=1;
    
    
    public Sound() {
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
        
        
        
        
        
        musicon = new JButton("music on");
        musicon.setPreferredSize(buttonSize);
        musicon.setFocusPainted(false);
        musicon.setForeground(Color.WHITE);
       musicon.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        musicon.setFont(new Font("Arial", Font.BOLD, 14));
        musicon.setBounds(282, 100, 200, 80);
        musicon.setBorderPainted(false);
        musicon.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
               
                musicon.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                musicon.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        

        
        musicoff = new JButton("music off");
        musicoff.setPreferredSize(buttonSize);
        musicoff.setForeground(Color.WHITE);
        musicoff.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        musicoff.setFont(new Font("Arial", Font.BOLD, 14));
        musicoff.setBounds(282, 200, 200, 80);
        musicoff.setBorderPainted(false);
        musicoff.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {

                musicoff.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
                // Change the button's background color back to red
                 musicoff.setBackground(new Color(Menu.R, Menu.G, Menu.B));
            }
        });
        
        
        
        backspeed = new JButton("go back");
        backspeed.setPreferredSize(buttonSize);
        backspeed.setForeground(Color.WHITE);
        backspeed.setBackground(new Color(Menu.R, Menu.G, Menu.B));
        backspeed.setFont(new Font("Arial", Font.BOLD, 14));
        backspeed.setBounds(282, 300, 200, 80);
        backspeed.setBorderPainted(false);
        backspeed.addMouseListener(new MouseAdapter() {    
            public void mouseEntered(MouseEvent e) {
                
                backspeed.setBackground(new Color(0, 51, 10));
            }
            public void mouseExited(MouseEvent e) {
            backspeed.setBackground(new Color(Menu.R, Menu.G, Menu.B));           }
        });
        
        Container contentPane = getContentPane();
        
        getContentPane().setBackground(Color.BLACK);
       
        GridBagConstraints c = new GridBagConstraints();
        
        
        backspeed.addActionListener(this);
        musicon.addActionListener(this);
        musicoff.addActionListener(this);
        
        
        getContentPane().add(musicon);
        getContentPane().add(musicoff);
        getContentPane().add(backspeed);
        
        

        
        add(P1);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public static void playMusic(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            if(Sound.M==1){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
		
        }
    public static void stopMusic(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            
                clip.stop();
                //clip.close();
        }
        public static void restartMusic(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
            if(Sound.M==1){
                
            
                clip.stop();
                clip.close();
             
                
            try {
                file = new File(filepath);
                audioStream = AudioSystem.getAudioInputStream(file);
                
		
		clip.open(audioStream);
		
		clip.start();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            else{
                clip.stop();
                    }
        }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == musicon) {
            M=1;
            try {
                Snake.audioStream = AudioSystem.getAudioInputStream(file);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
		
            try {
                clip.open(audioStream);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		clip.start();
            Snake.clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        }
        if (e.getSource() == musicoff) {
            Snake.clip.stop();
            //clip.close();
            M=0;
        }
        if (e.getSource() == backspeed) {
            Options op = new Options();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Sound();
    }
}