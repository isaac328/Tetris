package main.pieces;

import main.Block;
import main.Piece;
import main.enums.ArmPosition;
import processing.core.PApplet;

import java.util.ArrayList;

public class RightArm extends Piece {
	ArmPosition position;

	public RightArm(PApplet p){
		super(p);
		ArrayList<Block> blocks = getBlocks();
		blocks.add(new Block(p, 4, 0));
		blocks.add(new Block(p, 4, 1));
		blocks.add(new Block(p, 3, 1));
		blocks.add(new Block(p, 3, 2));
	}

	@Override
	public void setColor(){
		getPApplet().fill(255, 255, 255);
	}

	@Override
	public void rotate(){
		ArrayList<Block> blocks = getBlocks();

		//if the piece is in the starting position
		if(position == ArmPosition.UPRIGHT)
		{
			//if the piece is up against the left wall
			if(blocks.get(2).getX() == 0)
			{
				//make sure the piece wont rotate into anything
				if(getGrid()[blocks.get(1).getX() + 1][blocks.get(1).getY() + 1] == 0)
				{
					//rotate peice, set position to 1
					blocks.get(3).setY(blocks.get(3).getY() - 1);
					blocks.get(2).setX(blocks.get(2).getX() + 1);
					blocks.get(1).setY(blocks.get(1).getY() + 1);
					blocks.get(0).setY(blocks.get(0).getY() + 2);
					blocks.get(0).setX(blocks.get(0).getX() + 1);
					position = ArmPosition.FLAT;
				}
			}
			//if the piece is up against the right wall
			else if(blocks.get(0).getX() == 9)
			{
				//make sure piece is clear to rotate
				if(getGrid()[blocks.get(2).getX() - 1][blocks.get(2).getY() - 1] == 0)
				{
					//rotate, position is 1
					blocks.get(0).setY(blocks.get(0).getY() + 1);
					blocks.get(1).setX(blocks.get(1).getX() - 1);
					blocks.get(2).setY(blocks.get(2).getY() - 1);
					blocks.get(3).setY(blocks.get(3).getY() - 2);
					blocks.get(3).setX(blocks.get(3).getX() - 1);
					position = ArmPosition.FLAT;
				}
			}
			//if its in the middle, check if clear
			else if(getGrid()[blocks.get(3).getX() - 1][blocks.get(3).getY() - 1] == 0)
			{
				//rotate, position is 1
				blocks.get(0).setY(blocks.get(0).getY() + 1);
				blocks.get(1).setX(blocks.get(1).getX() - 1);
				blocks.get(2).setY(blocks.get(2).getY() - 1);
				blocks.get(3).setY(blocks.get(3).getY() - 2);
				blocks.get(3).setX(blocks.get(3).getX() - 1);
				position = ArmPosition.FLAT;

			}
		}
		//if the piece has rotated once
		else if(position == ArmPosition.FLAT)
		{
			//if the piece is on the bottom
			if(blocks.get(0).getY() == getPApplet().height/50 - 1)
			{
				//make sure its clear to rotate
				if(getGrid()[blocks.get(2).getX() - 1][blocks.get(2).getY()] == 0 &&
						getGrid()[blocks.get(1).getX()][blocks.get(1).getY() - 1] == 0)
				{
					//rotate, set position back to original
					blocks.get(0).setX(blocks.get(0).getX() - 1);
					blocks.get(1).setY(blocks.get(1).getY() - 1);
					blocks.get(2).setX(blocks.get(2).getX() + 1);
					blocks.get(3).setX(blocks.get(3).getX() + 2);
					blocks.get(3).setY(blocks.get(3).getY() - 1);
					position = ArmPosition.UPRIGHT;

				}
			}
			//if its in the middle, check to make sure its clear
			else if(getGrid()[blocks.get(1).getX() + 1][blocks.get(1).getY()] == 0 &&
					getGrid()[blocks.get(1).getX() + 1][blocks.get(1).getY() - 1] == 0)
			{
				blocks.get(0).setY(blocks.get(0).getY() - 1);
				blocks.get(1).setX(blocks.get(1).getX() + 1);
				blocks.get(2).setY(blocks.get(2).getY() + 1);
				blocks.get(3).setY(blocks.get(3).getY() + 2);
				blocks.get(3).setX(blocks.get(3).getX() + 1);
				position = ArmPosition.UPRIGHT;
			}
		}
	}
}
