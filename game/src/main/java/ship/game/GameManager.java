package ship.game;

import ship.game.Compass;
import ship.game.World;

public class GameManager {
	
	public World world = new World();
		
	public void Path(String path) throws Exception{
		for(int i = 0; i < path.length(); i++) {
		    char c = path.charAt(i);
		    switch(c){
		    case 'n':
		    	Move(true);
		    	break;
		    case 'w':
		    	Move(false);
		    	break;
		    case 'l':
		    	Turn(false);
		    	break;
		    case 'p':
		    	Turn(true);
		    	break;
		    }
		}
	}
	
	public void Move(boolean w) throws Exception{		
			if(w == true){
				Step(world.ship.direction);
			}
			else{
				switch(world.ship.direction){
					case N:
						Step(Compass.S);
						break;
					case S:
						Step(Compass.N);
						break;
					case E:
						Step(Compass.W);
						break;
					case W:
						Step(Compass.E);
						break;			
				}			
			}

	}
	
	public void Turn(boolean s){
		if(s == true){
			switch(world.ship.direction){
				case N:
					world.ship.direction = Compass.E;
					break;
				case S:
					world.ship.direction = Compass.W;
					break;
				case E:
					world.ship.direction = Compass.S;
					break;
				case W:
					world.ship.direction = Compass.N;
					break;			
			}	
		}
		else{
			switch(world.ship.direction){
			case N:
				world.ship.direction = Compass.W;
				break;
			case S:
				world.ship.direction = Compass.E;
				break;
			case E:
				world.ship.direction = Compass.N;
				break;
			case W:
				world.ship.direction = Compass.S;
				break;			
			}	
		}
	}
	
	private void Step(Compass w) throws Exception{		

		switch(w){
			case N:
				checkCollision(world.ship.x, world.ship.y+1);
				world.ship.y += 1;
				break;
			case S:
				checkCollision(world.ship.x, world.ship.y-1);
				world.ship.y -= 1;
				break;
			case E:
				checkCollision(world.ship.x+1, world.ship.y);
				world.ship.x += 1;
				break;
			case W:
				checkCollision(world.ship.x-1, world.ship.y+1);
				world.ship.x -= 1;
				break;			
		}	
	}
	
	private void checkCollision(int x, int y) throws Exception{
		if(x > 9 || y > 9) throw new Exception("Out Of Map!");
		int[][] map = world.map;
		if(map[x][y] == 1) throw new Exception("Collision detected!");
	}
}

