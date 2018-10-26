package flappy;

import java.util.Random;

import core.Game;

public class Pipe {

	public int x, length1, length2;
	
	public int y1 = 0, y2, width = 50;
	

	public Pipe()
	{
		y2 = Game.h - length2;
	}
	
	public void play()
	{
		x -= 8;
	}
}
