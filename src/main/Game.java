package main;

import java.util.ArrayList;

import main.factory.PieceFactory;
import processing.core.*;

public class Game extends PApplet
{
	private int[][] grid;
	private ArrayList<Piece> pieces;
	private boolean paused = false;
	private PieceFactory factory;

	public Game(){
		super();
		grid = new int[500/50][800/50];
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[x].length; y++)
			{
				grid[x][y] = 0;
			}
		}
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
		factory = PieceFactory.getFactory();
		pieces = new ArrayList<>();
		try{
			newPiece();
		}
		catch (Exception ex){ System.out.println(ex.getMessage());}
		grid = new int[width/50][height/50];
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[x].length; y++)
			{
				grid[x][y] = 0;
			}
		}
	}
	
	//this method loops, everything in this method is executed every frame
	@Override
	public void draw()
	{
		//set background to black
		background(0);
		//draw all the peices
		for(Piece p : pieces)
		{
			p.show();
		}
		//if not paused, move the blocks down
		if(paused == false)
		{
			try{
				moveDown(50);
			}
			catch (Exception ex){ System.out.println(ex.getMessage());}
		}
	}
	
	//moves the falling blocks down every specified time frame
	public void moveDown(int time) throws Exception
	{
		//make sure theres nothing under the piece
		if(pieces.get(0).check(grid))
		{
			//set time frame
			if(frameCount % time == 0)
			{
				//move pieces down one and check if full rows
				pieces.get(0).update();
				checkRows();
			}
		}
		//if there is something under the piece(another block, the bottom)
		else
		{
			//still within time frame
			if(frameCount % time == 0)
			{
				//update the grid with the new piece, check for full row, make new piece
				grid = pieces.get(0).updateGrid(grid);
				checkRows();
				newPiece();
			}
		}
	}
	
	//create new piece and add it to the top of the list
	public void newPiece() throws Exception
	{
		pieces.add(0, factory.makePiece(this));
		factory = PieceFactory.getFactory();
	}
	
	//if the user presses a key
	@Override
	public void keyPressed()
	{
		//send all keys except for p to the individual piece
		pieces.get(0).checkMove(grid);
		//if it is p, toggle paused
		if(key == 'p')
		{
			if(paused == false)
				paused = true;
			else
				paused = false;
		}
	}
	
	//this method checks to see if there are any full rows
	public void checkRows()
	{
		for(int y = 0; y < height/50; y++)
		{
			//count gets set to 0 at the start of every row
			int count = 0;
			for(int x = 0; x < width/50; x++)
			{
				//check every grid spot in each row, if a block is there(1), add it to the count 
				if(grid[x][y] != 0)
				{	
					count++;
				}
			}
			//if the count is 10(full row), delete the row, move all the blocks down, reset the grid
			if(count == 10)
			{
				deleteRow(y);
				moveAll(y);
				grid = resetGrid();
			}
		}
	}
	
	//used for deleting a full row of blocks
	public void deleteRow(int y)
	{
		//make an array to store the empty peices to be deleted
		ArrayList<Piece> emptyPieces = new ArrayList<>();
		
		for(Piece p : pieces)
		{
			//make an array to store all the individual blocks to be deleted
			ArrayList<Block> toRemove = new ArrayList<>();
			
			for(Block b : p.getBlocks())
			{
				//if the block is in the full row, add it to the trash pile
				if(b.getY() == y)
					toRemove.add(b);
			}
			//after all blocks have been added, delete them
			p.getBlocks().removeAll(toRemove);
			
			//if the piece has no blocks left in its list, add it to the trash pile
			if(p.getBlocks().isEmpty())
			{
				emptyPieces.add(p);
			}
		}
		
		//delete all the empty pieces
		if(!emptyPieces.isEmpty())
		{
			pieces.removeAll(emptyPieces);
		}
	}
	
	//used to make a new grid when a row is deleted
	public int[][] resetGrid()
	{
		//create the temporary grid
		int[][] newGrid = new int[width/50][height/50];
		//go through all the blocks in every piece and mark it on the grid
		for(Piece p : pieces)
		{
			for(Block b : p.getBlocks())
			{
				newGrid[b.getX()][b.getY()] = 1;
			}
		}
		//return the new grid
		return newGrid;
	}

	public int[][] getGrid(){ return this.grid; }
	
	//moves all the pieces down after a full row
	public void moveAll(int y)
	{
		//sort through all the pieces
		for(Piece p : pieces)
		{
			for(Block b : p.getBlocks())
			{
				//the block has to be above the deleted row to be moved down
				if(b.getY() < y)
				{
					b.setY(b.getY() + 1);
				}
			}
		}
	}

	//run main method from PApplet
	public static void main(String[] args)
	{
		PApplet.main("main.Game");
	}
}
