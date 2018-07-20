package game2model;

/**
 * @author Vincent Mangubat
 * @see Building
 * @see Resource
 * @see Boat
 * @see Wave
 * @see Ouch
 */

public abstract class BasicObject {
	protected int xloc; // x coordinate
	protected int yloc; // y coordinate
	protected int xsize; // width
	protected int ysize; // height
	protected int xspeed = 0; // how much to increase xloc during each tick
	protected int yspeed = 0; // how much to increase yloc during each tick
	protected String imgPath; // image path & file name

	// fields below are only used if animating
	protected int frametick = 1; // used to track what tick its on, increments
									// by 1 when ticked
	protected int frametickmax = 1; // if current frame reaches this threshold,
									// current frame resets to 0
	protected int numframes = 3; // the number of animation frames in an
									// animated image
	protected int currentframe = 1;// which animation frame this animated image
									// is currently showing. Ranges from 1 to
									// numframes

	public int getX() {
		return xloc;
	}

	public void setX(int x) {
		xloc = x;
	}

	public int getY() {
		return yloc;
	}

	public void setY(int y) {
		yloc = y;
	}

	public int getXsize() {
		return xsize;
	}

	public void setXsize(int xsize) {
		xsize = this.xsize;
	}

	public int getYsize() {
		return ysize;
	}

	public void setYsize(int ysize) {
		ysize = this.ysize;
	}

	public int getXspeed() {
		return xspeed;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public int getYspeed() {
		return yspeed;
	}

	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String path) {
		imgPath = path;
	}

	public void setImg(String path) {
		imgPath = path;
	}

	/**
	 * Checks to see if this object is touching the object being passed in.
	 * 
	 * @param obj
	 *            the BasicObject being checked to see if it's touching
	 * @return true if this BasicObject and the BasicObject being passed in the
	 *         function are touching, false otherwise
	 */
	public boolean isHitting(BasicObject obj) {
		return (withinX(obj) && (withinY(obj)));
	}

	/**
	 * @param obj
	 *            the BasicObject being checked to see if it's touching
	 * @return true if this BasicObject's xloc to xloc + xsize range are
	 *         touching obj's xloc to xloc+xsize range
	 */
	private boolean withinX(BasicObject obj) {
		return (xloc + xsize > obj.xloc && xloc < obj.xloc + obj.xsize);
	}

	/**
	 * @param obj
	 *            the BasicObject being checked to see if it's touching
	 * @return true if this BasicObject's yloc to yloc + ysize range are
	 *         touching obj's yloc to yloc + ysize range
	 */
	private boolean withinY(BasicObject obj) {
		return (yloc + ysize > obj.yloc && yloc < obj.yloc + obj.ysize);
	}

	/**
	 * Checks to see if this BasicObject is touching the x and y coordinates
	 * being passed in. This is mainly used to see if a mouse's x and y
	 * locations are touching this BasicObject.
	 * 
	 * @param mousex
	 *            an x coordinate
	 * @param mousey
	 *            a y coordinate
	 * @return true if the x and y coordinate being passed is touching this
	 *         BasicObject's
	 */
	public boolean overlapsCoord(int mousex, int mousey) {
		return (mousex >= xloc && mousex <= xloc + xsize && mousey >= yloc && mousey <= yloc + ysize);
	} // mainly for use in Mouse.java

	/**
	 * Determines what happens to this BasicObject during each tick.
	 */
	protected abstract void move();

	/**
	 * Used to tick the animation variables of this BasicObject. Every time
	 * frametick reaches frametickmax, frametick resets to 1 and currentframe
	 * increments by 1.
	 */
	protected void animate() {
		frametick = (frametick + 1) % frametickmax;
		if (frametick == 0) {
			currentframe = (currentframe + 1) % numframes + 1;
		}
	}
}
