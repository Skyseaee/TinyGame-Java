package game;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Column {
	BufferedImage img;
	int x, y;
	int w, h;
	int distance;
	int gap;
	
	Random ran = new Random();
	public Column( int i) {
		img = Tools.getImg("/image/column.png");
		w = img.getWidth()/2;
		h = img.getHeight()/2;
		distance = 245;
		x = 300 + 245*(i-1);
		y = -ran.nextInt(h+146-600);
		
	}
	
	public void move() {
		x--;
		if ( x <= -w) {
			x = 300 + distance;
			y = -ran.nextInt(h);
		}
	}
}
