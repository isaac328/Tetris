package main;

import java.util.ArrayList;
import processing.core.*;

public abstract class Piece
{
	private ArrayList<Block> blocks;
	private PApplet p;
	private int[][] grid;


	public abstract void setColor();
	public abstract void rotate();
	
	public Piece(PApplet p)
	{
		blocks = new ArrayList<>(4);
		this.p = p;
	}

	public PApplet getPApplet(){ return this.p; }

	public ArrayList<Block> getBlocks(){ return this.blocks; }

	public int[][] getGrid(){ return this.grid; }
	
	public void show()
	{
		setColor();
		for(Block b : blocks)
			b.show();
	}
	
	//moves all the blocks down one
	public void update()
	{
		for(Block b : blocks)
		{
			b.setY(b.getY() + 1);
		}
	}
	
	//checks if the current block is above another block or on the bottom
	public boolean check(int[][] grid)
	{
		for(Block b : blocks)
		{
			if(b.getY() >= p.height/50 - 1 || grid[b.getX()][b.getY()+1] != 0)
			{
				return false;
			}
		}
		return true;
	}
	
	//method that marks the locations of all the blocks on the grid
	public int[][] updateGrid(int[][] grid)
	{
		for(Block b : blocks)
		{
			grid[b.getX()][b.getY()	] = 1;
		}
		return grid;
	}
	
	//this method is used for controls (left right etc).
	public void checkMove(int[][] grid) 
	{
		//update the grid
		this.grid = grid;
		
		//if a key is pressed
		if(p.keyPressed)
		{	
			//if the key is a and the left side of the piece is clear
			if(p.key == 'a' && leftClear(grid))
			{
				//move all the blocks to the left one
				for(Block b : blocks)
					b.setX(b.getX() - 1);
			}
			//if the player wants to move right and the right side is clear
			else if(p.key == 'd' && rightClear(grid))
			{
				//move all the blocks right one
				for(Block b : blocks)
					b.setX(b.getX() + 1);
			}
			//if they press s and want to go down
			else if(p.key == 's')
			{
				//move all the blocks down one
				for(Block b : blocks)
				{
					b.setY(b.getY() + 1);
				}
			}
			//if they press w
			else if(p.key == 'w')
			{
				//rotate the piece
				rotate();
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
	public boolean leftClear(int[][] grid)
	{
		for(Block b : blocks)
		{
			if(b.getX() <= 0 || grid[b.getX() - 1][b.getY()] != 0)
				return false;
		}
		return true;
	}
	
	//this leftClear checks only for other blocks, used for rotating
	public boolean leftClear()
	{
		for(Block b : blocks)
		{
			if(grid[b.getX() - 1][b.getY()] != 0 || grid[b.getX() - 2][b.getY()] != 0)
				return false;
		}
		return true;
	}
	//this RightClear checks for blocks and walls, used for moving right
	public boolean rightClear(int[][] grid)
	{
		for(Block b : blocks)
		{
			if(b.getX() + 1 >= p.width/50 || grid[b.getX() + 1][b.getY()] != 0)
				return false;
		}
		return true;
	}
	//this rightClear checks only for blocks, used for rotation.
	public boolean rightClear()
	{
		for(Block b : blocks)
		{
			if(grid[b.getX() + 1][b.getY()] != 0 || grid[b.getX() + 2][b.getY()] != 0)
				return false;
		}
		return true;
	}

	//used for rotating the pieces
//	public void rotate()
//	{
//		//find out which type the piece is and call that specific rotate statement
//		if(type == 0)
//			rotateLine();
//		else if(type == 2)
//			rotateRightArm();
//		else if(type == 3)
//			rotateLeftArm();
//		else if(type == 4)
//			rotateTPiece();
//		else if(type == 5)
//			rotateRightL();
//		else if(type == 6)
//			rotateLeftL();
//	}

}
