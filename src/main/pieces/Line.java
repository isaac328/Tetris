package main.pieces;

import main.Block;
import main.Piece;
import main.enums.LinePosition;
import processing.core.PApplet;

import java.util.ArrayList;

public class Line extends Piece {
	LinePosition position;

	public Line(PApplet p){
		super(p);
		ArrayList<Block> blocks = getBlocks();
		for(int y = 0; y < 4; y++)
		{
			blocks.add(new Block(p, 4, y));
		}
		position = LinePosition.UPRIGHT;
	}

	@Override
	public void setColor(){
		getPApplet().fill(36, 255, 255);
	}

	@Override
	public void rotate(){
		ArrayList<Block> blocks = getBlocks();

		//if its in the starting position
		if(position == LinePosition.UPRIGHT)
		{
			//get the x position of one block(they're all the same)
			int x = blocks.get(0).getX();
			//make sure x is far enough away from the left wall and the right is clear
			if(x < 2 && rightClear())
			{
				//rotate blocks
				blocks.get(0).setX(3);
				blocks.get(0).setY(blocks.get(0).getY() + 1);
				blocks.get(1).setX(2);
				blocks.get(2).setX(1);
				blocks.get(2).setY(blocks.get(2).getY() - 1);
				blocks.get(3).setX(0);
				blocks.get(3).setY(blocks.get(3).getY() - 2);
				position = LinePosition.FLAT;
			}
			//make sure x is far enough away from right wall and the left side is clear
			else if(x > 7 && leftClear())
			{
				//rotate blocks
				blocks.get(0).setX(9);
				blocks.get(0).setY(blocks.get(0).getY() + 1);
				blocks.get(1).setX(8);
				blocks.get(2).setX(7);
				blocks.get(2).setY(blocks.get(2).getY() - 1);
				blocks.get(3).setX(6);
				blocks.get(3).setY(blocks.get(3).getY() - 2);
				position = LinePosition.FLAT;
			}
			//if its in the middle, just make sure right and left is clear
			else if(rightClear() && leftClear())
			{
				//rotate blocks
				blocks.get(0).setX(blocks.get(0).getX() + 1);
				blocks.get(0).setY(blocks.get(0).getY() + 1);
				blocks.get(2).setX(blocks.get(2).getX() - 1);
				blocks.get(2).setY(blocks.get(2).getY() - 1);
				blocks.get(3).setX(blocks.get(3).getX() - 2);
				blocks.get(3).setY(blocks.get(3).getY() - 2);
				position = LinePosition.FLAT;
			}
			//change position to 1 after a successful rotation
		}
		//if the line is in the sideways position
		else if(position == LinePosition.FLAT)
		{
			//rotate blocks
			blocks.get(0).setX(blocks.get(0).getX() - 1);
			blocks.get(0).setY(blocks.get(0).getY() - 1);
			blocks.get(2).setX(blocks.get(2).getX() + 1);
			blocks.get(2).setY(blocks.get(2).getY() + 1);
			blocks.get(3).setX(blocks.get(3).getX() + 2);
			blocks.get(3).setY(blocks.get(3).getY() + 2);
			position = LinePosition.UPRIGHT;
		}
	}
}
