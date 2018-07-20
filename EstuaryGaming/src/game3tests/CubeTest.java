package game3tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game3model.Cube;

public class CubeTest {

	@Test
	public void testCube() {
		Cube cube1 = new Cube();
		assertEquals(cube1.getXsize(),150);
	}

	@Test
	public void testCubeIntIntInt() {
		Cube cube1 = new Cube(10,10,10);
		assertEquals(cube1.getX(),10);
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetXsize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetXsize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetYsize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetYsize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetImg() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetImg() {
		fail("Not yet implemented");
	}

	@Test
	public void testOverlapsCoord() {
		fail("Not yet implemented");
	}

}
