package main.factory;

import main.Piece;
import main.pieces.TPiece;
import processing.core.PApplet;

public class TFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) throws Exception {
		return new TPiece(p);
	}
}
