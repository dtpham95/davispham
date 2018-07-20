package game2view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game2model.BasicObject;
import game2model.Building;
import game2model.MainShorelineDefense;
import game2model.ShoreBoard;
import game2controller.MouseGame;

/**
 * @author Vincent Mangubat
 *
 */
public class ViewScreen extends JPanel {
	private static final long serialVersionUID = 5123567232343694830L;
	BufferedImage waterImg; // background water image
	BufferedImage shoreImg; // shoreline/dirt/sand image
	BufferedImage redXimg; // image of a red x that goes over the dragged
							// Resource if not allowed to be placed
	BufferedImage tutorialImg; // image of the tutorial text, which disappears
								// when a Resource is first placed
	BufferedImage exitImg; //image of the exit button

	public ViewScreen() {
		try {
			if (ShoreBoard.getScreenheight() < ShoreBoard.getScreenwidth())
				waterImg = ImageIO.read(new File("src/images/oceanwide.png"));
			else
				waterImg = ImageIO.read(new File("src/images/oceantall.png"));

			shoreImg = ImageIO.read(new File("src/images/shore.png"));
			redXimg = ImageIO.read(new File("src/images/redx.png"));
			tutorialImg = ImageIO.read(new File("src/images/tutorial.png"));
			exitImg = ImageIO.read(new File("src/images/exit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Paints every component of the ShoreBoard and the estuary defense game
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		drawWater(g);
		drawTutorial(g);
		myDrawList(g, ShoreBoard.getWavelist());
		myDrawList(g, ShoreBoard.getReslist());
		myDrawList(g, ShoreBoard.getBoatlist());
		drawShore(g);
		myDrawList(g, ShoreBoard.getBldglist());
		drawAmmo(g);
		drawHPbar(g);
		myDrawList(g, ShoreBoard.getOuchlist());
		drawResourceDragged(g);
		drawGameTimer(g);
		drawExit(g);
	}

	/**
	 * Paints the timer clock on the top right along with text
	 * 
	 * @param g
	 */
	public void drawGameTimer(Graphics g) {
		int thicc = 50; // thickness of the timer
		int outlinethicc = 6; // thickeness of the outline of the timer
		int x = ShoreBoard.getScreenwidth() - (thicc * 2); // x-coordinate
		int y = thicc / 2; // y-coordinate
		Graphics2D tempG2 = (Graphics2D) g;

		// draw the timer portion
		tempG2.setColor(Color.orange);
		tempG2.fill(new Arc2D.Double(x - outlinethicc / 2, y - outlinethicc / 2, thicc + outlinethicc,
				thicc + outlinethicc, 90, 360, Arc2D.PIE));
		tempG2.setColor(Color.yellow);
		tempG2.fill(new Arc2D.Double(x, y, thicc, thicc, 90,
				-360 * (1.0 * MainShorelineDefense.getCurrenttick() / MainShorelineDefense.getTickLimit()), Arc2D.PIE));

		// draw the "Timee Left" text portion
		try {
			g.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(20f));
			g.setColor(Color.black);
			g.drawString("Time Left", x - thicc / 2, thicc * 2);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Paints every BasicObject in a given list
	 * 
	 * @param g
	 * @param list
	 *            a list of BasicObjects taken from the ShoreBoard class
	 */
	public void myDrawList(Graphics g, ArrayList<BasicObject> boList) {
		for (int i = 0; i < boList.size(); i++) {
			BasicObject tempBO = boList.get(i);
			try {
				BufferedImage tempImg = ImageIO.read(new File(tempBO.getImgPath()));
				g.drawImage(tempImg, tempBO.getX(), tempBO.getY(), tempBO.getXsize(), tempBO.getYsize(), this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Paints the ammo portion on top of the three buildings on the bottom of
	 * the screen. This includes the timer showing ammo regeneration, the number
	 * representing the ammo, and a gray transparent box if out of ammo.
	 * 
	 * @param g
	 */
	public void drawAmmo(Graphics g) {
		for (int i = 0; i < ShoreBoard.getBldglist().size(); i++) {
			int timerthicc = 30; // thickness of ammo timer click
			BasicObject tempBuilding = ShoreBoard.getBldglist().get(i);

			// gray out building icon if out of ammo
			if (((Building) tempBuilding).getAmmo() == 0) {
				g.setColor(new Color(0, 0, 0, (float) 0.8)); // partially
																// transparent
																// black
				g.fillRect(tempBuilding.getX(), tempBuilding.getY(), tempBuilding.getXsize(), tempBuilding.getYsize());
			}

			// draw ammo timer
			if (i < 2) { // skip concrete building which is i = 2
				Graphics2D tempG2 = (Graphics2D) g;

				// draw ammo timer outline
				int timerOutlineThickness = 6; // pixel thickness of black
												// outline
				int outlineX = tempBuilding.getX() + tempBuilding.getXsize() - timerthicc - timerOutlineThickness / 2; // x-coordinate
				int outlineY = tempBuilding.getY() + tempBuilding.getYsize() - timerthicc - timerOutlineThickness / 2; // y-coordinate
				int outlineThicc = timerthicc + timerOutlineThickness; // thickness
																		// of
																		// the
																		// black
																		// circle
				tempG2.setColor(Color.black);
				tempG2.fill(new Arc2D.Double(outlineX, outlineY, outlineThicc, outlineThicc, 90, 360, Arc2D.PIE)); // starts
																													// at
																													// 90
																													// degrees
																													// and
																													// fills
																													// 360
																													// degrees.

				// draw ammo timer on bottom right of a Building
				// variable timerthicc set earlier
				int ammotimerX = tempBuilding.getX() + tempBuilding.getXsize() - timerthicc; // x-coordinate
				int ammotimerY = tempBuilding.getY() + tempBuilding.getYsize() - timerthicc; // y-coordinate
				tempG2.setColor(Color.yellow);
				tempG2.fill(new Arc2D.Double(ammotimerX, ammotimerY, timerthicc, timerthicc, 90,
						360 * ((Building) tempBuilding).getRegen() / Building.getRegenMax(), Arc2D.PIE));// starts
																											// at
																											// 90
																											// degrees
																											// and
																											// fills
																											// a
																											// percent
																											// of
																											// 360
																											// degrees
																											// scaled
																											// to
																											// the
																											// shoreline's
																											// health

				// draw the ammo number on the bottom center of a Building
				String ammoText = "x" + ((Building) tempBuilding).getAmmo();
				int ammoNumX = tempBuilding.getX() + tempBuilding.getXsize() - timerthicc * 2;
				int ammoNumY = tempBuilding.getY() + tempBuilding.getYsize() - timerthicc / 2;
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.setColor(Color.black);
				g.drawString(ammoText, ammoNumX, ammoNumY);
			}

		}
	}

	/**
	 * Paints the health bar and the outline under it
	 * 
	 * @param g
	 */
	public void drawHPbar(Graphics g) {
		// draw outline of hp bar
		int hpOutlineThicc = 8; // programmer defined outline thickness
		int spaceFromEdges = 50; // programmer defined space of HP bar away from
									// the left
									// and right of the screen
		int outlineX = spaceFromEdges - hpOutlineThicc / 2;
		int outlineY = ShoreBoard.getHealthbaryloc() - hpOutlineThicc / 2;
		int outlineWidth = ShoreBoard.getScreenwidth() - spaceFromEdges * 2 + hpOutlineThicc;
		int outlineHeight = ShoreBoard.getHealthbarthicc() + hpOutlineThicc;
		g.setColor(Color.black);
		g.fillRect(outlineX, outlineY, outlineWidth, outlineHeight);

		// draw hp bar
		int hpX = spaceFromEdges; // x-coordinate of HP bar
		int hpY = ShoreBoard.getHealthbaryloc(); // y-coordinate of HP bar
		double healthbarXsize = (ShoreBoard.getScreenwidth() - spaceFromEdges * 2) * ShoreBoard.getHealth()
				/ ShoreBoard.getHealthmax(); // width of the HP bar, scales with
												// shoreline health
		if (healthbarXsize < 0)
			healthbarXsize = 0;
		g.setColor(Color.red);
		g.fillRect(hpX, hpY, (int) healthbarXsize, ShoreBoard.getHealthbarthicc());
	}

	/**
	 * Paints the shore/dirt/sand image.
	 * 
	 * @param g
	 */
	public void drawShore(Graphics g) {
		g.drawImage(shoreImg, 0, ShoreBoard.getShoreborderyloc(), ShoreBoard.getScreenwidth(),
				ShoreBoard.getShoreborderysize(), this);
	}

	/**
	 * Paints the water texture image background.
	 * 
	 * @param g
	 */
	public void drawWater(Graphics g) {
		g.drawImage(waterImg, 0, 0, ShoreBoard.getScreenwidth(), ShoreBoard.getScreenheight(), this);

	}

	/**
	 * Paints the Resource being dragged by the mouse.
	 * 
	 * @param g
	 */
	public void drawResourceDragged(Graphics g) {
		if (ShoreBoard.getIsDragging()) {
			BasicObject tempResBO = ShoreBoard.getResourceDragged();
			try {
				BufferedImage dragImg = ImageIO.read(new File(tempResBO.getImgPath()));
				g.drawImage(dragImg, tempResBO.getX(), tempResBO.getY(), tempResBO.getXsize(), tempResBO.getYsize(),
						this);

				if (ShoreBoard.getIsPlaceable() == false)
					g.drawImage(redXimg, tempResBO.getX(), tempResBO.getY(), tempResBO.getXsize(), tempResBO.getYsize(),
							this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Paints the tutorial text if a Resource has never been added to the water
	 * yet.
	 * 
	 * @param g
	 */
	public void drawTutorial(Graphics g) {
		int width = ShoreBoard.getScreenwidth();
		int height = (int) width / 3;
		int x = 0;
		int y = ShoreBoard.getScreenheight() / 2 - height / 2;
		if (MouseGame.isFirstResourceAdded() == false)
			g.drawImage(tutorialImg, x, y, width, height, this);
	}

	/**
	 * Paints the exit button on the top left of the screen.
	 * 
	 * @param g
	 */
	public void drawExit(Graphics g) {
		g.drawImage(exitImg, 0, 0, 100, 100, this);
	}
}
