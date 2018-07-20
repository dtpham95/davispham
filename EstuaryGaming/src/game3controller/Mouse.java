package game3controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import game3model.Board;
import game3model.Cube;
import game3model.InputBox;

public class Mouse extends JPanel implements MouseListener, MouseMotionListener {

	int middleX; // x-coordinate of the middle of an image/cube
	int middleY; // y-coordinate of the middle of an image/cube
	public boolean canDrag = false; // is true when the player is able to drag
	
	/**
	 * Updates the cube's x and y coordinate to follow the 
	 * mouse's location
	 * @param e
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (Board.getIsDragging()) {
			middleX = e.getX() - (Board.cubeDragged.getXsize() / 2);
			middleY = e.getY() - (Board.cubeDragged.getYsize() / 2);
			Board.cubeDragged.setX(middleX);
			Board.cubeDragged.setY(middleY);
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * First checks if the mouse's location is overlapping with a cube object.
	 * Then when the user presses and holds, it sets the cube to the
	 * mouse location
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		for (Cube cube : Board.cubeArr) {
			if (cube.overlapsCoord(e.getX(), e.getY()) && cube.canDrag == true) {
				Board.setIsDragging(true);
				middleX = e.getX() - (cube.getXsize() / 2);
				middleY = e.getY() - (cube.getYsize() / 2);
				Board.setCubeDragged(cube);
			}
		}
		
	}

	/**
	 * When mouse is released, the cube is then placed at that location,
	 * if the mouse overlaps with any of the InputBoxes, then the Cube
	 * changes its location to match that InputBox.
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
		if(Board.isDragging){
			for(InputBox box : Board.inputArr){
				if(box.overlapsCoord(e.getX(), e.getY())){
					Board.cubeDragged.setX(box.getX());
					Board.cubeDragged.setY(box.getY());
//					Board.step++;
					Board.cubeDragged.canDrag = false;
				}
			}
		}
		Board.setIsDragging(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
