package project.test2;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 * Heal heart from level two class.
 */


public class healHeart extends DynamicBody {

    private static final Shape heart = new PolygonShape(-0.373f,0.494f, -0.566f,0.289f, 
    		-0.56f,-0.056f, 0.0f,-0.504f, 0.557f,0.017f, 0.55f,0.297f, 0.363f,0.494f, -0.356f,0.499f);
	
	private static final BodyImage heartImage = new BodyImage("data/heart.png");
    
    public healHeart(World world) {
        super(world, heart);
        SolidFixture fixture = new SolidFixture(this, heart);
        fixture.setFriction(4);
        this.setFixedRotation(true);
		this.setImage(heartImage);
       
    }
	
	
	
}
