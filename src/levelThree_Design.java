
package project.test2;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level three design class.
 */

public class levelThree_Design extends World {
    private spoodermanCharacter spooder;
    private static spoodersEnemy_DOLAN dolan;
 
       
    public levelThree_Design() {
        super();
    
 
        { // make the ground
            Shape shape = new BoxShape(20, 0.5f);
             Body ground = new StaticBody(this, shape);
             ground.setPosition(new Vec2(0, -13.5f));
            
            // walls
            Shape leftWallShape = new BoxShape(0.5f, 30, new Vec2(-17, 0));
             new SolidFixture(ground, leftWallShape);
            Shape rightWallShape = new BoxShape(0.5f, 30, new Vec2(17, 0));
             new SolidFixture(ground, rightWallShape);
           // ceiling  
            Shape shape2 = new BoxShape(20, 0.5f);
             Body ceiling = new StaticBody(this, shape2);
             ceiling.setPosition(new Vec2(0, 17));
        }

        { //Platforms
        	Shape shape3 = new BoxShape(2, 0.5f);
        	Shape shape4 = new BoxShape(3, 0.5f);

        	//Platform Bodies
        	Body littlePlatform1 = new StaticBody(this, shape3);
        	Body littlePlatform2 = new StaticBody(this, shape3);
        	Body littlePlatform3 = new StaticBody(this, shape3);
        	Body littlePlatform4 = new StaticBody(this, shape3);
        	Body littlePlatform5 = new StaticBody(this, shape3);
        	Body littlePlatform6 = new StaticBody(this, shape3);
        	Body littlePlatform7 = new StaticBody(this, shape3);
        	Body littlePlatform8 = new StaticBody(this, shape3);
        	Body littlePlatform9 = new StaticBody(this, shape3);
        	Body littlePlatform10 = new StaticBody(this, shape3);
        	Body littlePlatform11 = new StaticBody(this, shape4);

        	//Platform Positions   
        	utilityClass.setPlatform(littlePlatform1, -13, -10);
        	utilityClass.setPlatform(littlePlatform2, -9, -5);
        	utilityClass.setPlatform(littlePlatform3, -1, -7);
        	utilityClass.setPlatform(littlePlatform4, 5, -8);
        	utilityClass.setPlatform(littlePlatform5, 8, -2);
        	utilityClass.setPlatform(littlePlatform6, 12, -6);
        	utilityClass.setPlatform(littlePlatform7, 15, 4);
        	utilityClass.setPlatform(littlePlatform8, 2, 5);
        	utilityClass.setPlatform(littlePlatform9, -3, 7);
        	utilityClass.setPlatform(littlePlatform10, -6, 9);
        	utilityClass.setPlatform(littlePlatform11, -12, 12);
       
          //Platform Walls
            //Wall Shape
            Shape wallShape = new BoxShape(0.5f, 1.5f); 
            //Wall Body
            Body littleWall1 = new StaticBody(this, wallShape);
            //Wall Position
            littleWall1.setPosition(new Vec2(3.5f, 3.5f));
  
        }
        
        {
        
         //character implementation
        	spooder = new spoodermanCharacter(this);
        	spooder.setPosition(new Vec2(0, -13));    
        	
             dolan = new spoodersEnemy_DOLAN(this);
        	 dolan.setPosition(new Vec2(-13, -9));
           	 dolan.addCollisionListener(new catchDolan_Collision(spooder));
        
         }

         {//webs
        	 
        	//Floor Webs
        	 for (int i = 0; i < 10; i++) {
                 Body web = new spiderWebs(this);
                 utilityClass.setObject(i, web, 4, 10, -13, spooder, 2);
             } 
        	//Web Bodies
        	 Body web1 = new spiderWebs(this);
        	 Body web2 = new spiderWebs(this);
        	 Body web3 = new spiderWebs(this);
        	 Body web4 = new spiderWebs(this);
        	 Body web5 = new spiderWebs(this);
        	 Body web6 = new spiderWebs(this);
        	 Body web7 = new spiderWebs(this);
        	 Body web8 = new spiderWebs(this);
        	 Body web9 = new spiderWebs(this);
        	 Body web10 = new spiderWebs(this);
        	 
        	//Web Positions
        	 utilityClass.setInvididual_Webs(web1, -14, -10, spooder);
             utilityClass.setInvididual_Webs(web2, -8, -5, spooder);       	   
             utilityClass.setInvididual_Webs(web3, 0, -7, spooder);        	
             utilityClass.setInvididual_Webs(web4, 6, -8, spooder);	
             utilityClass.setInvididual_Webs(web5, 7, -2, spooder);	     	
             utilityClass.setInvididual_Webs(web6, 13, -6, spooder);	
             utilityClass.setInvididual_Webs(web7, 14, 4, spooder);	  	
             utilityClass.setInvididual_Webs(web8, 1, 5, spooder);	       	
             utilityClass.setInvididual_Webs(web9, -2, 7, spooder);	
             utilityClass.setInvididual_Webs(web10, -11, 12, spooder);	
         }
        
        
    }
    public DynamicBody getActor() {
        return spooder;     
    }

    public spoodermanCharacter getSpooder()
    {
    	return spooder;
    }   
    
    public spoodersEnemy_DOLAN getDolan()
    {
    	return dolan;
    }  
}

