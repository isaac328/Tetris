package test.main.factory; 

import main.Game;
import main.factory.LeftArmFactory;
import main.factory.LeftLFactory;
import main.pieces.LeftArm;
import main.pieces.LeftL;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertTrue;

/** 
* LeftLFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 10, 2018</pre> 
* @version 1.0 
*/ 
public class LeftLFactoryTest { 

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
	LeftLFactory test = new LeftLFactory();

	assertTrue(test.makePiece(game) instanceof LeftL);
}


} 
