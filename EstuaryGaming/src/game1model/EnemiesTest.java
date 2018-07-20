package game1model;
import static org.junit.Assert.*;

import java.awt.Graphics2D;

import org.junit.Test;

public class EnemiesTest {
	
	Game game = new Game();

	@Test
	public void firstPredsTest() {
		Enemies e = new Enemies(game);
		e.firstPreds();
	}
	
	@Test
	public void secondPredsTest() {
		Enemies e = new Enemies(game);
		e.secondPreds();
	}
	
	@Test
	public void createImageTest() {
		Enemies e = new Enemies(game);
		e.firstPreds();
		e.createImage();
	}
	
	@Test
	public void movePredsTest() {
		Enemies e = new Enemies(game);
		e.firstPreds();
		e.movePreds();
	}
	
	@Test
	public void updateEnemiesTest() {
		Enemies e = new Enemies(game);
		e.firstPreds();
		game.gameStart = 3;
		e.updateEnemies();
		game.gameStart = 4;
		e.updateEnemies();
	}
	

	

}
