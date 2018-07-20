package game1model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Wall {
	int width;
	int height;
	int xPos;
	int yPos;
	Game game;
	BufferedImage vert = null;
	BufferedImage horiz = null;
	
	/**
	 * Initializes a Wall object. 
	 * 
	 * @param xPos The x position of the wall
	 * @param yPos The y position of the wall
	 * @param width The width of the wall
	 * @param height The height of the wall
	 * @param game The game object this wall belongs to
	 */
	public Wall(int xPos, int yPos, int width, int height, Game game) {
		this.width = width;
		this.height = height;
		this.game = game;
		this.xPos = xPos;
		this.yPos = yPos;
		getImages();
	}
	
	

	public int getxPos() {
		return xPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * Obtains the images necessary for the Wall class by following
	 * a file path.
	 */
	public void getImages() {
		try {
		    vert = ImageIO.read(new File("src/images/wall_vert.png"));
		    horiz = ImageIO.read(new File("src/images/wall_horiz.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}

	/**
	 * Determines if the given blue crab has collided with a wall.
	 * The integer returned corresponds to which direction the blue crab 
	 * has collided with the wall from.
	 * 
	 * @param bc A BlueCrab object
	 * @return	an integer representing the blue crab's approach direction
	 */
	public int wallHit(BlueCrab bc) {
		int xLow = bc.getXPos();
		int xHigh = bc.getXPos() + bc.getWidth();
		int yTop = bc.getYPos();
		int yBot = bc.getYPos() + bc.getHeight();
//		if (xLow  == (xPos + width) || (xHigh == xPos)) {
//			if ((yTop >= yPos && yTop  <= yPos + height) || (yBot <= yPos && yBot >= yPos + height)) {
//				return true;
//			}
//		}
//		if (yTop  == (yPos + height) || (yBot == yPos)) {
//			if ((xLow >= xPos && xLow  <= xPos + width) || (xHigh <= xPos && xHigh >= xPos + width)) {
//				return true;
//			}
//		}
		if (xLow  == (xPos + width) ) {
			if ((yBot > yPos && yTop  < yPos + height) || (yTop < yPos && yBot > yPos + height)) {
				return 1;
			}
		}
		if (xHigh  == xPos) {
			if ((yBot > yPos && yTop  < yPos + height) || (yTop < yPos && yBot > yPos + height)) {
				return 2;
			}
		}
		if (yTop  == (yPos + height)) {
			if ((xHigh > xPos && xLow  < xPos + width) || (xLow < xPos && xHigh > xPos + width)) {
				return 3;
			}
		}
		if  (yBot  == yPos) {
			if ((xHigh > xPos && xLow  < xPos + width) || (xLow < xPos && xHigh > xPos + width)) {
				return 4;
			}
		}
	  return 0;
	}
	
	public String toString() {
		return "(" + xPos + ", " +  yPos + ")";
	}
	/**
	 * Paints the wall object
	 * 
	 * @param g A Graphics2D object
	 */
	public void paint(Graphics2D g) {
//		g.setColor(Color.DARK_GRAY);
//		g.fillRect(xPos, yPos, width, height);
		if (height > width) {
			g.drawImage(vert, xPos, yPos, width, height, null);
		}
		if (height < width) {
			g.drawImage(horiz, xPos, yPos, width, height, null);
		}
	}
}
	
	