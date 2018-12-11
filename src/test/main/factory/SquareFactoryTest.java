package test.main.factory; 

import main.Game;
import main.factory.LeftLFactory;
import main.factory.SquareFactory;
import main.pieces.LeftL;
import main.pieces.Square;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertTrue;

/** 
* SquareFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 10, 2018</pre> 
* @version 1.0 
*/ 
public class SquareFactoryTest { 

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
	SquareFactory test = new SquareFactory();

	assertTrue(test.makePiece(game) instanceof Square);
}


} 
