package main.pieces;

import main.Block;
import main.Piece;
import main.enums.LPosition;
import processing.core.PApplet;

import java.util.ArrayList;

public class RightL extends Piece {
	LPosition position;

	public RightL(PApplet p) throws Exception{
		super(p);
		ArrayList<Block> blocks = getBlocks();
		blocks.add(new Block(p, 5, 1));
		blocks.add(new Block(p, 5, 2));
		blocks.add(new Block(p, 5, 3));
		blocks.add(new Block(p, 4, 3));
		position = LPosition.POINTING_UP;
	}

	@Override
	public void setColor(){
		getPApplet().fill(100, 255, 255);
	}

	@Override
	public void rotate(){
		//get individual blocks
		Block b0 = getBlocks().get(0);
		Block b1 = getBlocks().get(1);
		Block b2 = getBlocks().get(2);
		Block b3 = getBlocks().get(3);

		//if original position
		if(position == LPosition.POINTING_UP)
		{
			//if on the right wall
			if(b0.getX() == getPApplet().width/50 - 1)
			{
				//check if clear, rotate
				if(getGrid()[b1.getX() - 1][b1.getY()] == 0 && getGrid()[b1.getX() - 2][b1.getY()] == 0
						&& getGrid()[b0.getX() - 2][b0.getY()] == 0)
				{
					b0.setY(b0.getY() + 1);
					b1.setX(b1.getX() - 1);
					b2.setX(b2.getX() - 2);
					b2.setY(b2.getY() - 1);
					b3.setX(b3.getX() - 1);
					b3.setY(b3.getY() - 2);
					position = LPosition.POINTING_RIGHT;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(getGrid()[b1.getX() - 1][b1.getY()] == 0 && getGrid()[b0.getX() - 1][b0.getY()] == 0 &&
					getGrid()[b1.getX() + 1][b1.getY()] == 0)
			{
				b0.setX(b0.getX() + 1);
				b0.setY(b0.getY() + 1);
				b2.setX(b2.getX() - 1);
				b2.setY(b2.getY() - 1);
				b3.setY(b3.getY() - 2);
				position = LPosition.POINTING_RIGHT;
			}
		}
		//if piece has been rotated once
		else if(position == LPosition.POINTING_RIGHT)
		{
			///check if clear, rotate
			if(getGrid()[b1.getX()][b1.getY() - 1] == 0 &&
					getGrid()[b1.getX()][b1.getY() - 2] == 0 &&
					getGrid()[b0.getX()][b0.getY() - 2] == 0)
			{
				b0.setX(b0.getX() - 1);
				b1.setY(b1.getY() - 1);
				b2.setX(b2.getX() + 1);
				b2.setY(b2.getY() - 2);
				b3.setY(b3.getY() - 1);
				b3.setX(b3.getX() + 2);
				position = LPosition.POINTING_DOWN;
			}
		}
		//if piece has been rotated twice
		else if(position == LPosition.POINTING_DOWN)
		{
			//if on left wall
			if(b0.getX() == 0)
			{
				//check if clear, rotate
				if(getGrid()[b1.getX() + 1][b1.getY()] == 0 &&
						getGrid()[b1.getX() + 2][b1.getY()] == 0 &&
						getGrid()[b0.getX() + 2][b0.getY()] == 0)
				{
					b0.setY(b0.getY() - 1);
					b1.setX(b1.getX() + 1);
					b2.setX(b2.getX() + 2);
					b2.setY(b2.getY() + 1);
					b3.setY(b3.getY() + 2);
					b3.setX(b3.getX() + 1);
					position = LPosition.POINTING_LEFT;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(getGrid()[b0.getX() + 1][b0.getY()] == 0 &&
					getGrid()[b1.getX() + 1][b1.getY()] == 0 &&
					getGrid()[b1.getX() - 1][b1.getY()] == 0)
			{
				b0.setX(b0.getX() - 1);
				b0.setY(b0.getY() - 1);
				b2.setX(b2.getX() + 1);
				b2.setY(b2.getY() + 1);
				b3.setY(b3.getY() + 2);
				position = LPosition.POINTING_LEFT;
			}
		}
		//if piece has been rotated 3 times
		else if(position == LPosition.POINTING_LEFT)
		{
			//check if clear, rotate, set position to original
			if(getGrid()[b0.getX()][b0.getY() - 1] == 0 &&
					getGrid()[b1.getX()][b1.getY() - 2] == 0)
			{
				b0.setX(b0.getX() + 1);
				b0.setY(b0.getY() - 1);
				b2.setX(b2.getX() - 1);
				b2.setY(b2.getY() + 1);
				b3.setX(b3.getX() - 2);
				position = LPosition.POINTING_UP;
			}
		}
	}
}
