package game2model;

/**
 * @author Vincent Mangubat
 *
 */
public class Seagrass extends Resource {

	/**
	 * Calls Resource's constructor, initializes the image path, expireRate, and
	 * frametickmax. The variable expireRate to later be overwritten in
	 * MouseGame.java
	 * 
	 * @param x
	 *            an x-coordinate
	 * @param y
	 *            a y-coordinate
	 */
	public Seagrass(int x, int y, int expire) {
		super(x, y);
		imgPath = "src/images/seagrass-1.png";
		expireRate = expire;
		frametickmax = 10;
	}

	/*
	 * Overwrite's Resource's move() by taking into account animation frames.
	 * 
	 * @see model.Resource#move()
	 */
	@Override
	public void move() {
		health -= expireRate;
		animate();
		if (health <= .25 * healthMax) {
			imgPath = "src/images/seagrass25-" + currentframe + ".png";
			frametickmax = 25;
		} else if (health <= .5 * healthMax) {
			imgPath = "src/images/seagrass50-" + currentframe + ".png";
			frametickmax = 20;
		} else if (health <= .75 * healthMax) {
			imgPath = "src/images/seagrass75-" + currentframe + ".png";
			frametickmax = 15;
		} else {
			imgPath = "src/images/seagrass-" + currentframe + ".png";
			// frametickmax is still 10
		}
	}
}
