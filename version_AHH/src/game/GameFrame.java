package game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame() {
		setSize(700,730);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flappy Bird");
		setIconImage(Tools.getImg("/image/0.png"));
	}
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		GamePanel panel = new GamePanel();
		frame.add(panel);
		frame.setVisible(true);
		
	}
}
