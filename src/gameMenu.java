package project.test2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class gameMenu extends JLayeredPane {
	private static JButton start = new JButton("Start Game");
	private static BufferedImage splashImage = null;
    private static JToggleButton soundButton = new JToggleButton("Sound ON/OFF");
    private static JButton quit = new JButton("Quit");

	
	public gameMenu(int w, int h)
	{
		Dimension d = new Dimension(w, h);	
		this.setPreferredSize(d);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		gameSound.backgroundMusic();
		
		try {
			splashImage = ImageIO.read(new File("data/splash1.gif"));
		} catch (IOException io) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I/O Exception!");
			io.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(splashImage));
		
   	    this.setButton(start, 30, 100, 150, 30);
        this.add(start, 1);
   	     
        this.setToggleButton(soundButton, 30, 150, 150, 30);
        this.add(soundButton, 2);

        this.setButton(quit, 30, 200, 150, 30);
        this.add(quit, 3);   
        
		picLabel.setBounds(-5, 0, w, h);
   	    picLabel.setOpaque(true);
   	    this.add(picLabel, 5);
        
        start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{		
				gameSound.buttonSound();
				guiPanel g = new guiPanel();
				initialiseGame.getFrame().add(g, BorderLayout.SOUTH);
				initialiseGame.initiateLevel_One(500, 900);
			}
		 });
        
        soundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JToggleButton soundButton = (JToggleButton)e.getSource();
               if (soundButton.isSelected()) 
               {
                gameSound.buttonSound();
            	soundButton.setText("Sound OFF");
            	gameSound.stopMusic(true);
               } 
               else
               {
                gameSound.buttonSound();
                soundButton.setText("Sound ON");  
                gameSound.startMusic(true);           
               }
            }
         });
        
        quit.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e)
            {
           	 gameSound.buttonSound();
            	Object[] options = {"Quit", "I want to keep playing"};

                int answer = JOptionPane.showOptionDialog(null, "What would you like to do? ", "Quit",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                             null, options,options[1]);
                if(answer == JOptionPane.YES_OPTION)
                {
               	 gameSound.buttonSound();
                    System.exit(0); 
                }	
                if(answer == JOptionPane.NO_OPTION)
                {
               	 gameSound.buttonSound();
                }
            }
        });
            	
	}
	
	public static JButton getQuit_Button()
	{
		return quit;
	}	
	
	public void setButton(JButton b, int z, int y, int x, int i)
	{
        b.setBounds(z, y, x, i);
        b.setMargin(new Insets(1,1,1,1)); 
        b.setBackground(Color.red);
        b.setFocusable(false);	
	}
	
	public void setToggleButton(JToggleButton b, int z, int y, int x, int i)
	{
        b.setBounds(z, y, x, i);
        b.setMargin(new Insets(1,1,1,1)); 
        b.setBackground(Color.red);
        b.setFocusable(false);	
	}
}
