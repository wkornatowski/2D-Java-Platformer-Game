
package project.test2;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

/**
 * Level two design class.
 */

public class levelTwo_Design extends World {
    private spoodermanCharacter spooder;

    
    public levelTwo_Design() {
        super();

        
        { // make the ground
            Shape shape = new BoxShape(77, 0.5f);     
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, -8.5f));
       
            // walls
            Shape leftWallShape = new BoxShape(0.5f, 7, new Vec2(-11, 7));
            new SolidFixture(ground, leftWallShape);
            
            //health room walls
            Shape leftWallShape_HEALROOM = new BoxShape(0.5f, 4, new Vec2(19.5f, 18));
             new SolidFixture(ground, leftWallShape_HEALROOM);
            Shape rightWallShape_HEALROOM = new BoxShape(0.5f, 4, new Vec2(28.5f, 18));
             new SolidFixture(ground, rightWallShape_HEALROOM);

        }

        { // make platform shapes
            Shape shape = new BoxShape(15.5f, 0.5f);
            Shape shape2 = new BoxShape(20, 0.5f);
            Shape shape3 = new BoxShape(2, 0.5f);
            Shape shape4 = new BoxShape(2, 0.5f);
            Shape shape5 = new BoxShape(5, 0.5f);
            Shape healRoom_CEILING = new BoxShape(5, 0.5f);
            
          //make platforms
             Body ceilingPlatform = new StaticBody(this, shape);
             Body ceilingPlatform2 = new StaticBody(this, shape2);
             Body littlePlatform = new StaticBody(this, shape3);       
             Body endPlatform1 = new StaticBody(this, shape4);
             Body endPlatform2 = new StaticBody(this, shape5);
             Body healCeiling = new StaticBody(this, healRoom_CEILING);
             
          //set platform positions
             
             utilityClass.setPlatform(ceilingPlatform, 4.5, 5);
             utilityClass.setPlatform(ceilingPlatform2, 42, 5);
             utilityClass.setPlatform(littlePlatform, 22, -1);
             utilityClass.setPlatform(endPlatform1, 78, 0);
             utilityClass.setPlatform(endPlatform2, 95, 6);
             utilityClass.setPlatform(healCeiling, 24, 14);
             
          //advert 
             Body bb = new billboardAd(this);
             bb.setPosition(new Vec2(-22, -3));    
        }
        
        { //character implementation
        	spooder = new spoodermanCharacter(this);
        	spooder.setPosition(new Vec2(-10, -7));     //-10, -7 //95, 7

        	Body dolan = new spoodersEnemy_DOLAN(this);      
        	dolan.setPosition(new Vec2(96, 7));
        	dolan.addCollisionListener(new dolanCollision(spooder));
        }
        
        {

        	//Spike Bodies
        	Body spike3 = new deathSpikes(this);
        	Body spike1 = new deathSpikes(this);
        	Body spike2 = new deathSpikes(this);
        	
        	//Laser Bodies
        	Body laser1 = new deathLasers(this);
        	
        	//Heart Body
        	Body heart = new healHeart(this);
        	
        	//Spike Positions
        	spike3.setPosition(new Vec2(89.5f, 6));
            spike3.setAngle(190);
            spike3.addCollisionListener(new spikeCollision(spooder));
            
              //heal room spike
            spike1.setPosition(new Vec2(24, 6));
            spike1.addCollisionListener(new spikeCollision(spooder));
              //wall spike
            spike2.setPosition(new Vec2(20.5f, 8));
            spike2.setAngle(300);
            spike2.addCollisionListener(new spikeCollision(spooder));
              //level platform spikes
            for (int i = 0; i < 15; i++){
                Body spike = new deathSpikes(this);
                utilityClass.setObject(i, spike, 6, 8, -7.5, spooder, 1);
        	}
        	//Laser Positions
            laser1.setPosition(new Vec2(91, 13));
            laser1.addCollisionListener(new laserCollision(spooder));
    
            for (int i = 0; i < 20; i++){
                Body laser = new deathLasers(this);
                laser.setPosition(new Vec2(i*8-5, 3));
                laser.addCollisionListener(new laserCollision(spooder));
        	}      	
        	//Web Positions
            for (int i = 0; i < 10; i++) {
                Body web = new spiderWebs(this);
                utilityClass.setObject(i, web, 4, 10, -3, spooder, 2);
            }   	
        	//Heart Positions
        	heart.setPosition(new Vec2(26, 7));
        	heart.addCollisionListener(new heartCollision(spooder));        
        }
	
    }
    public DynamicBody getActor() {
        return spooder;     
    }    
    public spoodermanCharacter getSpooder()
    {
    	return spooder;
    }
      
}

