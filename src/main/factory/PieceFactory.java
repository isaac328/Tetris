package main.factory;

import main.Piece;
import processing.core.PApplet;

import java.util.Random;

public abstract class PieceFactory {
	public abstract Piece makePiece(PApplet p) throws Exception;

	public static PieceFactory getFactory(){
		Random rand = new Random();
		int type = rand.nextInt(7);
		switch (type){
			case 0:
				return new LineFactory();
			case 1:
				return new LeftArmFactory();
			case 2:
				return new RightArmFactory();
			case 3:
				return new LeftLFactory();
			case 4:
				return new RightLFactory();
			case 5:
				return new SquareFactory();
			case 6:
				return new TFactory();
			default:
				return null;
		}
	}
}
