package game2model;

/**
 * @author Vincent Mangubat
 * @see Wall
 */
public class BldgConcrete extends Building {
	/**
	 * Sets the picture path and sets its x coordinate to be on the right (four
	 * fifths of the screen width). Since Walls are always available, regenRate
	 * is set to 0.
	 */
	BldgConcrete() {
		imgPath = "src/images/concretebuilding.png";
		xloc = (ShoreBoard.getScreenwidth() * 4 / 5) - (xsize / 2);
		regenRate = 0;
	}

	/**
	 * Overrides the parent reduceAmmo() function, and if the shore does not
	 * enough health, then the user cannot grab anymore Walls. This is done by
	 * setting ammo to 0.
	 * 
	 * @see game2model.Building#reduceAmmo()
	 */
	@Override
	public void reduceAmmo() {
		if (ShoreBoard.getHealth() <= ShoreBoard.getHealthmax() / 10)
			ammo = 0;
	}
}
