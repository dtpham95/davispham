package game1model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlueCrab extends Animal {
	
	int life;
	int lifeTime;
	int word = 0;
	BufferedImage crabImage = null;
	ArrayList<BufferedImage> crabAni = new ArrayList<BufferedImage>();
	int picNum = 0;
	int frameCount = 22;
	ArrayList<BufferedImage> crabAni2 = new ArrayList<BufferedImage>();
	int picNum2 = 0;
	int frameCount2 = 18;
	BufferedImage crabWin = null;
	BufferedImage crabLose = null;
	ArrayList<BufferedImage> blink = new ArrayList<BufferedImage>();
	int blinkFrameCount = 17;
	int picNum3;
	boolean hitRight = false;
	boolean hitLeft = false;
	boolean hitUp = false;
	boolean hitDown = false;
	
	/**
	 * Creates an instance of the BlueCrab class. The life attribute is initialized to 3.
	 * 
	 * @param xPos
	 * @param yPos
	 * @param width
	 * @param height
	 * @param game
	 */
	public BlueCrab(int xPos, int yPos, int width, int height, Game game) {
		super(xPos, yPos, width, height, game);
		this.life = 3;
		createImage();
		
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void setLife(int x) {
		this.life = x;
	}
	

	/**
	 * Determines whether or not a blue crab should lose a life depending on the 
	 * Predator class's hitPred() method. If a blue crab hits a predator, it's position is adjusted based on the direction it 
	 * approached the predator from.
	 *
	 */
	public void loseLife() {
		for (int i = 0; i < game.e.preds.size(); i++) {
			if (game.e.preds.get(i).hitPred(this) > 0) {
				life -= 1;
				lifeTime = game.getTime();
				Random rand = new Random();

				word = rand.nextInt(10) + 1;
				if (game.e.preds.get(i).hitPred(this) == 1) {
					yPos -= 60;
					hitRight = false;
					hitUp = true;
					hitLeft = false;
					hitDown = false;
				}
				else if (game.e.preds.get(i).hitPred(this) == 2){
					yPos += 60;
					hitRight = false;
					hitUp = false;
					hitLeft = false;
					hitDown = true;
				} 
				else if (game.e.preds.get(i).hitPred(this) == 5) {
					yPos -= 60;
					hitRight = false;
					hitUp = true;
					hitLeft = false;
					hitDown = false;
				}
				else if (game.e.preds.get(i).hitPred(this) == 3) {
					xPos += 60;
					hitRight = true;
					hitUp = false;
					hitLeft = false;
					hitDown = false;
				}
				else  if (game.e.preds.get(i).hitPred(this) == 4){
					xPos -= 60;
					hitRight = false;
					hitUp = false;
					hitLeft = true;
					hitDown = false;
				}
				else if (game.e.preds.get(i).hitPred(this) == 6) {
					xPos -= 60;
					hitRight = false;
					hitUp = false;
					hitLeft = true;
					hitDown = false;
				}
			}
		}
	}
		
	
	public boolean wallOverlapX() {
		for (int i = 0; i < game.m.walls.size(); i++) {
			if (game.m.walls.get(i).xPos + game.m.walls.get(i).width < xPos + width) {
				if (game.m.walls.get(i).xPos > xPos) {
					if (game.m.walls.get(i).yPos + game.m.walls.get(i).height > yPos + height) {
						if (game.m.walls.get(i).yPos < yPos) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean wallOverlapY() {
		for (int i = 0; i < game.m.walls.size(); i++) {
			if (game.m.walls.get(i).yPos + game.m.walls.get(i).height < yPos + height) {
				if (game.m.walls.get(i).yPos > yPos) {
					if (game.m.walls.get(i).xPos + game.m.walls.get(i).width > xPos + width) {
						if (game.m.walls.get(i).xPos < xPos) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Obtains all the images necessary for the blue crab. Also puts images 
	 * into arrays to be used for animations.
	 */
	public void createImage() {
		BufferedImage crab1ststep = null;
		BufferedImage crab2ndstep = null;
		BufferedImage crabhalf = null;
		BufferedImage crabfull = null;
		BufferedImage eye6 = null;
		BufferedImage eye5 = null;
		BufferedImage eye4 = null;
		BufferedImage eye3 = null;
		BufferedImage eye2 = null;
		BufferedImage eye1 = null;
		BufferedImage eyeClosed = null;
		try {
		    crabImage = ImageIO.read(new File("src/images/crab.png"));
		    crab1ststep = ImageIO.read(new File("src/images/crab1ststep.png"));
		    crab2ndstep = ImageIO.read(new File("src/images/crab2ndstep.png"));
		    crabhalf = ImageIO.read(new File("src/images/crabhalf.png"));
		    crabfull = ImageIO.read(new File("src/images/crabfull.png"));
		    crabWin = ImageIO.read(new File("src/images/crabwin.png"));
		    crabLose = ImageIO.read(new File("src/images/crablose.png"));
		    eye6 = ImageIO.read(new File("src/images/crab_eye6.png"));
		    eye5 = ImageIO.read(new File("src/images/crab_eye5.png"));
		    eye4 = ImageIO.read(new File("src/images/crab_eye4.png"));
		    eye3 = ImageIO.read(new File("src/images/crab_eye3.png"));
		    eye2 = ImageIO.read(new File("src/images/crab_eye2.png"));
		    eye1 = ImageIO.read(new File("src/images/crab_eye1.png"));
		    eyeClosed = ImageIO.read(new File("src/images/eyes_closed.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
//		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
//		crabAni.add(crab1ststep);
		crabAni.add(crab1ststep);
		crabAni.add(crab1ststep);
		crabAni.add(crab1ststep);
		crabAni.add(crab1ststep);
		crabAni.add(crab1ststep);
//		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
		crabAni.add(crabImage);
//		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		crabAni.add(crab2ndstep);
		
		crabAni2.add(crabImage);
		crabAni2.add(crabImage);
		crabAni2.add(crabImage);
		crabAni2.add(crabImage);
		crabAni2.add(crabImage);
		crabAni2.add(crabImage);
		crabAni2.add(crabhalf);
		crabAni2.add(crabhalf);
		crabAni2.add(crabhalf);
		crabAni2.add(crabhalf);
		crabAni2.add(crabhalf);
		crabAni2.add(crabhalf);
		crabAni2.add(crabfull);
		crabAni2.add(crabfull);
		crabAni2.add(crabfull);
		crabAni2.add(crabfull);
		crabAni2.add(crabfull);
		crabAni2.add(crabfull);
		
		blink.add(eye6);
		blink.add(eye6);
//		blink.add(eye5);
//		blink.add(eye5);
		blink.add(eye4);
		blink.add(eye4);
//		blink.add(eye3);
//		blink.add(eye3);
		blink.add(eye2);
		blink.add(eye2);
//		blink.add(eye1);
//		blink.add(eye1);
		blink.add(eyeClosed);
		blink.add(eyeClosed);
		blink.add(eyeClosed);
		blink.add(eyeClosed);
//		blink.add(eye1);
//		blink.add(eye1);
		blink.add(eye2);
		blink.add(eye2);
//		blink.add(eye3);
//		blink.add(eye3);
		blink.add(eye4);
		blink.add(eye4);
//		blink.add(eye5);
//		blink.add(eye5);
		blink.add(eye6);
		blink.add(eye6);
	}
	
	

	/**
	 * Paints the blue crab. If the blue crab is not moving the claws will snap.
	 * If the crab is moving the legs will move. The crab will always blink every
	 * four seconds. If the game is won the crab will smile. If the game is lost the crab
	 * will frown. When lives are lost random messages display above the crab.
	 * 
	 * @param g Graphics2D object
	 */
	public void paint(Graphics2D g) {
		if (xVel != 0 || yVel != 0) {
		picNum = (picNum + 1) % frameCount;
		picNum2 = 0;
		} else {
			picNum2 = (picNum2 + 1) % frameCount2;
			picNum = 0;
		}
//		g.setColor(Color.RED);
//		g.fillOval(getXPos(), getYPos(), getWidth(), getHeight());
		

		if (xVel != 0 || yVel != 0) {
			g.drawImage(crabAni.get(picNum), xPos, yPos, 60, 60, null);
		} else {
			g.drawImage(crabAni2.get(picNum2), xPos, yPos, 60, 60, null);
		}
		if (game.gameStart >= 4) {
			if (game.getTime() % 4 == 0) {
				if (picNum3 == 15) {
					
				} else {
				picNum3 = (picNum3 + 1) % blinkFrameCount;
				g.drawImage(blink.get(picNum3), xPos, yPos, 60, 60, null);
				}
			} else {
				picNum3 = 0;
			}
		}
		
		if (game.gameStart == 4) {
		if (game.gameWon() == true) {
			g.drawImage(crabWin, xPos, yPos, 60, 60, null);
		} else if (game.gameOver() == true) {
			g.drawImage(crabLose, xPos, yPos, 60, 60, null);
		}
		}
//		Font f = new Font("VCR OSD Mono", Font.PLAIN, 50); 
		
		g.setColor(Color.CYAN);
		g.setFont(game.f50);
		if (lifeTime > 0) {
			if (game.getTime() > (lifeTime - 2)) {
				if (life > 0) {
				switch (word) {
				case(1) :
					if (life == 1) {
						g.drawString("You're Not Very Good At This", xPos - 200, yPos - 50);
						break;
					} else {
						g.drawString("Ouch", xPos - 50 , yPos - 50);
						break;
					}
				case(2) :
					if (life == 1) {
						g.drawString("Seriously!?", xPos - 75, yPos - 50);
						break;
					} else {
						g.drawString("Ow!", xPos - 50 , yPos - 50);
						break;
					}
				case(3) :
					if (life == 1) {
						g.drawString("Really!?", xPos - 50, yPos - 50);
						break;
					} else {
						g.drawString("Ouch!", xPos - 50 , yPos - 50);
						break;
					}
				case(4) :
					if (life == 1) {
						g.drawString("FOCUS!", xPos - 200, yPos - 50);
						break;
					} else {
						g.drawString("Darn!", xPos - 50 , yPos - 50);
						break;
					}
				case(5) :
					if (life == 1) {
						g.drawString("This Shouldn't Be That Difficult", xPos - 400, yPos - 50);
						break;
					} else {
						g.drawString("Oops!", xPos - 50 , yPos - 50);
						break;
					}
				case(6) :
					g.drawString("Oof!", xPos - 50 , yPos - 50);
					break;
				case(7) :
					if (life == 1) {
						g.drawString("Only 1 Left!", xPos - 75 , yPos - 50);
						break;
					} else {
						g.drawString("Whoops!", xPos - 50 , yPos - 50);
						break;
					}
				case(8) :
					if (life == 1) {
						g.drawString("You're Not Very Good At This", xPos - 350, yPos - 50);
						break;
					} else {
						g.drawString("Don't Do That Again", xPos - 100 , yPos - 50);
						break;
					}
				case(9) :
					if (life == 1) {
						g.drawString("I Don't Think We're Gonna Make It", xPos - 350, yPos - 50);
						break;
					} else {
						g.drawString("Please Don't Do That Again", xPos - 300 , yPos - 50);
						break;
					}
				case(10) :
					if (life == 1) {
						g.drawString("I Don't Think We're Gonna Make It", xPos - 350, yPos - 50);
						break;
					} else {
						g.drawString("2 More", xPos - 50 , yPos - 50);
						break;
					}
				}
				}

				

			}
		}
	}

	
	/**
	 * Stops the crab when the key is released.
	 * 
	 * @param e KeyEvent object
	 */
	public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				xVel = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				xVel = 0;
			}
		
		if (xVel == 0) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				yVel = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				yVel = 0;
			}
		}
	}
	
	/**
	 * Moves the crab when a key is pressed.
	 * 
	 * @param e KeyEvent object
	 */
	public void keyPressed(KeyEvent e) {
		xVel = 0;
		yVel = 0;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				moveLeft();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				moveRight();
			}
		
		if (xVel == 0) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				moveUp();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				moveDown();
			}
		}
	}
	
	/**
	 * Moves the blue crab. Detects whether the crab hit a wall based on the wall's wallHit() method.
	 * Also detects whether the crab has reached the edge of the playing area.
	 */
	public void moveBlueCrab() {
		loseLife();
		if (wallOverlapX()) {
			if (hitRight) {
				if (xVel > 0) {
					yPos += yVel;
					return;
				} else {
					xPos += xVel;
					yPos += yVel;
					return;
				}
			} else if (hitLeft) {
				if (xVel < 0) {
					yPos += yVel;
					return;
				} else {
					xPos += xVel;
					yPos += yVel;
					return;
				}
			}
		}
		if (wallOverlapY()) {
			if (hitUp) {
				if (yVel < 0) {
					xPos += xVel;
					return;
				} else {
					xPos += xVel;
					yPos += yVel;
					return;
				}
			} else if (hitDown) {
				if (yVel > 0) {
					xPos += xVel;
					return;
				} else {
					xPos += xVel;
					yPos += yVel;
					return;
				}
			}
		}
		int xLow = xPos;
		int xHigh =xPos + width;
		int yTop = yPos;
		int yBot = yPos + height;
		for (int i = 0; i < game.m.walls.size(); i++) {
			if (game.m.walls.get(i).wallHit(this) > 0) {
//				while (game.m.walls.get(i).wallHit(this)) {
				if (game.m.walls.get(i).wallHit(this) == 4) {
					if (yVel < 0) {
						yPos += yVel;
						return;
					} 
					else {
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 1) {
								if (xVel > 0) {
									xPos += xVel;
								}
								return;
							}
						}
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 2) {
								if (xVel < 0) {
									xPos += xVel;
								}
								return;
							}
						}
						xPos += xVel;
						return;
					}
				}
				else if (game.m.walls.get(i).wallHit(this) == 3) {
					if (yVel > 0) {
						yPos += yVel;
						return;
					} 
					else {
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 1) {
								if (xVel > 0) {
									xPos += xVel;
								}
								return;
							}
						}
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 2) {
								if (xVel < 0) {
									xPos += xVel;
								}
								return;
							}
						}
						xPos += xVel;
						return;
					}
				}
				else if (game.m.walls.get(i).wallHit(this) == 2) {
					if (xVel < 0) {
						xPos += xVel;
						return;
					} 
					else {
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 3) {
								if (yVel > 0) {
									yPos += yVel;
								}
								return;
							}
						}
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 4) {
								if (yVel < 0) {
									yPos += yVel;
								}
								return;
							}
						}
						yPos += yVel;
						return;
					}
				}
				else if (game.m.walls.get(i).wallHit(this) == 1) {
					if (xVel > 0) {
						xPos += xVel;
						return;
					} 
					else {
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 3) {
								if (yVel > 0) {
									yPos += yVel;
								}
								return;
							}
						}
						for (int j = 0; j < game.m.walls.size(); j++) {
							if (game.m.walls.get(j).wallHit(this) == 4) {
								if (yVel < 0) {
									yPos += yVel;
								}
								return;
							}
						}
						yPos += yVel;
						return;
					}
				}
