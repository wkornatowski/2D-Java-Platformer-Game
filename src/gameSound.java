package project.test2;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Game sound class, consisting off all the sounds within the game.
 */

public class gameSound {
	
	private static FloatControl volume;
	private static JSlider volumeSlider;

	private static File musicFile = new File("data/sound/musicSound.wav");
	private static AudioInputStream backgroundMusic; 
	private static DataLine.Info musicData;
	private static Clip musicClip;
	
	private static File webCollision_soundFile = new File("data/sound/webSound.wav");	
	private static AudioInputStream web_collisionSound; 	
	private static DataLine.Info web_soundData;	
	private static Clip web_soundClip;
		
	private static File spikeCollision_soundFile = new File("data/sound/spikeSound.wav");
	private static AudioInputStream spike_collisionSound; 
	private static DataLine.Info spike_soundData;
	private static Clip spike_soundClip;
	
	private static File splashSound_File = new File("data/sound/suspense.wav");
	private static AudioInputStream splashSound; 
	private static DataLine.Info splash_soundData;
	private static Clip splash_soundClip;
	
	private static File jumpSound_File = new File("data/sound/jumpSound.wav");
	private static AudioInputStream jumpSound; 
	private static DataLine.Info jump_soundData;
	private static Clip jump_soundClip;
	
	private static File deathSound_File = new File("data/sound/deathSound.wav");
	private static AudioInputStream deathSound; 
	private static DataLine.Info death_soundData;
	private static Clip death_soundClip;
	
	private static File buttonSound_File = new File("data/sound/buttonSound1.wav");
	private static AudioInputStream buttonSound; 
	private static DataLine.Info button_soundData;
	private static Clip button_soundClip;
	

	public static void buttonSound()
	{
		try {
			//web collision sound
		
			buttonSound = AudioSystem.getAudioInputStream(buttonSound_File); 
			button_soundData = new DataLine.Info(Clip.class, buttonSound.getFormat());
			button_soundClip = (Clip) AudioSystem.getLine(button_soundData);
			button_soundClip.open(buttonSound);	
			volume = (FloatControl) button_soundClip.getControl(FloatControl.Type.MASTER_GAIN);
	    	volume.setValue(-20);
			
			button_soundClip.start();
			}
			
	        catch(UnsupportedAudioFileException uae) {
				
				JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
	            System.out.println(uae);
	        }
	        catch(IOException ioe) {
	        	JOptionPane.showMessageDialog(null, "I/O Exception!");
	            System.out.println(ioe);
	        }
	        catch(LineUnavailableException lua) {
	        	
	        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
	            System.out.println(lua);
	        }
		
		
	}
	
	public static void deathSound()
	{
		try {
			//web collision sound
	
			deathSound = AudioSystem.getAudioInputStream(deathSound_File); 
			death_soundData = new DataLine.Info(Clip.class, deathSound.getFormat());
			death_soundClip = (Clip) AudioSystem.getLine(death_soundData);
			death_soundClip.open(deathSound);		
			volumeRegulator(death_soundClip, -15);
			death_soundClip.start();

			
			}
			
	        catch(UnsupportedAudioFileException uae) {
				
				JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
	            System.out.println(uae);
	        }
	        catch(IOException ioe) {
	        	JOptionPane.showMessageDialog(null, "I/O Exception!");
	            System.out.println(ioe);
	        }
	        catch(LineUnavailableException lua) {
	        	
	        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
	            System.out.println(lua);
	        }
	
	}
	
	public static void jumpSound()
	{
		try {
			//web collision sound
		
			jumpSound = AudioSystem.getAudioInputStream(jumpSound_File); 
			jump_soundData = new DataLine.Info(Clip.class, jumpSound.getFormat());
			jump_soundClip = (Clip) AudioSystem.getLine(jump_soundData);
			jump_soundClip.open(jumpSound);		
			volumeRegulator(jump_soundClip, -5);
			jump_soundClip.start();

			}
			
	        catch(UnsupportedAudioFileException uae) {
				
				JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
	            System.out.println(uae);
	        }
	        catch(IOException ioe) {
	        	JOptionPane.showMessageDialog(null, "I/O Exception!");
	            System.out.println(ioe);
	        }
	        catch(LineUnavailableException lua) {
	        	
	        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
	            System.out.println(lua);
	        }
		
		
	}
	
