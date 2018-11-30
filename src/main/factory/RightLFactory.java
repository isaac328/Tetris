package main.factory;

import main.Piece;
import main.pieces.RightL;
import processing.core.PApplet;

public class RightLFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) {
		return new RightL(p);
	}
}
