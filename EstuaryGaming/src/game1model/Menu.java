package game1model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {
	BufferedImage box = null;
	int width = 300;
	int height = 510;
	int xPos;
	int yPos;
	Font f;
	Font f2;
	Game game;
	int cursor = 0;
	BufferedImage cursorImg = null;
	boolean paused = false;
	BufferedImage overBox = null;
	BufferedImage overSelect = null;

	
	/**
	 * 
	 * Creates an instance of a menu. Menu includes both the pause menu and the game over/game won menus.
	 * 
	 * @param game The game the menu belongs to.
	 */
	public Menu(Game game) {
		this.game  = game;
		xPos = 1690;
		yPos = 1530;
		getImages();
	}
	
	/**
	 * Obtains the images necessary for the menu
	 */
	public void getImages() {
		try {
		    box = ImageIO.read(new File("src/images/menu_box.png"));
		    cursorImg = ImageIO.read(new File("src/images/menu_select.png"));
		    overBox = ImageIO.read(new File("src/images/overMenu.png"));
		    overSelect = ImageIO.read(new File("src/images/overSelect.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
	
	/**
	 * Paints the menus. If the game is paused the pause menu is painted. If the game has been lost 
	 * or won the game over and game won menus are painted respectively. The paint function also paints
	 * the cursor.
	 * 
	 * @param g Graphics2D object
	 */
	public void paint(Graphics2D g) {

		f = game.f50;
		f2 = game.f32;
		if (paused) {
			g.drawImage(box, xPos, yPos, width, height, null);
			
			if (cursor == 0) {
				g.drawImage(cursorImg, xPos + 20, yPos + 120, 248, 70, null);
			} else if (cursor == 1) {
				g.drawImage(cursorImg, xPos + 20, yPos + 220, 248, 70, null);
			} else if (cursor == 2) {
				g.drawImage(cursorImg, xPos + 20, yPos + 325, 248, 70, null);
			}
			
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString("PAUSED", xPos + 59, yPos + 75);
			g.drawString("Resume", xPos + 59, yPos + 175);
			g.drawString("Restart", xPos + 47, yPos + 275);
			g.setFont(f2);
			g.drawString("Title Screen", xPos + 33, yPos + 370);
		}
			
		if (game.gameOver()) {
			g.drawImage(overBox, xPos, yPos + 300, 336, 204, null);
			if (cursor == 0) {
				g.drawImage(overSelect, xPos, yPos + 300, 336, 204, null);
			} else if (cursor == 1) {
				g.drawImage(overSelect, xPos, yPos + 360, 336, 204, null);
			}
			g.setFont(f);
			g.setColor(Color.WHITE);
//			g.drawString("Restart", xPos + 47, yPos + 575);
			if (game.gameOver()) {
				g.drawString("Restart", xPos + 73, yPos + 390);
			} else {
			if (game.gameStart == 4 || game.gameStart == 5 ) {
				g.setFont(f2);
				g.drawString("Next Level", xPos + 76, yPos + 380);
			}
			if (game.gameStart == 6) {
				g.drawString("Restart", xPos + 72, yPos + 390);
			}
			}
			g.setFont(f2);
			g.drawString("Title Screen", xPos + 62, yPos + 440);
		}
		if (game.gameWon()) {
			g.drawImage(overBox, xPos + 300, yPos + 300, 336, 204, null);
			if (cursor == 0) {
				g.drawImage(overSelect, xPos + 300, yPos + 300, 336, 204, null);
			} else if (cursor == 1) {
				g.drawImage(overSelect, xPos + 300, yPos + 360, 336, 204, null);
			}
			g.setFont(f);
			g.setColor(Color.WHITE);
//			g.drawString("Restart", xPos + 47, yPos + 575);
			if (game.gameOver()) {
				g.drawString("Restart", xPos + 373, yPos + 390);
			} else {
			if (game.gameStart == 4 || game.gameStart == 5) {
				g.setFont(f2);
				g.drawString("Next Level", xPos + 376, yPos + 380);
			}
			if (game.gameStart == 6) {
				g.drawString("Restart", xPos + 372, yPos + 390);
			}
			}
			g.setFont(f2);
			g.drawString("Title Screen", xPos + 362, yPos + 440);
		}

	}
	
	/**
	 * Pauses the game if p is pressed. Also moves the cursor based on up and down arrow keys.
	 * Performs the action requested by the cursor on the menu when the space bar is pressed.
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			paused = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (game.gameStart >= 4) {
				if (paused) {
					cursor += 1;
					if (cursor >= 3) {
						cursor = 2;
					}
				}
				else if (game.gameWon() || game.gameOver()) {
					cursor += 1;
					if (cursor >= 2) {
						cursor = 1;
					}
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (game.gameStart >= 4) {
				if (paused) {
					cursor -= 1;
					if (cursor <= -1) {
						cursor = 0;
					}
				}
				else if (game.gameWon() || game.gameOver()) {
					cursor -= 1;
					if (cursor <= -1) {
						cursor = 0;
					}
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (paused) {
				if (cursor == 0) {
					cursor = 0;
					paused = false;
				}
				if (cursor == 1) {
					cursor = 0;
					paused = false;
					if (game.gameStart > 5) {
						game.bc = 	 new BlueCrab(600, 2000, 60, 60, game);
					} else {
						game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					}
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.setTime(64);
				}
				if (cursor == 2) {
					paused = false;
					cursor = 0;
					game.gameStart = 0;
					game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.w.cursor = 0;
					game.setTime(64);
					game.setTutTime(0);
					game.d = new Decorations(game);
					game.t = new Tutorial(game);
				}
			}
			if (game.gameOver()) {
				if (cursor == 0) {
					cursor = 0;
					if (game.gameStart > 5) {
						game.bc = 	 new BlueCrab(600, 2000, 60, 60, game);
					} else {
						game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					}
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.setTime(64);
				}
				if (cursor == 1) {
					cursor = 0;
					game.gameStart = 0;
					game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.w.cursor = 0;
					game.setTime(64);
					game.setTutTime(0);
					game.d = new Decorations(game);
					game.t = new Tutorial(game);
				}
			}
			if (game.gameWon()) {
				if (cursor == 0) {
					cursor = 0;
					if (game.gameStart == 4 || game.gameStart == 5) {
					game.gameStart += 1;
					}
					if (game.gameStart == 5) {
					game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					} else {
						game.bc = 	 new BlueCrab(600, 2000, 60, 60, game);
					}
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.m.updateMaze();
//					game.e = new Enemies(game);
					game.e.updateEnemies();
					game.e.createImage();
					game.setTime(64);
					game.textBox = 0;
				}
				if (cursor == 1) {
					cursor = 0;
					game.gameStart = 0;
					game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
					game.sb = new SalinityBar(game);
					game.cam = new Camera(game);
					game.w.cursor = 0;
					game.setTime(64);
					game.setTutTime(0);
					game.d = new Decorations(game);
					game.t = new Tutorial(game);
					game.textBox = 0;
				}
			}
		}
	}
	
	
	/**
	 * Moves the menu based on the crabs position so that it is always locked onto the crab.
	 */
	public void moveMenu() {
		
		xPos =  ((game.bc.getXPos())) - 130;
		yPos =  ((game.bc.getYPos())) - 160;
	}
}
