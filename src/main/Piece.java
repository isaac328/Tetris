package main;

import java.util.ArrayList;
import processing.core.*;

public abstract class Piece
{
	private ArrayList<Block> blocks;
	private PApplet p;

	public abstract void setColor();
	public abstract void rotate();
	
	public Piece(PApplet p) throws Exception
	{
		if(p == null)
			throw new Exception("PApplet cannot be null");
		blocks = new ArrayList<>(4);
		this.p = p;
	}

	public PApplet getPApplet(){ return this.p; }

	public ArrayList<Block> getBlocks(){ return this.blocks; }

	public int[][] getGrid(){ return ((Game)p).getController().getGrid(); }
	
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
	public boolean checkClearBelow()
	{
		for(Block b : blocks)
		{
			if(b.getY() >= p.height/50 - 1 || getGrid()[b.getX()][b.getY()+1] != 0)
			{
				return false;
			}
		}
		return true;
	}

}
