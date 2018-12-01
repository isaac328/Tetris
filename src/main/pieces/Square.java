package main.pieces;

import main.Block;
import main.Piece;
import processing.core.PApplet;

import java.util.ArrayList;

public class Square extends Piece {

	public Square(PApplet p) throws Exception{
		super(p);
		ArrayList<Block> blocks = getBlocks();
		blocks.add(new Block(p, 4, 0));
		blocks.add(new Block(p, 5, 0));
		blocks.add(new Block(p, 4, 1));
		blocks.add(new Block(p, 5, 1));
	}

	@Override
	public void setColor(){
		getPApplet().fill(0, 255, 255);
	}

	@Override
	public void rotate(){
		return;
	}
}
