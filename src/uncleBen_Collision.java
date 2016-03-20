package project.test2;

import city.cs.engine.*;

import javax.swing.*;

/**
 * Uncles Ben collision class
 */

public class uncleBen_Collision implements CollisionListener {
    private spoodermanCharacter spooder;
    
    
    public uncleBen_Collision(spoodermanCharacter spooder) {
        this.spooder = spooder;
    }

    @Override 
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {		
            e.getReceivingBody().destroy();
            JOptionPane.showMessageDialog(null, "Uncle Ben is already dead, but good effort for trying to save him."
            		+ " You've passed the level, well done!" + 
            		"\n\nYou've scored: " + spooder.getScore()+ " spider webs in this level!", "Level Completed!", JOptionPane.PLAIN_MESSAGE );
            gameSound.buttonSound();
            
            initialiseGame.initiateLevel_Two(900, 500);

            
        }
    }
    
}
