package game1model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Waves {
	BufferedImage titleBack;
	BufferedImage backGloss;
	ArrayList<Wave> waves = new ArrayList<Wave>();
	Game game;
	Font f;
	Font f2;
	BufferedImage titleImage;
	BufferedImage texas;
	BufferedImage florida;
	BufferedImage delaware;
	BufferedImage tx_hl;
	BufferedImage fl_hl;
	BufferedImage de_hl;
	BufferedImage medals;
	BufferedImage medalsSelect;
	int cursor = 0;
	boolean medalsSelected;

	
	/**
	 * Initializes a Waves object
	 * 
	 * @param game The game object this object belongs to
	 */
	public Waves(Game game) {

		getImages();
		createWaves();
		this.game = game;

	}
	
	public class Wave {
		BufferedImage wave;
		int xPos;
		int yPos;
		int xVel;
		int dir;

		
		/**
		 *  Initializes a Wave object
		 * 
		 * @param xPos The x position of the wave
		 * @param yPos The y position of the wave
		 * @param dir The direction of the wave
		 */
		public Wave(int xPos, int yPos, int dir) {
			this.xPos = xPos;
			this.yPos = yPos;
			this.dir = dir;
			this.xVel = 1;
			getImage();
		}
		
		
		/**
		 * Gets the images necessary for the Wave class
		 */
		public void getImage() {
			BufferedImage image = null;
			try {
			    image = ImageIO.read(new File("src/images/wave8bit2.png"));
			    
			} catch (IOException e) {
				System.out.println("bad");
			}
			wave = image;
		}
		
		
		/**
		 * Moves the wave object according to the direction it holds. Waves that reach 
		 * the end of the screen get reset.
		 * 
		 * 
		 */
		public void move() {
			if (dir == 1) {
				xPos += xVel;
				if (xPos >= 1300) {
					xPos = -100;
				}
			}
			if (dir == 2) {
				xPos -= xVel;
				if (xPos <= -100) {
					xPos = 1300;
				}
			}
		}
		/**
		 * Paints the wave object at the location it holds.
		 * 
		 * @param g Graphics2D object
		 */
		public void paint(Graphics2D g) {
			g.drawImage(wave, xPos, yPos, 100, 50, null);
		}
	}

	
	/**
	 * Creates an array list of waves. Each is given a
	 * location that allows for proper spacing.
	 */
	public void createWaves() {		
		int x = -200;
		int y = 30;
		int d = 1;
		for (int i = 0; i < 56; i++) {
			x += 200;
			if (x == 1400) {
				x = 0;
				y += 90;
				if (d == 1) {
					d = 2;
				} else {
					d = 1;
				}
			}
			waves.add(new Wave(x, y, d));
		}
	}
	
	/**
	 * Obtains all the images used in the Waves class from a file path.
	 */
	public void getImages() {
		BufferedImage image = null;
		BufferedImage image2 = null;
		BufferedImage image3 = null;
		BufferedImage image4 = null;
		BufferedImage image5 = null;
		BufferedImage image6 = null;
		BufferedImage image7 = null;
		BufferedImage image8 = null;
		BufferedImage image9 = null;
		try {
		    image = ImageIO.read(new File("src/images/crab_run8bit.png"));
		    image2 = ImageIO.read(new File("src/images/titleBack.png"));
		    image3 = ImageIO.read(new File("src/images/backGloss.png"));
		    image4 = ImageIO.read(new File("src/images/tx_8bit.png"));
		    image5 = ImageIO.read(new File("src/images/fl_8bit.png"));
		    image6 = ImageIO.read(new File("src/images/de_8bit.png"));
		    image7 = ImageIO.read(new File("src/images/tx_highlight.png"));
		    image8 = ImageIO.read(new File("src/images/fl_highlight.png"));
		    image9 = ImageIO.read(new File("src/images/de_highlight.png"));
		    medals = ImageIO.read(new File("src/images/medalsButton.png"));
		    medalsSelect = ImageIO.read(new File("src/images/medalsButtonSelect.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
		titleImage = image;
		titleBack = image2;
		backGloss = image3;
		texas = image4;
		florida = image5;
		delaware = image6;
		tx_hl = image7;
		fl_hl = image8;
		de_hl = image9;
	}
	
	/**
	 * Paints everything that belongs to the Wave class. 
	 * 
	 * @param g Graphics2D object
	 */
	public void paint(Graphics2D g) {
		 f = game.f70;
		 f2 = game.f30;
		g.drawImage(titleBack, 0, 0, 1200, 700, null);
		for (int i = 0; i < waves.size(); i++) {
			waves.get(i).paint(g);
		}
		g.drawImage(backGloss, 0, 0, 1200, 700, null);
		g.setFont(f);
		g.setColor(Color.BLUE);
		if (game.gameStart == 0) { // title screen
			if (game.getTitleTime() % 2 == 0) {
				g.setColor(Color.WHITE);
				g.drawString("Press Space", 500, 550);
			}
			g.drawImage(titleImage, 0, 0, 1200, 700, null);
			g.setFont(f2);
			g.setColor(Color.RED);
			g.drawString("Press 'esc' at Any Time to Exit", 320, 650);
		}
		if (game.gameStart == 1 || game.gameStart == 2) { // state selction screen
			g.setColor(Color.WHITE);
			g.setFont(f);
			g.drawImage(texas, 100, 200, 300, 300, null);
			g.drawImage(florida, 450, 200, 300, 300, null);
			g.drawImage(delaware, 900, 200, 150, 300, null);
			g.drawImage(medals, 440, 500, 300, 100, null);
			if (cursor == 0) {
				g.drawString("TEXAS", 490, 70);
				g.setFont(f2);
				g.drawString("(coming soon)", 477, 100);
				g.drawImage(tx_hl, 85, 180, 340, 340, null);
			} else if (cursor == 1) {
				g.drawString("FLORIDA", 440, 70);
				g.setFont(f2);
				g.drawString("(coming soon)", 465, 100);
				g.drawImage(fl_hl, 440, 180, 325, 335, null);
			} else if (cursor == 2) {
				g.drawString("DELAWARE", 430, 70);
				g.drawImage(de_hl, 700, 175, 390, 360, null);
			} else if (cursor == -1) {
				g.drawString("View Medals", 360, 70);
				g.drawImage(medalsSelect, 440, 500, 300, 100, null);
			}
			g.setColor(Color.WHITE);
			g.setFont(f2);
			g.drawString("(press space to select)", 400, 650);
		}
		if (game.gameStart == 3) { // tutorial screen
			game.t.paint(g);
		}
		if (game.gameStart == -1) {
			if (!game.viewLeaders) {
				g.setColor(Color.WHITE);
	
				g.drawString("Medals Won", 360, 70);
				Font f = game.f30;
				g.setFont(f);
				g.drawImage(game.w.delaware, 100, 100, 30, 70, null);
				g.drawString(": Easy", 140, 150);
				
				g.drawImage(game.w.delaware, 100, 300, 30, 70, null);
				g.drawString(": Medium", 140, 350);
				
				g.drawImage(game.w.delaware, 100, 500, 30, 70, null);
				g.drawString(": Hard", 140, 550);
				
				if (game.pgs.goldTimeE) {
					g.drawImage(game.pgs.gold, 400, 80, 113, 170, null);
				}
				else if (game.pgs.silverTimeE) {
					g.drawImage(game.pgs.silver, 400, 80, 113, 170, null);
				}
				else if (game.pgs.bronzeTimeE) {
					g.drawImage(game.pgs.bronze, 400, 80, 113, 170, null);
				}
				if (game.pgs.goldLiveE) {
					g.drawImage(game.pgs.goldLife, 800, 80, 113, 170, null);
				}
				else if (game.pgs.silverLiveE) {
					g.drawImage(game.pgs.silverLife, 800, 80, 113, 170, null);
				}
				else if (game.pgs.bronzeLiveE) {
					g.drawImage(game.pgs.bronzeLife, 800, 80, 113, 170, null);
				}
				if (game.pgs.goldTimeM) {
					g.drawImage(game.pgs.gold, 400, 280, 113, 170, null);
				}
				else if (game.pgs.silverTimeM) {
					g.drawImage(game.pgs.silver, 400, 280, 113, 170, null);
				}
				else if (game.pgs.bronzeTimeM) {
					g.drawImage(game.pgs.bronze, 400, 280, 113, 170, null);
				}
				if (game.pgs.goldLiveM) {
					g.drawImage(game.pgs.goldLife, 800, 280, 113, 170, null);
				}
				else if (game.pgs.silverLiveM) {
					g.drawImage(game.pgs.silverLife, 800, 280, 113, 170, null);
				}
				else if (game.pgs.bronzeLiveM) {
					g.drawImage(game.pgs.bronzeLife, 800, 280, 113, 170, null);
				}
				if (game.pgs.goldTimeH) {
					g.drawImage(game.pgs.gold, 400, 480, 113, 170, null);
				}
				else if (game.pgs.silverTimeH) {
					g.drawImage(game.pgs.silver, 400, 480, 113, 170, null);
				}
				else if (game.pgs.bronzeTimeH) {
					g.drawImage(game.pgs.bronze, 400, 480, 113, 170, null);
				}
				if (game.pgs.goldLiveH) {
					g.drawImage(game.pgs.goldLife, 800, 480, 113, 170, null);
				}
				else if (game.pgs.silverLiveH) {
					g.drawImage(game.pgs.silverLife, 800, 480, 113, 170, null);
				}
				else if (game.pgs.bronzeLiveH) {
					g.drawImage(game.pgs.bronzeLife, 800, 480, 113, 170, null);
				}
				g.setColor(Color.WHITE);
				g.setFont(f2);
				g.drawString("(press space to return)", 400, 650);
				g.drawString("Hold 'L' to View", 900, 400);
				g.drawString("Leaderboards", 935, 425);
			} else {
				g.setColor(Color.WHITE);
				
				g.drawString("Leaderboards", 360, 70);
				Font f = game.f30;
				g.setFont(f);
				g.drawImage(game.w.delaware, 200, 100, 30, 70, null);
				g.drawString(": Easy", 240, 150);
				
				g.drawImage(game.w.delaware, 500, 100, 30, 70, null);
				g.drawString(": Medium", 540, 150);
				
				g.drawImage(game.w.delaware, 800, 100, 30, 70, null);
				g.drawString(": Hard", 840, 150);
				
				g.drawImage(game.pgs.leaderboard, 500, 200, 200, 300, null);
				int n = 270;
				g.setColor(Color.WHITE);
				for (int i = 0; i < game.scb.scoresM.size(); i++) {
					Font f2  = game.f30;
					g.setFont(f2);
					n += 40;
					g.drawString(game.scb.scoresM.get(i).toString(), 510,  0 + n);
				}
				g.drawImage(game.pgs.leaderboard, 200, 200, 200, 300, null);
				int m = 270;
				g.setColor(Color.WHITE);
				for (int i = 0; i < game.scb.scores.size(); i++) {
					Font f2  = game.f30;
					g.setFont(f2);
					m += 40;
					g.drawString(game.scb.scores.get(i).toString(),  210, 0 + m);
				}
				g.drawImage(game.pgs.leaderboard, 800, 200, 200, 300, null);
				int j = 270;
				g.setColor(Color.WHITE);
				for (int i = 0; i < game.scb.scoresH.size(); i++) {
					Font f2  = game.f30;
					g.setFont(f2);
					j += 40;
					g.drawString(game.scb.scoresH.get(i).toString(),  810, 0 + j);
				}
			}
		}
	}
	
	
	/**
	 * Moves each wave in the array list by calling each wave's 
	 * move method. Also calls the tutorial's move method if the 
	 * game state is 2. 
	 */
	public void move() {
		if (game.gameStart == 3) {
			game.t.move();
		}
		for (int i = 0; i < waves.size(); i++) {
			waves.get(i).move();
		}
	}


	/**
	 * Moves the cursor for the state selection screen
	 * when certain keys are pressed.
	 * 
	 * 
	 * @param e KeyEvent object
	 */
	public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (cursor == -1) {
					cursor = 0;
					return;
				}
				cursor -= 1;
				if (cursor == -1) {
					cursor = 0;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (cursor == -1) {
					cursor = 2;
					return;
				}
				cursor += 1;
				if (cursor == 3) {
					cursor = 2;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (game.gameStart == 1) {
					cursor = -1;
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (game.gameStart == 1) {
					cursor = 1;
				}
			}
	}
}
