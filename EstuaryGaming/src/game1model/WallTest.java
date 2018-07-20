package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class WallTest {
	
	Game game = new Game();

	@Test
	public void xPosTest() {
		Wall w = new Wall(0, 0, 10, 100, game);
		w.setxPos(10);
		int x = w.getxPos();
		assertEquals(10, x);
	}
	
	@Test
	public void yPosTest() {
		Wall w = new Wall(0, 0, 10, 100, game);
		w.setyPos(10);
		int y = w.getyPos();
		assertEquals(10, y);
	}
	
	@Test
	public void wallHitTest() {
		Wall w = new Wall(0, 0, 10, 100, game);
		game.bc = new BlueCrab(10, 50, 60, 60, game);
		w.wallHit(game.bc);
		game.bc = new BlueCrab(-60, 50, 60, 60, game);
		w.wallHit(game.bc);
		game.bc = new BlueCrab(9, 110, 60, 60, game);
		w.wallHit(game.bc);
	}
	
	@Test
	public void toStringTest() {
		Wall w = new Wall(0, 0, 10, 100, game);
		w.toString();
	}

}
