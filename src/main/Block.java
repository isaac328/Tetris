package main;

import processing.core.*;

public class Block
{
	private float blockSize = 50;
	private PApplet p;
	private int x;
	private int y;
	
	public Block(PApplet p, int x, int y)
	{
		this.p = p;
		this.x = x;
		this.y = y;
	}
	
	public void show()
	{
		p.rect(x*50, y*50, blockSize, blockSize);
	}

	public void setX(int x){ this.x = x; }

	public void setY(int y){ this.y = y; }

	public int getX(){ return this.x; }

	public int getY(){ return this.y; }
}
