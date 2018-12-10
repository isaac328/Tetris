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
* @since <pre>Dec 6, 2018</pre> 
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
	Game game = new Game();
	Square square = new Square(game);

	assertSame(game.getController().getGrid(), square.getGrid());
} 


/** 
* 
* Method: checkClearBelow() 
* 
*/ 
@Test
public void testCheckClearBelow() throws Exception { 
	Game game = new Game();
	Square square = new Square(game);

	//assertTrue(square.checkClearBelow());

//	for(int i = 0; i < 8; i++)
//		game.getController().moveBlockDown(1);
//
//	assertTrue(square.checkClearBelow());
} 


} 
