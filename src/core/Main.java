package core;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		new TimeManager(game);
	}
	
	
	
}