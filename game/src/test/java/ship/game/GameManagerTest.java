package ship.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ship.game.Compass;
import ship.game.GameManager;
import ship.game.Ship;


public class GameManagerTest 
{
		@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		private GameManager game;
		
		@Before
		public void setUp() throws Exception 
		{
			game = new GameManager();
			Ship ship = new Ship(4, 4, Compass.N);
			game.world.ship = ship;
		}
	
		@Test
		public void moveToIsland() throws Exception
		{		
			thrown.expect(Exception.class);
			thrown.expectMessage("Collision detected!");
			
			game.Path("wlnln");
			
			assertThat(game.world.ship.y, equalTo(3));
		}
		
		@Test
		public void checkIfMapHasIsland()
		{
			Integer[] testTable = new Integer[4];
			testTable[0] = game.world.map[3][2];
			testTable[1] = game.world.map[4][2];
			testTable[2] = game.world.map[5][2];
			testTable[3] = game.world.map[6][2];
			
			assertThat(testTable, arrayContaining(1,1,1,1));
		}
		
		@Test
		public void moveOutOfMapToTheRight() throws Exception
		{		
			thrown.expect(Exception.class);
			thrown.expectMessage("Out Of Map!");
			
			game.Path("nnpnnnnnn");
			
			assertThat(game.world.ship.x, equalTo(9));
		}
		
		@Test
		public void moveOutOfMapToTheTop() throws Exception
		{		
			thrown.expect(Exception.class);
			thrown.expectMessage("Out Of Map!");
			
			game.Path("nnnnnn");
			
			assertThat(game.world.ship.y, equalTo(9));
		}
		
		@Test 
		public void simplePathTest () throws Exception
		{
			game.Path("nnllnp");
			
			assertThat(game.world.ship.x, equalTo(4));
		}
		
		@Test 
		public void wrongPathTest() throws Exception
		{
			game.Path("kiol");
			
			Integer[] testTable = new Integer[2];
			testTable[0] = game.world.ship.y;
			testTable[1] = game.world.ship.x;
			
			assertThat(testTable, arrayContaining(4,4));
		}
		
	 	@Test
	    public void turnShipRight()
	    {
	        game.Turn(true);	        
	        assertThat(game.world.ship.direction, equalTo(Compass.E));
	    }
	 	
	 	@Test
	    public void turnShipRight360()
	    {
	        game.Turn(true);
	        game.Turn(true);
	        game.Turn(true);
	        game.Turn(true);
	        
	        assertThat(game.world.ship.direction, equalTo(Compass.N));
	    }
	 	
	 	@Test
	    public void turnShipLeft()
	    {
	        game.Turn(false);	        
	        assertThat(game.world.ship.direction, equalTo(Compass.W));
	    }
	 	
	 	@Test
	    public void turnShipLeft360()
	    {
	        game.Turn(false);
	        game.Turn(false);
	        game.Turn(false);
	        game.Turn(false);
	        
	        assertThat(game.world.ship.direction, equalTo(Compass.N));
	    }
	 	
	 	@Test
	 	public void moveForward() throws Exception
	 	{
	 		game.Move(true);
	 		
	 		assertThat(game.world.ship.y, equalTo(5));
	 	}
	 	
	 	@Test
	 	public void moveBackward() throws Exception
	 	{
	 		game.Move(false);
	 		
	 		assertThat(game.world.ship.y, equalTo(3));
	 	}
	 	
	 	@After
		public void tearDown() throws Exception {
	 		game = null;
		}
}
