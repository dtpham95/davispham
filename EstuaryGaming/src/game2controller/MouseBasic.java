package game2controller;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Vincent Mangubat
 *
 */
public class MouseBasic extends JPanel implements MouseListener {
	private static final long serialVersionUID = -4448794386273051621L;
	private Boolean clicked;

	/**
	 * Initializes that this JPanel has not been clicked.
	 */
	public MouseBasic() {
		clicked = false;
	}

	public Boolean getClicked() {
		return clicked;
	}

	public void setClicked(Boolean clicked) {
		this.clicked = clicked;
	}

	/**
	 * Establishes that this has been clicked
	 *
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		clicked = true;
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub

	}

}
