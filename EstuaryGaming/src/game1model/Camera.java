package game1model;
import java.awt.event.KeyEvent;

public class Camera {
	Game game;
	
	int width;
	int height;
	int xVel = 0;
	int yVel = 0;
	float xPos = -1240;
	float yPos = -1400;
	int maxX = 0;
	int maxY = 0;
	
	/**
	 * Creates an instance of a Camera
	 * 
	 * 
	 * 
	 * @param game
	 */
	public Camera(Game game) {
		this.game = game;
		this.maxX = game.mapWidth;
		this.maxY = game.mapHeight;
		this.width = game.displayWidth;
		this.height = game.displayHeight;
	}
	
	public float getxPos() {
		return xPos;
	}
	
	public float getyPos() {
		return yPos;
	}
	
	public void setxPos(float x) {
		this.xPos = x;
	}
	
	public void setyPos(float y) {
		this.yPos = y;
	}
	

//	/**
//	 * Stops the movement of the camera when a key is released.
//	 * 
//	 * @param e KeyEvent object
//	 */
//	public void keyReleased(KeyEvent e) {
//
//			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
//				xVel = 0;
//			}
//			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
//				xVel = 0;
//			}
//		
//		if (xVel == 0) {
//			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
//				yVel = 0;
//			}
//			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
//				yVel = 0;
//			}
//		}
//	}
//	
//	
//
//	public void keyPressed(KeyEvent e) {
//		xVel = 0;
//		yVel = 0;
//			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
//		
//					 xVel = -2;
//				}
//			
//			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
//	
//					xVel = 2;
//				}
//		
//		if (xVel == 0) {
//			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
//	
//					yVel = -2;
//				}
//			
//			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
//	
//					yVel = 2;
//			}
//		}
//	}
	
	
	/**
	 * Moves the camera. Based on the position of the crab so the camera will always be locked 
	 * on the crab. 
	 */
	public void moveCamera() {



		xPos = 560 + ((game.bc.getXPos()) * -1);
		yPos = 300 + ((game.bc.getYPos()) * -1);
	}
}
