package game2model;

/**
 * @author Vincent Mangubat
 *
 */
public class Wave extends BasicObject {
	private final int userSettingDamage = 1500; // default damage set by
												// programmer
	private final int maxFramesSpeed1 = 12;
	private final int maxFramesSpeed2 = 8;
	private final int maxFramesSpeed3 = 5;
	private int damage; // how much this wave will hurt the shoreline or
						// Resource

	/**
	 * Initializes this Wave. The speed in the y direction, yspeed, is set to
	 * the speed being passed in, which is usually a Boat's x-speed. The size
	 * and damage of the wave is bigger when the speed is faster. The variable
	 * frametickmax is lower when the yspeed is faster, meaning the animation
	 * frames will change more frequently than a slow wWave.
	 * 
	 * @param x
	 *            an x-coordinate
	 * @param y
	 *            a y-coordinate
	 * @param boatspeed
	 *            the x-speed of a moving Boat
	 */
	public Wave(int x, int y, int boatspeed) {
		xloc = x; // x-coordinate position
		yloc = y; // y-coordinate position
		yspeed = boatspeed; // the y-speed of this Wave will be a Boat's x-speed
							// being passed in

		xsize = 100 + (yspeed - 1) * 30;
		ysize = 60 + (yspeed - 1) * 20;
		imgPath = "src/images/wave-1.png";
		damage = yspeed * userSettingDamage;

		if (yspeed == 1)
			frametickmax = maxFramesSpeed1;
		else if (yspeed == 2)
			frametickmax = maxFramesSpeed2;
		else if (yspeed == 3)
			frametickmax = maxFramesSpeed3;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Override's BasicObject's move() by taking into account animation frames.
	 * Also increments its y-coordinate by the speed in the y-direction
	 * 
	 * @see game2model.BasicObject#move()
	 */
	@Override
	public void move() {
		frametick = (frametick + 1) % frametickmax;
		if (frametick == 0) {
			currentframe = (currentframe + 1) % numframes + 1;
			imgPath = "src/images/wave-" + currentframe + ".png";
		}
		yloc += yspeed;
	}

}
