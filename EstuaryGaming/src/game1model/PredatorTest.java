package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class PredatorTest {

	Game game = new Game();
	
	@Test
	public void moveTest() {
		Predator p = new Predator(300, 300, 60, 80, game, 200, 400, 1);
		p.movePredator();
		game.bc = new BlueCrab(300, 300, 60, 60, game);
		p.movePredator();
		p = new Predator(300, 300, 60, 80, game, 200, 400, 2);
		p.movePredator();
	}

	@Test
	public void createImageTest() {
		Predator p = new Predator(300, 300, 60, 80, game, 200, 400, 1);
		p.createImage();
	}
	
	@Test 
	public void hitPredTest() {
		Predator p = new Predator(300, 300, 60, 80, game, 200, 400, 1);
		game.bc = new BlueCrab(310, 380, 60, 60, game);
		p.hitPred(game.bc);
	}
}
