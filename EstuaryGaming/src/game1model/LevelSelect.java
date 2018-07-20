package game1model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelSelect {
	int xPos = 700;
	int yPos = 300;
	int emhCursor;
	Game game;
	BufferedImage emhMenu;
	BufferedImage lock;
	BufferedImage emhCursorImg;
	BufferedImage medium;
	boolean clicked = false;
	int count = 0;
	int emhCount = 0;
	Font f1;
	Font f2;
	
	public LevelSelect(Game game) {
		this.game = game;
		emhCursorImg = game.menu.cursorImg;
		f1 = game.f20;
		f2 = game.f30;
		getImages();
	}
	
	public void getImages() {
		try {
		    lock = ImageIO.read(new File("src/images/EMHmenuLock.png"));
		    emhMenu = ImageIO.read(new File("src/images/EMHmenu.png"));
		    medium = ImageIO.read(new File("src/images/medium.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			emhCursor -= 1;
			if (emhCursor == -1) {
				emhCursor = 0;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			emhCursor += 1;
			if (emhCursor == 3) {
				emhCursor = 2;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.gameStart = 1;
			game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (emhCursor == 0) {
				game.gameStart += 1;
			}
			if (emhCursor == 1) {
				if (!game.levelOneWon) {
					return;
				}
				emhCursor = 0;
				game.gameStart = 5;
				game.bc = 	 new BlueCrab(1800, 1700, 60, 60, game);
				game.m.updateMaze();
				game.e.updateEnemies();
				game.e.createImage();
			}
			if (emhCursor == 2) {
				if (!game.levelTwoWon) {
					return;
				}
				emhCursor = 0;
				game.gameStart = 6;
				game.bc = 	 new BlueCrab(600, 2000, 60, 60, game);
				game.m.updateMaze();
				game.e.updateEnemies();
				game.e.createImage();
				return;
			}
		}
	}
	
	public void paint(Graphics2D g) {
//		System.out.print(emhCursor + "\n");
//		System.out.print(emhCount + "\n");
//		System.out.print(count + "\n");
		if (game.w.cursor == 2) {
			g.drawImage(emhMenu, xPos, yPos, 150, 255, null);
			if (emhCursor == 0) {
				g.drawImage(emhCursorImg, xPos + 10, yPos + 60, 124, 35, null);
			}
			if (emhCursor == 1) {
				g.drawImage(emhCursorImg, xPos + 10, yPos + 110, 124, 35, null);
			}
			if (emhCursor == 2) {
				g.drawImage(emhCursorImg, xPos + 10, yPos + 160, 124, 35, null);
			}
			g.setFont(f1);
			g.drawString("Easy", xPos + 20, yPos + 87);
			g.drawImage(medium, xPos + 20, yPos + 115, 70, 25, null);
			g.drawString("Hard", xPos + 20, yPos + 190);
			if (!game.levelOneWon) {
				g.drawImage(lock, xPos + 100, yPos + 115, 20, 25, null);
			}
			if (!game.levelTwoWon) {
				g.drawImage(lock, xPos + 100, yPos + 165, 20, 25, null);
			}
		}
	}
	
	
}
