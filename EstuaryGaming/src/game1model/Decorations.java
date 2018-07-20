package game1model;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Decorations {
	int xPos;
	int yPos;
	Game game;
	BufferedImage plant = null;
	BufferedImage plant2 = null;
	BufferedImage plant3 = null;
	BufferedImage otherplant1 = null;
	BufferedImage otherplant2 = null;
	ArrayList<Plant> plants = new ArrayList<Plant>();
	ArrayList<OtherPlant> otherPlants = new ArrayList<OtherPlant>();
	ArrayList<Coral> corals = new ArrayList<Coral>();
	BufferedImage coral = null;
	BufferedImage coral2 = null;
	BufferedImage coral3 = null;
	
	
	/**
	 * Creates an instance of the Decorations class. Intitalizes the arrays of decorations.
	 * 
	 * @param game
	 */
	public Decorations(Game game) {
		this.game = game;
		getImages();
		plantArray();
		otherPlantArray();
		coralArray();
	}
	
	public class Plant {
		int xPos;
		int yPos;
		int picNum;
		int frameCount = 45;
		ArrayList<BufferedImage> plantImages = new ArrayList<BufferedImage>();
		
		
		/**
		 * Creates an instance of a plant. Gives the plant a random x position and a random y position.
		 */
		public Plant() {
			Random rand = new Random();
			xPos = rand.nextInt((3500) + 1) + 100;
			yPos = rand.nextInt((2000) + 1) + 100;
			
			picNum = rand.nextInt(45 + 1);
			plantAni();
		}
		
		/**
		 * Paints a plant. Animates the plant.
		 * 
		 * @param g {@link Graphics2D} object
		 */
		public void paintPlant(Graphics2D g) {
			picNum = (picNum + 1) % frameCount;
			g.drawImage(plantImages.get(picNum), xPos, yPos, 60, 90, null);
		}
		
		/**
		 * Creates an array of plant images to be used for animation.
		 */
		public void plantAni() {
			for (int i = 0; i < 45; i++) {
				if (i < 15) {
					plantImages.add(plant);
				} 
				else if (i < 30) {
					plantImages.add(plant2);
				}
				else {
					plantImages.add(plant3);
				}
			}
		}
	} // end Plant class

	public class OtherPlant {
		int xPos;
		int yPos;
		int orientation;
		
		/**
		 * Creates an instance of an other plant. Gives the plant a random x position and a random y position.
		 */
		public OtherPlant() {
			Random rand = new Random();
			xPos = rand.nextInt((3500) + 1) + 100;
			yPos = rand.nextInt((2000) + 1) + 100;
			
			orientation = rand.nextInt(2 + 1);
		}
		
		/**
		 * Paints an other plant.
		 * 
		 * @param g Graphics2D object
		 */
		public void paintPlant(Graphics2D g) {
			if (orientation == 1) {
			g.drawImage(otherplant1, xPos, yPos, 33, 47, null);
			}
			if (orientation == 2) {
			g.drawImage(otherplant2, xPos, yPos, 33, 47, null);
			}
		}
	} 
	
	public class Coral {
		int xPos;
		int yPos;
		int picNum;
		int frameCount = 45;
		ArrayList<BufferedImage> coralImages = new ArrayList<BufferedImage>();
		
		
		/**
		 * Creates an instance of a coral.  Gives the coral a random x position and a random y position.
		 */
		public Coral() {
			Random rand = new Random();
			xPos = rand.nextInt((3500) + 1) + 100;
			yPos = rand.nextInt((2000) + 1) + 100;
			
			picNum = rand.nextInt(45 + 1);
			coralAni();
		}
		
		/**
		 * Paints the coral. Uses the array of images to animate the coral.
		 * 
		 * @param g Graphics2D object
		 */
		public void paintCoral(Graphics2D g) {
			picNum = (picNum + 1) % frameCount;
			g.drawImage(coralImages.get(picNum), xPos, yPos, 50, 50, null);
		}
		
		/**
		 * Creates an array of coral images to be used for animation.
		 */
		public void coralAni() {
			for (int i = 0; i < 45; i++) {
				if (i < 15) {
					coralImages.add(coral);
				} 
				else if (i < 30) {
					coralImages.add(coral2);
				}
				else {
					coralImages.add(coral3);
				}
			}
		}
	}
	
	
	
	/**
	 * Paints the three lists of decorations.
	 * 
	 * @param g {@link Graphics2D} object
	 */
	public void paint(Graphics2D g) {
		
		
		for (int i = 0; i < plants.size(); i++) {
			plants.get(i).paintPlant(g);
		}
		for (int i = 0; i < otherPlants.size(); i++) {
			otherPlants.get(i).paintPlant(g);
		}
		for (int i = 0; i < corals.size(); i++) {
			corals.get(i).paintCoral(g);
		}
	}
	
	/**
	 * Obtains the images necessary for the decorations.
	 */
	public void getImages() {
		try {
			plant = ImageIO.read(new File("src/images/plant1.png"));
			plant2 =ImageIO.read(new File("src/images/plant2.png"));
			plant3 = ImageIO.read(new File("src/images/plant3.png"));
			otherplant1= ImageIO.read(new File("src/images/OtherPlant1.png"));
			otherplant2 = ImageIO.read(new File("src/images/OtherPlant2.png"));
			coral = ImageIO.read(new File("src/images/coral1.png"));
			coral2 =ImageIO.read(new File("src/images/Coral2.png"));
			coral3 = ImageIO.read(new File("src/images/Coral3.png"));
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Creates a plant array.
	 */
	public void plantArray() {
		for (int i = 0; i < 20; i++) {
			plants.add(new Plant());
		}
	}
	
	/**
	 * Creates an other plant array.
	 */
	public void otherPlantArray() {
		for (int i = 0; i < 20; i++) {
			otherPlants.add(new OtherPlant());
		}
	}
	
	/**
	 * Creates a coral array.
	 */
	public void coralArray() {
		for (int i = 0; i < 15; i++) {
			corals.add(new Coral());
		}
	}
}
