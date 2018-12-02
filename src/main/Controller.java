package main;

import main.factory.PieceFactory;
import processing.core.PApplet;

import java.util.ArrayList;

public class Controller {

	private ArrayList<Piece> pieces;
	private int[][] grid;
	private PieceFactory factory;
	private PApplet p;

	public Controller(PApplet p){
		this.p = p;
		pieces = new ArrayList<>();
		factory = PieceFactory.getFactory();

		grid = new int[500/50][800/50];
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[x].length; y++)
			{
				grid[x][y] = 0;
			}
		}
	}

	//moves the falling blocks down every specified time frame
	public void moveDown(int time) throws Exception
	{
		//make sure theres nothing under the piece
		if(pieces.get(0).check(grid))
		{
			//set time frame
			if(p.frameCount % time == 0)
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
			if(p.frameCount % time == 0)
			{
				//update the grid with the new piece, check for full row, make new piece
				grid = pieces.get(0).updateGrid(grid);
				checkRows();
				newPiece();
			}
		}
	}

	//this method checks to see if there are any full rows
	public void checkRows()
	{
		for(int y = 0; y < p.height/50; y++)
		{
			//count gets set to 0 at the start of every row
			int count = 0;
			for(int x = 0; x < p.width/50; x++)
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
		int[][] newGrid = new int[p.width/50][p.height/50];
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

	//create new piece and add it to the top of the list
	public void newPiece() throws Exception
	{
		pieces.add(0, factory.makePiece(p));
		factory = PieceFactory.getFactory();
	}

	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
}
