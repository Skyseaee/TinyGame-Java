package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 *地面类 
 * 
 * @author keira
 *
 */
public class Ground {
	//x坐标
	int x;
	//y坐标
	int y;
	//地面的图片
	BufferedImage img;
	//地面的宽度
	int w;
	//地面的高度
	int h;
	
	//地面的构造器用来构造地面对象
	public Ground() {
		//先初始化地面图片
		img=Tools.getImg("../img/ground.png");
		//获取图片高度
		h=img.getHeight();
		//获取图片宽度
		w=img.getWidth();
		//初始化x
		x=0;
		//初始化y
		y=740 - 166;
		
	}
	
	//地面移动的方法
	public void move () {
		if(x>=-(w-600)) {
			x--;
		}
		else x=0;
		
	}

}