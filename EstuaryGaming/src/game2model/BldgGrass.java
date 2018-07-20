package game2model;

/**
 * @author Vincent Mangubat
 * @see Seagrass
 */
public class BldgGrass extends Building {
	/**
	 * Sets the picture path and sets its x coordinate to be in the middle (one
	 * half of the screen). The regenRate is also set
	 */
	BldgGrass() {
		imgPath = "src/images/grassbuilding.png";
		xloc = (ShoreBoard.getScreenwidth() / 2) - (xsize / 2);
		regenRate = 15;
	}
}
