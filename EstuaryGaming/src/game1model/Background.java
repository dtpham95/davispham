package game1model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Background {

	int yVel;
	Game game;
	ArrayList<Pic> imgs = new ArrayList<Pic>();

	
	public Background(Game game) {
		this.game = game;

		createList();

		yVel = 0;
	}
	
	public class Pic {
		int yPos;
		BufferedImage img;

		
		/**
		 * Creates an instance of a Pic. A Pic object is a single row of the background.
		 * 
		 * @param yPos
		 */
		public Pic(int yPos) {
			createBackground();
			this.yPos = yPos;
		}
		
		/**
		 * Obtains the images necessary to create the background 
		 */
		public void createBackground() {
			BufferedImage image = null;
			try {
			    image = ImageIO.read(new File("src/images/ocean3.png"));
			    

			} catch (IOException e) {
				System.out.println("bad");
			}
			img = image;

		}
		
		
		/**
		 * Paints one row of the background
		 * 
		 * @param g {@link Graphics2D} object
		 */
		public void paint(Graphics2D g) {
			g.drawImage(img, 0, yPos, 3600, 120, null);
		}
		
	} // end Pic class
	

	
	/**
	 * Creates a list of background images to be tiled across the playing area 
	 */
	public void createList() {
		int y = 2100;
		for (int i = 0; i <= 17; i++) {
			y -= 120;
			imgs.add(new Pic(y));
		}
	}
	

	
	/**
	 * Paints the elements of the background class
	 * 
	 * @param g Graphics2D object
	 */
	public void paint(Graphics2D g) {

			for (int j = 0; j <= 16;  j++) {
				imgs.get(j).paint(g);
			}



	}
	

	
}

