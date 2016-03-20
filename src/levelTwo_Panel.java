package project.test2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import city.cs.engine.UserView;

@SuppressWarnings("serial")
public class levelTwo_Panel extends JPanel {
	private static levelTwo_Design worldTwo;
	private static UserView viewTwo;
	
	public levelTwo_Panel(int w, int h)
	{
		Dimension d = new Dimension(w, h);
		this.setPreferredSize(d);
		
		worldTwo = new levelTwo_Design();
		viewTwo = new gameView_Two(worldTwo, worldTwo.getSpooder(), w, h);
		this.add(viewTwo);
		this.requestFocus();	
		this.setBackground(Color.black);
		worldTwo.start();
	}
	

	public static levelTwo_Design getWorld() {
		// TODO Auto-generated method stub
		return worldTwo;
	}
	
	public static UserView getView()
	{
		return viewTwo;
	}

}
