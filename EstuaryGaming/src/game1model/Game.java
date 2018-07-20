package game1model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Random;
import java.awt.event.KeyListener;
 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Game extends JPanel {
	
	static int displayWidth = 1200;
	static int displayHeight = 700;
	static int mapWidth = 3600;
	static int  mapHeight = 2100;
	int gameStart = 0;
	boolean drought = false;
	boolean levelOneWon = false;
	boolean levelTwoWon = false;
	BufferedImage droughtOverlay = null;
	BufferedImage youWin = null;
	BufferedImage outerEdge = null;
	int gameWinLives;


	static int droughtTime;
	int time = 64;
	int titleTime = 0;
	int tutTime = 0;
//	Font f1 = new Font("VCR OSD Mono", Font.PLAIN, 100);
	Font f20;
	Font f70;
	Font f40;
	Font f30;
	Font f32;
	Font f50;
	Font f100;
	Font f500;
	
	int textBox = 0;
	boolean viewLeaders = false;
	
	BlueCrab bc = new BlueCrab(1800, 1700, 60, 60, this);
	Camera cam = new Camera(this);
	Maze m = new Maze(this);
	SalinityBar sb = new SalinityBar(this);
	Enemies e = new Enemies(this);
	Background bg = new Background(this);
	Clock c = new Clock(this);
	Bubbles b = new Bubbles(this);
	Waves w = new Waves(this);
	Menu menu = new Menu(this); 
	Tutorial t = new Tutorial(this);
	Decorations d = new Decorations(this);
	LevelSelect ls = new LevelSelect(this);
	PostGameScreen pgs = new PostGameScreen(this);
	Scoreboard scb = new Scoreboard(this);


	
	/**
	 * Creates an instance of a Game. 
	 */
	public Game() {
		

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				bc.keyReleased(e);
				t.bc.keyReleased(e);
//				cam.keyReleased(e);
//				sb.keyReleased(e);
				if (e.getKeyCode() == KeyEvent.VK_L) {
					if (gameStart == -1) {
						viewLeaders = false;
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent ev) {
				if (ev.getKeyCode() == KeyEvent.VK_SPACE) {
					if (gameStart < 2 || (gameStart > 2 && gameStart < 4)) {
						if (gameStart == 1) {
							if (w.cursor < 2 && w.cursor > -1) {
								gameStart = 1;
								return;
							} else if (w.cursor == -1) {
								gameStart = -1;
								return;
							}
							else {
								gameStart += 1;
								return;
							}
						}
						if (gameStart == -1) {
							gameStart = 1;
							return;
						}
						gameStart += 1;
						m.updateMaze();
						e.updateEnemies();
						e.createImage();
						return;
					}

				}
				if (gameStart == 3) {
					if (!t.rightWay) {
						t.bc.keyPressed(ev);
					}
				}
				if (gameStart == 2) {
					ls.keyPressed(ev);
				}
				if (!menu.paused) {
					bc.keyPressed(ev);
	//				cam.keyPressed(e);
	//				sb.keyPressed(ev);
					w.keyPressed(ev);
				}

				menu.keyPressed(ev);
				if (ev.getKeyCode() == KeyEvent.VK_L) {
					if (gameStart == -1) {
						viewLeaders = true;
					}
				}
				if (ev.getKeyCode() == KeyEvent.VK_ESCAPE) {
					//System.exit(0);
					Main.escPressed = true;
				}
			}
		});
		setFocusable(true);
	}
	
	
	
	/**
	 * Adds a custom font to the graphics envrionment.
	 */
	public void addFont() {
		try {
		    //create the font to use. Specify the size!
		     f100 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(100f);
		     f50 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(50f);
		     f32 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(32f);
		     f30 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(30f);
		     f500 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(500f);
		     f40 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(40f);
		     f70 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(70f);
		     f20 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")));
		} catch (IOException e) {
			System.out.print("bad");
		} catch(FontFormatException e) {
		    System.out.print("bad");
}
	}
	
	/**
	 * Obtains the images needed for the Game class. 
	 */
	public void getImages() {
		try {
		    droughtOverlay = ImageIO.read(new File("src/images/droughtOverlay.png"));
		    youWin = ImageIO.read(new File("src/images/youWIn.png"));
		    outerEdge = ImageIO.read(new File("src/images/oceanEdge.png"));
		} catch (IOException e) {
			System.out.println("bad");
		}
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	

	public int getTutTime() {
		return tutTime;
	}



	public void setTutTime(int tutTime) {
		this.tutTime = tutTime;
	}



	public int getTitleTime() {
		return titleTime;
	}



	public void setTitleTime(int titleTime) {
		this.titleTime = titleTime;
	}



	/**
	 * Determines when and for how long a drought will occur during
	 * the game.
	 * 
	 * @param n Represents the random start time generated for the drought
	 */
	public void createDrought(int n) {
		
		if (n >= time && time >= (n - 10)) {
			drought = true;
		}
		else {
			drought = false;
		}
	}

	
	
	/**
	 * Determines if the game is over or not. If the blue crab has lost all 
	 * lives or time has run out the game is over.
	 * 
	 * @return	A boolean representing whether the game is over or not.
	 */
	public boolean gameOver() {
		if (bc.life <= 0 || time <= 0) {
			if (!gameWon())
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if the game has been won or not. If the blue crab has
	 * reached the estuary the game has been won.
	 * 
	 * @return	A boolean representing whether the game has been won or not.
	 */
	public boolean gameWon() {
		if (bc.getYPos() <= 0) {
			gameWinLives = bc.getLife();
			if (gameStart == 4) {
				levelOneWon = true;
			}
			if (gameStart == 5) {
				levelTwoWon = true;
			}
			return true;
		}
		return false;
	}
	
	
	public void gameWon2() {
		if (bc.getYPos() <= 0) {
				int gameWinTime = getTime();
				int gameWinLife = bc.getLife();
				int s = gameWinTime + (gameWinLife * 5);
				scb.newScore(s);
		}
	}
	


	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
		if ((gameStart < 4) && !gameWon()) {
			w.paint(g2d);
			if (gameStart == 2) {
				ls.paint(g2d);
			}
		}
		else {
		g2d.translate(cam.getxPos(), cam.getyPos());
//		g2d.setColor(Color.LIGHT_GRAY);
//		g2d.fillRect(0, 0, mapWidth, mapHeight);

		for (int i = -1000; i < 5600; i += 120) {
			for (int j = -1000; j < 4100; j += 120) {
				g.drawImage(outerEdge, i, j, 120, 120, null);
			}
		}
		
		bg.paint(g2d);

		if (gameStart > 5) {
			g.drawImage(m.oceanText, 0, 1500, 600, 350, null);
			g.drawImage(m.estuaryText, 2975, -157, 625, 350, null);
		} else {
			g.drawImage(m.oceanText, 1505, 1400, 600, 350, null);
			g.drawImage(m.estuaryText, 1500, -157, 625, 350, null);
		}
		g2d.setColor(Color.blue);
//		if (gameStart == 6) {
//		g2d.setColor(Color.blue);
//		g2d.fillRect(0, 0, 1200, 700);
//		g2d.setColor(Color.cyan);
//		g2d.fillRect(1200, 0, 1200, 700);
//		g2d.setColor(Color.magenta);
//		g2d.fillRect(2400, 0, 1200, 700);
//		g2d.setColor(Color.YELLOW);
//		g2d.fillRect(0, 700, 1200, 700);
//		g2d.setColor(Color.orange);
//		g2d.fillRect(1200, 700, 1200, 700);
//		g2d.setColor(Color.pink);
//		g2d.fillRect(2400, 700, 1200, 700);
//		g2d.setColor(Color.green);
//		g2d.fillRect(0, 1400, 1200, 700);
//		g2d.setColor(Color.black);
//		g2d.fillRect(1200, 1400, 1200, 700);
//		g2d.setColor(Color.white);
//		g2d.fillRect(2400, 1400, 1200, 700);
//		}
		
		d.paint(g2d);
		m.paint(g2d);
		bc.paint(g2d);
		
		e.paint(g2d);
		b.paint(g2d);
		sb.paint(g2d);
		if (drought) {
			g.drawImage(droughtOverlay, 0, 60, 3600, 2100, null);
		}


		
//		g2d.fillRect(0, 2100, 3600, 120);

	
		if (gameOver()) {
			g2d.setColor(Color.BLACK);

			g2d.setFont(f100);
			g2d.drawString("GAME OVER", bc.getXPos() - 225, bc.getYPos() -100);
		} 
		if (gameWon()) {
//			g2d.setColor(Color.YELLOW);
//			g2d.setFont(f1);
//			g2d.drawString("You Win!", bc.getXPos() - 200, 100);
			pgs.paint(g2d);
//			g.drawImage(youWin, bc.getXPos() - 320, -270, 780, 480, null);
			g.setColor(Color.YELLOW); 
			g.setFont(f100);
			g.drawString("You Win!", bc.getXPos() - 150, -200);
		}
		menu.paint(g2d);
		g2d.translate(-cam.getxPos(), -cam.getyPos());
		}
	}
	
	/**
	 * Controls the movement of every object that has a move method.
	 * 
	 */
	void move() {
		if (gameStart < 4) {
			w.move();
		}
		if (!gameOver() && !gameWon() && !menu.paused)  {
			if (gameStart >= 4) {
				cam.moveCamera();
				sb.moveSalinityBar();
				if (time < 61) {
					sb.setLevel();
					bc.moveBlueCrab();
					e.movePreds();
		//			bg.move();
					b.move();
					menu.moveMenu();
				}
			}
		}
		if (gameWon()) {
			pgs.move();
		}
	}
	

    private static void resizePreview(JPanel innerPanel, JPanel container) {
        int w = container.getWidth();
        int h = container.getHeight();
        int size =  Math.min(w, h);
        innerPanel.setPreferredSize(new Dimension(size, size));
        container.revalidate();
    }
   
	

}
