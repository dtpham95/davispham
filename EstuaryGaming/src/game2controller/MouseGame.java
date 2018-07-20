package game2controller;

import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import game2model.BasicObject;
import game2model.BldgConcrete;
import game2model.BldgGabion;
import game2model.BldgGrass;
import game2model.Boat;
import game2model.Building;
import game2model.Gabion;
import game2model.Ouch;
import game2model.Resource;
import game2model.Seagrass;
import game2model.ShoreBoard;
import game2model.Wall;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Vincent
 *
 *
 */
public class MouseGame extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 4150963441157902824L;
	private int middleX; // x-coordinate of the middle of an image
	private int middleY; // y-coordinate of the middle of an image
	private static boolean firstResourceAdded = false; // true if there has been
														// at least one resource
														// placed, false
														// displays the tutorial
														// text

	public static boolean isFirstResourceAdded() {
		return firstResourceAdded;
	}

	public static void setFirstResourceAdded(boolean firstResourceAdded) {
		MouseGame.firstResourceAdded = firstResourceAdded;
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
	}

	/**
	 * If user clicks & holds within a Buidling's area, a picture of the
	 * Resource being spawned by the Building is shown on the mouse cursor.
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		for (BasicObject tempBldg : ShoreBoard.getBldglist()) {
			if (((Building) tempBldg).getAmmo() > 0 && tempBldg.overlapsCoord(m.getX(), m.getY())) {
				ShoreBoard.setIsDragging(true);
				middleX = m.getX() - (tempBldg.getXsize() / 2);
				middleY = m.getY() - (tempBldg.getYsize() / 2);
				if (tempBldg instanceof BldgGabion)
					ShoreBoard.setResourceDragged(new Gabion(middleX, middleY));
				else if (tempBldg instanceof BldgGrass)
					ShoreBoard.setResourceDragged(new Seagrass(middleX, middleY, 1));
				else if (tempBldg instanceof BldgConcrete)
					ShoreBoard.setResourceDragged(new Wall(middleX, middleY));
			}
		}
	}

	/**
	 * If a Resource is being dragged as a player releases the mouse, and is
	 * correctly being placed within certain boundaries, the Resource being
	 * dragged is added to the corresponding BasicObject list in ShoreBoard. The
	 * picture anchored to the dragging mouse cursor also stops displaying.
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub
		BasicObject tempResDrag = ShoreBoard.getResourceDragged(); // the
																	// resource
																	// being
																	// dragged

		if (ShoreBoard.getIsPlaceable()) {// ensures mouse location is above
											// shoreline, below boats, within
											// screen, and not too close from
											// other Resources
			firstResourceAdded = true;
			ShoreBoard.addResource(tempResDrag);
			// the resource being dragged is added into the resource list

			if (tempResDrag instanceof Gabion)
				((Building) (ShoreBoard.getBldglist().get(0))).reduceAmmo();
			if (tempResDrag instanceof Seagrass)
				((Building) (ShoreBoard.getBldglist().get(1))).reduceAmmo();
			if (tempResDrag instanceof Wall) {
				((Building) (ShoreBoard.getBldglist().get(2))).reduceAmmo();
				ShoreBoard.getOuchlist()
						.add(new Ouch(tempResDrag.getX(), tempResDrag.getY() - (tempResDrag.getYsize() * 2 / 3)));
			}
		}

		ShoreBoard.setIsDragging(false);
		ShoreBoard.setIsPlaceable(false);

	}

	/**
	 * Updates the resource being dragged's x and y coordinates to follow the
	 * mouse location. The distance away from the shore affects the
	 * deteriorating rate of Seagrass if Seagrass is being dragged.
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent m) {
		BasicObject tempres = ShoreBoard.getResourceDragged();
		if (ShoreBoard.getIsDragging()) {

			ShoreBoard.setIsPlaceable(checkPlaceable(m));
			// ensure mouse location is above shoreline and below boats

			middleX = m.getX() - (tempres.getXsize() / 2);// x-coordinate of the
															// middle of the
															// Resource image
															// being dragged
			middleY = m.getY() - (tempres.getYsize() / 2);// y-coordinate of the
															// middle of the
															// Resource image
															// being dragged
			tempres.setX(middleX);
			tempres.setY(middleY);

			if (ShoreBoard.getResourceDragged() instanceof Seagrass) {
				int expireRateMinimum = 10; // grass must at least decay at this
											// rate
				int expireRateRange = 15; // up to this number can be added to
											// the decay rate depending on
											// distance away from shore
				double dynamicGrassExpireRate = (expireRateMinimum
						+ (expireRateRange * (1 - (1.0 * middleY / ShoreBoard.getShoreborderyloc())))); // decay
																										// rate
																										// depending
																										// on
																										// distance
																										// away
																										// from
																										// shore
				ShoreBoard.setResourceDragged(new Seagrass(middleX, middleY, (int) dynamicGrassExpireRate));
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent m) {
		// TODO Auto-generated method stub
	}

	/**
	 * Checks that a resource being dragged is allowed to be placed at its
	 * current location.
	 * 
	 * @param m
	 * @return false if a Resource is trying to be placed outside the frame, in
	 *         boat spawn, on the shore, on top of a Resource, or too close to a
	 *         Resource, true otherwise
	 */
	private Boolean checkPlaceable(MouseEvent m) {
		return checkWithinBoundary(m) && checkOverlapOrAdjacent();
	}

	/**
	 * Checks that a resource being dragged is within frame and not touching the
	 * shore and boat spawn.
	 * 
	 * @param m
	 * @return false if a Resource is trying to be placed outside the frame, in
	 *         boat spawn, or on the shore, true otherwise
	 */
	private Boolean checkWithinBoundary(MouseEvent m) {
		int mouseX = m.getX(); // x-coordinate of mouse
		int mouseY = m.getY(); // y-coordinate of mouse
		return mouseY < ShoreBoard.getShoreborderyloc() - (Resource.getResourceHeight() / 2)
				&& mouseY > 3 * Boat.getBoatysize() + (Resource.getResourceHeight() / 2)
				&& mouseX >= Resource.getResourceWidth() / 2
				&& mouseX < ShoreBoard.getScreenwidth() - (Resource.getResourceWidth() / 2);
	}

	/**
	 * Checks that a resource being dragged is not touching another Resource and
	 * is not too close to another Resource to make a row of them.
	 * 
	 * @return false if a Resource is trying to be placed while overlapping
	 *         another Resource or is too close side by side another Resource.
	 */
	private Boolean checkOverlapOrAdjacent() {
		BasicObject tempdragged = ShoreBoard.getResourceDragged();
		int dragX = tempdragged.getX(); // x-coordinate of dragged Resource to
										// check if its touching another
										// Resource
		int dragY = tempdragged.getY(); // its y-coordinate
		int dragWidth = tempdragged.getXsize(); // its width
		int dragHeight = tempdragged.getYsize(); // its height

		for (BasicObject tempresource : ShoreBoard.getReslist()) {
			int resX = tempresource.getX(); // x-coordinate of a Resource in the
											// water
			int resY = tempresource.getY(); // ycoordinate of a Resource in the
											// water
			int resWidth = tempresource.getXsize(); // width of a Resource in
													// the water
			int resHeight = tempresource.getYsize(); // height of a Resource in
														// the water

			// return false if two objects are overlapping
			if (tempdragged.isHitting(tempresource))
				return false;

			// return false of two objects are too close to each other
			double percentTooCloseSideBySide = 1.5; // how much is too close to
													// another Resource, 1.5
													// means 150% of a
													// Resource's width
			if (dragX <= resX + percentTooCloseSideBySide * resWidth
					&& resX <= dragX + percentTooCloseSideBySide * dragWidth && dragY <= resY + resHeight
					&& resY <= dragY + dragHeight)
				return false;
		}
		return true;
	}
}
