package game3model;

/**
 * 
 * @author Al Cooper, Ryan Gray, Vincent Mangubat, Ryan Wang, Davis Pham
 *
 */
public class Cube {

	int xloc; //x-location of the cube object
	int yloc; //y-location of the cube object
	int xsize = 150; //the width of the cube object
	int ysize = 150; //the height of the cube object
	public int img; //integer to represent which index in a BufferedImage array
	public boolean canDrag = false; //boolean that allows the cube to be dragged or not
	
	public Cube(){
		
	}
	
	/**
	 * A Constructors that passes the parameters to set the fields
	 * @param xloc
	 * @param yloc
	 * @param img
	 */
	public Cube(int xloc, int yloc, int img) {
		this.xloc = xloc;
		this.yloc = yloc;
		this.img = img;
	}

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

	public void setImg(int img){
		this.img = img;
	}
	
	public int getImg(){
		return img;
	}
	/**
	 * Checks to see if this Cube is touching the x and y coordinates
	 * being passed in. This is mainly used to see if a mouse's x and y
	 * locations are touching this Cube.
	 * 
	 * @param mousex
	 *            an x coordinate
	 * @param mousey
	 *            a y coordinate
	 * @return true if the x and y coordinate being passed is touching this
	 *         Cube's
	 */
	public boolean overlapsCoord(int mousex, int mousey) {
		return (mousex >= xloc && mousex <= xloc + xsize && mousey >= yloc && mousey <= yloc + ysize);
	}
	
}
