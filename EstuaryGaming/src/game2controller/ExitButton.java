package game2controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import game2model.MainShorelineDefense;
import game2model.ShoreBoard;

/**
 * @author VincentMangubat
 *
 */
public class ExitButton extends JButton {
	private static final long serialVersionUID = -5672056743434159234L;

	/**
	 * Initializes a transparent button on the top left of a passed frame with size 100.
	 * @param frame
	 */
	public ExitButton(JFrame frame) {
		this.setBounds(0, 0, 100, 100);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MainShorelineDefense.setExitClicked(true);
			}
		});
	}

}
