package project.test2;

import city.cs.engine.*;

/**
 * Death laser design class from level two
 */

public class deathLasers extends DynamicBody {
	private static final Shape shape = new PolygonShape(-0.05f,2.74f, 0.36f,2.61f, 0.35f,-2.34f, 0.01f,-2.72f, -0.4f,-2.4f, -0.39f,2.63f, -0.16f,2.73f);	
	private static final BodyImage laserImage = new BodyImage("data/laser.gif", 5.5f);

	public deathLasers(World world){
		
		super(world, shape);
	
		SolidFixture fixture = new SolidFixture(this, shape);
		
		fixture.setFriction(4);
		//Restitution to allow them to bounce.
		fixture.setRestitution(1);
			
		this.setFixedRotation(true);
		this.setImage(laserImage);
		
	}
}
