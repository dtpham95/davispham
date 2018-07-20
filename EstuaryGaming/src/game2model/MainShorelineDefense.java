package game2model;

import java.awt.Color;
import javax.swing.JFrame;
import game2controller.ExitButton;
import game2controller.MouseBasic;
import game2controller.MouseGame;
import game2view.EndScreen;
import game2view.StartScreen;
import game2view.ViewScreen;

/**
 * @author Vincent Mangubat
 * @see ShoreBoard
 *
 */
public class MainShorelineDefense {
	private final static int minutes = 2; // how many minutes we want the game
											// to last for
	private final static int tickLimit = minutes * 60000; // how long the game
															// will last for
	private final static int sleepinterval = 15; // Used for Thread.sleep(#).
													// The bigger this number
													// is, the slower the game
													// runs in real time.
	private static int currenttick;// runs from 0 to tickLimit
	private static boolean exitClicked;

	public MainShorelineDefense() throws InterruptedException {
		currenttick = 0;
		exitClicked = false;
		ShoreBoard gameboard = new ShoreBoard();

		// set up the frame
		JFrame frame = new JFrame("Estuary Defense");
		frame.setBackground(Color.white);
		frame.setSize(ShoreBoard.getScreenwidth(), ShoreBoard.getScreenheight());
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// start screen
		StartScreen startjpanscreen = new StartScreen();
		frame.add(startjpanscreen);
		MouseBasic startmouselisten = new MouseBasic();
		startjpanscreen.addMouseListener(startmouselisten);
		frame.setVisible(true);
		while (startmouselisten.getClicked() == false)
			Thread.sleep(10);
		frame.remove(startjpanscreen);

		// exit button
		ExitButton exitbutton = new ExitButton(frame);
		/*
		 * exitbutton.setBounds(0, 0, 100, 100); exitbutton.setOpaque(false);
		 * exitbutton.setContentAreaFilled(false);
		 * exitbutton.setBorderPainted(false); exitbutton.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent evt) {
		 * frame.setVisible(false); frame.dispose(); } });
		 */

		// after pressing start, proceed to game
		ViewScreen gamejpanscreen = new ViewScreen();
		frame.add(gamejpanscreen);
		frame.add(exitbutton);
		gamejpanscreen.setVisible(true);
		MouseGame gamemouselisten = new MouseGame();
		gamejpanscreen.setLocation(0, 0);
		gamejpanscreen.setSize(ShoreBoard.getScreenwidth(), ShoreBoard.getScreenheight());
		gamejpanscreen.addMouseListener(gamemouselisten);
		gamejpanscreen.addMouseMotionListener(gamemouselisten);
		frame.add(gamejpanscreen);
		while (ShoreBoard.getIsPlaying() && exitClicked == false) {
			gameboard.moveall();
			gamejpanscreen.repaint();

			Thread.sleep(sleepinterval);
			currenttick += sleepinterval;
			// System.out.println(currentmsec / 1000);
			if (currenttick >= tickLimit) {
				ShoreBoard.setIsPlaying(false);
			}
		}
		frame.remove(gamejpanscreen);

		// win/lose game screen
		if (exitClicked == false) {
			EndScreen endjpanscreen = new EndScreen();
			endjpanscreen.setBounds(0, 0, ShoreBoard.getScreenwidth(), ShoreBoard.getScreenheight());
			frame.add(endjpanscreen);
			endjpanscreen.setVisible(true);
			MouseBasic endmouselisten = new MouseBasic();
			endjpanscreen.addMouseListener(endmouselisten);
			endjpanscreen.setVisible(true);
			endjpanscreen.repaint();
			while (endmouselisten.getClicked() == false) {
				Thread.sleep(10);
			}
			frame.remove(endjpanscreen);
		}

		// exit game
		frame.remove(exitbutton);
		frame.setVisible(false);
		frame.dispose();
	}

	public static void main(String[] args) throws InterruptedException {
		new MainShorelineDefense();
	}

	public static boolean isExitClicked() {
		return exitClicked;
	}

	public static void setExitClicked(boolean exitClicked) {
		MainShorelineDefense.exitClicked = exitClicked;
	}

	public static int getTicklimit() {
		return tickLimit;
	}

	public static int getMinutes() {
		return minutes;
	}

	public static int getTickLimit() {
		return tickLimit;
	}

	public static int getSleepinterval() {
		return sleepinterval;
	}

	public static int getCurrenttick() {
		return currenttick;
	}

	public static void setCurrenttick(int currenttick) {
		MainShorelineDefense.currenttick = currenttick;
	}

}
