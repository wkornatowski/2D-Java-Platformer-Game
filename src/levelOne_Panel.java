package project.test2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import city.cs.engine.UserView;

@SuppressWarnings("serial")
public class levelOne_Panel extends JPanel {
	private static levelOne_Design world;
	private static UserView view;
	
	public levelOne_Panel(int w, int h)
	{
		Dimension d = new Dimension(w , h);
		this.setPreferredSize(d);
		
		world = new levelOne_Design();
		view = new gameView(world, world.getSpooder(), w, h);
		this.add(view);
		this.requestFocus();	
		this.setBackground(Color.black);
		//this.setVisible(true);
		world.start();
	}
	

	public static levelOne_Design getWorld() {
		// TODO Auto-generated method stub
		return world;
	}

}
