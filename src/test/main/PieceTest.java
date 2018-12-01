package test.main; 

import main.Game;
import main.Piece;
import main.pieces.Square;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* Piece Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class PieceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: getPApplet() 
* 
*/ 
@Test
public void testGetPApplet() throws Exception {
	Game game = new Game();
	Piece piece = new Square(game);

	assertSame(game, piece.getPApplet());
}

/** 
* 
* Method: getBlocks() 
* 
*/ 
@Test
public void testGetBlocks() throws Exception {
	Game game = new Game();
	Piece piece = new Square(game);

	assertEquals(4, piece.getBlocks().size());
}

/** 
* 
* Method: getGrid() 
* 
*/ 
@Test
public void testGetGrid() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: check(int[][] grid) 
* 
*/ 
@Test
public void testCheck() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateGrid(int[][] grid) 
* 
*/ 
@Test
public void testUpdateGrid() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: checkMove(int[][] grid) 
* 
*/ 
@Test
public void testCheckMove() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: leftClear(int[][] grid) 
* 
*/ 
@Test
public void testLeftClear() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rightClear(int[][] grid) 
* 
*/ 
@Test
public void testRightClear() throws Exception { 
//TODO: Test goes here... 
} 


} 
