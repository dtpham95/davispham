/**
 * 
 */
package game2tests;

import static org.junit.Assert.*;
import org.junit.Test;
import game2model.Wave;
import game2model.BasicObject;
import game2model.Seagrass;

/**
 * @author Vincent Mangubat
 *
 */
public class BasicObjectTest {

	/**
	 * Test method for {@link game2model.BasicObject#getX()}.
	 */
	@Test
	public void testGetX() {
		BasicObject botest = new Wave(0, 0, 1);
		assertEquals(0, botest.getX());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setX(int)}.
	 */
	@Test
	public void testSetX() {
		BasicObject botest = new Wave(0, 0, 1);
		botest.setX(32);
		assertEquals(32, botest.getX());
	}

	/**
	 * Test method for {@link game2model.BasicObject#getY()}.
	 */
	@Test
	public void testGetY() {
		BasicObject botest = new Wave(45, 34, 1);
		assertEquals(34, botest.getY());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setY(int)}.
	 */
	@Test
	public void testSetY() {
		BasicObject botest = new Wave(0, 0, 1);
		botest.setY(46);
		assertEquals(46, botest.getY());
	}

	/**
	 * Test method for {@link game2model.BasicObject#getXsize()}.
	 */
	@Test
	public void testGetXsize() {
		BasicObject botest = new Seagrass(500,600, 5);
		assertEquals(120, botest.getXsize());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setXsize(int)}.
	 */
	@Test
	public void testSetXsize() {
		BasicObject botest = new Seagrass(500,600, 5);
		botest.setXsize(200);
		assertEquals(200, botest.getXsize());
	}

	/**
	 * Test method for {@link game2model.BasicObject#getYsize()}.
	 */
	@Test
	public void testGetYsize() {
		BasicObject botest = new Seagrass(500,600, 5);
		assertEquals(60, botest.getYsize());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setYsize(int)}.
	 */
	@Test
	public void testSetYsize() {
		BasicObject botest = new Seagrass(500,600, 5);
		botest.setXsize(30);
		assertEquals(30, botest.getYsize());
	}

	/**
	 * Test method for {@link game2model.BasicObject#getXspeed()}.
	 */
	@Test
	public void testGetXspeed() {
		BasicObject botest = new Wave(0, 0, 1);
		assertEquals(1, botest.getXspeed());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setXspeed(int)}.
	 */
	@Test
	public void testSetXspeed() {
		BasicObject botest = new Wave(0, 0, 1);
		botest.setXspeed(3);
		assertEquals(3, botest.getXspeed());
	}

	/**
	 * Test method for {@link game2model.BasicObject#getYspeed()}.
	 */
	@Test
	public void testGetYspeed() {
		BasicObject botest = new Seagrass(500,600, 5);
		botest.setYspeed(5);
		assertEquals(5, botest.getYspeed());
	}

	/**
	 * Test method for {@link game2model.BasicObject#setYspeed(int)}.
	 */
	@Test
	public void testSetYspeed() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#getImgPath()}.
	 */
	@Test
	public void testGetImgPath() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#setImgPath(java.lang.String)}.
	 */
	@Test
	public void testSetImgPath() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#setImg(java.lang.String)}.
	 */
	@Test
	public void testSetImg() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#isHitting(game2model.BasicObject)}.
	 */
	@Test
	public void testIsHitting() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#overlapsCoord(int, int)}.
	 */
	@Test
	public void testOverlapsCoord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#move()}.
	 */
	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link game2model.BasicObject#animate()}.
	 */
	@Test
	public void testAnimate() {
		fail("Not yet implemented");
	}

}
