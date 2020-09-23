package game;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public class Bird {
	BufferedImage img;
	int x, y;
	int w, h;
	List<BufferedImage> list;
	double v0;
	double t;
	double s;
	double g;
	public Bird() {
		img = Tools.getImg("/image/0.png");
		x = 100;
		y = 200;
		w = img.getWidth()/2;
		h = img.getHeight()/2;
		list = new ArrayList<BufferedImage>();
		for ( int i=0; i<8; i++) {
			list.add(Tools.getImg("/image/"+i+".png"));
		}
		v0 = 30;
		t = 0.2;
		s = 0;
		g = 10;
	}
	
	int index = 0;
	public void fly() {
		img = list.get(index%list.size());
		index ++;
	}
	
	public void drop() {
		s = v0 * t;
		y = y - (int)s;
		double v2 = v0 - g*t;
		v0 = v2;
	}
	public void clickup() {
		v0 = 30;
	}
	
	public boolean hit() {
		if ( y<=0 || y>= 644-146-h ) {
			return true;
		}	
		return false;
	}
	
	public boolean hit(Column column) {
		if ( x >= column.x-w && x <= column.x+column.w) {
			if ( y>column.h/2+y-column.gap/2 && y<column.h/2+y+column.gap/2-h ) {
				return false;
			}
			return true;
		}
		
		return false;
	}
}
