package game2model;

/**
 * @author Vincent Mangubat
 *
 */
public class Gabion extends Resource {
	/**
	 * Calls Resource's constructor then increases its size since Gabions
	 * should look bigger and better than the other two Resources. Its
	 * expireRate is set to 1, meaning its decays very slowly compare to the
	 * other Resources. The image paths are also set depending on health.
	 * 
	 * @param x
	 *            an x-coordinate
	 * @param y
	 *            a y-coordinate
	 */
	public Gabion(int x, int y) {
		super(x, y);
		xsize += xsize * .25;
		ysize += ysize * .25;
		expireRate = 1;
		imgPath = "src/images/gabion.png";
		path75 = "src/images/gabion75.png";
		path50 = "src/images/gabion50.png";
		path25 = "src/images/gabion25.png";

	}

	/**
	 * Overrides the Resource's move so that this Gabion only takes 5 times more
	 * damage of a Wave compared to the other resources that take 10 times a
	 * Wave's damage.
	 * 
	 * @see game2model.Resource#hitBy(game2model.Wave)
	 */
	@Override
	public void hitBy(Wave w) {
		health -= w.getDamage() * 5;
	}
}
