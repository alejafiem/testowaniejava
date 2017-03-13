package ship.game;

import ship.game.Compass;

public class Ship {
	public int x;
	public int y;
	public Compass direction;
	
	public Ship(int x, int y, Compass direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
}
