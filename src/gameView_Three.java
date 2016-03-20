package project.test2;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;
import city.cs.engine.UserView;
import city.cs.engine.World;

/**
 * Level three game view class.
 */

@SuppressWarnings("serial")
public class gameView_Three extends UserView {
	
	spoodermanCharacter spooder;
	spoodersEnemy_DOLAN dolan;
	static int counter;
	
	public gameView_Three(World worldThree , spoodermanCharacter spooder, spoodersEnemy_DOLAN dolan, int width, int height)
	{
	super(worldThree,width,height);
	this.spooder = spooder;
	this.dolan = dolan;
	
	}
	@Override
	protected void paintBackground(Graphics2D bg){
	ImageIcon img;
	img = new ImageIcon("data/bg_level3.gif");
	bg.drawImage(img.getImage(),0,0, this);

	}
	
	@Override
    protected void paintForeground(Graphics2D g) {
		counter++;
	//platform1
		if(counter == 90){
			System.out.print("Position Changed");
			dolan.setPosition(new Vec2(-9, -4));
	//platform2		 
		}
		if(counter == 180){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(-1, -6));
    //platform3
		}
		if(counter == 270){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(5, -7));
			 
		}
	    //platform4
		if(counter == 360){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(8, -1));
			 
		}	
	    //platform5
		if(counter == 450){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(12, -5));		 
		}
	    //platform6
		if(counter == 540){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(15, 5));
			 
		}
	    //platform7
		if(counter == 630){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(2, 6));
			 
		}
	    //platform8
		if(counter == 720){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(-3, 8));
			 
		}
	    //platform9
		if(counter == 810){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(-6, 10));
			 
		}
	    //platform10
		if(counter == 900){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(-12, 13));
			 
		}
		
		//end
		if(counter == 1150){
			System.out.print("\nPosition Changed");
			dolan.setPosition(new Vec2(-300, -300));
			JOptionPane.showMessageDialog(null, "Game Over", "You weren't quick enough", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
    	//display score
		g.setColor(Color.WHITE);
    	String score = "Score: " + spooder.getScore(); 	
        g.drawString(score, 35, 20);
        
        g.setColor(Color.RED);
        String time = "Time: " + counter/24.56f;
        //String nonSecond = "Time: " + counter;
        //String time2 = "seconds: " + System.currentTimeMillis()/1000;
    
        
       
        g.drawString(time, 305, 17);
        //g.drawString(nonSecond, 305, 30);
        //g.drawString(time2, 222, 34);       
        
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
        g.drawString(health, 605, 20);
        
    }
	
}
