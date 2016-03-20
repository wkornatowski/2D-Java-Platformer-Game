package project.test2;

import city.cs.engine.*;

import javax.swing.*;

/**
 * Dolan character collision class from level two.
 */

public class dolanCollision implements CollisionListener {
    private spoodermanCharacter spooder;
    final private ImageIcon dolanIcon = new ImageIcon("data/spooder_dolanIcons.gif");   
    
    
    public dolanCollision(spoodermanCharacter spooder) {
        this.spooder = spooder;  
        
    }

    @Override 
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {	
        	e.getReceivingBody().destroy();
        	JOptionPane.showMessageDialog(null, "Spooder: DOLAN!? How could you do this, we were like brothers" + "\n\n\nDolan: SPOODEY PLS" +
        	"\n\n\n\nYou've caught Uncle Ben's murderer, well done you've cleared the level!" 
        			+ "\n\nYou've scored: " + spooder.getScore()+ " spider webs in this level!",
        	"Uncle Ben's murderer!", 
        		    JOptionPane.PLAIN_MESSAGE, dolanIcon);
        	gameSound.buttonSound();
        	
            initialiseGame.initiateLevel_Three(700, 700);

            
        }
    }
    
}
