package project.test2;

import city.cs.engine.*;

/**
 * Billboard from level two design class.
 */

public class billboardAd extends StaticBody {
	//Variables
    private static final Shape shape = new BoxShape(10.5f, 14.5f);
	private static final BodyImage adImage = new BodyImage("data/billboard.gif", 10.5f);
    
    public billboardAd(World world) {
        super(world, shape);
        new SolidFixture(this, shape);
		this.setImage(adImage);
       
    }
}
