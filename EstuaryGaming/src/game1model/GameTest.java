package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void gameWonTest() {
		Game g = new Game();
		g.gameStart = 3;
		g.bc.setYPos(-100);
		g.gameWon();
		g.gameStart = 4;
		g.gameWon();
		g.bc.setYPos(100);
		g.gameWon();
		g.gameStart = 0;
		g.gameWon();
	}
	
	@Test
	public void gameOverTest() {
		Game g = new Game();
		g.bc.setLife(0);
		g.gameOver();
		g.bc.setLife(3);
		g.setTime(60);
		g.gameOver();
		g.setTime(0);
		g.gameOver();
		g.bc.setYPos(-100);
		g.gameOver();
	}
	
	@Test
	public void createDroughtTest() {
		Game g = new Game();
		g.setTime(40);
		g.createDrought(43);
		g.createDrought(51);
	}
	
	@Test
	public void getImagesTest() {
		Game g = new Game();
		g.getImages();
	}

	@Test
	public void tutTimeTest() {
		Game g = new Game();
		g.setTutTime(30);
		int x = g.getTutTime();
		assertEquals(x, 30);
	}
	
}
