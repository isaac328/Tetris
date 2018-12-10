package test.main; 

import main.Block;
import main.Game;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* Block Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 6, 2018</pre> 
* @version 1.0 
*/ 
public class BlockTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

/** 
* 
* Method: setX(int x) 
* 
*/ 
@Test
public void testGetSetX() throws Exception {
	Game game = new Game();
	Block b = new Block(game, 2, 2);

	assertEquals(2, b.getX());

	b.setX(5);

	assertEquals(5, b.getX());
}

/** 
* 
* Method: setY(int y) 
* 
*/ 
@Test
public void testGetSetY() throws Exception {
	Game game = new Game();
	Block b = new Block(game, 2, 2);

	assertEquals(2, b.getY());

	b.setY(5);

	assertEquals(5, b.getY());
}


} 
