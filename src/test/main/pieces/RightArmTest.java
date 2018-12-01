package test.main.pieces; 

import main.Block;
import main.Game;
import main.pieces.RightArm;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* RightArm Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class RightArmTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void testConstructor() throws Exception{
	Game game = new Game();
	RightArm piece = new RightArm(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(4, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(3, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(3, piece.getBlocks().get(3).getX());
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
	RightArm piece = new RightArm(game);

	assertEquals(4, piece.getBlocks().size());

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(0, piece.getBlocks().get(0).getY());

	assertEquals(4, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(3, piece.getBlocks().get(2).getX());
	assertEquals(1, piece.getBlocks().get(2).getY());

	assertEquals(3, piece.getBlocks().get(3).getX());
	assertEquals(2, piece.getBlocks().get(3).getY());

	piece.rotate();

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(1, piece.getBlocks().get(0).getY());

	assertEquals(3, piece.getBlocks().get(1).getX());
	assertEquals(1, piece.getBlocks().get(1).getY());

	assertEquals(3, piece.getBlocks().get(2).getX());
	assertEquals(0, piece.getBlocks().get(2).getY());

	assertEquals(2, piece.getBlocks().get(3).getX());
	assertEquals(0, piece.getBlocks().get(3).getY());

	for(Block b : piece.getBlocks()){
		b.setY(b.getY() + 1);
	}

	piece.rotate();

	assertEquals(4, piece.getBlocks().get(0).getX());
	assertEquals(1, piece.getBlocks().get(0).getY());

	assertEquals(4, piece.getBlocks().get(1).getX());
	assertEquals(2, piece.getBlocks().get(1).getY());

	assertEquals(3, piece.getBlocks().get(2).getX());
	assertEquals(2, piece.getBlocks().get(2).getY());

	assertEquals(3, piece.getBlocks().get(3).getX());
	assertEquals(3, piece.getBlocks().get(3).getY());
}


} 