//				if (xVel > 0) {
//					xPos -= 20;
//					return;
//				} 
//				else if (xVel < 0) {
//					xPos += 20;
//					return;
//				}
//				if (yVel > 0) {
//					yPos -= 20;
//					return;
//				}
//				else if (yVel < 0) {
//					yPos += 20;
//					return;
//				}
//			}
			}
		}
		if (xPos <= 0) {
			if (xVel > 0) {
				xPos += xVel;
			} else  if (yPos + height <= game.mapHeight && yPos >= 0){
				yPos += yVel;
			} else {
				return;
			}
		} else if (xPos + width >= game.mapWidth) {
			if (xVel < 0) {
				xPos += xVel;
			} else  if (yPos + height <= game.mapHeight && yPos >= 0){
				yPos += yVel;
			} else {
				return;
			}
		} else if (yPos <= 0) {
			if (yVel > 0) {
				yPos += yVel;
			} else if  (xPos + width <= game.mapWidth && xPos >= 0){ 
				xPos += xVel;
			} else {
				return;
			}
		} else if (yPos + height >= game.mapHeight) { 
			if (yVel < 0) {
				yPos += yVel;
			} else if (xPos + width <= game.mapWidth && xPos >= 0){
				xPos += xVel;
			} else {
				return;
			}
		}  else {
			xPos += xVel;
			yPos += yVel;
		}

	}
	
}
