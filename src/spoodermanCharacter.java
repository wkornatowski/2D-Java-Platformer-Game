package project.test2;

import javax.swing.JOptionPane;

import city.cs.engine.*;

/**
 * Spooderman character class
 */
public class spoodermanCharacter extends DynamicBody {
    private static final Shape spooderBody = new PolygonShape(-0.086f,0.72f, -0.363f,0.469f, -0.363f,-1.125f, 0.381f,-1.104f, 0.41f,0.7f, -0.059f,0.72f);
    private static final Shape spooderHead = new PolygonShape(-0.168f,1.125f, -0.018f,1.072f, 0.159f,0.8f, -0.092f,0.715f, -0.384f,0.839f, -0.393f,0.977f, -0.21f,1.119f);    
    private static int score;
    private static int health;
    private String direction;
    
    @SuppressWarnings("unused")
	private static final BodyImage spooderRIGHT = new BodyImage("data/spoodermanRIGHT.gif", 2.25f);
    private static final BodyImage spooderLEFT = new BodyImage("data/spoodermanLEFT.gif", 2.25f);

    public spoodermanCharacter(World world) {
        super(world);  
        
        Fixture fixtureOne = new SolidFixture(this, spooderHead);
        Fixture fixtureTwo = new SolidFixture(this, spooderBody);
   
        ((SolidFixture) fixtureTwo).setFriction(2.5f);
        ((SolidFixture) fixtureOne).setFriction(0.5f);
        
        this.setImage(spooderLEFT);
        
        this.direction = "left";
      
        setFixedRotation(true);
  
        score = 0;
        health = 10; 
    }
    
    public void setDirection_LEFT()
    {
    	
    	this.direction = "left";
    }
    
    public void setDirection_RIGHT()
    {
    	this.direction = "right";
    }

    public String getDirection()
    
    {
    	return this.direction;
    }
    
    public int getScore() {
    	return score;
    }
    @SuppressWarnings("static-access")
	public void addScore(){
    	this.score++;
    	System.out.println("Score: " + score);
    }
    
    public int getHealth(){
    	return health;
    }
    
    public void healHeart(){
    	health = health + 10;
    	score = score +10;
    }
    
    public void decreaseHealth_Spikes(){
    	health = --health;
    	System.out.println("You got hurt, your health is: " + health);
    	
    	if (health == 0)
    	{
    		gameSound.deathSound();
    		JOptionPane.showMessageDialog(null, "You Died, try again! Dont leave Uncle Ben hanging.");
    		gameSound.buttonSound();
    		System.exit(0);
    	}
    }
    
    public void decreaseHealth_Lasers(){
    	health = 0;
    	
    	if (health >= 0)
    	{
    		gameSound.deathSound();
    		JOptionPane.showMessageDialog(null, "You Died, try again!");
    		gameSound.buttonSound();
    		System.exit(0);
    	}
    }
   
}
