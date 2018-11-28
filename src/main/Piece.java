package main;

import java.util.ArrayList;
import java.util.Random;

import processing.core.*;

public class Piece 
{
	ArrayList<Block> blocks;
	PApplet p;
	int type;
	int position;
	int[][] grid;
	Random rand = new Random();
	
	public Piece(PApplet p)
	{
		blocks = new ArrayList<>(4);
		this.p = p;
		type = rand.nextInt(7);
		//type = 0;
		createPiece();
		position = 0;
	}
	
	public void createPiece()
	{
		switch(type)
		{
			//linePiece
			case 0:
				for(int y = 0; y < 4; y++)
				{
					blocks.add(new Block(p, 4, y));
				}
				break;
			//SquarePiece
			case 1:
				blocks.add(new Block(p, 4, 0));
				blocks.add(new Block(p, 5, 0));
				blocks.add(new Block(p, 4, 1));
				blocks.add(new Block(p, 5, 1));
				break;
			//right arm
			case 2:
				blocks.add(new Block(p, 4, 0));
				blocks.add(new Block(p, 4, 1));
				blocks.add(new Block(p, 3, 1));
				blocks.add(new Block(p, 3, 2));
				break;
			//left arm
			case 3:
				blocks.add(new Block(p, 4, 0));
				blocks.add(new Block(p, 4, 1));
				blocks.add(new Block(p, 5, 1));
				blocks.add(new Block(p, 5, 2));
				break;
			//T Piece
			case 4:
				blocks.add(new Block(p, 4, 0));
				blocks.add(new Block(p, 3, 1));
				blocks.add(new Block(p, 4, 1));
				blocks.add(new Block(p, 5, 1));
				break;
			//right L
			case 5:
				blocks.add(new Block(p, 5, 0));
				blocks.add(new Block(p, 5, 1));
				blocks.add(new Block(p, 5, 2));
				blocks.add(new Block(p, 4, 2));
				break;
			//left L
			case 6:
				blocks.add(new Block(p, 4, 0));
				blocks.add(new Block(p, 4, 1));
				blocks.add(new Block(p, 4, 2));
				blocks.add(new Block(p, 5, 2));
				break;
		}
	}
	
	public void show()
	{
		switch(type)
		{
			//Line
			case 0:
				p.fill(36, 255, 255);
				break;
			//Square
			case 1:
				p.fill(0, 255, 255);
				break;
			//Right Arm
			case 2:
				p.fill(255, 255, 255);
				break;
			//Left Arm
			case 3:
				p.fill(82, 255, 255);
				break;
			//T Piece
			case 4:
				p.fill(205, 255, 255);
				break;
			//right L
			case 5:
				p.fill(100, 255, 255);
				break;
			//left L
			case 6:
				p.fill(27, 255, 255);
				break;
		}
		for(Block b : blocks)
			b.show();
	}
	
	//moves all the blocks down one
	public void update()
	{
		for(Block b : blocks)
		{
			b.y += 1;
		}
	}
	
