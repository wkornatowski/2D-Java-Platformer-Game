package project.test2;

import city.cs.engine.*;

/**
 * Spider web design class.
 */

public class spiderWebs extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    private static final Shape spiderWeb = new PolygonShape(-0.391f,0.296f, -0.392f,-0.288f, 0.392f,-0.287f, 0.391f,0.299f, -0.381f,0.298f);
	
	private static final BodyImage webImage = new BodyImage("data/spiderweb.gif");
    
    public spiderWebs(World world) {
        super(world, spiderWeb);
        new SolidFixture(this, shape);
		this.setImage(webImage);
       
    }
}
