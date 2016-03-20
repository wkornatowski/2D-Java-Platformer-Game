package project.test2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Loading screen design class.
 */

@SuppressWarnings("serial")
public class loadingScreen extends JWindow {
	private int duration;
	private JProgressBar progressBar;
	private int progressMinimum = 0;
	private int progressMaximum;
	final private JLabel loadingInformation = new JLabel("Loading.. ");
	private JPanel loadingContent = (JPanel)getContentPane();
	
	public loadingScreen(int time)
	{
	duration = time;
	progressMaximum = time;
	}

	public void displayLoading()
	{	
		//define the size of the loading screen
		int width = 600;
		int height = 500;	
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenDimension.width-width)/2;
		int y = (screenDimension.height-height)/2;	
		this.setBounds(x, y, width, height);

		progressBar = new JProgressBar();
		JPanel bottomBar = new JPanel(new BorderLayout());
		JLabel logo = new JLabel(new ImageIcon("data/spider_load.png"));
		JLabel copyright = new JLabel("Copy Right @ 2014 Kornatowski Studios", JLabel.CENTER);
		Color c = new Color(152, 23, 25, 245);
			
		loadingContent.setBackground(Color.white);
		bottomBar.setBackground(Color.white);
		copyright.setBorder(new EmptyBorder(10, 10, 10, 10));
		loadingInformation.setVisible(true);
		loadingContent.setBorder(BorderFactory.createLineBorder(c, 5));
	
		loadingContent.add(logo, BorderLayout.CENTER);
		loadingContent.add(bottomBar, BorderLayout.SOUTH);
		loadingContent.add(loadingInformation, BorderLayout.NORTH);
	
		bottomBar.add(progressBar, BorderLayout.NORTH);
		bottomBar.add(copyright, BorderLayout.SOUTH);
		loadingInfo();
		
		this.setVisible(true);
		
		for (int i = progressMinimum; i <= progressMaximum; i=(int) (i+4.)) {
		      final int percent = i;
		      try {
		        SwingUtilities.invokeLater(new Runnable() {
		          public void run() {
		            updateBar(percent);
		          }
		        });
		      
		        java.lang.Thread.sleep(duration);
		      } catch (InterruptedException e) {;}	      
		}
		
	    this.setVisible(false);
	}
	
	public void updateBar(int updatedValue){
		progressBar.setValue(updatedValue);
	}
	
	public void loadMenu(int w, int h) {
	    displayLoading();
	    new initialiseGame(w, h);
	}
	
	public void loadingInfo(){
		
		new Thread() {  
		     public void run() {  
		       String t1 = "Loading sprites..";  
		       String t2 = "Loading components..";  
		       String t3 = "Loading menu..";  
		       String t4 = "Successfully Loaded!";
		       loadingInformation.setText(t1);  
		       validate();  
		       try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		       loadingInformation.setText(t2);  
		       validate();  
		       try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         
		       loadingInformation.setText(t3);  
		       validate();  
		       try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		       loadingInformation.setText(t4);  
		       validate();  
		       try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		     }  
		   }.start();  
	}
}
