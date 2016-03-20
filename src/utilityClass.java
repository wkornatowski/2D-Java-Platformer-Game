package project.test2;

import org.jbox2d.common.Vec2;

import city.cs.engine.Body;
/**
 * Class which hold many of the design tool methods such as setting platform/spike/web positions.
 * These tools can be called in with position variables passed through and can be utilised across 
 * all the level designs.
 * Also adds collision listeners to objects.
 */


abstract class utilityClass  {
	
	public static void setPlatform(Body platform, double x, double y)
	   
	{	    
		platform.setPosition(new Vec2((float)x, (float) y));       
	}
	
	public static void setObject(int i, Body body, int x, int y, double d, spoodermanCharacter s, int action)
	{
		body.setPosition(new Vec2(i*x-y, (float) d));
		if(action == 1)
		{
        body.addCollisionListener(new spikeCollision(s));
		}
		if(action == 2)
		{
		body.addCollisionListener(new webCollision(s));
		}
	}
	
	public static void setInvididual_Webs(Body web, int x, int y, spoodermanCharacter s)
	{
        web.setPosition(new Vec2(x, y));
        web.addCollisionListener(new webCollision(s));
	}
}
