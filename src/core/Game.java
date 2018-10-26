package core;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import flappy.Pipe;
import flappy.PipeManager;

public class Game extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private PipeManager p;
	private static int birdY = 250;
	
	public static int w = 800, h = 600;
	
	public void init()
	{
		setSize(w, h);
		setTitle("Flappy Clone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		p = new PipeManager();
		
		JPanel panel = new JPanel();
		add(panel);
		addKeyListener(new KeyHandle());
		
		setVisible(true);
	}
	
	public void play()
	{
		p.play();
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.RED);
		g.fillRect(50, birdY, 30, 30);
		
		
		g.setColor(Color.green);
		
		for (Pipe pipe : p.getPipes()) {			
			g.fillRect(pipe.x, pipe.y1, pipe.width, pipe.length1);
			g.fillRect(pipe.x, pipe.y2, pipe.width, pipe.length2);
		}
	}

}
