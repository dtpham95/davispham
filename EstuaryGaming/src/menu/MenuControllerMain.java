package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import game1model.Main;
import game2model.MainShorelineDefense;
import game3model.MainStoryCube;

public class MenuControllerMain {
	private static int gameToPlay;

	public static void main(String[] args) throws InterruptedException {
		gameToPlay = 0;

		MenuView menu = new MenuView();
		JFrame frame = new JFrame("Menu");
		frame.getContentPane().add(new MenuView());
		frame.add(menu);
		frame.setSize(menu.screenWidth, menu.screenHeight);
		frame.setVisible(true);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		int bwidth = 262;
		int bheight = 85;

		JButton game1 = new JButton("Game1");
		game1.setBounds(221, 157, bwidth, bheight);
		frame.add(game1);
		game1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameToPlay = 1;
			}
		});

		JButton game2 = new JButton("Game2");
		game2.setBounds(221, 276, bwidth, bheight);
		frame.add(game2);
		game2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameToPlay = 2;
			}
		});

		JButton game3 = new JButton("Game3");
		game3.setBounds(221, 396, bwidth, bheight);
		frame.add(game3);
		game3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameToPlay = 3;
			}
		});

		while (true) {
			if (gameToPlay == 1) {
				frame.setVisible(false);
				Main.main(args);
				frame.setVisible(true);
				frame.toFront();
				gameToPlay = 0;
				System.out.println("test0");
			} else if (gameToPlay == 2) {
				frame.setVisible(false);
				new MainShorelineDefense();
				frame.setVisible(true);
				frame.toFront();
				gameToPlay = 0;
			} else if (gameToPlay == 3) {
				frame.setVisible(false);
				MainStoryCube.main(args);
				frame.setVisible(true);
				frame.toFront();
				gameToPlay = 0;
			}
			frame.repaint();
		}
	}
}
