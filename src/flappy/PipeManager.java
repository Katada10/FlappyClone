package flappy;

import java.util.ArrayList;
import java.util.Random;

import core.Game;

public class PipeManager {

	private ArrayList<Pipe> pipes;
	private int firstX = Game.w;
	private Random rand;

	public PipeManager() {
		pipes = new ArrayList<>();
		rand = new Random();
		create();
	}

	
	public void reset()
	{
		for (Pipe pipe : pipes) {
			pipe.moveFactor = 10;
		}
		firstX = Game.w;
	}
	
	private void create() {
		for (int i = 0; i < 3; i++) {
			pipes.add(new Pipe());
		}
		for (Pipe pipe : pipes) {
			setPipe(pipe);
		}
		firstX = Game.w;
	}

	private void setPipe(Pipe pipe) {
		pipe.length1 = rand.nextInt(25) + 230;	//Max 255
		pipe.length2 = rand.nextInt(150) + 150;	//Max 260
		pipe.y2 = Game.h - pipe.length2;

		pipe.x = firstX;
		firstX += 300;
	}
	
	public void stop()
	{
		for (Pipe pipe : pipes) {
			pipe.moveFactor = 0;
		}
		firstX = 0;
	}

	public ArrayList<Pipe> getPipes() {
		return pipes;
	}
        
	public void play() {
		for (Pipe pipe : pipes) {
			pipe.play();
			
			if(pipe.x < 0)
			{
				setPipe(pipe);
			}
			firstX = Game.w;
		}
	}

}
