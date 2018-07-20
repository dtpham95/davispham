package game1model;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
	Toolkit toolkit;
	Timer timer;
	Game game;

	
	  /**
	   * Creates an instance of a game
	   * 
	 * @param game
	 */
	public Clock(Game game) {
		    this.game = game;
		    toolkit = Toolkit.getDefaultToolkit();
		    timer = new Timer();
		    timer.schedule(new RemindTask(), 0, //initial delay
		        1 * 1000); //subsequent rate
		  }

		  class RemindTask extends TimerTask {
		    int numWarningBeeps = 0;
		    
		    /* (non-Javadoc)
		     * @see java.util.TimerTask#run()
		     */
		    public void run() {

		      if ((game.gameStart >= 4) && !game.gameOver() && !game.gameWon() && !game.menu.paused) {
		        game.setTime(game.getTime() - 1);
		      } 
		      if ( game.gameStart == 0) {
		    	  game.setTitleTime(game.getTitleTime() + 1);
		      }
	    	  if (game.gameStart == 3) {
	    		  game.setTutTime(game.getTutTime() + 1);
	    	  }
		      if (game.getTime() <= 0) {
		    	  
//		        System.out.println("Time's up!");
		    	  game.setTime(0);
//		        timer.cancel(); //Not necessary because we call System.exit
//		        System.exit(0); //Stops the AWT thread (and everything else)
		      }
		    }
		  }
		  
}
