package core;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import flappy.*;

public class Game extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	private PipeManager p;
	private BirdManager b;
	
	private String score;
	private float scrFlt;
	
	public static boolean isGameOver = false;
	
	private String highScrFnt = "";
	private float highScore;
	
	private String restartStr = "";
	
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
		addKeyListener(this);
		
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
			scrFlt = 0;
		}
	}
	
	
	public void stop()
	{
		p.stop();
		b.stop();
		
		
		if(scrFlt > highScore) {
			highScore = scrFlt;
		}
		highScrFnt = "High Score: " + highScore;
	
		restartStr = "Restart? (Y / N)";
		
		repaint();
	
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
	
	
	public void reset()
	{
		p.reset();
		b.reset();
		
		highScrFnt = "";
		restartStr = "";
		scrFlt = 0;
		isGameOver = false;
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
		Font f = new Font(score, Font.PLAIN, 16);
		g.setFont(f);
		g.drawString(score, 50   , 50);
		
		
		g.setFont(new Font(highScrFnt, Font.BOLD, 40));
		g.drawString(highScrFnt, 200, 300);
		
		g.setFont(new Font(restartStr, Font.PLAIN, 30));
		g.drawString(restartStr, 300, 350);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(isGameOver)
		{
			if(e.getKeyCode() == KeyEvent.VK_N)
			{
				System.exit(0);
			}
			if(e.getKeyCode() == KeyEvent.VK_Y)
			{
				reset();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
