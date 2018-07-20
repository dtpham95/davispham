package game2model;

/**
 * @author Vincent Mangubat
 *
 */
public class Ouch extends BasicObject {
	private final int ouchWidth = 105;
	private final int ouchHeight = 30;
	private int timer;// how long this Ouch warning will appear

	/**
	 * @param x
	 * @param y
	 */
	public Ouch(int x, int y) {
		timer = 100;
		xloc = x;
		yloc = y;
		xsize = ouchWidth;
		ysize = ouchHeight;
		imgPath = "src/images/ouch.png";
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub
		timer--;
	}

}
