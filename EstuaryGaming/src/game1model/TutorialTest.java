package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class TutorialTest {
	
	Game game = new Game();
	

	@Test
	public void moveTest() {
		Tutorial t = new Tutorial(game);
		t.move();
		game.setTutTime(9);
		t.move();
	}
	
	@Test
	public void crabScriptTest() {
		Tutorial t = new Tutorial(game);
		t.crabScript();
		game.setTutTime(0);
		t.crabScript();
		game.setTutTime(2);
		t.crabScript();
		game.setTutTime(4);
		t.crabScript();
		game.setTutTime(5);
		t.crabScript();
		game.setTutTime(6);
		t.crabScript();
		game.setTutTime(7);
		t.crabScript();
		game.setTutTime(10);
		t.crabScript();
		game.setTutTime(11);
		t.crabScript();
		game.setTutTime(15);
		t.crabScript();
		game.setTutTime(18);
		t.crabScript();
		game.setTutTime(24);
		t.crabScript();
	}


}
