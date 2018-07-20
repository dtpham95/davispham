package game1model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Bubbles {
	
	ArrayList<Bubble> b = new ArrayList<Bubble>();
	Game game;
	
	
	/**
	 * Creates an instance of the Bubbles class. The class holds a list of bubbles.
	 * 
	 * @param game The game the bubbles belong to
	 */
	public Bubbles(Game game) {
		this.game = game;
		bubblesList();
	}
	
	public class Bubble {
		int yPos;
		int xPos;
		int size;
		int speed;
		BufferedImage img;
		
		/**
		 * Creates an instance of a bubble. Each  bubble has a random x position, a random y position, and 
		 * random size, and a random speed. 
		 */
		public Bubble() {
			Random rand = new Random();

			int  x = rand.nextInt(3500) + 100;
			int y = rand.nextInt(2000) + 100;
			int s = rand.nextInt(80) + 20;
			int speed = rand.nextInt(2) + 1;
			createBubble();
			this.yPos = y;
			this.xPos = x;
			this.size = s;
			this.speed = speed;
		}
		
		/**
		 * Obtains the images necessary for a bubble. 
		 */
		public void createBubble() {
			BufferedImage image = null;
			try {
			    image = ImageIO.read(new File("src/images/bubble4.png"));
			} catch (IOException e) {
				System.out.println("bad");
			}
			img = image;
		}
		
		/**
		 * Moves the bubble. If the bubble reaches the top of the playing area, it is placed at the bottom.
		 */
		public void move() {
			yPos -= speed;
			if (yPos <= 0) {
				yPos = 2100;
			}
		}
		
		/**
		 * Paints the bubble.
		 * 
		 * @param g Graphics2D object
		 */
		public void paint(Graphics2D g) {
			g.drawImage(img, xPos, yPos, size, size, null);
		}
	} // end Bubble class
	
	/**
	 * Creates a list of bubbles 
	 */
	public void bubblesList() {
		for (int i = 0; i < 20; i++) {
			b.add(new Bubble());
		}
	}
	
	/**
	 * Paints the list of bubbles 
	 * 
	 * @param g {@link Graphics2D} object
	 */
	public void paint(Graphics2D g) {
		for (int i = 0; i < b.size(); i++) {
			b.get(i).paint(g);
		}
	}
	
	/**
	 * Moves the list of bubbles
	 */
	public void move() {
		for (int i = 0; i < b.size(); i++) {
			b.get(i).move();
		}
	}
}
