package main.factory;

import main.Piece;
import main.pieces.TPiece;
import processing.core.PApplet;

public class TFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) {
		return new TPiece(p);
	}
}
