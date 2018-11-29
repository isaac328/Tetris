package main.pieces;

import main.Block;
import main.Piece;
import main.enums.ArmPosition;
import processing.core.PApplet;

import java.util.ArrayList;

public class LeftArm extends Piece {

	ArmPosition position;

	public LeftArm(PApplet p){
		super(p);
		ArrayList<Block> blocks = getBlocks();
		blocks.add(new Block(p, 4, 0));
		blocks.add(new Block(p, 4, 1));
		blocks.add(new Block(p, 5, 1));
		blocks.add(new Block(p, 5, 2));
	}


	@Override
	public void setColor(){
		getPApplet().fill(82, 255, 255);
	}

	@Override
	public void rotate(){
		//get individual pieces
		Block b0 = getBlocks().get(0);
		Block b1 = getBlocks().get(1);
		Block b2 = getBlocks().get(2);
		Block b3 = getBlocks().get(3);

		//if starting position
		if(position == ArmPosition.UPRIGHT)
		{
			//if its on the right wall
			if(b2.getX() == getPApplet().width/50 - 1)
			{
				//check if clear, rotate
				if(getGrid()[b1.getX()][b1.getY() + 1] == 0 &&
						getGrid()[b1.getX() - 1][b1.getY() - 1] == 0)
				{
					b0.setY(b0.getY() + 1);
					b0.setX(b0.getX() + 1);
					b2.setX(b2.getX() - 1);
					b2.setY(b2.getY() + 1);
					b3.setX(b3.getX() - 2);
					position = ArmPosition.FLAT;
				}
			}
			//if on left wall or middle, check if clear, rotate
			else if(getGrid()[b3.getX() - 1][b3.getY()] == 0 &&
					getGrid()[b2.getX() + 1][b2.getY()] == 0)
			{
				b0.setY(b0.getY() + 1);
				b0.setX(b0.getX() + 2);
				b1.setX(b1.getX() + 1);
				b2.setY(b2.getY() + 1);
				b3.setX(b3.getX() - 1);

				position = ArmPosition.FLAT;
			}
		}
		//if in rotated position
		else if(position == ArmPosition.FLAT)
		{
			//check if clear, rotate
			if(getGrid()[b1.getX() - 1][b1.getY()] == 0 && getGrid()[b1.getX() - 1][b1.getY() - 1] == 0)
			{
				b0.setY(b0.getY() - 1);
				b0.setX(b0.getX() - 2);
				b1.setX(b1.getX() - 1);
				b2.setY(b2.getY() - 1);
				b3.setX(b3.getX() + 1);

				position = ArmPosition.UPRIGHT;
			}
		}
	}
}
