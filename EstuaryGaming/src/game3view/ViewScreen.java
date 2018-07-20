package game3view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game3model.Board;
import game3model.Cube;
import game3model.InputBox;

/**
 * 
 * @author Al Cooper, Ryan Gray, Vincent Mangubat, Ryan Wang, Davis Pham
 *
 */

public class ViewScreen extends JPanel {
	
	Random rand = new Random();
	
	Font f40; // Font with size 40
	Font f50; // Font with size 50
	BufferedImage[] images = new BufferedImage[22]; //array of BufferedImages used for the game
	
	/**
	 * calls createImage(), which buffers images into images
	 */
	public ViewScreen(){
		createImage();
	}
	
	/**
	 * Paints certain images depending on the step field that belongs to 
	 * Board.java. Game progresses as step increases, and paint different steps.
	 * @param g
	 */
	public void paint(Graphics g) {
		
		BufferedImage background = images[20];
		
		if (Board.step > 0){
			background = images[0];
		}
		else{
			background = images[20];
		}
		
		g.drawImage(background, 0, 0, new Color(0, 0, 0, 0), this);
		
		g.setFont(f40);
		
		g.drawImage(images[21], 0, 0,100, 100, this);
		
		
		switch(Board.step){
		case 0:
			g.drawRect(950, 555, 300, 100);
			break;
		case 1:
			g.setColor(Color.WHITE);
			g.fillRect((Board.screenWidth/10), 20, 800, 60);
			g.setColor(Color.BLACK);
			g.drawRect((Board.screenWidth/10), 20, 800, 60);
			g.drawString("Add/Minus How Many Cubes to Use", (Board.screenWidth / 10), 70);
			myDrawChooseNum(g);
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.fillRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.setColor(Color.BLACK);
			g.drawRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.drawString("Click to Roll", (Board.screenWidth / 2) - 150, 70);
			myDrawInput(g, Board.inputArr);
			myDrawList(g, Board.cubeArr);
			break;
		case 3:
			g.setColor(Color.RED);
			g.fillRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.setColor(Color.BLACK);
			g.drawRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.drawString("Click to Stop", (Board.screenWidth / 2) - 150, 70);			
			randomImg(Board.cubeArr);		
			myDrawInput(g, Board.inputArr);
			myDrawList(g, Board.cubeArr);
			break;
		case 4:
			checkUnique();
		case 5:
			g.setFont(f50);
			g.drawString(" Now DRAG!", (Board.screenWidth / 2) - 140, 70);
			g.drawString("Drag here:", Board.screenWidth/9, 340);
			g.setColor(Color.WHITE);
			g.fillRect(400, 600, 650, 100);
			g.setColor(Color.BLACK);
			g.drawString("Done? Type Your Story!", 415, 670);
			g.drawRect(400, 600, 650, 100);
			myDrawInput(g, Board.inputArr);
			myDrawList(g, Board.cubeArr);
			break;
		case 7:
			g.setColor(Color.WHITE);
			g.fillRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.setColor(Color.BLACK);
			g.drawRect((Board.screenWidth / 2) - 150, 10, 310, 100);
			g.drawString(" Start over",(Board.screenWidth / 2) - 150, 70);
			g.setColor(Color.BLACK);
			if(Board.story.length() > 50){
				String story1 = Board.story.substring(0, 50) + "-";
				String story2 = Board.story.substring(50);
				g.drawString(story1, 100, 200);
				g.drawString(story2, 100, 240);
				
			}
			else
				g.drawString(Board.story, 100, 200);
			myDrawList(g, Board.cubeArr);
			break;
		default: myDrawList(g, Board.cubeArr);
		} 
	}
	
	/**
	 * Paints the boxes and images when the player
	 * selects number of cubes
	 * @param g
	 */
	public void myDrawChooseNum(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(100, 100, 100, 100);
		g.fillRect(300, 100, 100, 100);
		g.fillRect(100, 250, 300, 100);
		g.setColor(Color.BLACK);
		g.drawRect(100, 100, 100, 100);
		g.drawRect(300, 100, 100, 100);
		g.drawRect(100, 250, 300, 100);
		g.drawString("-", 135, 165);
		g.drawString("+", 335, 165);
		g.drawString("OK", 215, 315);
		g.drawString("We Have " + String.valueOf(Board.getNumOfCubes() + " Cubes Now"), 500, 250);
	}
	
