package project.test2;
import city.cs.engine.*;

/**
 * Spider web collision class.
 */

public class webCollision implements CollisionListener {
    private spoodermanCharacter spooder;
    
    public webCollision(spoodermanCharacter spooder) {
        this.spooder = spooder;
    }

    @Override 
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {	
        	gameSound.web_collisionSound();
        	spooder.addScore();
            e.getReceivingBody().destroy();
        
        }
    }
    
}
