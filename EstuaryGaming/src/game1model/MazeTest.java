package game1model;
import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest {
	
	Game game = new Game();
	
	@Test
	public void firstMazeTest() {
		Maze m = new Maze(game);
		m.firstMaze();
	}
	
	@Test
	public void secondMazeTest() {
		Maze m = new Maze(game);
		m.secondMaze();
	}
	
	@Test
	public void updateMazeTest() {
		Maze m = new Maze(game);
		game.gameStart = 3;
		m.updateMaze();
		game.gameStart = 4;
		m.updateMaze();
	}

}
