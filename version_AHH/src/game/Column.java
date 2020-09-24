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
		w = img.getWidth();
		h = img.getHeight();
		distance = 311;
		x = 544 + 311*(i-1);
		y = -208-ran.nextInt(201);
		gap = 150;
	}
	
	public void move() {
		x--;
		if ( x <= -w) {
			x = 544 + distance;
//			y = -ran.nextInt(h);
		}
	}
}
