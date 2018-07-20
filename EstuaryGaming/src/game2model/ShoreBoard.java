package game2model;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

/**
 * @author Vincent Mangubat
 *
 */
public class ShoreBoard extends JPanel {
	private static final long serialVersionUID = -9010104395857929069L;
	private Random rand = new Random();

	static Dimension computerScreenDimensions = Toolkit.getDefaultToolkit().getScreenSize(); // the
																								// size
																								// of
																								// the
																								// computer
																								// screen
	private final static int screenWidth = (int) computerScreenDimensions.getWidth(); // width
																						// of
																						// the
																						// computer
																						// screen
	private final static int screenHeight = (int) computerScreenDimensions.getHeight(); // height
																						// of
																						// the
																						// computer
																						// screen

	private final static int shoreborderYsize = 200; // how tall the shoreline
														// is
	private final static int shoreborderYloc = screenHeight - shoreborderYsize; // the
																				// y-coordinate
																				// of
																				// the
																				// shoreline's
																				// edge

	private final static int healthMax = 30000; // how much health the shoreline
												// starts with
	private static int health; // the shoreline's current health
	private final static int healthbarThicc = 15; // how thick the healthbar is
	private final static int healthbarYloc = screenHeight - 2 * healthbarThicc; // the
																				// y-coordinate
																				// of
																				// the
																				// healthbar

	private static int spawnBoatTimer; // for ticking purposes, determines when
										// to spawn a Boat
	private final static int spawnBoatTimerMin = 300; // Minimum amount of time
														// for boats to spawn
														// after another.
	private final static int spawnBoatTimerRange = 200; // The variable time to
														// be
														// added to
														// spawnBoatTimer to
														// range between 1-200.

	private static ArrayList<BasicObject> bldglist; // BasicObject list of
													// Buildings
	private static ArrayList<BasicObject> reslist;// BasicObject list of
													// Resources
	private static ArrayList<BasicObject> boatlist;// BasicObject list of Boats
	private static ArrayList<BasicObject> wavelist;// BasicObject list of Waves
	private static ArrayList<BasicObject> ouchlist;// BasicObject list of Ouch
													// warnings

	private static Boolean isPlaying; // true when the game is still playing,
										// meaning health has not reached 0 and
										// there's time still remaining

	private static BasicObject resourceDragged; // The Resource being dragged by
												// the mouse cursor
	private static Boolean isDragging; // true if the the player is holding down
										// on the mouse and dragging a Resource
										// from a Building
	private static Boolean isPlaceable; // true if the resourceDragged is
										// placeable in the water, false when
										// the resourceDragged is not in the
										// water, out of the screen, overlapping
										// the Boat spawns, or overalapping
										// other Resources, or too close to
										// other Resources

	/**
	 * Initializes/resets the boat timer, health, Building list, Resource list,
	 * Boat list, Wave list, Ouch list, and resource dragging variables.
	 */
	ShoreBoard() {
		spawnBoatTimer = spawnBoatTimerMin;
		health = healthMax;
		bldglist = new ArrayList<BasicObject>(3);
		reslist = new ArrayList<BasicObject>();
		boatlist = new ArrayList<BasicObject>();
		wavelist = new ArrayList<BasicObject>();
		ouchlist = new ArrayList<BasicObject>();
		isPlaying = true;
		isDragging = false;
		isPlaceable = false;

		bldglist.add(new BldgGabion()); // index 0
		bldglist.add(new BldgGrass());// index 1
		bldglist.add(new BldgConcrete());// index 2

	}

	public static int getHealth() {
		return health;
	}

	public static void setHealth(int health) {
		ShoreBoard.health = health;
	}

	public static int getSpawnBoatTimer() {
		return spawnBoatTimer;
	}

	public static void setSpawnBoatTimer(int spawnBoatTimer) {
		ShoreBoard.spawnBoatTimer = spawnBoatTimer;
	}

	public static ArrayList<BasicObject> getBldglist() {
		return bldglist;
	}

	public static void setBldglist(ArrayList<BasicObject> bldglist) {
		ShoreBoard.bldglist = bldglist;
	}

	public static ArrayList<BasicObject> getReslist() {
		return reslist;
	}

	public static void setReslist(ArrayList<BasicObject> reslist) {
		ShoreBoard.reslist = reslist;
	}

	public static ArrayList<BasicObject> getBoatlist() {
		return boatlist;
	}

	public static void setBoatlist(ArrayList<BasicObject> boatlist) {
		ShoreBoard.boatlist = boatlist;
	}

	public static ArrayList<BasicObject> getWavelist() {
		return wavelist;
	}

	public static void setWavelist(ArrayList<BasicObject> wavelist) {
		ShoreBoard.wavelist = wavelist;
	}

	public static ArrayList<BasicObject> getOuchlist() {
		return ouchlist;
	}

	public static void setOuchlist(ArrayList<BasicObject> ouchlist) {
		ShoreBoard.ouchlist = ouchlist;
	}

