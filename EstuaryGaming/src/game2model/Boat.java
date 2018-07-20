package game2model;

import java.util.Random;

/**
 * @author Vincent Mangubat
 *
 */
public class Boat extends BasicObject {
	private Random rand = new Random();
	private final static int boatXsize = 100; // width set by programmer, called
												// on by outside classes
	private final static int boatYsize = 60;// height set by programmer, called
											// on by outside classes

	private final int maxWavesToSpawn = 3;// Boats can spawn up to this many
											// waves
	private final int numWavesToSpawn; // Boats will spawn this many waves
	private final int[] wavesToSpawnXloc; // the x-coordinates of where this
											// Boat
											// will spawn Waves

	/**
	 * Initializes this object: The speed in the x direction will be a random
	 * number from 1 to 3. The number of wave it will spawn on the screen will
	 * be a random number from 1 to maxWavesToSpawn. It then creates an int
	 * array of x-coordinates of where this Boat will spawn waves. Its x-
	 * coordinate is set to the coordinate passed in. Its y-coordinate depends
	 * on the speed randomly generated. Boats will be in their own lane
	 * depending on their speed. Fast boats will be on top. Slow boats will be
	 * lower than faster boats.
	 * 
	 * @param x
	 *            an x coordinate to set this Boat's x-coordinate
	 */
	Boat(int x) {
		int speedwave = rand.nextInt(maxWavesToSpawn) + 1;
		xspeed = speedwave;
		numWavesToSpawn = maxWavesToSpawn - speedwave + 1;
		wavesToSpawnXloc = new int[numWavesToSpawn];
		for (int i = 0; i < numWavesToSpawn; i++)
			wavesToSpawnXloc[i] = rand.nextInt(ShoreBoard.getScreenwidth() - boatXsize);

		xloc = x;
		yloc = (3 - speedwave) * Boat.boatYsize; // rand.nextInt(yrange)
		xsize = boatXsize;
		ysize = boatYsize;
		imgPath = "src/images/boat-1.png";

		if (speedwave == 3)
			frametickmax = 7;
		else if (speedwave == 2)
			frametickmax = 11;
		else
			frametickmax = 16;
	}

	public int getNumWavesToSpawn() {
		return numWavesToSpawn;
	}

	public int[] getWavesToSpawnXloc() {
		return wavesToSpawnXloc;
	}

	public static int getBoatxsize() {
		return boatXsize;
	}

	public static int getBoatysize() {
		return boatYsize;
	}

	/**
	 * Overrides BasicObject's move() by increasing its x-coordinate by its
	 * x-speed. If this Boat's x-coordinate reaches an x-coordinate in
	 * wavesToSpawnXloc[], it will spawn a Wave by adding a Wave to the
	 * ShoreBoard's list of Waves. This move() also takes into account animated
	 * frames.
	 * 
	 * @see game2model.BasicObject#move()
	 */
	@Override
	public void move() {
		xloc += xspeed;
		for (int i = 0; i < numWavesToSpawn; i++)
			if (wavesToSpawnXloc[i] >= xloc && wavesToSpawnXloc[i] < xloc + xspeed)
				spawnWave();

		animate();
		imgPath = "src/images/boat-" + currentframe + ".png";
	}

	/**
	 * Creates a new Wave object based on this Boat's location and speed and
	 * places it in the ShoreBoard's wavelist
	 * 
	 * @see ShoreBoard
	 * @see Wave
	 */
	private void spawnWave() {
		ShoreBoard.getWavelist().add(new Wave(xloc, yloc, xspeed));
		// the yspeed of the new wave will be the same as the boat's xspeed
	}
}