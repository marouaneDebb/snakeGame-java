

package com.mycompany.snake;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Snake {
    
    static File file = new File("AAAA.wav");
    static AudioInputStream audioStream; 
    static Clip clip ;
   
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
	
            Ouverture ov = new Ouverture();
                 
		audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
		
		clip.open(audioStream);
		
		clip.start();	
	}  
}



    

