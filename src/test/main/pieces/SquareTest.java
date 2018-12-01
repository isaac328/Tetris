package test.main.pieces; 

import main.Game;
import main.pieces.Square;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* Square Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class SquareTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void testConstructor() throws Exception{
	Game game = new Game();
	Square piece = new Square(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(0, piece.getBlocks().get(1).getY());

	assertEquals(4, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(5, piece.getBlocks().get(3).getX());
	assertEquals(1, piece.getBlocks().get(3).getY());
}

/** 
* 
* Method: rotate() 
* 
*/ 
@Test
public void testRotate() throws Exception {
	Game game = new Game();
	Square piece = new Square(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(0, piece.getBlocks().get(1).getY());

	assertEquals(4, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(5, piece.getBlocks().get(3).getX());
	assertEquals(1, piece.getBlocks().get(3).getY());

	piece.rotate();

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(0, piece.getBlocks().get(1).getY());

	assertEquals(4, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(5, piece.getBlocks().get(3).getX());
	assertEquals(1, piece.getBlocks().get(3).getY());
}


} 
