package test.main.pieces; 

import main.Block;
import main.Game;
import main.pieces.RightArm;
import main.pieces.RightL;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* RightL Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class RightLTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void testConstructor() throws Exception {
	Game game = new Game();
	RightL piece = new RightL(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(5, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(5, piece.getBlocks().get(2).getX());
	assertEquals(2, piece.getBlocks().get(2).getY());

	assertEquals(4, piece.getBlocks().get(3).getX());
	assertEquals(2, piece.getBlocks().get(3).getY());
}


/** 
* 
* Method: rotate() 
* 
*/ 
@Test
public void testRotate() throws Exception {
	Game game = new Game();
	RightL piece = new RightL(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(5, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(5, piece.getBlocks().get(2).getX());
	assertEquals(2, piece.getBlocks().get(2).getY());

	assertEquals(4, piece.getBlocks().get(3).getX());
	assertEquals(2, piece.getBlocks().get(3).getY());

	piece.rotate();

	assertEquals(6, piece.getBlocks().get(0).getX());
	assertEquals(1, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(4, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(4, piece.getBlocks().get(3).getX());
	assertEquals(0, piece.getBlocks().get(3).getY());

	for(Block b : piece.getBlocks())
		b.setY(b.getY() + 2);

	piece.rotate();

	assertEquals(5, piece.getBlocks().get(0).getX());
	assertEquals(3, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(2, piece.getBlocks().get(1).getY());

	assertEquals(5, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(6, piece.getBlocks().get(3).getX());
	assertEquals(1, piece.getBlocks().get(3).getY());

	piece.rotate();

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(2, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(2, piece.getBlocks().get(1).getY());

	assertEquals(6, piece.getBlocks().get(2).getX());
	assertEquals(2, piece.getBlocks().get(2).getY());

	assertEquals(6, piece.getBlocks().get(3).getX());
	assertEquals(3, piece.getBlocks().get(3).getY());

	piece.rotate();

	assertEquals(5, piece.getBlocks().get(0).getX());
	assertEquals(1, piece.getBlocks().get(0).getY());

	assertEquals(5, piece.getBlocks().get(1).getX());
	assertEquals(2, piece.getBlocks().get(1).getY());

	assertEquals(5, piece.getBlocks().get(2).getX());
	assertEquals(3, piece.getBlocks().get(2).getY());

	assertEquals(4, piece.getBlocks().get(3).getX());
	assertEquals(3, piece.getBlocks().get(3).getY());
}


} 
