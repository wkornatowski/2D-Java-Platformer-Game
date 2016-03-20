package project.test2;

import city.cs.engine.*;

/**
 * Laser from level two collision class.
 */

public class laserCollision implements CollisionListener {
	private spoodermanCharacter spooder;
	
 
    public laserCollision(spoodermanCharacter spooder) {
        this.spooder = spooder;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == spooder) {	
            spooder.decreaseHealth_Lasers();
            e.getReceivingBody().destroy();
        }
    }

}
