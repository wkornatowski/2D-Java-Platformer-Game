
package project.test2;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;
/**
 * Level one design class.
 */

public class levelOne_Design extends World {
    private spoodermanCharacter spooder;
    
    public levelOne_Design() {
        super();
        
        { // make the ground
            Shape shape = new BoxShape(11, 0.5f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, -21.5f));
            // walls
            Shape leftWallShape = new BoxShape(0.5f, 22, new Vec2(-11.5f, 21.5f));
            new SolidFixture(ground, leftWallShape);
            Shape rightWallShape = new BoxShape(0.5f, 22, new Vec2(11.5f, 21.5f));
            new SolidFixture(ground, rightWallShape);
        }

        { // make a platform
            Shape shape = new BoxShape(4, 0.5f);
            Shape shape2 = new BoxShape(2, 0.5f);
            
            //create platform bodies
            Body platform1 = new StaticBody(this, shape);
            Body platform2 = new StaticBody(this, shape);
            Body platform3 = new StaticBody(this, shape);
            Body platform4 = new StaticBody(this, shape);
            Body platform5 = new StaticBody(this, shape);
            Body platform6 = new StaticBody(this, shape2);
            
            //set platform location in world
            utilityClass.setPlatform(platform1, -7, -12.5);
            utilityClass.setPlatform(platform2, 2, -6.5);           
            utilityClass.setPlatform(platform3, -3, 1.5);            
            utilityClass.setPlatform(platform4, -8, 8.5);            		
            utilityClass.setPlatform(platform5, 8, 17.5);        
            utilityClass.setPlatform(platform6, -8, 16.5);
        }
        
        { //Character implementation
        	spooder = new spoodermanCharacter(this);
        	spooder.setPosition(new Vec2(11, -20));     //11, -20 //5, -19
        }
        
        {
          //Create Uncle Ben
                Body uncle = new uncleBen(this);
                uncle.setPosition(new Vec2(9, 18));
                uncle.addCollisionListener(new uncleBen_Collision(spooder));
         
          //***CREATE SPIKES  
            //ground spikes
           for (int i = 0; i < 11; i++) {
               Body spike1 = new deathSpikes(this);
               utilityClass.setObject(i, spike1, 5, 11, -20.5, spooder, 1);
           }  
        
           //platform1 spikes
           for (int i = 0; i < 2; i++) {
               Body spike2 = new deathSpikes(this);
               utilityClass.setObject(i, spike2, -3, 6, -11.5, spooder, 1);
           }           
           //platform2 spikes
           for (int i = 0; i < 2; i++) {
               Body spike3 = new deathSpikes(this);
               utilityClass.setObject(i, spike3, 5, 0, -5.5, spooder, 1);
            }
           //platform3 spikes
           for (int i = 0; i < 2; i++) {
               Body spike4 = new deathSpikes(this);
               utilityClass.setObject(i, spike4, -4, 0, 2.5, spooder, 1);
           }          
           //platform4 spikes
           for (int i = 0; i < 2; i++) {
               Body spike5 = new deathSpikes(this);
               utilityClass.setObject(i, spike5, -3, 6, 9.5, spooder, 1);
           } 
           //platform6 spikes
           for (int i = 0; i < 1; i++) {
               Body spike6 = new deathSpikes(this);
               utilityClass.setObject(i, spike6, -8, 8, 17.5, spooder, 1);
           }    
           
         //****CREATE WEBS
           //ground webs
           for (int i = 0; i < 10; i++) {
                Body web1 = new spiderWebs(this);
                utilityClass.setObject(i, web1, 4, 10, -20, spooder, 2);
            }                              
           //platform1 webs
           for (int i = 0; i < 2; i++) {
                Body web2 = new spiderWebs(this);
                utilityClass.setObject(i, web2, -4, 5, -10, spooder, 2);
            }                              
            //platform2 webs
           for (int i = 0; i < 2; i++) {
                Body web3 = new spiderWebs(this);
                utilityClass.setObject(i, web3, 4, 0, -5, spooder, 2);
            }                    
           //platform3 webs
           for (int i = 0; i < 2; i++) {
                Body web4 = new spiderWebs(this);
                utilityClass.setObject(i, web4, -5, 0, 3, spooder, 2);
            } 
                     
           //platform4 webs
           for (int i = 0; i < 2; i++) {
                Body web5 = new spiderWebs(this);
                utilityClass.setObject(i, web5, -4, 5, 10, spooder, 2);
            }         
           //platform6 webs 
            for (int i = 0; i < 1; i++) {
               Body web6 = new spiderWebs(this);
               utilityClass.setObject(i, web6, -7, 8, 18, spooder, 2);
            }          
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

