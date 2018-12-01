package test.main.pieces; 

import main.Game;
import main.pieces.LeftArm;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* LeftArm Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 1, 2018</pre> 
* @version 1.0 
*/ 
public class LeftArmTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

@Test
public void testConstructor() throws Exception{
	Game game = new Game();
	LeftArm arm = new LeftArm(game);

	assertEquals(4, arm.getBlocks().size());

	assertEquals(4, arm.getBlocks().get(0).getX());
	assertEquals(0, arm.getBlocks().get(0).getY());

	assertEquals(4, arm.getBlocks().get(1).getX());
	assertEquals(1, arm.getBlocks().get(1).getY());

	assertEquals(5, arm.getBlocks().get(2).getX());
	assertEquals(1, arm.getBlocks().get(2).getY());

	assertEquals(5, arm.getBlocks().get(3).getX());
	assertEquals(2, arm.getBlocks().get(3).getY());

}

/** 
* 
* Method: rotate() 
* 
*/ 
@Test
public void testRotate() throws Exception {
	Game game = new Game();
	LeftArm arm = new LeftArm(game);

	assertEquals(4, arm.getBlocks().get(0).getX());
	assertEquals(0, arm.getBlocks().get(0).getY());

	assertEquals(4, arm.getBlocks().get(1).getX());
	assertEquals(1, arm.getBlocks().get(1).getY());

	assertEquals(5, arm.getBlocks().get(2).getX());
	assertEquals(1, arm.getBlocks().get(2).getY());

	assertEquals(5, arm.getBlocks().get(3).getX());
	assertEquals(2, arm.getBlocks().get(3).getY());

	arm.rotate();

	assertEquals(6, arm.getBlocks().get(0).getX());
	assertEquals(1, arm.getBlocks().get(0).getY());

	assertEquals(5, arm.getBlocks().get(1).getX());
	assertEquals(1, arm.getBlocks().get(1).getY());

	assertEquals(5, arm.getBlocks().get(2).getX());
	assertEquals(2, arm.getBlocks().get(2).getY());

	assertEquals(4, arm.getBlocks().get(3).getX());
	assertEquals(2, arm.getBlocks().get(3).getY());

	arm.rotate();

	assertEquals(4, arm.getBlocks().get(0).getX());
	assertEquals(0, arm.getBlocks().get(0).getY());

	assertEquals(4, arm.getBlocks().get(1).getX());
	assertEquals(1, arm.getBlocks().get(1).getY());

	assertEquals(5, arm.getBlocks().get(2).getX());
	assertEquals(1, arm.getBlocks().get(2).getY());

	assertEquals(5, arm.getBlocks().get(3).getX());
	assertEquals(2, arm.getBlocks().get(3).getY());

}


} 
