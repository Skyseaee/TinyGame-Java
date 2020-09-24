package game;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Ground {
	int x, y;
	BufferedImage img;
	int w, h;
	
	public Ground() {
		img = Tools.getImg("/image/ground.png");
		h = 158;
		w = img.getWidth();
		x = 0;
		y = 730 - h;
	}

	public void move() {
		if( x<= -(w-700)) {
			x = 0;
		}
		x --;
	}
}
