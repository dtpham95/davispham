package game3model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game3controller.Mouse;
import game3view.ViewScreen;

/**
 * 
 * @author Al Cooper, Ryan Gray, Vincent Mangubat, Ryan Wang, Davis Pham
 */
public class MainStoryCube {
	
	public MainStoryCube() throws InterruptedException{
		//creates Board and Screen
		Board gameboard = new Board();
		ViewScreen gamescreen = new ViewScreen();
		//adds fonts into the Screen
		gamescreen.addFont();
		
		//sets up the frame
		JFrame frame = new JFrame("Story Cube");
		frame.getContentPane().add(new ViewScreen());
		frame.add(gamescreen);
		frame.setSize(Board.screenWidth, Board.screenHeight);
		frame.setVisible(true);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		int bwidth = 300; // button width
		int bheight = 100; // button height
		JButton rollB = new JButton("Click to Roll"); // button to roll and stop
		rollB.setBounds((Board.screenWidth / 2) - (bwidth / 2), 10, bwidth, bheight);
		frame.add(rollB); // adds to frame
		rollB.setEnabled(false); // is set to true at appropriate step

		int ButtonSideLength = 100;
		JButton exit = new JButton("exit"); // exit button
		JButton start = new JButton("start"); // start button
		JButton plus = new JButton("plus"); // add cubes button
		JButton minus = new JButton("minus"); // subtract cubes button
		JButton ok = new JButton("OK"); // ok to progress button
		JButton typeStory = new JButton("typeStory"); // button when player is ready to type
		// sets buttons at specific location
		exit.setBounds(0, 0, 100, 100);
		start.setBounds(950, 555, bwidth, bheight);
		plus.setBounds(300, 100, ButtonSideLength, ButtonSideLength);
		minus.setBounds(100, 100, ButtonSideLength, ButtonSideLength);
		ok.setBounds(100, 250, ButtonSideLength * 3, ButtonSideLength);
		typeStory.setBounds(400, 600, 650, ButtonSideLength);
		// adds all buttons onto the frame
		frame.add(exit);
		frame.add(plus);
		frame.add(minus);
		frame.add(ok);
		frame.add(typeStory);
		frame.add(start);
		//initiates which buttons are enabled or not
		exit.setEnabled(true);
		start.setEnabled(true);
		plus.setEnabled(false);
		minus.setEnabled(false);
		ok.setEnabled(false);
		typeStory.setEnabled(false);
		
		/**
		 * Exit button terminates the program when clicked
		 */
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameboard.gameOver = true;
			}
		});
		
		/**
		 * Adds to the step counter and enables
		 * the next set of buttons that are available 
		 * to be pressed
		 */
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameboard.step++;
				start.setEnabled(false);
				plus.setEnabled(true);
				minus.setEnabled(true);
				ok.setEnabled(true);
			}
		});
		
		/**
		 * Increaes the number of cubes if the current number of cubes is 
		 * less than 9
		 */
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if ((gameboard.getNumOfCubes() > 3) && (gameboard.getNumOfCubes() < 9)) {
					int numOfCubes = gameboard.getNumOfCubes();
					numOfCubes++;
					gameboard.setNumOfCubes(numOfCubes);
					gameboard.reset(gameboard.cubeArr, gameboard.inputArr);
				}
			}
		});
		
		/**
		 * Decreases the number of cubes if the current number of cubes is
		 * greater than 4
		 */
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if ((gameboard.getNumOfCubes() > 4) && (gameboard.getNumOfCubes() < 10)) {
					int numOfCubes = gameboard.getNumOfCubes();
					numOfCubes--;
					gameboard.setNumOfCubes(numOfCubes);
					gameboard.reset(gameboard.cubeArr, gameboard.inputArr);
				}
			}
		});
		
		/**
		 * A progress button that adds to step counter and 
		 * enables certain buttons when the player is ready to
		 * continue
		 */
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if ((gameboard.getNumOfCubes() > 3) && (gameboard.getNumOfCubes() < 10)) {
					gameboard.step++;
					plus.setEnabled(false);
					minus.setEnabled(false);
					ok.setEnabled(false);
					rollB.setEnabled(true);
				}
			}
		});
		
		/**
		 * When clicked, step counter increases which prompts the user
		 * to input a story
		 */
		typeStory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gameboard.step = 6;
				typeStory.setEnabled(false);
			}
		});
		
		//creates JPanel to detect mouse
		JPanel jpan = new JPanel();
		Mouse mouselisten = new Mouse();
		jpan.setLocation(0, 0);
		jpan.setSize(Board.screenWidth, Board.screenHeight);
		jpan.addMouseListener(mouselisten);
		jpan.addMouseMotionListener(mouselisten);
		//adds JPanel
		frame.add(jpan);

		/**
		 * Button that begins the slot machine like effect for the cubes.
		 * Same button to stop the the images from rolling.
		 * Progresses the step counter and enables the typeStory button.
		 */
		rollB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				if (gameboard.step < 5) {
					gameboard.step++;
				}
				if (gameboard.step == 4) {
					for (Cube cube : Board.cubeArr) {
						if (cube.canDrag == false) {
							cube.canDrag = true;
						}
					}
					typeStory.setEnabled(true);
				}
				if (gameboard.step == 6) {
					typeStory.setEnabled(false);
				}
				if (gameboard.step >= 7) {
					gameboard.step = 1;
					gameboard.numOfCubes = 4;
					gameboard.reset(gameboard.cubeArr, gameboard.inputArr);
					plus.setEnabled(true);
					minus.setEnabled(true);
					ok.setEnabled(true);
					rollB.setEnabled(false);
				}
			}
		});
		
		//continually paints the the game
		while (gameboard.gameOver == false) {
			gameboard.askStory();
			frame.repaint();
			Thread.sleep(0);
		}
		frame.setVisible(false);
		frame.dispose();
	}

	public static void main(String[] args) throws InterruptedException {
		new MainStoryCube();

	}

}
