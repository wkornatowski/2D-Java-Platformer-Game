package project.test2;

import city.cs.engine.*;

/**
 * Uncle Ben design class.
 */

public class uncleBen extends DynamicBody {
	private static final Shape uncleBody = new PolygonShape(-0.514f,0.239f, -0.534f,-0.244f, 1.099f,-0.168f, 0.974f,-0.011f, 0.108f,0.25f, -0.491f,0.244f);
	private static final Shape uncleHead = new PolygonShape(-1.114f,-0.071f, -0.531f,0.145f, -0.534f,-0.247f, -0.972f,-0.224f, -1.116f,-0.094f);
    
    public uncleBen(World world) {
        super(world);
        
        new SolidFixture(this, uncleHead);
        new SolidFixture(this, uncleBody);
     
        setImage (new BodyImage("data/uncleben.gif", 0.7f));   
    }
}
