package game2view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game2model.ShoreBoard;

/**
 * @author Vincent Mangubat
 *
 */
public class EndScreen extends JPanel {
	private static final long serialVersionUID = -2399325667046656787L;
	private BufferedImage endScreenImg;// the image of the game win/lose text
	private int x; // x-coordinate of image
	private int y; // y-coordinate of image
	private int width; // width of image
	private int height; // height of image

	/**
	 * Initializes the image properties of this game/lose image
	 */
	public EndScreen() {
		width = ShoreBoard.getScreenwidth();
		height = (int) (width / 3.5); // height will always scale to three
										// fifths of the width
		x = 0;
		y = ShoreBoard.getScreenheight() / 2 - height / 2;
		try {
			if (ShoreBoard.getHealth() <= 0)
				endScreenImg = ImageIO.read(new File("src/images/loser.png"));
			else
				endScreenImg = ImageIO.read(new File("src/images/winner.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Paints the image of this end screen.
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(endScreenImg, x, y, width, height, this);
	}
}
