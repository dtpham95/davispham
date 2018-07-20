package game1model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.font.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Font;


public class SalinityBar {
	int level;
	float xPos;
	float yPos;
	int xVel;
	int yVel;
	int width;
	Game game;
	Font sb;
	Font f;
	BufferedImage fullHeart = null;
	BufferedImage emptyHeart = null;
	
	/**
	 * Creates an instance of Salinity Bar. Salinity Bar holds everything displayed at the top of the gameplay screen
	 * 
	 * @param game The game the Salinity Bar belongs to
	 */
	public SalinityBar(Game game) {
		this.game = game;
		xPos = 1330;
		yPos = 1500;
		level = 0;
		getImages();
	}
	
	
	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	/**
	 * Paints the salinity bar and other things that are at the top of the gameplay screen. 
	 * If there is a drought the salinity bar is replaced by a special drought bar.
	 * 
	 * @param g Graphics2D object
	 */
	public void paint(Graphics2D g) {
		Font sb = game.f30;
		Font f = game.f500;
		
		
		int x = Math.round(xPos);
		int y = Math.round(yPos);

//		g.setColor(Color.cyan);

		g.setFont(sb);
//		g.drawString("Salinity", x - 40, y - 20);
//		g.drawString(Integer.toString(y2), x+300, y+300);
//		g.drawString(Integer.toString(x2), x+400, y+300);
//		g.setColor(Color.white);
//		g.fillRect(x - 10, y - 10, 40, 120);

//		
//		g.setColor(Color.cyan);
//		g.fillRect(x, y, 20, 100);
		
//		g.setColor(Color.white);
//		g.fillRect(x, y, 20, level);
		
		if (game.drought) {
			g.setColor(Color.RED);
			g.fillRect(x - 10, y - 10, 40, 120);
			
			g.drawString("DROUGHT", x - 50, y - 20);
		} else {
			
			g.setColor(Color.white);
			g.fillRect(x - 10, y - 10, 40, 120);
			g.setColor(Color.cyan);
			g.drawString("Salinity", x - 50, y - 20);
			g.fillRect(x, y, 20, 100);
			g.setColor(Color.white);
			g.fillRect(x, y, 20, level);
		}
		
		// Lives
		g.setColor(Color.cyan);
		g.drawString("Lives: ", x + 800, y - 20);
		
		if (game.getTime() < 61) {
			g.drawString("Time: " + game.getTime(), x + 600, y - 20);
		} else if (game.getTime() == 63) {
			g.setFont(f);
			g.drawString("3", x + 350, y + 400);
		} else if (game.getTime() == 62) {
			g.setFont(f);
			g.drawString("2", x + 350, y + 400);
		} else if (game.getTime() == 61) {
			g.setFont(f);
			g.drawString("1", x + 350, y + 400);
		} 
		
		int n = 870;
		for (int i = 0; i < 3; i++) {
			n += 50;
			g.drawImage(emptyHeart, x + n, y - 55, 50, 50, null);
		}
		int m = 1070;
		for (int i = 0; i < game.bc.getLife(); i++) {
			m -= 50;
			g.drawImage(fullHeart, x + m, y - 55, 50, 50, null);
		}
		
		if (game.gameStart == 4) {
			g.setFont(sb);
			g.drawImage(game.w.delaware, x + 200, y - 70, 30, 70, null);
			g.drawString(": Easy", x + 240, y - 20);
		}
		if (game.gameStart == 5) {
			g.setFont(sb);
			g.drawImage(game.w.delaware, x + 200, y - 70, 30, 70, null);
			g.drawString(": Medium", x + 240, y - 20);
		}
		if (game.gameStart == 6) {
			g.setFont(sb);
			g.drawImage(game.w.delaware, x + 200, y - 70, 30, 70, null);
			g.drawString(": Hard", x + 240, y - 20);
		}

	}
	
	
	
	/**
	 * Obtains the images needed for the salinity bar class
	 */
	public void getImages() {
		try {
		    fullHeart = ImageIO.read(new File("src/images/fullHeart2.png"));
		    emptyHeart = ImageIO.read(new File("src/images/emptyHeart2.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
	
	/**
	 * Sets the level of the salinity bar based on the crabs position relative to the estuary 
	 */
	public void setLevel() {
		int y = 3600 - game.bc.yPos;
		int x;
		if (game.gameStart > 5) {
			x = 3600 - game.bc.xPos;
			x = (100 - (x / 18)) / 3;
		}
		else {
			x = Math.abs(1800 - game.bc.xPos);
			x = Math.abs(100 - (x / 18)) / 3;
		}
		
		
		y = (y / 36) / 3;
		if (game.bc.yPos > 1300) { 
			x = x / 2;
		}
		level = x + y + y - 20 ;
	}
	

	
	
//	public void keyReleased(KeyEvent e) {
//
//			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
//				xVel = 0;
//			}
//			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
//				xVel = 0;
//			}
//		
//		if (xVel == 0) {
//			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
//				yVel = 0;
//			}
//			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
//				yVel = 0;
//			}
//		}
//	}
//	
//	
//	public void keyPressed(KeyEvent e) {
//		xVel = 0;
//		yVel = 0;
//			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
//		
//					 xVel = -2;
//				}
//			
//			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
//	
//					xVel = 2;
//				}
//		
//		if (xVel == 0) {
//			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
//	
//					yVel = -2;
//				}
//			
//			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
//	
//					yVel = 2;
//				}
//		}
//	}
	
	/**
	 * Moves the salinity bar using the crab's position so that it is always locked onto the crab
	 */
	public void moveSalinityBar() {
//		xPos -= xVel;
//		yPos -= yVel;
		
		xPos =  ((game.bc.getXPos())) - 470;
		yPos =  ((game.bc.getYPos())) - 200;
	}
}