	public static void splashSound()
	{
		try {
			//web collision sound
		
			splashSound = AudioSystem.getAudioInputStream(splashSound_File); 
			splash_soundData = new DataLine.Info(Clip.class, splashSound.getFormat());
			splash_soundClip = (Clip) AudioSystem.getLine(splash_soundData);
			splash_soundClip.open(splashSound);		
			splash_soundClip.start();

			}
			
	        catch(UnsupportedAudioFileException uae) {
				
				JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
	            System.out.println(uae);
	        }
	        catch(IOException ioe) {
	        	JOptionPane.showMessageDialog(null, "I/O Exception!");
	            System.out.println(ioe);
	        }
	        catch(LineUnavailableException lua) {
	        	
	        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
	            System.out.println(lua);
	        }
		
		
	}
	
	public static void backgroundMusic()
	{
		if (musicClip != null && musicClip.isRunning()) {  
            musicClip.stop();  
        } 
		
		try {
			
			backgroundMusic = AudioSystem.getAudioInputStream(musicFile); 
			musicData = new DataLine.Info(Clip.class, backgroundMusic.getFormat());
	    	musicClip = (Clip) AudioSystem.getLine(musicData);
	    	musicClip.open(backgroundMusic);
	    	musicClip.loop(Clip.LOOP_CONTINUOUSLY);
	    	volumeRegulator(musicClip, -20);
	    	musicClip.start();
		}
		
		catch(UnsupportedAudioFileException uae) {
			
			JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
            System.out.println(uae);
        }
        catch(IOException ioe) {
        	JOptionPane.showMessageDialog(null, "I/O Exception!");
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
        	
        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
            System.out.println(lua);
        }
		
		final FloatControl musicControl = (FloatControl)musicClip.getControl(FloatControl.Type.MASTER_GAIN);
		
		volumeSlider = new JSlider(JSlider.HORIZONTAL, (int)musicControl.getMinimum(), (int)musicControl.getMaximum(), (int)musicControl.getValue());
		volumeSlider.setFocusable(false);
		volumeSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e)
			{
				musicControl.setValue(volumeSlider.getValue());
			}			
		});	
	}
	
	public static JSlider getvolumeSlider()
	{
		return volumeSlider;
	}
	
	public static void startMusic(boolean bgM){
		
		if(bgM == true)
		{
		musicClip.loop(Clip.LOOP_CONTINUOUSLY);
		musicClip.start();
		}

	}
	
	public static void stopMusic(boolean bgM){
		
		if(bgM == true)
		{
		musicClip.stop();
		}	
	}
	
	public static void web_collisionSound()
	{
		
		try {
		//web collision sound
	
		web_collisionSound = AudioSystem.getAudioInputStream(webCollision_soundFile); 
		web_soundData = new DataLine.Info(Clip.class, web_collisionSound.getFormat());
		web_soundClip = (Clip) AudioSystem.getLine(web_soundData);
		web_soundClip.open(web_collisionSound);	
		volumeRegulator(web_soundClip, -20);
	    web_soundClip.start();

		}
		
        catch(UnsupportedAudioFileException uae) {
			
			JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
            System.out.println(uae);
        }
        catch(IOException ioe) {
        	JOptionPane.showMessageDialog(null, "I/O Exception!");
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
        	
        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
            System.out.println(lua);
        }		
	}
	
	public static void spike_collisionSound()
	{		
		try {
		//web collision sound
	
		spike_collisionSound = AudioSystem.getAudioInputStream(spikeCollision_soundFile); 
		spike_soundData = new DataLine.Info(Clip.class, spike_collisionSound.getFormat());
		spike_soundClip = (Clip) AudioSystem.getLine(spike_soundData);
		spike_soundClip.open(spike_collisionSound);		
		volumeRegulator(spike_soundClip, -17);
	
	    spike_soundClip.start();
		
		}
		
        catch(UnsupportedAudioFileException uae) {
			
			JOptionPane.showMessageDialog(null, "Unsupported Audio file Exception!");
            System.out.println(uae);
        }
        catch(IOException ioe) {
        	JOptionPane.showMessageDialog(null, "I/O Exception!");
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
        	
        	JOptionPane.showMessageDialog(null, "Line Unavailable Exception!");
            System.out.println(lua);
        }
	
	}
	
	public static void volumeRegulator(Clip c, int i)
	{
		volume = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
    	volume.setValue(i);	
	}
}
