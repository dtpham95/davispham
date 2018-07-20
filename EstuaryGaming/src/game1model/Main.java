package game1model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static boolean escPressed;

	public Main() throws InterruptedException {
		escPressed = false;
		JFrame frame = new JFrame("Crab Run");
		Game game = new Game();
		frame.add(game);
		frame.setSize(game.displayWidth, game.displayHeight);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Random rand = new Random();
		game.addFont();

		game.getImages();
		game.droughtTime = rand.nextInt(59) + 1;

		game.scb.readsE();
		game.scb.readsM();
		game.scb.readsH();
		while (escPressed == false) {
			game.createDrought(game.droughtTime);
			game.move();
			game.repaint();

			game.gameWon2();
			if (game.textBox == 1) {
				if (game.gameStart == 4) {
					game.textBox += 5;
					JFrame f = new JFrame("New High Score!");
					JTextField t1;
					t1 = new JTextField("(enter your name)");
					t1.setBounds(50, 75, 200, 30);
					f.add(t1);
					f.setSize(300, 200);
					f.setLayout(null);
					f.setVisible(true);
					t1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String x = t1.getText();
							Score s = new Score(game.time + (game.bc.getLife() * 5), x);
							game.scb.scores.add(s);
							Collections.sort(game.scb.scores);
							game.scb.scores.remove(5);
							game.scb.writesE();
							f.setVisible(false);
						}
					});
				}
				if (game.gameStart == 5) {
					game.textBox += 5;
					JFrame f = new JFrame("New High Score!");
					JTextField t1;
					t1 = new JTextField("(enter your name)");
					t1.setBounds(50, 75, 200, 30);
					f.add(t1);
					f.setSize(300, 200);
					f.setLayout(null);
					f.setVisible(true);
					t1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String x = t1.getText();
							Score s = new Score(game.time + (game.bc.getLife() * 5), x);
							game.scb.scoresM.add(s);
							Collections.sort(game.scb.scoresM);
							game.scb.scoresM.remove(5);
							game.scb.writesM();
							f.setVisible(false);
						}
					});
				}
				if (game.gameStart == 6) {
					game.textBox += 5;
					JFrame f = new JFrame("New High Score!");
					JTextField t1;
					t1 = new JTextField("(enter your name)");
					t1.setBounds(50, 75, 200, 30);
					f.add(t1);
					f.setSize(300, 200);
					f.setLayout(null);
					f.setVisible(true);
					t1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String x = t1.getText();
							Score s = new Score(game.time + (game.bc.getLife() * 5), x);
							game.scb.scoresH.add(s);
							Collections.sort(game.scb.scoresH);
							game.scb.scoresH.remove(5);
							game.scb.writesH();
							f.setVisible(false);
						}
					});
				}
			}
			Thread.sleep(10);
		}
		frame.setVisible(false);
		frame.dispose();
	}

	public static void main(String[] args) throws InterruptedException {
		new Main();
	}

}
