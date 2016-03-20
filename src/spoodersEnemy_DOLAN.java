package project.test2;
import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 * Dolan design class
 */

public class spoodersEnemy_DOLAN extends DynamicBody {
    private static final Shape dolan = new PolygonShape(-0.086f,0.72f, -0.363f,0.469f, -0.363f,-1.125f, 0.381f,-1.104f, 0.41f,0.7f, -0.059f,0.72f);
    
    private static final BodyImage dolanImage = new BodyImage("data/dolan.gif", 2.25f);

    public spoodersEnemy_DOLAN(World world) {
        super(world);  
        
        Fixture fixture = new SolidFixture(this, dolan);        
        ((SolidFixture) fixture).setFriction(2.5f);
        setImage(dolanImage);
        setFixedRotation(true); 
    }
    
    
    
}