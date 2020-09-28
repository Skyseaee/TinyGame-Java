package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	BufferedImage bg;
	
	Ground ground;
	Column column1;
	Column column2;
	Column column3;
	Bird bird;
	boolean start;
	boolean gameover;
	int score;
	
	public GamePanel() {
		setBackground(Color.pink);
		bg = Tools.getImg("/image/背景.png");
		ground = new Ground();
		column1 = new Column(1);
		column2 = new Column(2);
		column3 = new Column(3);
		bird = new Bird();
		start = false;
		gameover = false;
		score = 0;
		
		setFocusable(true);
		requestFocus();

		KeyListener BirdKeyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				if ( start == false ) {
					if (keycode == KeyEvent.VK_SPACE) {
						start = true;
						start();
//						System.out.println("按下空格键");
					}
				}else if( gameover ){
					if (keycode == KeyEvent.VK_SPACE) {
						start = false;
						gameover = false;
						ground = new Ground();
						column1 = new Column(1);
						column2 = new Column(2);
						column3 = new Column(3);
						bird = new Bird();
						score = 0;
						repaint();
//						System.out.println("按下空格键");
						}
				}else {
					if (keycode == KeyEvent.VK_SPACE) {
						bird.clickup();
//						System.out.println("按下空格键");
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}		
		};
			
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if ( start == false ) {
					start = true;
					start();
				}else if( gameover ){
					start = false;
					gameover = false;
					ground = new Ground();
					column1 = new Column(1);
					column2 = new Column(2);
					column3 = new Column(3);
					bird = new Bird();
					score = 0;
					repaint();
				}else {
					bird.clickup();
				}
			}
		};
		this.addMouseListener(adapter);
		this.addKeyListener(BirdKeyListener);
		this.requestFocus();
	}
	
	public void start() {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg, 0, 0, null);
		g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
		g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
		g.drawImage(column3.img, column3.x, column3.y, column3.w, column3.h, null);
		g.drawImage(ground.img, ground.x, ground.y, null);
		g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
		if ( start == false) {
			g.drawImage(Tools.getImg("/image/start.png"), 134, 43, null);
		}
		if ( gameover ) {
			g.drawImage(Tools.getImg("/image/gameover.png"), 134, 63, null);
		}
		Font f = new Font("宋体", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("分数：" + score, 30, 50);
	}

	class MyThread implements Runnable {
		@Override
		public void run() {
			while(true) {
				ground.move();
				column1.move();
				column2.move();
				column3.move();
				bird.fly();
				bird.drop();
				
				boolean bool1 = bird.hit();
				boolean bool2 = bird.hit(column1);
				boolean bool3 = bird.hit(column2);
				boolean bool4 = bird.hit(column3);
				if ( bool1 || bool2 || bool3 || bool4) {
					gameover = true;
					return;
				}
				
				if (bird.x == column1.x +column1.w || bird.x == column2.x + column2.w || bird.x==column3.x+column3.w) {
					score ++;
				}
				try {
					Thread.sleep(30);
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
