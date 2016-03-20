package project.test2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * This is the class which creates the game frame and initialises the game levels.
 */

public class initialiseGame {
    //frame
    private static JFrame frame;   
    //custom level panels
	private static levelOne_Panel levelOne;
	private static levelTwo_Panel levelTwo;
	private static levelThree_Panel levelThree;
	private static gameMenu gameMenu;

    //create frame and load menu
    public initialiseGame(int w, int h) {
        // display the view in a frame
        frame = new JFrame("Spooderman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setUndecorated(true);
        
        try
        {
            //Set look and feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
            //Update the frame with the theme
            SwingUtilities.updateComponentTreeUI(frame);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        gameMenu = new gameMenu(w, h);
   	    frame.add(gameMenu, BorderLayout.CENTER);	    	 
        frame.setResizable(false);
        frame.pack();        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();     
    }
     
     
     public static void initiateLevel_One(int w, int h)
     {
    	 gameMenu.removeAll();
         levelOne = new levelOne_Panel(w, h);
         frame.add(levelOne, BorderLayout.CENTER);	
         frame.addKeyListener(new Controller(levelOne_Panel.getWorld().getActor(), levelOne_Panel.getWorld().getSpooder()));
         validateFrame(w, h+30); //60 Windowed //40 Borderless
     }

     public static void initiateLevel_Two(int w, int h)
     {   
    	levelOne.removeAll();
    	levelTwo = new levelTwo_Panel(w, h);
    	frame.add(levelTwo, BorderLayout.CENTER);
    	frame.addKeyListener(new Controller(levelTwo_Panel.getWorld().getActor(), levelOne_Panel.getWorld().getSpooder()));
    	levelTwo_Panel.getWorld().addStepListener(new Tracker(levelTwo_Panel.getView(), levelTwo_Panel.getWorld().getActor()));
    	validateFrame(w, h);  
     }
     
     public static void initiateLevel_Three(int w, int h)
     {	
    	levelTwo.removeAll();
        levelThree = new levelThree_Panel(w, h);
     	frame.add(levelThree, BorderLayout.CENTER);
     	frame.addKeyListener(new Controller(levelThree_Panel.getWorld().getActor(), levelOne_Panel.getWorld().getSpooder()));
        validateFrame(w, h);
     }

     public static void validateFrame(int x, int y)
     {
    	frame.invalidate();
      	frame.validate(); 
      	frame.setSize(x, y);  	
      	frame.setLocationRelativeTo(null);
     }
     
     public static JFrame getFrame()
     {
 	     return frame;
     }
      
}