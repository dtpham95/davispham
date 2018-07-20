package game1model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PostGameScreen {
	int xPos = 0;
	int yPos = 0;
	BufferedImage img;
	BufferedImage bronze;
	BufferedImage silver;
	BufferedImage gold;
	BufferedImage bronzeLife;
	BufferedImage silverLife;
	BufferedImage goldLife;
	BufferedImage firework1;
	BufferedImage firework2;
	BufferedImage firework3;
	BufferedImage firework4;
	BufferedImage firework5;
	BufferedImage firework6;
	BufferedImage firework7;
	BufferedImage leaderboard;
	ArrayList<BufferedImage> ani = new ArrayList<BufferedImage>();
	int frameCount = 35;
	int picNum = 0;
	Game game;
	boolean goldTimeE = false;
	boolean silverTimeE = false;
	boolean bronzeTimeE = false;
	boolean goldLiveE = false;
	boolean silverLiveE = false;
	boolean bronzeLiveE = false;
	boolean goldTimeM = false;
	boolean silverTimeM = false;
	boolean bronzeTimeM = false;
	boolean goldLiveM = false;
	boolean silverLiveM = false;
	boolean bronzeLiveM = false;
	boolean goldTimeH = false;
	boolean silverTimeH = false;
	boolean bronzeTimeH = false;
	boolean goldLiveH = false;
	boolean silverLiveH = false;
	boolean bronzeLiveH = false;
	
	
	public PostGameScreen(Game game) {
		this.game = game;
		getImages();
	}
	
	public void getImages() {
		try {
		    img = ImageIO.read(new File("src/images/postGameScreen.png"));
		    bronze = ImageIO.read(new File("src/images/bronzeTime.png"));
		    silver = ImageIO.read(new File("src/images/silverTime.png"));
		    gold = ImageIO.read(new File("src/images/goldTime.png"));
		    bronzeLife = ImageIO.read(new File("src/images/bronzeLife.png"));
		    silverLife = ImageIO.read(new File("src/images/silverLife.png"));
		    goldLife = ImageIO.read(new File("src/images/goldLife.png"));
		    firework1 = ImageIO.read(new File("src/images/firework1.png"));
		    firework2 = ImageIO.read(new File("src/images/firework2.png"));
		    firework3 = ImageIO.read(new File("src/images/firework3.png"));
		    firework4= ImageIO.read(new File("src/images/firework4.png"));
		    firework5 = ImageIO.read(new File("src/images/firework5.png"));
		    firework6 = ImageIO.read(new File("src/images/firework6.png"));
		    firework7 = ImageIO.read(new File("src/images/firework7.png"));
		    leaderboard = ImageIO.read(new File("src/images/leaderboard.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
		
		for (int i = 0; i < 35; i++) {
			if (i < 5) {
				ani.add(firework1);
			}
			else if (i < 10) {
				ani.add(firework2);
			}
			else if (i < 15) {
				ani.add(firework3);
			}
			else if (i < 20) {
				ani.add(firework4);
			}
			else if (i < 25) {
				ani.add(firework5);
			}
			else if (i < 30) {
				ani.add(firework6);
			}
			else if (i < 35) {
				ani.add(firework7);
			}
		}
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(img, xPos, yPos, 1200, 680, null);
		g.drawImage(ani.get(picNum), xPos, yPos, 1200, 680, null);
		picNum = (picNum + 1) % frameCount;
		
		if (game.gameStart == 4) {
			g.setColor(Color.GRAY);
			Font f  = game.f20;
			g.setFont(f);
			g.drawString("Score", xPos + 658, yPos + 220);
			g.drawString("=", xPos + 680, yPos + 240);
			g.drawString("Time Remaining", xPos + 610, yPos + 260);
			g.drawString("+", xPos + 680, yPos + 280);
			g.drawString("(Lives Remaining * 5)", xPos + 560, yPos + 300);
			int s = game.time + (game.bc.getLife() * 5);
			g.drawString("Your Score = " + s, xPos + 590, yPos + 380);
			g.drawImage(leaderboard, xPos + 820, yPos + 120, 200, 300, null);
			int n = 190;
			g.setColor(Color.WHITE);
			for (int i = 0; i < game.scb.scores.size(); i++) {
				Font f2  = game.f30;
				g.setFont(f2);
				n += 40;
				g.drawString(game.scb.scores.get(i).toString(), xPos + 830, yPos + n);
			}
		}
		if (game.gameStart == 5) {
			g.setColor(Color.GRAY);
			Font f  = game.f20;
			g.setFont(f);
			g.drawString("Score", xPos + 658, yPos + 220);
			g.drawString("=", xPos + 680, yPos + 240);
			g.drawString("Time Remaining", xPos + 610, yPos + 260);
			g.drawString("+", xPos + 680, yPos + 280);
			g.drawString("(Lives Remaining * 5)", xPos + 560, yPos + 300);
			int s = game.time + (game.bc.getLife() * 5);
			g.drawString("Your Score = " + s, xPos + 590, yPos + 380);
			g.drawImage(leaderboard, xPos + 820, yPos + 120, 200, 300, null);
			int n = 190;
			g.setColor(Color.WHITE);
			for (int i = 0; i < game.scb.scoresM.size(); i++) {
				Font f2  = game.f30;
				g.setFont(f2);
				n += 40;
				g.drawString(game.scb.scoresM.get(i).toString(), xPos + 830, yPos + n);
			}
		}
		if (game.gameStart == 6) {
			g.setColor(Color.GRAY);
			Font f  = game.f20;
			g.setFont(f);
			g.drawString("Score", xPos + 658, yPos + 220);
			g.drawString("=", xPos + 680, yPos + 240);
			g.drawString("Time Remaining", xPos + 610, yPos + 260);
			g.drawString("+", xPos + 680, yPos + 280);
			g.drawString("(Lives Remaining * 5)", xPos + 560, yPos + 300);
			int s = game.time + (game.bc.getLife() * 5);
			g.drawString("Your Score = " + s, xPos + 590, yPos + 380);
			g.drawImage(leaderboard, xPos + 820, yPos + 120, 200, 300, null);
			int n = 190;
			g.setColor(Color.WHITE);
			for (int i = 0; i < game.scb.scoresH.size(); i++) {
				Font f2  = game.f30;
				g.setFont(f2);
				n += 40;
				g.drawString(game.scb.scoresH.get(i).toString(), xPos + 830, yPos + n);
			}
		}
		if (determineTimeMedal() > 0) {
			g.setColor(Color.WHITE);
			g.drawString("You Got a Time Medal!", xPos + 120, yPos + 170);
			if (determineTimeMedal() == 1) {
				g.drawImage(gold, xPos + 250, yPos + 180, 113, 170, null);
				g.drawString("Gold", xPos + 270, yPos + 340);
				g.drawString("Finished in Under 30 Seconds", xPos + 60, yPos + 370);
				if (game.gameStart == 4) {
					goldTimeE = true;
				}
				if (game.gameStart == 5) {
					goldTimeM = true;
				}
				if (game.gameStart == 6) {
					goldTimeH = true;
				}
			}
			if (determineTimeMedal() == 2) {
				g.drawImage(silver, xPos + 250, yPos + 180, 113, 170, null);
				g.drawString("Silver", xPos + 250, yPos + 340);
				g.drawString("Finished in Under 40 Seconds", xPos + 60, yPos + 370);
				if (game.gameStart == 4) {
					silverTimeE = true;
				}
				if (game.gameStart == 5) {
					silverTimeM = true;
				}
				if (game.gameStart == 6) {
					silverTimeH = true;
				}
			}
			if (determineTimeMedal() == 3) {
				g.drawImage(bronze, xPos + 250, yPos + 180, 113, 170, null);
				g.drawString("Bronze", xPos + 230, yPos + 340);
				g.drawString("Finished in Under 50 Seconds", xPos + 60, yPos + 370);
				if (game.gameStart == 4) {
					bronzeTimeE = true;
				}
				if (game.gameStart == 5) {
					bronzeTimeM = true;
				}
				if (game.gameStart == 6) {
					bronzeTimeH = true;
				}
			}
		}
		if (determineLifeMedal() > 0) {
			g.setColor(Color.WHITE);
			g.drawString("You Got a Life Medal!", xPos + 120, yPos + 430);
			if (determineLifeMedal() == 1) {
				g.drawImage(goldLife, xPos + 250, yPos + 440, 113, 170, null);
				g.drawString("Gold", xPos + 270, yPos + 600);
				g.drawString("Finished with 3 Lives Remaining", xPos + 60, yPos + 630);
				if (game.gameStart == 4) {
					goldLiveE = true;
				}
				if (game.gameStart == 5) {
					goldLiveM = true;
				}
				if (game.gameStart == 6) {
					goldLiveH = true;
				}
			}
			if (determineLifeMedal() == 2) {
				g.drawImage(silverLife, xPos + 250, yPos + 440, 113, 170, null);
				g.drawString("Silver", xPos + 250, yPos + 600);
				g.drawString("Finished with 2 Lives Remaining", xPos + 60, yPos + 630);
				if (game.gameStart == 4) {
					silverLiveE = true;
				}
				if (game.gameStart == 5) {
					silverLiveM = true;
				}
				if (game.gameStart == 6) {
					silverLiveH = true;
				}
			}
			if (determineLifeMedal() == 3) {
				g.drawImage(bronzeLife, xPos + 250, yPos + 440, 113, 170, null);
				g.drawString("Bronze", xPos + 230, yPos + 600);
				g.drawString("Finished with 1 Life Remaining", xPos + 60, yPos + 630);
				if (game.gameStart == 4) {
					bronzeLiveE = true;
				}
				if (game.gameStart == 5) {
					bronzeLiveM = true;
				}
				if (game.gameStart == 6) {
					bronzeLiveH = true;
				}
			}
		}
	}
	
	public void move() {
		xPos =  ((game.bc.getXPos())) - 560;
		yPos =  ((game.bc.getYPos())) - 300;
	}
	
	public int determineTimeMedal() {
		if (game.gameWon()) {
			if (game.getTime() >= 30) {
				return 1;
			} else if (game.getTime() >= 20) {
				return 2;
			} else if (game.getTime() >= 10) {
				return 3;
			}
		}
		return 0;
	}
	
	public int determineLifeMedal() {
		if (game.gameWon()) {
			if (game.gameWinLives == 3) {
				return 1;
			} else if (game.gameWinLives == 2) {
				return 2;
			} else if (game.gameWinLives == 1) {
				return 3;
			}
		}
		return 0;
	}
	

}