	public static Boolean getIsPlaying() {
		return isPlaying;
	}

	public static void setIsPlaying(Boolean isPlaying) {
		ShoreBoard.isPlaying = isPlaying;
	}

	public static BasicObject getResourceDragged() {
		return resourceDragged;
	}

	public static void setResourceDragged(BasicObject resourceDragged) {
		ShoreBoard.resourceDragged = resourceDragged;
	}

	public static Boolean getIsDragging() {
		return isDragging;
	}

	public static void setIsDragging(Boolean isDragging) {
		ShoreBoard.isDragging = isDragging;
	}

	public static Boolean getIsPlaceable() {
		return isPlaceable;
	}

	public static void setIsPlaceable(Boolean isPlaceable) {
		ShoreBoard.isPlaceable = isPlaceable;
	}

	public static int getScreenwidth() {
		return screenWidth;
	}

	public static int getScreenheight() {
		return screenHeight;
	}

	public static int getShoreborderysize() {
		return shoreborderYsize;
	}

	public static int getShoreborderyloc() {
		return shoreborderYloc;
	}

	public static int getHealthmax() {
		return healthMax;
	}

	public static int getHealthbaryloc() {
		return healthbarYloc;
	}

	public static int getHealthbarthicc() {
		return healthbarThicc;
	}

	public static int getSpawnboattimermin() {
		return spawnBoatTimerMin;
	}

	public static int getSpawnboattimerrange() {
		return spawnBoatTimerRange;
	}

	/**
	 * Adds a Resource to this game's corresponding list of Resources. If a Wall
	 * is being added, health is reduced by 10% of max health because Walls
	 * contribute to erosion in a long run
	 * 
	 * @param tempresource
	 *            the resource to be added in the water
	 */
	public static void addResource(BasicObject tempresource) {
		if (tempresource instanceof Gabion || tempresource instanceof Seagrass || tempresource instanceof Wall) {
			reslist.add(tempresource);
			if (tempresource instanceof Wall)
				ShoreBoard.health -= healthMax / 10;
		}
	}

	/**
	 * Used to tick the game, all of its components. Explanations for what ticks
	 * and how they're ticked is explained in the comments of this function
	 */
	public void moveall() {
		// tick boat spawner
		spawnBoatTimer--;
		if (spawnBoatTimer == 0) {
			boatlist.add(new Boat(1 - Boat.getBoatxsize()));
			spawnBoatTimer = rand.nextInt(spawnBoatTimerRange) + spawnBoatTimerMin;
		}

		// tick each building
		for (BasicObject o : bldglist) {
			((Building) o).move();
		}

		// maxList is the number representing the biggest size of a list out of
		// the list of Resources, Boats, Waves, and Ouch warnings
		int maxList = Math.max(reslist.size(), boatlist.size());
		maxList = Math.max(maxList, wavelist.size());
		maxList = Math.max(maxList, ouchlist.size());

		// iterates through every list at the same time, starting at index of
		// the biggest list then going down until 0. This way, lists can
		// modify and remove elements without errors.
		for (int i = maxList; i >= 0; i--) {
			// move boats right but removes them if theyre out of screen on the
			// right
			if (i < boatlist.size()) {
				Boat tempboat = (Boat) boatlist.get(i);
				tempboat.move();

				if (tempboat.getX() >= screenWidth || tempboat.getX() + tempboat.getXsize() <= 0)
					boatlist.remove(i);
			}

			// moves each wave downward, removes a wave if it hits the shore or
			// resources
			if (i < wavelist.size()) {
				Wave w = (Wave) wavelist.get(i);
				w.move();
				if (w.getY() + w.getYsize() >= shoreborderYloc) {
					health -= w.getDamage();
					wavelist.remove(i);
					ouchlist.add(new Ouch(w.getX(), w.getY()));
				} else {
					for (BasicObject r : reslist) {
						if (w.isHitting(r)) {
							((Resource) r).hitBy(w);
							wavelist.remove(i);
							break;
						}
					}
				}
			}

			// ticks each Resource but removes them if their health reaches 0
			if (i < reslist.size()) {
				Resource r = (Resource) reslist.get(i);
				r.move();
				if (r.getHealth() <= 0) {
					reslist.remove(i);
				}
			}

			// displays each Ouch message but removes them if their timer wears
			// out
			if (i < ouchlist.size()) {
				Ouch tempOuch = (Ouch) ouchlist.get(i);
				tempOuch.move();
				if (tempOuch.getTimer() <= 0)
					ouchlist.remove(i);
			}
		}

		// after ticking everything, checks if the shore is out of health to end
		// the game.
		if (health <= 0)
			isPlaying = false;
	}

	/**
	 * Used at the end of the game to check of the player won or lost.
	 * 
	 * @return false of out of health, true otherwase.
	 */
	public static boolean checkWin() {
		if (health <= 0)
			return false;
		else
			return true;
	}

}
