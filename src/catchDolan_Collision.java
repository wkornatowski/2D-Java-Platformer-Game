package project.test2;

import city.cs.engine.*;

import javax.swing.*;

/**
 * Level three level ending collision class.
 */

public class catchDolan_Collision implements CollisionListener {
    private spoodermanCharacter spooder;

    public catchDolan_Collision(spoodermanCharacter spooder) {
        this.spooder = spooder;   
    }
    @Override 
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {	
        	e.getReceivingBody().destroy();
        	JOptionPane.showMessageDialog(null, "Justice will be served, Dolan will be punished.\n\n\nCongratulations you've completed the game!\n\n You've sYou've scored: " + spooder.getScore()+ 
        			" spider webs in this level!", "You've caught Dolan! Well done", JOptionPane.PLAIN_MESSAGE);
        	gameSound.buttonSound();
        	
            System.exit(0);          
        }
    }   
}
