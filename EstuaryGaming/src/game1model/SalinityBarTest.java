package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class SalinityBarTest {
	
	Game game = new Game();

	@Test
	public void xPosTest() {
		SalinityBar sb= new SalinityBar(game);
		sb.setxPos(0);
		float x = sb.getxPos();
		assertEquals(x, 0, 0);
	}
	
	@Test
	public void yPosTest() {
		SalinityBar sb= new SalinityBar(game);
		sb.setyPos(0);
		float y = sb.getyPos();
		assertEquals(y, 0, 0);
	}
	
	@Test
	public void setLevelTest() {
		SalinityBar sb= new SalinityBar(game);
		sb.setLevel();
	}
	
	@Test
	public void moveTest() {
		SalinityBar sb= new SalinityBar(game);
		sb.moveSalinityBar();
	}

}
