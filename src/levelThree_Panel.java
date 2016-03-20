package project.test2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import city.cs.engine.UserView;

@SuppressWarnings("serial")
public class levelThree_Panel extends JPanel {
	
	private static levelThree_Design worldThree;
	private static UserView viewThree;
	
	public levelThree_Panel(int w, int h)
	{
		Dimension d = new Dimension(w, h);
		this.setPreferredSize(d);
		
		worldThree = new levelThree_Design();
		viewThree = new gameView_Three(worldThree, worldThree.getSpooder(), worldThree.getDolan(), w, h);
		this.add(viewThree);
		this.requestFocus();
		this.setBackground(Color.black);
		worldThree.start();	
		worldThree.setGravity(30);
		JOptionPane.showMessageDialog(null, "Quickly! Catch Dolan!" + "\n\n\n *Watch out! Dolan seems to be exerting"
     			+ "\n  an aura which is blocking your powers*\n\n  "
     			+ "*He can teleport*" + "\n\n\n YOU HAVE 45 SECONDS! HURRY!", "Final Level!", 
     			JOptionPane.PLAIN_MESSAGE);	
	}
	

	public static levelThree_Design getWorld() {
		// TODO Auto-generated method stub
		return worldThree;
	}
	
}
