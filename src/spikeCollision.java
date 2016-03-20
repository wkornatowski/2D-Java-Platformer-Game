package project.test2;

import city.cs.engine.*;

/**
 * Death spike collision class.
 */

public class spikeCollision implements CollisionListener {
	private spoodermanCharacter spooder;
	//private JFrame frame2;
	
	public spikeCollision(spoodermanCharacter spooder) {
		this.spooder = spooder;
	}

	@Override
	public void collide(CollisionEvent e) {
		if (e.getOtherBody() == spooder) {
			gameSound.spike_collisionSound();
			spooder.decreaseHealth_Spikes();
		
		}
	}

}
