package main;

import processing.core.*;

public class Block
{
	float blockSize = 50;
	PApplet p;
	int x;
	int y;
	
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
	
	public void update()
	{
		
	}
}
