package main;

import processing.core.*;

public class Game extends PApplet
{
	private boolean paused = false;
	private Controller controller;

	public Game(){
		super();
		controller = new Controller(this);
	}

	
	//set the size
	@Override
	public void settings()
	{
		size(500, 800);
	}
	
	//set color mode, create instances, create first piece, initialize grid with all 0
	@Override
	public void setup()
	{
		colorMode(HSB);
		controller = new Controller(this);
		try{
			controller.newPiece();
		}
		catch (Exception ex){ System.out.println(ex.getMessage());}
	}
	
	//this method loops, everything in this method is executed every frame
	@Override
	public void draw()
	{
		//set background to black
		background(0);
		//draw all the peices
		for(Piece p : controller.getPieces())
		{
			p.show();
		}
		//if not paused, move the blocks down
		if(paused == false)
		{
			try{
				controller.moveDown(50);
			}
			catch (Exception ex){ System.out.println(ex.getMessage());}
		}
	}
	
	//if the user presses a key
	@Override
	public void keyPressed()
	{
		//send all keys except for p to the individual piece
		controller.getPieces().get(0).checkMove(controller.getGrid());
		//if it is p, toggle paused
		if(key == 'p')
		{
			if(paused == false)
				paused = true;
			else
				paused = false;
		}
	}

	public Controller getController(){ return this.controller; }

	//run main method from PApplet
	public static void main(String[] args)
	{
		PApplet.main("main.Game");
	}
}
