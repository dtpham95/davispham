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
public class StartScreen extends JPanel {
	private static final long serialVersionUID = -9010663398125060727L;
	private static final int titleWidth = ShoreBoard.getScreenwidth() * 3 / 4; // width
																				// of
																				// the
																				// picture
																				// showing
																				// the
																				// title
																				// &
																				// click
																				// to
																				// play
																				// image,
																				// scales
																				// with
																				// the
																				// width
																				// of
																				// the
																				// screen
	private static final int titleHeight = titleWidth * 3 / 4;// height of the
																// picture
																// showing the
																// title & click
																// to play
																// image, scales
																// with width of
																// the title
	private static final int titleX = (ShoreBoard.getScreenwidth() / 2) - (titleWidth / 2); // x
																							// coordinate
																							// of
																							// the
																							// image
	private static final int titleY = (ShoreBoard.getScreenheight() / 2) - (titleHeight / 2); // y
																								// coordinate
																								// of
																								// the
																								// image
	private BufferedImage titleImg; // the title & click to play image
	private BufferedImage darkWaterImg; // the water texture background

	/**
	 * Initializes the two images for this start screen
	 */
	public StartScreen() {
		try {
			titleImg = ImageIO.read(new File("src/images/title.png"));
			if (ShoreBoard.getScreenheight() < ShoreBoard.getScreenwidth())
				darkWaterImg = ImageIO.read(new File("src/images/darkoceanwide.png"));
			else
				darkWaterImg = ImageIO.read(new File("src/images/darkoceantall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Paints the two images.
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(darkWaterImg, 0, 0, ShoreBoard.getScreenwidth(), ShoreBoard.getScreenheight(), this);
		g.drawImage(titleImg, titleX, titleY, titleWidth, titleHeight, this);
	}

	public static int getTitleWidth() {
		return titleWidth;
	}

	public static int getTitleHeight() {
		return titleHeight;
	}

	public static int getTitleX() {
		return titleX;
	}

	public static int getTitleY() {
		return titleY;
	}
}
