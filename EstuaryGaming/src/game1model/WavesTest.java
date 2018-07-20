package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class WavesTest {
	
	Game game = new Game();

	@Test
	public void moveTest() {
		Waves w = new Waves(game);
		w.move();
		
		game.gameStart = 2;
		w.move();
	}

}
