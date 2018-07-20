package game2model;

/**
 * @author Vincent Mangubat
 * @see BldgGabion
 * @see BldgGrass
 * @see BldgConcrete
 *
 */
public abstract class Building extends BasicObject {
	private static final int regenMax = 10000; // the max amount of health this
												// Building starts with
	protected int currentRegenTime; // for ticking purposes, when
									// this reaches 0, ammo
									// increments by 1 and is reset
									// to regenMax's value
	protected int ammo = 1;// how many resources are available for dragging from
							// this Building
	protected int regenRate;// for ticking purposes, this variable is how fast
							// currentRegenTime will decrease this Building will
							// regenerate its ammo
	protected Boolean isSelected = false;// boolean for if this Building is
											// being
											// selected by the mouse (see class
											// MouseGame)

	/**
	 * Initializes the width and height. Its y location is the size of three
	 * health bars in the y plane and this Building's height above the bottom of
	 * the screen.
	 * 
	 * @see ShoreBoard
	 */
	Building() {
		currentRegenTime = regenMax;
		xsize = 150;
		ysize = 100;
		yloc = ShoreBoard.getScreenheight() - ysize - (3 * ShoreBoard.getHealthbarthicc());
	}

	public int getRegen() {
		return currentRegenTime;
	}

	public void setRegen(int regen) {
		currentRegenTime = regen;
	}

	public static int getRegenMax() {
		return regenMax;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int newAmmo) {
		ammo = newAmmo;
	}

	public Boolean getSelected() {
		return isSelected;
	}

	public void setSelected(Boolean newSelect) {
		isSelected = newSelect;
	}

	/**
	 * Reduces the ammo variable by 1 unless there is no ammo
	 */
	public void reduceAmmo() {
		if (ammo > 0)
			ammo--;
	}

	/**
	 * Subtracts regenRate from currentRegenTime. If it reaches <= 0, ammo
	 * increases by one and currentRegenTime is reset.
	 * 
	 * @see game2model.BasicObject#move()
	 */
	@Override
	public void move() {
		currentRegenTime -= regenRate;
		if (currentRegenTime <= 0) {
			ammo++;
			currentRegenTime = regenMax;
		}

	}

}
