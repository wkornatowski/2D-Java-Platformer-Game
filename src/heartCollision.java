package project.test2;
import city.cs.engine.*;

/**
 * Heal heart from level two collision class.
 */

public class heartCollision implements CollisionListener {
    private spoodermanCharacter spooder;
    
    public heartCollision(spoodermanCharacter spooder) {
        this.spooder = spooder;
    }

    @Override 
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {
        	gameSound.web_collisionSound();
        	spooder.healHeart();
            e.getReceivingBody().destroy();
        }
    }
    
}
