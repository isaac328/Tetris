package test.main.factory; 

import main.Game;
import main.factory.RightLFactory;
import main.pieces.RightL;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertTrue;

/** 
* RightLFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 10, 2018</pre> 
* @version 1.0 
*/ 
public class RightLFactoryTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: makePiece(PApplet p) 
* 
*/ 
@Test
public void testMakePiece() throws Exception {
	Game game = new Game();
	RightLFactory test = new RightLFactory();

	assertTrue(test.makePiece(game) instanceof RightL);
}


} 
