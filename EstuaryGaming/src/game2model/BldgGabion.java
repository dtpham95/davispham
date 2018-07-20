package game2model;

/**
 * @author Vincent Mangubat
 * @see Gabion
 */
public class BldgGabion extends Building {
	/**
	 * Sets the picture path and sets its x coordinate to be on the left (one
	 * fifth of the screen). The regenRate is set to 5, which is the slowest out
	 * of the three buildings because Gabions are the best of the three
	 * Resources.
	 */
	BldgGabion() {
		imgPath = "src/images/gabionbuilding.png";
		xloc = (ShoreBoard.getScreenwidth() / 5) - (xsize / 2);
		regenRate = 5;
	}

}
