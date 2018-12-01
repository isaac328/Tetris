package main.pieces;

import main.Block;
import main.Piece;
import main.enums.TPosition;
import processing.core.PApplet;

import java.util.ArrayList;

public class TPiece extends Piece {
	TPosition position;

	public TPiece(PApplet p) throws Exception{
		super(p);
		ArrayList<Block> blocks = getBlocks();
		blocks.add(new Block(p, 4, 0));
		blocks.add(new Block(p, 3, 1));
		blocks.add(new Block(p, 4, 1));
		blocks.add(new Block(p, 5, 1));
		position = TPosition.POINTING_UP;
	}

	@Override
	public void setColor(){
		getPApplet().fill(205, 255, 255);
	}

	@Override
	public void rotate(){
		//get individual blocks
		Block b0 = getBlocks().get(0);
		Block b1 = getBlocks().get(1);
		Block b2 = getBlocks().get(2);
		Block b3 = getBlocks().get(3);

		//if original position
		if(position == TPosition.POINTING_UP)
		{
			//if on the top(player rotated right away)
			if(b0.getY() == 0)
			{
				//check clear, rotate
				if(getGrid()[b2.getX()][b2.getY() + 1] == 0)
				{
					b0.setX(b0.getX() + 1);
					b0.setY(b0.getY() + 1);
					b1.setX(b1.getX() + 1);
					b1.setY(b1.getY() - 1);
					b3.setX(b3.getX() - 1);
					b3.setY(b3.getY() + 1);
					position = TPosition.POINTING_RIGHT;
				}
			}
			//if in middle, check clear, rotate
			else if(getGrid()[b0.getX()][b0.getY() - 1] == 0 && getGrid()[b0.getX() + 1][b0.getY()] == 0)
			{
				b0.setX(b0.getX() + 1);
				b1.setX(b1.getX() + 1);
				b1.setY(b1.getY() - 2);
				b2.setY(b2.getY() - 1);
				b3.setX(b3.getX() - 1);
				position = TPosition.POINTING_RIGHT;
			}
		}
		//if in first rotated position
		else if(position == TPosition.POINTING_RIGHT)
		{
			//if on left wall
			if(b1.getX() == 0)
			{
				//check clear, rotate
				if(getGrid()[b0.getX() + 1][b0.getY()] == 0 && getGrid()[b3.getX() + 1][b3.getY()] == 0)
				{
					b0.setY(b0.getY() + 1);
					b1.setX(b1.getX() + 2);
					b1.setY(b1.getY() + 1);
					b2.setX(b2.getX() + 1);
					b3.setY(b3.getY() - 1);
					position = TPosition.POINTING_DOWN;
				}
			}
			//if on right wall or middle, check clear, rotate
			else if(getGrid()[b2.getX() - 1][b2.getY()] == 0)
			{
				b0.setX(b0.getX() - 1);
				b0.setY(b0.getY() + 1);
				b1.setX(b1.getX() + 1);
				b1.setY(b1.getY() + 1);
				b3.setX(b3.getX() - 1);
				b3.setY(b3.getY() - 1);
				position = TPosition.POINTING_DOWN;
			}
		}
		//if piece has been rotated twice
		else if(position == TPosition.POINTING_DOWN)
		{
			//check clear, rotate
			if(getGrid()[b2.getX()][b2.getY() - 1] == 0)
			{
				b0.setX(b0.getX() - 1);
				b0.setY(b0.getY() - 1);
				b1.setX(b1.getX() - 1);
				b1.setY(b1.getY() + 1);
				b3.setX(b3.getX() + 1);
				b3.setY(b3.getY() - 1);
				position = TPosition.POINTING_LEFT;
			}
		}
		//if piece has been rotated 3 times
		else if(position == TPosition.POINTING_LEFT)
		{
			//check clear, rotate, set position back to original
			if(getGrid()[b2.getX() + 1][b2.getY()] == 0)
			{
				b0.setX(b0.getX() + 1);
				b0.setY(b0.getY() - 1);
				b1.setX(b1.getX() - 1);
				b1.setY(b1.getY() - 1);
				b3.setX(b3.getX() + 1);
				b3.setY(b3.getY() + 1);
				position = TPosition.POINTING_UP;
			}
		}
	}
}
