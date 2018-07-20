package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class ClockTest {

	Game g = new Game();
	
	@Test
	public void runTest() {
		g.gameStart = 2;
		Clock c = new Clock(g);

	}
	
	@Test
	public void runTest2() {
		g.gameStart = 4;
		Clock c = new Clock(g);

	}
	
	@Test
	public void runTest3() {
		g.time = 0;
		Clock c = new Clock(g);

	}
}
