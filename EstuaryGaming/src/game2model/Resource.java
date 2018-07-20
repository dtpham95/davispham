package game2model;

/**
 * @author Vincent Mangubat
 * @see Gabion
 * @see Seagrass
 * @see Wall
 */
public class Resource extends BasicObject {
	private final static int resourceWidth = 120;// width of each Resource's
													// picture
	private final static int resourceHeight = 60;// height of each Resource's
													// picture
	protected final double healthMax = 75000; // the health of this resource
												// that it starts with
	protected double health; // this Resource's current health
	protected int expireRate;// how fast this Resource deteriorates after being
								// placed in the water
	protected String path75; // set in children classes, the image path of this
								// Resource once it hits 75%
								// health
	protected String path50; // set in children classes, the image path of this
								// Resource once it hits 50%
								// health
	protected String path25; // set in children classes, the image path of this
								// Resource once it hits 25%
								// health

	/**
	 * Initializes this Resource health to be healthMax, x-coordinate to be the
	 * one passed in, y-coordinate to be the one passed in, width, and height
	 * 
	 * @param x
	 *            an x-coordinate
	 * @param y
	 *            a y-coordinate
	 */
	Resource(int x, int y) {
		health = healthMax;
		xloc = x;
		yloc = y;
		xsize = resourceWidth;
		ysize = resourceHeight;
	}

	public static int getResourceWidth() {
		return resourceWidth;
	}

	public static int getResourceHeight() {
		return resourceHeight;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getExpireRate() {
		return expireRate;
	}

	public void setExpireRate(int expir) {
		expireRate = expir;
	}

	/**
	 * Reduces its health by expireRate and updates this image path in
	 * accordance to this Resource's percent health.
	 * 
	 * @see game2model.BasicObject#move()
	 */
	@Override
	public void move() {
		health -= expireRate;
		updateHealthImg();
	}

	/**
	 * Decreases this Resource's health by the damage of the wave being passed
	 * in. It takes 10 times more damage than the shoreline being hit by a wave
	 *
	 * @param w
	 *            a Wave whose damage will reduce this Resource's health
	 * @see Wave
	 */
	public void hitBy(Wave w) {
		health -= w.getDamage() * 10; // take 10x more damage compared to a wave
										// hitting the shore
	}

	/**
	 * A private function that updates the image file path of this Resource
	 * depending on the percentage of its health
	 */
	private void updateHealthImg() {
		if (health <= .25 * healthMax)
			imgPath = path25;
		else if (health <= .5 * healthMax)
			imgPath = path50;
		else if (health <= .75 * healthMax)
			imgPath = path75;
	}
}
