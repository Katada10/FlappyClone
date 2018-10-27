package core;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import flappy.*;

public class Game extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private PipeManager p;
	private BirdManager b;
	
	private String score;
	private float scrFlt;
	
	private boolean isGameOver = false;
	
	private float highScore;
	
	public static int w = 800, h = 600;
	
	public Game()
	{
		init();
		score = "Score: ";
		scrFlt = 0;
		highScore = 0;
	}
	
	public void init()
	{
		setSize(w, h);
		setTitle("Flappy Clone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		p = new PipeManager();
		b = new BirdManager();
		
		
		JPanel panel = new JPanel();
		
		add(panel);
		addKeyListener(b);
		
		setVisible(true);
	}
	
	public void score()
	{
		scrFlt += 0.05f;
		score = "Score: " + scrFlt;
	}
	
	public void play()       
	{
		if(!isGameOver)
		{
			p.play();
			b.play();
			score();
			collide();
			repaint();
		}
		else
		{
			stop();
		}
	}
	
	
	public void stop()
	{
		p.stop();
		b.stop();
		
		highScore = scrFlt;
	}

	
	public void collide()
	{
		for (Pipe pipe : p.getPipes()) {
			
			if(((b.birdY - pipe.length1 < 0 && (pipe.x == 50))) || (b.birdY > pipe.y2 && (pipe.x == 50)))
			{
				isGameOver = true;
			}
			
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.RED);
		g.fillRect(50, b.birdY, 20, 20);
		
		g.setColor(Color.green);
		
		for (Pipe pipe : p.getPipes()) {			
			g.fillRect(pipe.x, pipe.y1, pipe.width, pipe.length1);
			g.fillRect(pipe.x, pipe.y2, pipe.width, pipe.length2);
		}
		
		g.setColor(Color.WHITE);
		Font f = new Font("Score : ", Font.PLAIN, 16);
		g.setFont(f);
		g.drawString(score, 50, 50);
	}

}
