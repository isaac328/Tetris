package main;

import main.factory.PieceFactory;
import processing.core.PApplet;

import java.util.ArrayList;

public class Controller {

	private ArrayList<Piece> pieces;
	private int[][] grid;
	private PieceFactory factory;
	private PApplet p;
	private int score;

	public Controller(PApplet p){
		this.p = p;
		pieces = new ArrayList<>();
		factory = PieceFactory.getFactory();
		score = 0;

		grid = new int[500/50][800/50];
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[x].length; y++)
			{
				grid[x][y] = 0;
			}
		}
	}

	//create new piece and add it to the top of the list
	public void newPiece() throws Exception
	{
		pieces.add(0, factory.makePiece(p));
		factory = PieceFactory.getFactory();
	}

	//moves the falling blocks down every specified time frame
	public void moveBlockDown(int time) throws Exception
	{
		//make sure theres nothing under the piece
		if(pieces.get(0).checkClearBelow())
		{
			//set time frame
			if(p.frameCount % time == 0)
			{
				//move pieces down one and check if full rows
				pieces.get(0).update();
				checkIfRowsCanBeCleared();
			}
		}
		//if there is something under the piece(another block, the bottom)
		else
		{
			//still within time frame
			if(p.frameCount % time == 0)
			{
				//update the grid with the new piece, check for full row, make new piece
				updateGrid(pieces.get(0));
				checkIfRowsCanBeCleared();
				newPiece();
			}
		}
	}

	//this method is used for controls (left right etc).
	public void processInput()
	{
		//if a key is pressed
		if(p.keyPressed)
		{
			//if the key is a and the left side of the piece is clear
			if(p.key == 'a' && canMoveLeft())
			{
				//move all the blocks to the left one
				for(Block b : pieces.get(0).getBlocks())
					b.setX(b.getX() - 1);
			}
			//if the player wants to move right and the right side is clear
			else if(p.key == 'd' && canMoveRight())
			{
				//move all the blocks right one
				for(Block b : pieces.get(0).getBlocks())
					b.setX(b.getX() + 1);
			}
			//if they press s and want to go down
			else if(p.key == 's')
			{
				//move all the blocks down one
				for(Block b : pieces.get(0).getBlocks())
				{
					b.setY(b.getY() + 1);
				}
			}
			//if they press w
			else if(p.key == 'w')
			{
				//rotate the piece
				pieces.get(0).rotate();
			}
			//if the game is launched from console, pressing g will display the grid system
			else if(p.key == 'g')
			{
				for(int y = 0; y < p.height/50; y++)
				{
					for(int x = 0; x < p.width/50; x++)
					{
						System.out.print(grid[x][y]);
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}

	//this leftClear checks for walls and other blocks, used for moving left
	private boolean canMoveLeft()
	{
		for(Block b : pieces.get(0).getBlocks())
		{
			if(b.getX() <= 0 || grid[b.getX() - 1][b.getY()] != 0)
				return false;
		}
		return true;
	}

	//this RightClear checks for blocks and walls, used for moving right
	private boolean canMoveRight()
	{
		for(Block b : pieces.get(0).getBlocks())
		{
			if(b.getX() + 1 >= p.width/50 || grid[b.getX() + 1][b.getY()] != 0)
				return false;
		}
		return true;
	}

	//this method checks to see if there are any full rows, updates the score
	public void checkIfRowsCanBeCleared()
	{
		int rowsCleared = 0;

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
				resetGrid();
				rowsCleared += 1;
			}
		}
		score += (int)Math.pow(rowsCleared, 2) * 100;
	}

	//moves all the pieces down after a full row
	private void moveAll(int y)
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


	//used for deleting a full row of blocks
	private void deleteRow(int y)
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
	private void resetGrid()
	{
		//create the temporary grid
		grid = new int[p.width/50][p.height/50];
		//go through all the blocks in every piece and mark it on the grid
		for(Piece p : pieces)
		{
			for(Block b : p.getBlocks())
			{
				grid[b.getX()][b.getY()] = 1;
			}
		}
	}

	//method that marks the locations of all the blocks on the grid
	public void updateGrid(Piece piece)
	{
		for(Block b : piece.getBlocks())
		{
			grid[b.getX()][b.getY()	] = 1;
		}
	}

	public int[][] getGrid(){ return this.grid; }


	public int getScore(){
		return score;
	}


	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
}
