package game3model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Al Cooper, Ryan Gray, Vincent Mangubat, Ryan Wang, Davis Pham
 *
 */
public class Board {
	
	Random rand = new Random();
	
	public final static int screenWidth = 1400; //width of the game screen
	public final static int screenHeight = 800; //height of the game screen
	
	public static Cube[] cubeArr = new Cube[9]; //Array of 9 Cubes
	public static InputBox[] inputArr = new InputBox[9]; //Array of 9 InputBox
	public static Cube cubeDragged; //Cube being dragged by mouse
	public static Boolean isDragging = false; //true if player is holding down on mouse over Cube
	public static int step = 0; //step counter to progress the game in an order
	public static String story = ""; //Input string from the user that gets printed on the screen
	public static int numOfCubes = 4; //Number of Cubes that are actually being used to play, ranges from 4-9
	public static boolean gameOver = false; //True when player clicks exit button
	
	/**
	 * Initializes the game board and fills in the cubeArr with Cubes
	 * and inputArr with InputBoxes. Calls reset(Cube[],InputBox[]).
	 */
	Board(){
		cubeArr[0] = new Cube();
		cubeArr[1] = new Cube();
		cubeArr[2] = new Cube();
		cubeArr[3] = new Cube();
		cubeArr[4] = new Cube();
		cubeArr[5] = new Cube();
		cubeArr[6] = new Cube();
		cubeArr[7] = new Cube();
		cubeArr[8] = new Cube();
		
		
		inputArr[0] = new InputBox();
		inputArr[1] = new InputBox();
		inputArr[2] = new InputBox();
		inputArr[3] = new InputBox();
		inputArr[4] = new InputBox();
		inputArr[5] = new InputBox();
		inputArr[6] = new InputBox();
		inputArr[7] = new InputBox();
		inputArr[8] = new InputBox();
		
		isDragging = false;
		step = 0;
		story = "";
		numOfCubes = 4;
		gameOver = false;
		
		reset(cubeArr, inputArr);
		
	}
	
	public static int getNumOfCubes() {
		return numOfCubes;
	}

	public static void setNumOfCubes(int numOfCubes) {
		Board.numOfCubes = numOfCubes;
	}

	public static void setCubeDragged(Cube cube) {
		cubeDragged = cube;
	}
	
	public static Cube getCutDragged() {
		return cubeDragged;
	}
	
	public static void setIsDragging(Boolean b) {
		isDragging = b;
	}

	public static Boolean getIsDragging() {
		return isDragging;
	}
	
	/**
	 * Sets the cubes and input boxes at the appropriate locations on the screen
	 * depending on how many cubes are selected. Image 19 in our BufferedImage array
	 * is the default "?" image.
	 * @param cubeArr
	 * 				Array of Cubes
	 * @param inputArr
	 * 				Array of InputBoxes
	 */
	public void reset(Cube[] cubeArr, InputBox[] inputArr){
		cubeArr[0].setX((screenWidth/numOfCubes)-160);
		cubeArr[0].setY(120);
		cubeArr[1].setX(2*(screenWidth/numOfCubes)-160);
		cubeArr[1].setY(120);
		cubeArr[2].setX(3*(screenWidth/numOfCubes)-160);
		cubeArr[2].setY(120);
		cubeArr[3].setX(4*(screenWidth/numOfCubes)-160);
		cubeArr[3].setY(120);
		cubeArr[4].setX(5*(screenWidth/numOfCubes)-160);
		cubeArr[4].setY(120);
		cubeArr[5].setX(6*(screenWidth/numOfCubes)-160);
		cubeArr[5].setY(120);
		cubeArr[6].setX(7*(screenWidth/numOfCubes)-160);
		cubeArr[6].setY(120);
		cubeArr[7].setX(8*(screenWidth/numOfCubes)-160);
		cubeArr[7].setY(120);
		cubeArr[8].setX(9*(screenWidth/numOfCubes)-160);
		cubeArr[8].setY(120);
		
		cubeArr[0].img = 19;
		cubeArr[1].img = 19;
		cubeArr[2].img = 19;
		cubeArr[3].img = 19;
		cubeArr[4].img = 19;
		cubeArr[5].img = 19;
		cubeArr[6].img = 19;
		cubeArr[7].img = 19;
		cubeArr[8].img = 19;
		
		inputArr[0].setX((screenWidth/numOfCubes)-160);
		inputArr[0].setY(340);
		inputArr[1].setX(2*(screenWidth/numOfCubes)-160);
		inputArr[1].setY(340);
		inputArr[2].setX(3*(screenWidth/numOfCubes)-160);
		inputArr[2].setY(340);
		inputArr[3].setX(4*(screenWidth/numOfCubes)-160);
		inputArr[3].setY(340);
		inputArr[4].setX(5*(screenWidth/numOfCubes)-160);
		inputArr[4].setY(340);
		inputArr[5].setX(6*(screenWidth/numOfCubes)-160);
		inputArr[5].setY(340);
		inputArr[6].setX(7*(screenWidth/numOfCubes)-160);
		inputArr[6].setY(340);
		inputArr[7].setX(8*(screenWidth/numOfCubes)-160);
		inputArr[7].setY(340);
		inputArr[8].setX(9*(screenWidth/numOfCubes)-160);
		inputArr[8].setY(340);
	}
	
	/**
	 * Is called when player reaches step 6, or when the player
	 * is ready to type in their story. Asks the user
	 * to enter their story and sets field story to the input.
	 */
	public static void askStory(){
		if(step == 6){
			JFrame frame2 = new JFrame("Type Story");
			story = JOptionPane.showInputDialog(frame2, "What's your story?");
			step++;
			}
		
	}

}
