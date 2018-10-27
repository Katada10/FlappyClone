package flappy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import core.Game;

public class BirdManager implements KeyListener{

	public int birdY = 250;
	public int gravity = 5;
	
	public void play()
	{
		birdY += gravity;
	}
	     
	public void stop()
	{
		gravity = 50;
	}
	
	public void reset()
	{
		birdY = 250;
		gravity = 5;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			birdY -= 40;
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			Game.isGameOver = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
