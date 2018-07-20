package game1model;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Maze {
	ArrayList<Wall> walls = new ArrayList<Wall>();
	Game game;
	BufferedImage estuaryText = null;
	BufferedImage oceanText = null;
	int check = 0;
	
	/**
	 * Creates an instance of a Maze. A maze holds all the walls for the current level.
	 * 
	 * @param game
	 */
	public Maze(Game game) {
		this.game = game;
//		firstMaze();
		getImages();
	}
	
	/**
	 * Creates the list of walls for the first level.
	 */
	public void firstMaze() {
		walls = new ArrayList<Wall>();
		// black
		walls.add(new Wall(1500, 1500, 10, 400, game));
		walls.add(new Wall(2100, 1500, 10, 400, game));
		walls.add(new Wall(1500, 1500,  600, 10, game));
		walls.add(new Wall(800, 1900, 710, 10, game)); // overlap black/green
		walls.add(new Wall(2100, 1900, 1310, 10, game));
		// green
		walls.add(new Wall(800, 1633, 10, 267, game));
		walls.add(new Wall(600, 1633, 200, 11, game));
		walls.add(new Wall(600, 1400, 10, 233, game));
		walls.add(new Wall(400, 1300, 10, 343, game)); // overlap green/yellow
		walls.add(new Wall(100, 1633, 300, 11, game));
		walls.add(new Wall(100, 1400, 10, 233, game));
		walls.add(new Wall(0, 1400, 100, 10, game));
		walls.add(new Wall(100, 1866, 300, 10, game));
		walls.add(new Wall(100, 1866, 10, 233, game));
		// yellow
		walls.add(new Wall(600, 1400, 600, 10, game));
		walls.add(new Wall(1190, 1100, 10, 300, game));
		walls.add(new Wall(100, 1300, 300, 10, game));
		walls.add(new Wall(100, 800, 10, 500, game));
		walls.add(new Wall(100, 800, 400, 10, game));
		walls.add(new Wall(500, 700, 10, 110, game));
		walls.add(new Wall(800, 700, 10, 300, game));
		walls.add(new Wall(450, 1000, 360, 10, game));
		walls.add(new Wall(450, 1000, 10, 100, game));
		walls.add(new Wall(450, 1100, 500, 10, game));
		walls.add(new Wall(950, 900, 10, 210, game));
		walls.add(new Wall(950, 900, 1250, 10, game)); // overlap yellow/orange
		// orange
		walls.add(new Wall(2200, 900, 10, 200, game));
		walls.add(new Wall(1900, 1100, 310, 10, game));
		walls.add(new Wall(1900, 1100, 10, 100, game));
		walls.add(new Wall(1900, 1200, 250, 10, game));
		walls.add(new Wall(2150, 1200, 10, 200, game));
		walls.add(new Wall(1350, 1390, 800, 10, game));
		walls.add(new Wall(1350, 1200, 10, 200, game));
		walls.add(new Wall(1350, 1200, 310, 10, game));
		walls.add(new Wall(1650, 1100, 10, 100, game));
		walls.add(new Wall(1200, 1100, 450, 10, game));
		// blue
		walls.add(new Wall(500, 500, 10, 200, game));
		walls.add(new Wall(800, 500, 10, 200, game));
		walls.add(new Wall(800, 500, 400, 10, game));
		walls.add(new Wall(300, 500, 200, 10, game));
		walls.add(new Wall(300, 200, 10, 300, game));
		walls.add(new Wall(300, 200, 1400, 10, game)); // overlap blue/cyan
		// cyan
		walls.add(new Wall(1900, 200, 1600, 10, game)); // overlap cyan/magenta
		walls.add(new Wall(1200, 500, 10, 200, game));
		walls.add(new Wall(1200, 700, 400, 10, game));
		walls.add(new Wall(1600, 500, 10, 210, game));
		walls.add(new Wall(1400, 500, 200, 10, game));
		walls.add(new Wall(1400, 300, 10, 200, game));
		walls.add(new Wall(1400, 300, 1600, 10, game)); // overlap cyan/magenta
		walls.add(new Wall(1700, 700, 700, 10, game));
		walls.add(new Wall(1700, 400, 10, 300, game));
		walls.add(new Wall(1700, 400, 300, 10, game));
		walls.add(new Wall(2000, 400, 10, 100, game));
		walls.add(new Wall(2000, 500, 600, 10, game)); // overlap cyan/magenta
		// magenta
		walls.add(new Wall(2600, 500, 10, 400, game)); // overlap magenta/pink
		walls.add(new Wall(3000, 300, 10, 400, game));
		walls.add(new Wall(3000, 700, 100, 10, game));
		walls.add(new Wall(3500, 200, 10, 500, game));
		walls.add(new Wall(3500, 700, 100, 10, game));
		// pink 
		walls.add(new Wall(3400, 800, 10, 110, game));
		walls.add(new Wall(3300, 900, 100, 10, game));
		walls.add(new Wall(3300, 800, 10, 100, game));
		walls.add(new Wall(3300, 800, 100, 10, game));
		walls.add(new Wall(3300, 1000, 100, 10, game));
		walls.add(new Wall(3300, 1000, 10, 400, game));
		walls.add(new Wall(3400, 1000, 10, 400, game));
		walls.add(new Wall(3100, 700, 10, 700, game));
		walls.add(new Wall(2900, 1400, 210, 10, game));
		walls.add(new Wall(2600, 1100, 10, 300, game));
		walls.add(new Wall(2600, 900, 300, 10, game));
		walls.add(new Wall(2400, 1100, 200, 10, game));
		walls.add(new Wall(2900, 900, 10, 500, game));
		walls.add(new Wall(2400, 700, 10, 400, game));
		// white
		walls.add(new Wall(2500, 1400, 110, 10, game));
		walls.add(new Wall(3300, 1400, 110, 10, game));
		walls.add(new Wall(2500, 1400, 10, 400, game));
		walls.add(new Wall(2500, 1800, 200, 10, game));
		walls.add(new Wall(2700, 1700, 10, 110, game));
		walls.add(new Wall(2700, 1700, 700, 10, game));
		walls.add(new Wall(3400, 1700, 10, 200, game));
	}
	
	/**
	 * Creates the list of walls for the second level
	 */
	public void secondMaze() {
		walls = new ArrayList<Wall>();
		walls.add(new Wall(1500, 1500, 10, 400, game));
		walls.add(new Wall(2100, 1500, 10, 400, game));
		walls.add(new Wall(800, 1500, 700, 10, game));
		walls.add(new Wall(2100, 1500, 700, 10, game));
		walls.add(new Wall(1000, 1300, 1600, 10, game));
		walls.add(new Wall(1000, 1200, 10, 100, game));
		walls.add(new Wall(2600, 1200, 10, 110, game));
		walls.add(new Wall(1000, 1200, 700, 10, game));
		walls.add(new Wall(1900, 1200, 700, 10, game));
		walls.add(new Wall(800, 1000, 10, 500, game));
		walls.add(new Wall(2800, 1000, 10, 510, game));
		walls.add(new Wall(800, 1000, 700, 10, game));
		walls.add(new Wall(2100, 1000, 700, 10, game));
		walls.add(new Wall(1700, 500, 10, 710, game));
		walls.add(new Wall(1900, 800, 10, 400, game));
		walls.add(new Wall(1500, 980, 10, 30, game));
		walls.add(new Wall(2100, 980, 10, 20, game));
		walls.add(new Wall(2100, 980, 710, 10, game));
		walls.add(new Wall(800, 980, 700, 10, game));
		walls.add(new Wall(800, 400, 10, 580, game));
		walls.add(new Wall(2800, 300, 10, 680, game));
		walls.add(new Wall(1500, 500, 200, 10, game));
		walls.add(new Wall(1500, 500, 10, 310, game));
		walls.add(new Wall(1000, 800, 500, 10, game));
		walls.add(new Wall(1000, 490, 10, 310, game));
		walls.add(new Wall(1900, 800, 700, 10, game));
		walls.add(new Wall(2600, 490, 10, 320, game));
		walls.add(new Wall(1000, 490, 1600, 10, game));
		walls.add(new Wall(800, 400, 700, 10, game));
		walls.add(new Wall(1500, 60, 10, 350, game));
		walls.add(new Wall(1700, 300, 1100, 10, game));
		walls.add(new Wall(1700, 200, 10, 100, game));
		walls.add(new Wall(1700, 200, 1300, 10, game));
		walls.add(new Wall(1900, 60, 1600, 10, game));
		walls.add(new Wall(3500, 60, 10, 1940, game));
		walls.add(new Wall(100, 2000, 3400, 10, game));
		walls.add(new Wall(3000, 200, 10, 1700, game));
		walls.add(new Wall(2100, 1900, 900, 10, game));
		walls.add(new Wall(600, 1900, 900, 10, game));
		walls.add(new Wall(100, 70, 10, 1930, game));
		walls.add(new Wall(600, 200, 10, 1700, game));
		walls.add(new Wall(600, 200, 800, 10, game));
		walls.add(new Wall(100, 70, 1300, 10, game));
		walls.add(new Wall(1400, 70, 10, 130, game));
	}
	
	public void thirdMaze() {
		walls = new ArrayList<Wall>();
		walls.add(new Wall(200, 1850, 10, 250, game));
		walls.add(new Wall(200, 1850, 400, 10, game));
		walls.add(new Wall(600, 1600, 10, 260, game));
		walls.add(new Wall(0, 1600, 600, 10, game));
		walls.add(new Wall(800, 1850, 600, 10, game));
		walls.add(new Wall(800, 1600, 10, 260, game));
		walls.add(new Wall(800, 1600, 500, 10, game));
		walls.add(new Wall(1400, 1550, 10, 300, game));
		walls.add(new Wall(1600, 1850, 2000, 10, game));
		walls.add(new Wall(1600, 1700, 10, 150, game));
		walls.add(new Wall(1600, 1700, 800, 10, game));
		walls.add(new Wall(1400, 1550, 800, 10, game));
		walls.add(new Wall(2400, 1500, 10, 200, game));
		walls.add(new Wall(2200, 1300, 10, 250, game));
		walls.add(new Wall(2400, 1500, 1200, 10, game));
		walls.add(new Wall(2400, 1350, 800, 10, game));
		walls.add(new Wall(2400, 1300, 10, 50, game));
		walls.add(new Wall(2400, 1300, 600, 10, game));
		walls.add(new Wall(1300, 1300, 10, 300, game));
		walls.add(new Wall(1300, 1300, 900, 10, game));
		walls.add(new Wall(3000, 700, 10, 600, game));
		walls.add(new Wall(3200, 700, 10, 650, game));
		walls.add(new Wall(3000, 700, 200, 10, game));
		walls.add(new Wall(2000, 700, 600, 10, game));
		walls.add(new Wall(2000, 700, 10, 400, game));
		walls.add(new Wall(2000, 1100, 600, 10, game));
		walls.add(new Wall(2600, 700, 10, 400, game));
		walls.add(new Wall(2000, 300, 10, 100, game));
		walls.add(new Wall(2000, 400, 1000, 10, game));
		walls.add(new Wall(2000, 300, 1000, 10, game));
		walls.add(new Wall(3000, 300, 10, 100, game));
		walls.add(new Wall(0, 60, 3200, 10, game));
		walls.add(new Wall(600, 1000, 10, 400, game));
		walls.add(new Wall(400, 1400, 200, 10, game));
		walls.add(new Wall(600, 1000, 200, 10, game));
		walls.add(new Wall(800, 1000, 10, 400, game));
		walls.add(new Wall(800, 1400, 200, 10, game));
		walls.add(new Wall(1000, 1000, 10, 400, game));
		walls.add(new Wall(1000, 1000, 600, 10, game));
		walls.add(new Wall(1600, 300, 10, 700, game));
		walls.add(new Wall(1400, 300, 200, 10, game));
		walls.add(new Wall(1400, 300, 10, 600, game));
		walls.add(new Wall(400, 900, 1000, 10, game));
		walls.add(new Wall(400, 900, 10, 500, game));
		walls.add(new Wall(400, 300, 800, 10, game));
		walls.add(new Wall(400, 600, 800, 10, game));
		walls.add(new Wall(400, 300, 10, 300, game));
		walls.add(new Wall(1200, 300, 10, 300, game));
	}
	
	/**
	 * Calls each wall's paint method. Also draws the ocean and estuary text on the map.
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		
		if (game.gameStart >= 4) {
			for (int i = 0; i < walls.size(); i++) {
				walls.get(i).paint(g);
			}
		}
	}
	
	/**
	 * Updates the maze based on the current level of the game.
	 */
	public void updateMaze() {
		if (game.gameStart == 4) {
			firstMaze();
		}
		if (game.gameStart == 5) {
			secondMaze();
		}
		if (game.gameStart == 6) {
			thirdMaze();
		}
	}
	

//	public void moveMaze() {
//		if (game.gameStart == 4) {
//			if (game.bc.xPos >= 2200 && game.bc.xPos <= 2400) {
//				if (game.bc.yPos <= 1500) {
//					if (check == 1) {
//						
//						return;
//					}
//					walls.add(new Wall(2100, 1700, 10, 200, game));
//					System.out.print("good");
//					check += 1;
//				}
//			}
//		}
//	}
	
	/**
	 * Gets the Images needed for the ocean and estuary texts
	 */
	public void getImages() {
		try {
		    oceanText = ImageIO.read(new File("src/images/ocean_text.png"));
		    estuaryText = ImageIO.read(new File("src/images/estuary_text.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
}
