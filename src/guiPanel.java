package project.test2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class guiPanel extends JPanel {
    private static JToggleButton pause = new JToggleButton("Pause");  
    private static JToggleButton muteButton = new JToggleButton("MUTE Music");
    
    public guiPanel() 
    {
    	this.setLayout(new FlowLayout());
    	this.setBackground(Color.black);
    	this.add(muteButton);
        this.add(gameSound.getvolumeSlider());
        this.add(pause);
        this.add(gameMenu.getQuit_Button());  
        pause.setFocusable(false);
        muteButton.setFocusable(false);
        pause.setBackground(Color.red);
        muteButton.setBackground(Color.red);
        
    	pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JToggleButton pause = (JToggleButton)e.getSource();
               if (pause.isSelected()) 
               {
               	    gameSound.buttonSound();          	
            		levelOne_Panel.getWorld().setPaused(true);
            		levelTwo_Panel.getWorld().setPaused(true);
            		levelThree_Panel.getWorld().setPaused(true);
               } 
               else
               {
               	    gameSound.buttonSound();
               	    levelOne_Panel.getWorld().setPaused(false);
                 	levelTwo_Panel.getWorld().setPaused(false);
                	levelThree_Panel.getWorld().setPaused(false);            			
               }
            }
         });
              
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JToggleButton muteButton = (JToggleButton)e.getSource();
               if (muteButton.isSelected()) 
               {
                 	gameSound.buttonSound();
            	    muteButton.setText("Music OFF");
            	    gameSound.stopMusic(true);           
               } 
               else
               {
                	gameSound.buttonSound();
            	    muteButton.setText("Music ON");  
                    gameSound.startMusic(true);                 
               }
            }
         });	

    }

}
