package test.main; 

import main.Game;
import main.pieces.Square;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* Controller Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 9, 2018</pre> 
* @version 1.0 
*/ 
public class ControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: newPiece() 
* 
*/ 
@Test
public void testNewPiece() throws Exception {
	Game game = new Game();
	assertEquals(0, game.getController().getPieces().size());
	game.getController().newPiece();
	assertEquals(1, game.getController().getPieces().size());

}

/** 
* 
* Method: moveBlockDown(int time) 
* 
*/ 
@Test
public void testMoveBlockDown() throws Exception {
	Game game = new Game();
	game.getController().newPiece();

	int[] y = new int[4];

	for(int i = 0; i < 4; i++)
		y[i] = game.getController().getPieces().get(0).getBlocks().get(i).getY();

	game.getController().moveBlockDown(1);

	for(int i = 0; i < 4; i++);
		//assertEquals(y[i] + 1, game.getController().getPieces().get(0).getBlocks().get(i).getY());
}


/** 
* 
* Method: checkIfRowsCanBeCleared() 
* 
*/ 
@Test
public void testCheckIfRowsCanBeCleared() throws Exception {
	Game game = new Game();
	int[][] grid = new int[16][10];
	for(int x = 0; x < grid.length; x++)
	{
		for(int y = 0; y < grid[x].length; y++)
		{
			grid[x][y] = 0;
		}
	}
	game.getController().setGrid(grid);
	game.getController().checkIfRowsCanBeCleared();

	for(int x = 0; x < grid.length; x++)
	{
		for(int y = 0; y < grid[x].length; y++)
		{
			assertEquals(0, game.getController().getGrid()[x][y]);
		}
	}

	for(int i = 0; i < 10; i++)
		grid[15][i] = 1;

	game.getController().setGrid(grid);
	game.getController().checkIfRowsCanBeCleared();

	for(int x = 0; x < grid.length; x++)
	{
		for(int y = 0; y < grid[x].length; y++)
		{
			//assertEquals(0, game.getController().getGrid()[x][y]);
		}
	}
}

/** 
* 
* Method: updateGrid(Piece piece) 
* 
*/ 
@Test
public void testUpdateGrid() throws Exception {
	Game game = new Game();
	Square square = new Square(game);

	game.getController().updateGrid(square);

	assertEquals(1,
			game.getController().getGrid()[square.getBlocks().get(0).getX()][square.getBlocks().get(0).getY()]);
	assertEquals(1,
			game.getController().getGrid()[square.getBlocks().get(1).getX()][square.getBlocks().get(1).getY()]);
	assertEquals(1,
			game.getController().getGrid()[square.getBlocks().get(2).getX()][square.getBlocks().get(2).getY()]);
	assertEquals(1,
			game.getController().getGrid()[square.getBlocks().get(3).getX()][square.getBlocks().get(3).getY()]);
}

/** 
* 
* Method: getGrid() 
* 
*/ 
@Test
public void testGetSetGrid() throws Exception {
	Game game = new Game();
	int[][] grid = new int[16][10];
	for(int x = 0; x < grid.length; x++)
	{
		for(int y = 0; y < grid[x].length; y++)
		{
			grid[x][y] = 0;
		}
	}
	game.getController().setGrid(grid);
	assertSame(grid, game.getController().getGrid());
}

/** 
* 
* Method: getScore() 
* 
*/ 
@Test
public void testGetScore() throws Exception {
	Game game = new Game();
	assertEquals(0, game.getController().getScore());
}

/** 
* 
* Method: getPieces() 
* 
*/ 
@Test
public void testGetPieces() throws Exception {
	Game game = new Game();
	assertEquals(0, game.getController().getPieces().size());
	game.getController().newPiece();
	assertEquals(1, game.getController().getPieces().size());

}


/** 
* 
* Method: canMoveLeft() 
* 
*/ 
@Test
public void testCanMoveLeft() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Controller.getClass().getMethod("canMoveLeft"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: canMoveRight() 
* 
*/ 
@Test
public void testCanMoveRight() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Controller.getClass().getMethod("canMoveRight"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: moveAll(int y) 
* 
*/ 
@Test
public void testMoveAll() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Controller.getClass().getMethod("moveAll", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: deleteRow(int y) 
* 
*/ 
@Test
public void testDeleteRow() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Controller.getClass().getMethod("deleteRow", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: resetGrid() 
* 
*/ 
@Test
public void testResetGrid() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Controller.getClass().getMethod("resetGrid"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
