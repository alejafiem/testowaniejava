package ship.game;

import ship.game.Ship;

public class World {
	
	public int[][] map = new int[10][10];
	public Ship ship;
	
	public World(){
		for(int i=0; i>10; i++)
		{
			for(int j=0; j>10; j++)
			{
				map[i][j] = 0;
			}
		}		
		map[3][2]= 1;
		map[4][2]= 1;
		map[5][2]= 1;
		map[6][2]= 1;
	}

}
