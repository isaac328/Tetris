package main.factory;

import main.Piece;
import main.pieces.Line;
import processing.core.PApplet;

public class LineFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) throws Exception{
		return new Line(p);
	}
}
