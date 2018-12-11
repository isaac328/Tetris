package test.main.factory; 

import main.Game;
import main.Piece;
import main.factory.LeftArmFactory;
import main.pieces.LeftArm;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* LeftArmFactory Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 10, 2018</pre> 
* @version 1.0 
*/ 
public class LeftArmFactoryTest { 

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
	LeftArmFactory test = new LeftArmFactory();

	assertTrue(test.makePiece(game) instanceof LeftArm);

}


} 
