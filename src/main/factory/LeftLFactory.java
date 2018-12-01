package main.factory;

import main.Piece;
import main.pieces.LeftL;
import processing.core.PApplet;

public class LeftLFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) throws Exception{
		return new LeftL(p);
	}
}
