package game1model;
import java.awt.Graphics2D;
import java.util.*;


public class Enemies {
	ArrayList<Predator> preds = new ArrayList<Predator>();
	Game game;
	
	/**
	 * Creates an instance of an enemies class. The enemies class holds the list of predators
	 * 
	 * @param game
	 */
	public Enemies(Game game) {
		this.game = game;
//		updateEnemies();
//		createImage();
	}
	
	/**
	 * Creates the list of predators for the first level.
	 */
	public void firstPreds() {
		preds = new ArrayList<Predator>();
		preds.add(new Predator(1800, 2000, 80, 60, game, 1200, 2400, 2));
		preds.add(new Predator(400, 900, 60, 80, game, 825, 1250, 1));
		preds.add(new Predator(500, 450, 80, 60, game, 400, 900, 2));
		preds.add(new Predator(2000, 600, 80, 60, game, 1800, 2500, 2));
		preds.add(new Predator(3175, 750, 60, 80, game, 700, 1400, 1));
		preds.add(new Predator(3475, 1350, 60, 80, game, 725, 1400, 1));
		preds.add(new Predator(1100, 950, 60, 80, game, 920, 1200, 1));
		preds.add(new Predator(850, 1800, 80, 60, game, 300, 700, 2));
		preds.add(new Predator(1350, 600, 60, 80, game, 220, 650, 1));
		preds.add(new Predator(3100, 600, 60, 80, game, 220, 650, 1));
		preds.add(new Predator(2550, 1450, 80, 60, game, 2530, 3520, 2));
	}
	
	/**
	 * Creates the list of predators for the second level.
	 */
	public void secondPreds() {
		preds = new ArrayList<Predator>();
//		preds.add(new Predator(1700, 300, 60, 80, game, 300, 400, 1));
		preds.add(new Predator(1800, 400, 60, 80, game, 300, 400, 1));
		preds.add(new Predator(2000, 900, 60, 80, game, 820, 1100, 1));
		preds.add(new Predator(1550, 900, 60, 80, game, 800, 1100, 1));
		preds.add(new Predator(900, 820, 80, 60, game, 900, 1400, 2));
		preds.add(new Predator(1950, 820, 80, 60, game, 1950, 2600, 2));
		preds.add(new Predator(900, 1000, 60, 80, game, 1000, 1400, 1));
		preds.add(new Predator(2600, 1000, 60, 80, game, 1000, 1400, 1));
		preds.add(new Predator(3400, 200, 60, 80, game, 200, 1900, 1));
		preds.add(new Predator(3000, 1900, 60, 80, game, 200, 1800, 1));
		preds.add(new Predator(3000, 200, 80, 60, game, 3000, 3400, 2));
		
		preds.add(new Predator(3000, 540, 80, 60, game, 3000, 3400, 2));
		preds.add(new Predator(3200, 600, 80, 60, game, 3000, 3400, 2));
		preds.add(new Predator(3400, 660, 80, 60, game, 3000, 3400, 2));
		
		preds.add(new Predator(3000, 1000, 80, 60, game, 3000, 3400, 2));
		preds.add(new Predator(3400, 1060, 80, 60, game, 3000, 3400, 2));
		
		preds.add(new Predator(3000, 1400, 80, 60, game, 3000, 3400, 2));
		preds.add(new Predator(3400, 1460, 80, 60, game, 3000, 3400, 2));
		
		preds.add(new Predator(3000, 1800, 80, 60, game, 3000, 3400, 2));
		preds.add(new Predator(3400, 1860, 80, 60, game, 3000, 3400, 2));
	}
	
	public void thirdPreds() {
		preds = new ArrayList<Predator>();
		preds.add(new Predator(1100, 300, 80, 60, game, 1200, 1320, 2));
		preds.add(new Predator(1610, 900, 80, 60, game, 1600, 1900, 2));
		preds.add(new Predator(1990, 1000, 80, 60, game, 1600, 1900, 2));
		preds.add(new Predator(2710, 900, 80, 60, game, 2600, 2900, 2));
		preds.add(new Predator(2610, 800, 80, 60, game, 2600, 2900, 2));
		preds.add(new Predator(2890, 700, 80, 60, game, 2600, 2900, 2));
		preds.add(new Predator(2900, 110, 60, 80, game, 100, 220, 1));
		preds.add(new Predator(2800, 210, 60, 80, game, 100, 220, 1));
		preds.add(new Predator(2400, 1300, 80, 60, game, 2200, 2320, 2));
		preds.add(new Predator(3300, 900, 80, 60, game, 3280, 3520, 2));
		preds.add(new Predator(3300, 1300, 80, 60, game, 3280, 3520, 2));
		preds.add(new Predator(3540, 900, 60, 80, game, 900, 1300, 1));
		preds.add(new Predator(3240, 1300, 60, 80, game, 900, 1300, 1));
	}
	
	/**
	 * Paints the predators in the current predator list. Based on the current level of the game.
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		if (game.gameStart == 4 ) {
		for (int i = 0; i < preds.size(); i++) {
			preds.get(i).paint(g);
		}
		}
		if (game.gameStart == 5) {
			for (int i = 0; i < preds.size(); i++) {
				preds.get(i).paint(g);
			}

		}
		if (game.gameStart == 6) {
			for (int i = 0; i < preds.size(); i++) {
				preds.get(i).paint(g);
			}

		}
	}
	
	/**
	 * Creates the images needed for each predator.
	 */
	public void createImage() {
		for (int i = 0; i < preds.size(); i++) {
			preds.get(i).createImage();
		}
	}
	
	/**
	 * Calls the move method for each of the predators in the current list.
	 */
	public void movePreds() {
		for (int i = 0; i < preds.size(); i++) {
			preds.get(i).movePredator();
		}
	}
	
	/**
	 * Updates the enemy list based on the current level of the game.
	 */
	public void updateEnemies() {
		if (game.gameStart == 4) {
			firstPreds();
		}
		if (game.gameStart == 5) {
			secondPreds();
		}
		if (game.gameStart == 6) {
			thirdPreds();
		}
	}
}

