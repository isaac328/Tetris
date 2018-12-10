package test.main; 

import main.Controller;
import main.Game;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* Game Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 6, 2018</pre> 
* @version 1.0 
*/ 
public class GameTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


/** 
* 
* Method: getController() 
* 
*/ 
@Test
public void testGetController() throws Exception {
	Game game = new Game();
	assertTrue(game.getController() instanceof Controller);
}

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
}
} 
