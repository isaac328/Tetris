package main.factory;

import main.Piece;
import main.pieces.LeftArm;
import processing.core.PApplet;

public class LeftArmFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) {
		return new LeftArm(p);
	}
}
