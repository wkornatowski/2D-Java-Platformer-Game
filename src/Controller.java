package project.test2;

import city.cs.engine.*;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control a body.
 * *** I do not claim this as my own ***
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 4;
    int pause = 0;    
    private DynamicBody body;
    private World world;
    private Walker walkLeft;
    private Walker walkRight;   
    private spoodermanCharacter spooder;
    private static final BodyImage spooderRIGHT = new BodyImage("data/spoodermanRIGHT.gif", 2.25f);
    private static final BodyImage spooderLEFT = new BodyImage("data/spoodermanLEFT.gif", 2.25f);
    
    // one of walkLeft, walkRight or null
    private Walker currentWalker;

    public Controller(DynamicBody body, spoodermanCharacter spooder) {
        this.body = body;
        this.world = body.getWorld();
        this.walkLeft = new Walker(body, - WALKING_SPEED);
        this.walkRight = new Walker(body, WALKING_SPEED);
        this.currentWalker = null;
        this.spooder = spooder;
    }
    
    /** Handle key press events for walking and jumping. 
     * @return */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        }      
        else if (code == KeyEvent.VK_SPACE) { // SPACE = jump
            gameSound.jumpSound(); 
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.setLinearVelocity(new Vec2(v.x, JUMPING_SPEED));
            }
        } else if (code == KeyEvent.VK_LEFT) {
        	body.setImage(spooderLEFT);
            // LEFT ARROW = walk left
            setWalker(walkLeft);
            spooder.setDirection_LEFT();
            
            
        } else if (code == KeyEvent.VK_RIGHT) {
        	
            // RIGHT ARROW = walk right
        	body.setImage(spooderRIGHT);
            setWalker(walkRight);
            spooder.setDirection_RIGHT();
        }
    }
    
    /** Handle key release events (stop walking). */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            // LEFT ARROW = walk left
            clearWalker(walkLeft);
        } else if (code == KeyEvent.VK_RIGHT) {
            // RIGHT ARROW = walk right
            clearWalker(walkRight);
        }
    }
    
    /** Set the walker, unless already walking */
    void setWalker(Walker w) {
        if (currentWalker == null) {
            currentWalker = w;
            world.addStepListener(currentWalker);
        }
    }

    /** Clear the walker, if this is the one in effect. */
    void clearWalker(Walker w) {
        if (currentWalker == w) {
            world.removeStepListener(currentWalker);
            currentWalker = null;
        }
    }
}
