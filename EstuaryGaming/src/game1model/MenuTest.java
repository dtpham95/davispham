package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {
	
	Game game = new Game();

	@Test
	public void moveMenuTest() {
		Menu m = new Menu(game);
		m.moveMenu();
	}

}
