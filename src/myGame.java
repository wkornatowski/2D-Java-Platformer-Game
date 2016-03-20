package project.test2;

/**
 * Main class
 */

public class myGame {
	
	public myGame()
	{		
		gameSound.splashSound();
		loadingScreen load = new loadingScreen(105);
		((loadingScreen) load).loadMenu(650, 500);
		
	}

    public static void main(String[] args) {
        new myGame();
    }
}
