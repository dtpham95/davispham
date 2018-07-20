package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class BubblesTest {
	
	Game g = new Game();

	
	@Test
	public void moveBubbleTest() {
		Bubbles b = new Bubbles(g);
		b.b.get(0).yPos = 0;
		b.move();
	}
}
