package project.test2;
import city.cs.engine.*;

/**
 * Death spike design class from across the game.
 */ 
public class deathSpikes extends StaticBody {
	
	private static final Shape shape = new PolygonShape(-0.444f,-0.496f, -0.437f,0.494f, 0.445f,0.494f, 0.445f,-0.496f, -0.435f,-0.496f);	
	private static final BodyImage image = new BodyImage("data/spikes10.png");

	public deathSpikes(World w){
		super(w);
		new SolidFixture(this, shape);
		this.setImage(image);		
   
	}
}