	//checks if the current block is above another block or on the bottom
	public boolean check(int[][] grid)
	{
		for(Block b : blocks)
		{
			if(b.y >= p.height/50 - 1 || grid[b.x][b.y+1] != 0)
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
			grid[b.x][b.y] = 1;
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
					b.x -= 1;
			}
			//if the player wants to move right and the right side is clear
			else if(p.key == 'd' && rightClear(grid))
			{
				//move all the blocks right one
				for(Block b : blocks)
					b.x += 1;
			}
			//if they press s and want to go down
			else if(p.key == 's')
			{
				//move all the blocks down one
				for(Block b : blocks)
				{
					b.y += 1;
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
			if(b.x <= 0 || grid[b.x - 1][b.y] != 0)
				return false;
		}
		return true;
	}
	
	//this leftClear checks only for other blocks, used for rotating
	public boolean leftClear()
	{
		for(Block b : blocks)
		{
			if(grid[b.x - 1][b.y] != 0 || grid[b.x - 2][b.y] != 0)
				return false;
		}
		return true;
	}
	//this RightClear checks for blocks and walls, used for moving right
	public boolean rightClear(int[][] grid)
	{
		for(Block b : blocks)
		{
			if(b.x + 1 >= p.width/50 || grid[b.x + 1][b.y] != 0)
				return false;
		}
		return true;
	}
	//this rightClear checks only for blocks, used for rotation.
	public boolean rightClear()
	{
		for(Block b : blocks)
		{
			if(grid[b.x + 1][b.y] != 0 || grid[b.x + 2][b.y] != 0)
				return false;
		}
		return true;
	}
	//used for rotating the pieces
	public void rotate()
	{
		//find out which type the piece is and call that specific rotate statement
		if(type == 0)
			rotateLine();
		else if(type == 2)
			rotateRightArm();
		else if(type == 3)
			rotateLeftArm();
		else if(type == 4)
			rotateTPiece();
		else if(type == 5)
			rotateRightL();
		else if(type == 6)
			rotateLeftL();
	}
	
	//used to rotate a line
	public void rotateLine()
	{
		//if its in the starting position
		if(position == 0)
		{
			//get the x position of one block(theyre all the same)
			int x = blocks.get(0).x;
			//make sure x is far enough away from the left wall and the right is clear
			if(x < 2 && rightClear())
			{
				//rotate blocks
				blocks.get(0).x = 3;
				blocks.get(0).y += 1;
				blocks.get(1).x = 2;
				blocks.get(2).x = 1;
				blocks.get(2).y -= 1;
				blocks.get(3).x = 0;
				blocks.get(3).y -= 2;
				position = 1;
			}
			//make sure x is far enough away from right wall and the left side is clear
			else if(x > 7 && leftClear())
			{
				//rotate blocks
				blocks.get(0).x = 9;
				blocks.get(0).y += 1;
				blocks.get(1).x = 8;
				blocks.get(2).x = 7;
				blocks.get(2).y -= 1;
				blocks.get(3).x = 6;
				blocks.get(3).y -= 2;
				position = 1;
			}
			//if its in the middle, just make sure right and left is clear
			else if(rightClear() && leftClear())
			{
				//rotate blocks
				blocks.get(0).x += 1;
				blocks.get(0).y += 1;
				blocks.get(2).x -= 1;
				blocks.get(2).y -= 1;
				blocks.get(3).x -= 2;
				blocks.get(3).y -= 2;
				position = 1;
			}
			//change position to 1 after a successful rotation
		}
		//if the line is in the sideways position
		else if(position == 1)
		{
			//rotate blocks
			blocks.get(0).x -= 1;
			blocks.get(0).y -= 1;
			blocks.get(2).x += 1;
			blocks.get(2).y += 1;
			blocks.get(3).x += 2;
			blocks.get(3).y += 2;	
			position = 0;
		}
	}
	
	//right arm rotation method
	public void rotateRightArm()
	{
		//make copies of all the blocks for ease of testing
		Block b0 = blocks.get(0);
		Block b1 = blocks.get(1);
		Block b2 = blocks.get(2);
		Block b3 = blocks.get(3);
		
		//if the piece is in the starting position
		if(position == 0)
		{
			//if the piece is up against the left wall
			if(b2.x == 0)
			{
				//make sure the peice wont rotate into anything
				if(grid[b1.x + 1][b1.y + 1] == 0)
				{
					//rotate peice, set position to 1
					blocks.get(3).y -= 1;
					blocks.get(2).x += 1;
					blocks.get(1).y += 1;
					blocks.get(0).y += 2;
					blocks.get(0).x += 1;
					position = 1;
				}
			}
			//if the piece is up against the right wall
			else if(b0.x == 9)
			{
				//make sure peice is clear to rotate
				if(grid[b2.x - 1][b2.y - 1] == 0)
				{
					//rotate, position is 1
					blocks.get(0).y += 1;
					blocks.get(1).x -= 1;
					blocks.get(2).y -= 1;
					blocks.get(3).y -= 2;
					blocks.get(3).x -= 1;
					position = 1;
				}
			}
			//if its in the middle, check if clear
			else if(grid[b3.x - 1][b3.y - 1] == 0)
			{
				//rotate, position is 1
				blocks.get(0).y += 1;
				blocks.get(1).x -= 1;
				blocks.get(2).y -= 1;
				blocks.get(3).y -= 2;
				blocks.get(3).x -= 1;
				position = 1;
				
			}
		}
		//if the piece has rotated once
		else if(position == 1)
		{
			//if the piece is on the bottom
			if(b0.y == p.height/50 - 1)
			{
				//make sure its clear to rotate
				if(grid[b2.x - 1][b2.y] == 0 && grid[b1.x][b1.y - 1] == 0)
				{
					//rotate, set position back to original
					blocks.get(0).x -= 1;
					blocks.get(1).y -= 1;
					blocks.get(2).x += 1;
					blocks.get(3).x += 2;
					blocks.get(3).y -= 1;
					position = 0;
					
				}
			}
			//if its in the middle, check to make sure its clear
			else if(grid[b1.x + 1][b1.y] == 0 && grid[b1.x + 1][b1.y - 1] == 0)
			{
				blocks.get(0).y -= 1;
				blocks.get(1).x += 1;
				blocks.get(2).y += 1;
				blocks.get(3).y += 2;
				blocks.get(3).x += 1;
				position = 0;
			}
		}
	}
	
	//rotation for left arm
	public void rotateLeftArm()
	{
		//get individual pieces
		Block b0 = blocks.get(0);
		Block b1 = blocks.get(1);
		Block b2 = blocks.get(2);
		Block b3 = blocks.get(3);
		
		//if starting position
		if(position == 0)
		{
			//if its on the right wall
			if(b2.x == p.width/50 - 1)
			{
				//check if clear, rotate
				if(grid[b1.x][b1.y + 1] == 0 && grid[b1.x - 1][b1.y - 1] == 0)
				{
					blocks.get(0).y += 1;
					blocks.get(0).x += 1;
					blocks.get(2).x -= 1;
					blocks.get(2).y += 1;
					blocks.get(3).x -= 2;
					position = 1;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(grid[b3.x - 1][b3.y] == 0 && grid[b2.x + 1][b2.y] == 0)
			{
				blocks.get(0).y += 1;
				blocks.get(0).x += 2;
				blocks.get(1).x += 1;
				blocks.get(2).y += 1;
				blocks.get(3).x -= 1;
				
				position = 1;
			}
		}
		//if in rotated position
		else if(position == 1)
		{
			//check if clear, rotate
			if(grid[b1.x - 1][b1.y] == 0 && grid[b1.x - 1][b1.y - 1] == 0)
			{
				blocks.get(0).y -= 1;
				blocks.get(0).x -= 2;
				blocks.get(1).x -= 1;
				blocks.get(2).y -= 1;
				blocks.get(3).x += 1;
				
				position = 0;
			}
		}			
	}
	
	//rotation for T piece
	public void rotateTPiece()
	{
		//get individual blocks
		Block b0 = blocks.get(0);
		Block b1 = blocks.get(1);
		Block b2 = blocks.get(2);
		Block b3 = blocks.get(3);
		
		//if original position
		if(position == 0)
		{
			//if on the top(player rotated right away)
			if(b0.y == 0)
			{
				//check clear, rotate
				if(grid[b2.x][b2.y + 1] == 0)
				{
					blocks.get(0).x += 1;
					blocks.get(0).y += 1;
					blocks.get(1).x += 1;
					blocks.get(1).y -= 1;
					blocks.get(3).x -= 1;
					blocks.get(3).y += 1;
					position = 1;
				}
			}
			//if in middle, check clear, rotate
			else if(grid[b0.x][b0.y - 1] == 0 && grid[b0.x + 1][b0.y] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(1).x += 1;
				blocks.get(1).y -= 2;
				blocks.get(2).y -= 1;
				blocks.get(3).x -= 1;
				position = 1;
			}
		}
		//if in first rotated position
		else if(position == 1)
		{
			//if on left wall
			if(b1.x == 0)
			{
				//check clear, rotate
				if(grid[b0.x + 1][b0.y] == 0 && grid[b3.x + 1][b3.y] == 0)
				{
					blocks.get(0).y += 1;
					blocks.get(1).x += 2;
					blocks.get(1).y += 1;
					blocks.get(2).x += 1;
					blocks.get(3).y -= 1;
					position = 2;
				}
			}
			//if on right wall or middle, check clear, rotate
			else if(grid[b2.x - 1][b2.y] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(0).y += 1;
				blocks.get(1).x += 1;
				blocks.get(1).y += 1;
				blocks.get(3).x -= 1;
				blocks.get(3).y -= 1;
				position = 2;
			}
		}
		//if piece has been rotated twice
		else if(position == 2)
		{
			//check clear, rotate
			if(grid[b2.x][b2.y - 1] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(0).y -= 1;
				blocks.get(1).x -= 1;
				blocks.get(1).y += 1;
				blocks.get(3).x += 1;
				blocks.get(3).y -= 1;
				position = 3;
			}
		}
		//if piece has been rotated 3 times
		else if(position == 3)
		{
			//check clear, rotate, set position back to original
			if(grid[b2.x + 1][b2.y] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(0).y -= 1;
				blocks.get(1).x -= 1;
				blocks.get(1).y -= 1;
				blocks.get(3).x += 1;
				blocks.get(3).y += 1;
				position = 0;
			}
		}
	}
	
	//rotation method for right L piece
	public void rotateRightL()
	{
		//get individual blocks
		Block b0 = blocks.get(0);
		Block b1 = blocks.get(1);
		Block b2 = blocks.get(2);
		Block b3 = blocks.get(3);
		
		//if original position
		if(position == 0)
		{
			//if on the right wall
			if(b0.x == p.width/50 - 1)
			{
				//check if clear, rotate
				if(grid[b1.x - 1][b1.y] == 0 && grid[b1.x - 2][b1.y] == 0 && grid[b0.x - 2][b0.y] == 0)
				{
					blocks.get(0).y += 1;
					blocks.get(1).x -= 1;
					blocks.get(2).x -= 2;
					blocks.get(2).y -= 1;
					blocks.get(3).x -= 1;
					blocks.get(3).y -= 2;
					position = 1;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(grid[b1.x - 1][b1.y] == 0 && grid[b0.x - 1][b0.y] == 0 && grid[b1.x + 1][b1.y] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(0).y += 1;
				blocks.get(2).x -= 1;
				blocks.get(2).y -= 1;
				blocks.get(3).y -= 2;
				position = 1;
			}
		}
		//if piece has been rotated once
		else if(position == 1)
		{
			///check if clear, rotate
			if(grid[b1.x][b1.y - 1] == 0 && grid[b1.x][b1.y - 2] == 0 && grid[b0.x][b0.y - 2] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(1).y -= 1;
				blocks.get(2).x += 1;
				blocks.get(2).y -= 2;
				blocks.get(3).y -= 1;
				blocks.get(3).x += 2;
				position = 2;
			}
		}
		//if piece has been rotated twice
		else if(position == 2)
		{
			//if on left wall
			if(b0.x == 0)
			{
				//check if clear, rotate
				if(grid[b1.x + 1][b1.y] == 0 && grid[b1.x + 2][b1.y] == 0 && grid[b0.x + 2][b0.y] == 0)
				{
					blocks.get(0).y -= 1;
					blocks.get(1).x += 1;
					blocks.get(2).x += 2;
					blocks.get(2).y += 1;
					blocks.get(3).y += 2;
					blocks.get(3).x += 1;
					position = 3;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(grid[b0.x + 1][b0.y] == 0 && grid[b1.x + 1][b1.y] == 0 && grid[b1.x - 1][b1.y] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(0).y -= 1;
				blocks.get(2).x += 1;
				blocks.get(2).y += 1;
				blocks.get(3).y += 2;
				position = 3;
			}
		}
		//if piece has been rotated 3 times
		else if(position == 3)
		{
			//check if clear, rotate, set position to original
			if(grid[b0.x][b0.y - 1] == 0 && grid[b1.x][b1.y - 2] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(0).y -= 1;
				blocks.get(2).x -= 1;
				blocks.get(2).y += 1;
				blocks.get(3).x -= 2;
				position = 0;
			}
		}
	}
	
	//rotation for left L
	public void rotateLeftL()
	{
		//get individual blocks
		Block b0 = blocks.get(0);
		Block b1 = blocks.get(1);
		Block b2 = blocks.get(2);
		Block b3 = blocks.get(3);
		
		//if original position
		if(position == 0)
		{
			//if on left wall
			if(b0.x == 0)
			{
				//check if clear, rotate
				if(grid[b1.x + 1][b1.y] == 0 && grid[b1.x + 2][b1.y] == 0)
				{
					blocks.get(0).x += 2;
					blocks.get(0).y += 1;
					blocks.get(1).x += 1;
					blocks.get(2).y -= 1;
					blocks.get(3).x -= 1;
					position = 1;
				}
			}
			//if on right wall or middle, check if clear, rotate
			else if(grid[b1.x - 1][b1.y] == 0 && grid[b2.x - 1][b2.y] == 0 && grid[b1.x + 1][b2.y] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(0).y += 1;
				blocks.get(2).x -= 1;
				blocks.get(2).y -= 1;
				blocks.get(3).x -= 2;
				position = 1;
			}
		}
		//if piece has been rotated once
		else if(position == 1)
		{
			//check if clear, rotate
			if(grid[b1.x][b1.y + 1] == 0 && grid[b1.x][b1.y - 1] == 0 && grid[b2.x][b2.y - 1] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(0).y += 1;
				blocks.get(2).x += 1;
				blocks.get(2).y -= 1;
				blocks.get(3).y -= 2;
				position = 2;
			}
		}
		//if peice has been rotated twice
		else if(position == 2)
		{
			//if on right wall
			if(b0.x == p.width / 50 - 1)
			{
				//check if clear, rotate
				if(grid[b1.x - 1][b1.y] == 0 && grid[b1.x - 2][b1.y] == 0)
				{
					blocks.get(0).x -= 2;
					blocks.get(0).y -= 1;
					blocks.get(1).x -= 1;
					blocks.get(2).y += 1;
					blocks.get(3).x += 1;
					position = 3;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(grid[b1.x - 1][b1.y] == 0 && grid[b1.x + 1][b1.y] == 0 && grid[b2.x + 1][b2.y] == 0)
			{
				blocks.get(0).x -= 1;
				blocks.get(0).y -= 1;
				blocks.get(2).x += 1;
				blocks.get(2).y += 1;
				blocks.get(3).x += 2;
				position = 3;
			}
		}
		//if piece has been rotated 3 times
		else if(position == 3)
		{
			//check if clear, rotate
			if(grid[b1.x][b1.y - 1] == 0 && grid[b1.x][b1.y - 2] == 0)
			{
				blocks.get(0).x += 1;
				blocks.get(0).y -= 2;
				blocks.get(1).y -= 1;
				blocks.get(2).x -= 1;
				blocks.get(3).y += 1;
				position = 0;
			}
		}
	}
}
