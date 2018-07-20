package game1model;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

public class BlueCrabTest {
	
	Game game = new Game();

	@Test
	public void getXPosTest() {
		BlueCrab test = new BlueCrab(4, 6, 10, 10, game);
		int result = test.getXPos();
		assertEquals(result, 4);
	}
	@Test
	public void getYPosTest() {
		BlueCrab test = new BlueCrab(4, 6, 10, 10, game);
		int result = test.getYPos();
		assertEquals(result, 6);
	}
	
	@Test
	public void getLifeTest() {
		BlueCrab test = new BlueCrab(4, 6, 10, 10, game);
		int result = test.getLife();
		assertEquals(result, 3);
	}
	
	@Test
	public void setLifeTest() {
		BlueCrab test = new BlueCrab(4, 6, 10, 10, game);
		test.setLife(4);
		int result = test.getLife();
		assertEquals(result, 4);
	}
	
	@Test
	public void loseLifeTest() {
		BlueCrab test = new BlueCrab(4, 6, 10, 10, game);
		game.e.preds.add(new Predator(4, 2, 10, 10, game, 1, 100, 2));
		test.loseLife();
		game.e.preds.get(0).yPos = 15;
		test.loseLife();
	}

	@Test
	public void moveBlueCrabTest() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game);
		game.m.updateMaze();
		test.setXPos(1510);
		test.setyVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest2() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game);
		game.m.updateMaze();
		test.setXPos(1700);
		test.setYPos(1510);
		test.setxVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	

	
	@Test
	public void moveBlueCrabTest3() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game);
		game.m.updateMaze();
		test.setXPos(1510);
		test.setxVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest4() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game);
		game.m.updateMaze();
		test.setXPos(2110);
		test.setyVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest5() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game);
		game.m.updateMaze();
		test.setXPos(2100);
		test.setyVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	@Test
	public void moveBlueCrabTest6() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game); 
		game.m.updateMaze();
		test.setXPos(-1);
		test.setYPos(1511);
		test.setyVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest7() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game); 
		game.m.updateMaze();
		test.setXPos(-1);
		test.setYPos(1511);
		test.setxVel(2);
		System.out.print(game.m.walls);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest8() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game); 
		game.m.updateMaze();
		test.setXPos(3600);
		test.setYPos(-100);
		test.setxVel(-2);
		test.moveBlueCrab();
		test.setxVel(2);
		test.moveBlueCrab();
		test.setYPos(100);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest9() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game); 
		game.m.updateMaze();
		test.setXPos(600);
		test.setYPos(-100);  
		test.setyVel(2); 
		test.moveBlueCrab();
		test.setyVel(-2);
		test.moveBlueCrab();
		test.setXPos(100);
		test.moveBlueCrab();
	}
	
	@Test
	public void moveBlueCrabTest10() {
		BlueCrab test = new BlueCrab(1700, 1510, 10, 10, game);
		game.gameStart = 3;
		game.m = new Maze(game); 
		game.m.updateMaze();
		test.setXPos(600);
		test.setYPos(2200);  
		test.setyVel(-2); 
		test.moveBlueCrab();
		test.setyVel(2); 
		test.moveBlueCrab();
	}
	

}
