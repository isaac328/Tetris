package main.factory;

import main.Piece;
import main.pieces.RightArm;
import processing.core.PApplet;

public class RightArmFactory extends PieceFactory {
	@Override
	public Piece makePiece(PApplet p) throws Exception {
		return new RightArm(p);
	}
}