	/**
	 * Paints each Cube in cubeArr using their img field to retrieve
	 * that certain image from the Buffered Image array.
	 * @param g
	 * @param cubeArr
	 */
	public void myDrawList(Graphics g, Cube[] cubeArr) {
		for (Cube cube : cubeArr) {
			BufferedImage tempImg = images[cube.getImg()];
			g.drawImage(tempImg, cube.getX(), cube.getY(), cube.getXsize(), cube.getYsize(), this);

		}
	}
	
	/**
	 * Paints each InputBox in inputArr as dark gray boxes
	 * @param g
	 * @param inputArr
	 */
	public void myDrawInput(Graphics g, InputBox[] inputArr){
		for (InputBox input : inputArr) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(input.getX(), input.getY(), input.getXsize(), input.getYsize());
		}
	}
	
	/**
	 * Method is called in step 3 when the player "rolls" through
	 * images, this generates the slot machine like effect.
	 * @param cubeArr
	 * 				Array of cubes that are being randomized
	 */
	public void randomImg(Cube[] cubeArr){
		for(Cube cube : cubeArr){
			cube.img = rand.nextInt(15) + 1;
		}
	}
	
	/**
	 * Buffers every image and puts it in the images[]
	 */
	private void createImage() {

		try{
			images[0] = ImageIO.read(new File("images/Backgrounds/minigame_background.png"));//background
			
			images[1] = ImageIO.read(new File("images/Animals/bluecrab_0.png"));
			images[2] = ImageIO.read(new File("images/Animals/clam_back_1.png"));
			images[3] = ImageIO.read(new File("images/Animals/fish_bass_right.png"));
			images[4] = ImageIO.read(new File("images/Animals/horseshoe_crab_right_1.png"));
			images[5] = ImageIO.read(new File("images/Animals/fish_catfish_right_0.png"));

			images[6] = ImageIO.read(new File("images/Objects/net.png"));
			images[7] = ImageIO.read(new File("images/Objects/trashbag.png"));
			images[8] = ImageIO.read(new File("images/Objects/crabtrap.png"));
			images[9] = ImageIO.read(new File("images/Objects/dirtyvessel.png"));
			images[10] = ImageIO.read(new File("images/Objects/turd.png"));

			images[11] = ImageIO.read(new File("images/Plants/cordgrass.png"));
			images[12] = ImageIO.read(new File("images/Plants/blazingstarplant.png"));
			images[13] = ImageIO.read(new File("images/Plants/sadmilkweed.png"));
			images[14] = ImageIO.read(new File("images/People and Humanoids/captain_estuary_punch.png"));
			images[15] = ImageIO.read(new File("images/People and Humanoids/volunteer_grayshirt_pickup_0.png"));
			
			images[16] = ImageIO.read(new File("images/dice1.png"));
			images[17] = ImageIO.read(new File("images/dice3.png"));
			images[18] = ImageIO.read(new File("images/dice6.png"));
			images[19] = ImageIO.read(new File("images/0.png"));
			images[20] = ImageIO.read(new File("images/StoryCube_Beginning_Pic1.png"));
			images[21] = ImageIO.read(new File("src/images/exit.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks to see if each image of the cubes are unique.
	 * This worked when we only had 4 cubes to worry about but
	 * now we have an adjustable amount so this method doesn't
	 * really work.
	 */
	public void checkUnique(){
		boolean duplicates = true;
/*		while(duplicates){
			randomImg(Board.cubeArr);
			for (int j = 0; j < Board.cubeArr.length; j++)
				  for (int k = j + 1; k < Board.cubeArr.length; k++)
				    if (k != j && Board.cubeArr[k] == Board.cubeArr[j])
				      duplicates = true;
				    else
				    	duplicates = false;
		}
*/		while(Board.cubeArr[0].img == Board.cubeArr[1].img || Board.cubeArr[0].img == Board.cubeArr[2].img || Board.cubeArr[0].img == Board.cubeArr[3].img || Board.cubeArr[1].img == Board.cubeArr[2].img || Board.cubeArr[1].img == Board.cubeArr[3].img || Board.cubeArr[2].img == Board.cubeArr[3].img){
			randomImg(Board.cubeArr);
		}
	}
	
	/**
	 * Creates the fonts and set it to the f40 and f50 fields.
	 */
	public void addFont() {
		try {
		    //create the font to use. Specify the size!
		     
		    f40 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(40f);
		    f50 = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")).deriveFont(50f);
		    
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/pixel.ttf")));
		} catch (IOException e) {
			System.out.print("bad");
		} catch(FontFormatException e) {
		    System.out.print("bad");
		}
	}
	
}
