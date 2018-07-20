package game1model;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tutorial {
		Game game;
		int bcXPos = 580;
		int bcYPos = 140;
		BlueCrab bc;
		TutPred p1;
		Wall w1 = new Wall(0, 100, 1200, 10, game);
		Wall w2 = new Wall(0, 400, 1200, 10, game);
		BufferedImage tut_rect;
		BufferedImage kb;
		BufferedImage rightHL;
		BufferedImage leftHL;
		BufferedImage upHL;
		BufferedImage downHL;
		BufferedImage img;
		BufferedImage target;
		BufferedImage targetText;
		BufferedImage rightBox;
		BufferedImage leftBox;
		BufferedImage dirChoice;
		Font f;
		Font f2;
		Font f3;
		TutBar sb;
		TutBox tb;
		Menu m;
		int goodJob;
		int tryAgain;
		int passed;
		boolean rightWay;
		boolean chooseDir = false;
		int rightWayInt = 0;
		
		/**
		 * Creates an instance of a Tutorial 
		 * 
		 * @param game The game the tutorial belongs to
		 */
		public Tutorial(Game game) {
			this.game = game;
			bc = new BlueCrab(bcXPos, bcYPos, 40, 40, game);
			p1 = new TutPred(-80, 170);
			sb = new TutBar(game);
			m = new Menu(game);
			tb = new TutBox(200, 300);
			bc.xVel = 2;
			sb.xPos = 950;
			sb.yPos = 500;
			m.xPos = 680;
			m.yPos = 90;
			getImages();
		}
		
		public class TutPred {
			int yPos;
			int xPos;
			int xVel = 3;
			int width;
			int height;
			int predCount = 0;
			
			/**
			 * Creates an instance of a predator used exclusively in the tutorial
			 * 
			 * @param xPos The x position of the tutorial predator
			 * @param yPos The y position of the tutorial predator
			 */
			public TutPred(int xPos, int yPos) {
				this.xPos = xPos;
				this.yPos = yPos;
				this.height = 60;
				this.width = 80;
//				getImage();
			}
			
			

			/**
			 * Paints the tutorial predator
			 * 
			 * @param g
			 */
			public void paint(Graphics2D g) {
				g.drawImage(img, xPos, yPos, width, height, null);
			}
			
			public int hitPred(BlueCrab bc) {
				int xLow = bc.getXPos();  
				int xHigh = bc.getXPos() + bc.getWidth();
				int yTop = bc.getYPos();
				int yBot = bc.getYPos() + bc.getHeight();
				if ((xLow >= xPos && xLow <= (xPos + width)) || (xHigh >= xPos && xHigh <= (xPos + width))) {
					if (yBot >= yPos + 10 && yBot <= (yPos + (height/2))) {
						bc.setXPos(700);
						bc.setYPos(200);
						xPos = -80;
						yPos = 210;
						tryAgain = game.getTutTime();
						return 1;
					}
					else if (yTop <= yPos + (height) - 10 &&  yTop >= (yPos + (height/2))) {
						bc.setXPos(700);
						bc.setYPos(200);
						xPos = -80;
						yPos = 210;
						tryAgain = game.getTutTime();
						return 2;
					}
					else if ((yBot >= yPos && yBot <= (yPos + height) || yTop >= yPos &&  yTop <= (yPos + height))) {
						bc.setXPos(700);
						bc.setYPos(200);
						xPos = -80;
						yPos = 210;
						tryAgain = game.getTutTime();
						return 3;
					}
				}
				return 0;
			}
			
			public boolean predPassed() {
				if (xPos >= 1280) {
					if (predCount < 1) {
						predCount += 1;
					passed = game.getTutTime();
					}
					return true;
				}
				return false;
			}
			/**
			 * Moves the tutorial predator
			 */
			public void move() {
				hitPred(bc);
				xPos += xVel;
			}
		} // end TutPred class
		
		public class TutBar extends SalinityBar {
			
			
			/**
			 * Creates an instance of a salinity bar used exclusively in the tutorial
			 * 
			 * @param game
			 */
			public TutBar(Game game) {
				super(game);
			}
			
			/* (non-Javadoc)
			 * @see SalinityBar#setLevel()
			 */
			@Override
			public void setLevel() {
				int x;
				x = (1200 - bc.getXPos()) / 15;
				level = x;
			}
		} // end tutbar class
		
		public class TutBox {
			int xPos;
			int yPos;
			int width;
			int height;
			int count = 0;
			
			public TutBox(int xPos, int yPos) {
				this.xPos = xPos;
				this.yPos = yPos;
				this.width = 80;
				this.height = 80;
			}
			
			public boolean boxHit(BlueCrab bc) {
				if (bc.getXPos() >= xPos - 5 && bc.getXPos() + bc.getWidth() <= xPos + width + 5) {
					if (bc.getYPos() + bc.getHeight() <= yPos + height + 5 && bc.getYPos() >= yPos - 5) {
						count += 1;
						if (count == 2) {
							goodJob = game.getTutTime();
						}
						return true;
					}
				}
				return false;
			}
			
			public void paint(Graphics2D g) {
				if (count == 2) {
					return;
				}
				if (!boxHit(bc)) {
					g.drawImage(target, xPos, yPos, width, height, null);
				} else {
					xPos = 700;
					yPos = 150;
				}
			}
			
			
		}
		
		
		/**
		 * Paints the entire tutorial. Many different things are painted based on time intervals
		 * 
		 * @param g Graphics2D object
		 */
		public void paint(Graphics2D g) {
			f = game.f70;
			f2 = game.f30;
			f3 = game.f40;
			g.setColor(Color.WHITE);
			g.setFont(f);
			g.drawString("TUTORIAL", 440, 70);
			g.setFont(f2);
			if (game.getTutTime() % 2 == 0) { 
				g.drawString("(press space to skip)", 400, 650);
			}
			if (!checkCrabGone()) {
				w1.paint(g);
				w2.paint(g);
				g.drawImage(tut_rect, 0, 110, 1200, 290, null);
			}
			tb.paint(g);
			

			g.setColor(Color.WHITE);
			if (tb.count <= 1) {
				g.setFont(f3);
				g.drawImage(kb, 800, 420, 360, 200, null);
				keyHighlights(g);
				g.drawString("Press Arrow Keys to Move", 100, 550);
				g.setColor(Color.CYAN);
				g.drawImage(targetText, 190, 230, 800, 52, null);
			}
			if (tb.count >= 2) {
				if (game.getTutTime() >= goodJob && game.getTutTime() < goodJob + 2) {
					g.setColor(Color.WHITE);
					g.setFont(f3);
					g.drawString("Good Job!", 300, 200);
				}
			}
			if (tb.count >= 2) { 
				if (!p1.predPassed()) {
					g.setFont(f3);
					if (game.getTutTime() >= tryAgain && game.getTutTime() < tryAgain + 2) {
						g.setColor(Color.RED);
						g.drawString("Try Again", 300, 200);
					}
					g.setColor(Color.WHITE);
					g.drawString("Avoid Predators", 100, 550);
					g.drawString("Striped Bass", 753, 460);
					g.drawImage(img, 810, 470, 160, 120, null);
					p1.paint(g);
				}
			}
			if (!checkCrabGone()) {
			if (p1.predPassed()) {
				if (game.getTutTime() >= passed && game.getTutTime() < passed + 2) {
					g.drawString("Well Done!", 300, 200);
				}
				chooseDir = true;
				sb.setLevel();
				sb.paint(g);
				g.drawImage(leftBox, 0, 110, 100, 290, null);
				g.drawImage(rightBox, 1100, 110, 100, 290, null);
				g.setFont(f3);
				g.drawImage(dirChoice, 190, 230, 800, 52, null);

				if (checkDir() > 0) {
					if (checkDir() == 2) {
						g.setColor(Color.RED);
						g.drawString("Wrong Way", 500, 200);
					}
					if (checkDir() == 1) {
						g.setColor(Color.WHITE);
						g.drawString("Nice!", 300, 200);
					}
				}
				g.setColor(Color.WHITE);
				if (game.getTutTime() >= passed && game.getTutTime() < passed + 5) {
					g.drawString("Use the Salinity Bar to Navigate", 80, 490);
					g.drawString("Towards the Estuary", 80, 540);
				}
				if (game.getTutTime() >= passed + 5) {
					g.drawString("Hint:", 80, 470);
					g.drawString("- Oceans contain saltwater", 80, 520);
					g.drawString("- Estuaries contain saltwater", 80, 570);
					g.drawString("   and freshwater", 80, 620);
					System.out.print(rightWayInt);
				}
			}}
			if (checkCrabGone()) {
			if (game.getTutTime() >= rightWayInt && game.getTutTime() < rightWayInt + 6) {
				g.setFont(f3);
				g.setColor(Color.WHITE);
				g.drawString("At Random Times Droughts", 180, 270);
				g.drawString("Occur Which Make Salinity", 180, 320);
				g.drawString("Levels Undetectable", 180, 370);
				g.setColor(Color.RED);
				g.fillRect(930, 310, 40, 120);
				g.drawString("DROUGHT", 880, 290);
			}
			if (game.getTutTime() >= rightWayInt + 6 && game.getTutTime() < rightWayInt + 12) {
				g.setFont(f3);
				g.setColor(Color.WHITE);
				g.drawString("Press 'P' to Pause", 180, 320);
				m.paused = true;
				if (game.getTutTime() >= rightWayInt + 6 && game.getTutTime() < rightWayInt + 8) {
					m.cursor = 0;
					m.paint(g);
				}
				if (game.getTutTime() >= rightWayInt + 8 && game.getTutTime() < rightWayInt + 10) {
					m.cursor = 1;
					m.paint(g);
				}
				if (game.getTutTime() >= rightWayInt + 10 && game.getTutTime() < rightWayInt + 12) {
					m.cursor = 2;
					m.paint(g);
				}
			}
			}
			bc.paint(g);
		}
		
		public int checkDir() {
			if (bc.getXPos() <= 90) {
				rightWay = true;
				return 1;
			}
			if (bc.getXPos() >= 1040) {
				return 2;
			}
			return 0;
		}
		
		/**
		 * Gets the images needed for the tutorial 
		 */
		public void getImages() {
			try {
			    tut_rect = ImageIO.read(new File("src/images/tut_rect.png"));
			    kb = ImageIO.read(new File("src/images/keyboard.png"));
			    rightHL = ImageIO.read(new File("src/images/right_hl.png"));
			    leftHL = ImageIO.read(new File("src/images/left_hl.png"));
			    upHL = ImageIO.read(new File("src/images/up_hl.png"));
			    downHL = ImageIO.read(new File("src/images/down_hl.png"));
			    img = ImageIO.read(new File("src/images/stripedbassRight.png"));
			    target = ImageIO.read(new File("src/images/target.png"));
			    targetText = ImageIO.read(new File("src/images/targetsText.png"));
			    rightBox = ImageIO.read(new File("src/images/rightDir.png"));
			    leftBox = ImageIO.read(new File("src/images/leftDir.png"));
			    dirChoice = ImageIO.read(new File("src/images/dirChoice.png"));
			} catch (IOException e) {
				System.out.println("bad");
			}
		}
		
		
		/**
		 * Figures out which key should be highlighted based on the crabs velocity
		 * 
		 * @param g Graphics2D object
		 */
		public void keyHighlights(Graphics2D g) {
			if (bc.xVel > 0 ) {
				g.drawImage(rightHL, 800, 420, 360, 200, null);
			} 
			if (bc.xVel < 0) {
				g.drawImage(leftHL, 800, 420, 360, 200, null);
			}
			if (bc.yVel > 0) {
				g.drawImage(downHL, 800, 420, 360, 200, null);
			}
			if (bc.yVel < 0) {
				g.drawImage(upHL, 800, 420, 360, 200, null);
			}
		}
		
		/**
		 * Moves the objects that need to move in the tutorial 
		 */
		public void move() {
//			crabScript();

			if (chooseDir == true) {
				if (checkDir() == 1) {
					bc.setxVel(-2);
				}
			}
			if (bc.getYPos() == 340) {
				if (bc.getyVel() < 0) {
					bc.setXPos(bc.getXPos() + bc.getxVel()); 
					bc.setYPos(bc.getYPos() + bc.getyVel()); 
				}
				else {
					bc.setXPos(bc.getXPos() + bc.getxVel()); 
				}
			}
			else if (bc.getYPos() == 110) {
				if (bc.getyVel() > 0) {
					bc.setXPos(bc.getXPos() + bc.getxVel()); 
					bc.setYPos(bc.getYPos() + bc.getyVel()); 
				}
				else {
					bc.setXPos(bc.getXPos() + bc.getxVel()); 
				}
			}
			else {
				bc.setXPos(bc.getXPos() + bc.getxVel()); 
				bc.setYPos(bc.getYPos() + bc.getyVel()); 
			}

			if (tb.count >= 2) {
			if (game.getTutTime() >= goodJob + 3) {
				p1.move();
			}
			}

		}
		
		public boolean checkCrabGone() {
			if (bc.getXPos() <= -100) {
				if (rightWay) {
					if (rightWayInt == 0) {
					rightWayInt = game.getTutTime();
					}
				}
				return true;
			}
			return false;
		}
		
		/**
		 * The script for the tutorial's crab. Actions are based on time intervals.
		 */
		public void crabScript() {
			if (game.getTutTime() <= 1) {
				bc.setxVel(2);
			}
			if (game.getTutTime() > 1 && game.getTutTime() <= 3) {
				bc.setxVel(-2);
			}
			if (game.getTutTime() > 3 && game.getTutTime() <= 4) {
				bc.setxVel(2);
			}
			if (game.getTutTime() > 4 && game.getTutTime() <= 5) {
				bc.setxVel(0);
				bc.setyVel(2);
			}
			if (game.getTutTime() > 5 && game.getTutTime() <= 6) {
				bc.setyVel(-2);
			}
			if (game.getTutTime() > 6 && game.getTutTime() <= 7) {
				bc.setyVel(2);
			}
			if (game.getTutTime() > 7 && game.getTutTime() <= 9) {
				bc.setyVel(0);
			}
			if (game.getTutTime() > 9 && game.getTutTime() <= 10) {
				bc.setyVel(-2);
			}
			if (game.getTutTime() > 10 && game.getTutTime() <= 11) {
				bc.setyVel(0);
			}
			if (game.getTutTime() > 13 && game.getTutTime() <= 15) {
				bc.setxVel(-2);
			}
			if (game.getTutTime() > 15 && game.getTutTime() <= 18) {
				bc.setxVel(2);
			}
			if (game.getTutTime() > 18 && game.getTutTime() <= 25) {
				bc.setxVel(-2);
			}
		}
		
}
