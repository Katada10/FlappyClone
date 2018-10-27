package core;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TimeManager implements Runnable, WindowListener {
	private Thread thread;
	public static boolean isRunning;
	private Game game;
	
	public TimeManager(Game g) {
		thread = new Thread(this);
		thread.start();
		isRunning = false;
		this.game = g;
	}

	private void start() {
		while(isRunning)
		{
			game.play();
			try
			{
				Thread.sleep(30);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void stop() throws InterruptedException {
		isRunning = false;
		thread.join();
	}

	public void run() {
		isRunning = true;
		start();
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			stop();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
