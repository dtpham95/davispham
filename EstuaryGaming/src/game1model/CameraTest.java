package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class CameraTest {

	Game g = new Game();
	

	

	@Test
	public void xPosTest() {
		Camera c = new Camera(g);
		c.setxPos(1240);
		float x = c.getxPos();
		
		assertEquals(x, 1240, 0);
	}

	@Test 
	public void yPosTest() {
		Camera c = new Camera(g);
		c.setyPos(1240);
		float y = c.getyPos();
		
		assertEquals(y, 1240, 0);
	}
	@Test 
	public void moveTest() {
		Camera c = new Camera(g);
		c.moveCamera();
	}
}
