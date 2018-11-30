package main.factory;

import main.Piece;
import main.pieces.Square;
import processing.core.PApplet;

public class SquareFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) {
		return new Square(p);
	}
}
