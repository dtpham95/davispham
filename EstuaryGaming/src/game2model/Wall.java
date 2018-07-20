package game2model;

/**
 * @author Vincent Mangubat
 *
 */
public class Wall extends Resource {
	/**
	 * Calls Resource's constructor then initializes the expireRate and image
	 * paths depending on health. This expireRate is faster out of the three
	 * Resources.
	 * 
	 * @param x
	 * @param y
	 */
	public Wall(int x, int y) {
		super(x, y);
		imgPath = "src/images/wall.png";
		expireRate = 25;
		path75 = "src/images/wall75.png";
		path50 = "src/images/wall50.png";
		path25 = "src/images/wall25.png";
	}
}
