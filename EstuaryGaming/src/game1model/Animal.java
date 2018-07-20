package game1model;

public class Animal {
	int xPos;
	int yPos;
	int width;
	int height;
	int xVel = 0;
	int yVel = 0;
	int speed;
	Game game;
	
	/**
	 * Creates an instance of an Animal. Speed is initialized as 
	 * 2. 
	 * 
	 * @param xPos	The x position of the animal
	 * @param yPos	The y position of the animal
	 * @param width	The width of the animal
	 * @param height	The height of the animal
	 * @param game	The game this animal belongs to
	 */
	public Animal(int xPos, int yPos, int width, int height, Game game) {
		this.game = game;
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = 2; 
		this.width = width;
		this.height = height;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public void setXPos(int x) {
		this.xPos = x;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public void setYPos(int y) {
		this.yPos = y;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	/**
	 * Moves the animal right. Based on the speed of the animal. 
	 */
	public void moveRight() {
			this.xVel = speed;
	}
	
	/**
	 * Moves the animal left. Based on the speed of the animal. 
	 */
	public void moveLeft() {
			this.xVel = -1 * speed;
	}
	
	/**
	 * Moves the animal up. Based on the speed of the animal. 
	 */
	public void moveUp() {
			this.yVel = -1 * speed;
	}
	
	/**
	 * Moves the animal down. Based on the speed of the animal. 
	 */
	public void moveDown() {
			this.yVel = speed;
	}

	
}
