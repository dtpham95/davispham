package game1model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Predator extends Animal{
	static final int VERTICAL = 1;
	static final int HORIZONTAL = 2;
	int upperBound;
	int lowerBound;
	int dir;
	int speed;
	BufferedImage bassImg = null;
	BufferedImage bassRight = null;
	BufferedImage bassUp = null;
	BufferedImage bassDown = null;
	
	/**
	 * 
	 * Creates an instance of a Predator class.
	 * 
	 * @param xPos The x direction of the predator
	 * @param yPos The y position of the predator
	 * @param width The width of the predator
	 * @param height The height of the predator
	 * @param game The game that this predator belongs to
	 * @param lb The lower bound for the predator's path
	 * @param ub The upper bound for the predator's path
	 * @param dir The direction of the predator's movement (up and down or side to side)
	 */
	public Predator(int xPos, int yPos, int width, int height, Game game, int lb, int ub, int dir) {
		super(xPos, yPos, width, height, game);
		this.upperBound = ub;
		this.lowerBound = lb;
		this.dir = dir;
		this.speed = 3;
		this.xVel = speed;
		this.yVel = speed; 
	}
	
	/**
	 * Moves the predator. Based on the predator's direction. Also checks the switchDir() 
	 * method to see if it hits a bound.
	 * 
	 */
	public void movePredator() {
		if (dir == HORIZONTAL) {
			if (hitPred(game.bc) > 0) {
				xVel *= -1;
			}
			xPos += switchDir();
		}
		else if (dir == VERTICAL) {
			if (hitPred(game.bc) > 0) {
				yVel *= -1;
			}
			yPos += switchDir();
		}
	}
	
	
	/**
	 * Obtains the images needed for the predator 
	 */
	public void createImage() {
		try {
		    bassImg = ImageIO.read(new File("src/images/stripedbass2.png"));
		    bassRight = ImageIO.read(new File("src/images/stripedbassRight.png"));
		    bassUp = ImageIO.read(new File("src/images/stripedbassUp.png"));
		    bassDown = ImageIO.read(new File("src/images/stripedbassDown.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
	
	
	/**
	 * Paints the predator. Changes the image if the predator's orientation changes
	 * 
	 * @param g Graphics 2D object
	 */
	public void paint(Graphics2D g) {
		if (dir == VERTICAL) { 
			if (yVel > 0) {
				g.drawImage(bassDown, getXPos(), getYPos(), getWidth(), getHeight(), null);
			} else {
				g.drawImage(bassUp, getXPos(), getYPos(), getWidth(), getHeight(), null);
			}
		}
		if (dir == HORIZONTAL) { 
			if (xVel > 0) {
				g.drawImage(bassRight, getXPos(), getYPos(), getWidth(), getHeight(), null);
			} else {
				g.drawImage(bassImg, getXPos(), getYPos(), getWidth(), getHeight(), null);
			}
		}
	}
	
	/**
	 * Checks to see if the predator has hit a bound, a switches its direction if it has.
	 * 
	 * @return an updated velocity integer
	 */
	public int switchDir() {
		if (dir == VERTICAL) {
			if (yPos <= lowerBound) {
				yVel = speed;
				return yVel;
			} else if (yPos >= upperBound) {
				yVel = speed * -1;
				return yVel;
			} else {
				return yVel;
			}
		} else if (dir == HORIZONTAL) {
			if (xPos <= lowerBound) {
				xVel = speed;
				return xVel;
			} else if (xPos >= upperBound) {
				xVel = speed * -1;
				return xVel;
			} else {
				return xVel;
			}
		}
		return 0;
	}
	
	
	/**
	 * Checks to see if the blue crab has hit the predator. Returns an integer representing the direction from which the
	 * blue crab approached the predator.
	 * 
	 * @param bc Blue Crab object
	 * @return an integer representing the direction from which the
	 * blue crab approached the predator.
	 */
	public int hitPred(BlueCrab bc) {
		int xLow = bc.getXPos();  
		int xHigh = bc.getXPos() + bc.getWidth();
		int yTop = bc.getYPos();
		int yBot = bc.getYPos() + bc.getHeight();
		if (dir == 2) {
			if ((xLow >= xPos && xLow <= (xPos + width)) || (xHigh >= xPos && xHigh <= (xPos + width))) {
				if (yBot >= yPos  && yBot <= (yPos + (height/2))) {
					return 1;
				}
				else if (yTop <= yPos + (height) &&  yTop >= (yPos + (height/2))) {
					return 2;
				}
				else if ((yBot >= yPos && yBot <= (yPos + height) || yTop >= yPos &&  yTop <= (yPos + height))) {
					return 5;
				}
			}
		}
		else if (dir == 1) {
			if ((yBot >= yPos && yBot <= (yPos + height) || yTop >= yPos &&  yTop <= (yPos + height))) {
				if (xLow >= xPos + (width/2) && xLow <= (xPos + width) ) {
					return 3;
				}
				else if (xHigh >= xPos && xHigh <= (xPos + (width/2)) ) {
					return 4;
				}
				else if ((xLow >= xPos && xLow <= (xPos + width)) || (xHigh >= xPos && xHigh <= (xPos + width))) {
					return 6;
				}
			}
		}
		return 0;
	}

}
