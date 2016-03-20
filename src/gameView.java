package project.test2;

import java.awt.Color;
import java.awt.Graphics2D;


import javax.swing.ImageIcon;

import city.cs.engine.UserView;
import city.cs.engine.World;

/**
 * Level one game view class.
 */


@SuppressWarnings("serial")
public class gameView extends UserView {
	
	spoodermanCharacter spooder;
	
	public gameView(World world , spoodermanCharacter spooder, int width, int height)
	{
	super(world,width,height);
	this.spooder = spooder;
	}
	@Override
	protected void paintBackground(Graphics2D bg){
	ImageIcon img;
	img = new ImageIcon("data/bg.gif");
	bg.drawImage(img.getImage(),0,0, this);

	}
	
	@Override
    protected void paintForeground(Graphics2D g) {
    	//display score
		g.setColor(Color.WHITE);
    	String score = "Score: " + spooder.getScore(); 	
        g.drawString(score, 35, 20);
        
        //display health
        
        //default health color
        g.setColor(Color.WHITE);
        
        //health level warnings color coded with orange and red
        if((int)spooder.getHealth() <= 5)
        {
        g.setColor(Color.ORANGE);
        }
        if((int)spooder.getHealth() <= 2)
        {
        g.setColor(Color.RED);
        }     
        String health = "Health: " + spooder.getHealth();
        g.drawString(health, 405, 20);
        
    }
	
}
