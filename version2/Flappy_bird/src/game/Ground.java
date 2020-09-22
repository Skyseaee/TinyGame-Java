package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 文档注释快捷键 shift+alt+j
 * 
 *地面类 
 * 
 * @author Haiyun
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
		h=158;
		//获取图片宽度
		w=img.getWidth();
		//初始化x
		x=0;
		//初始化y
		y=730-h;
		
	}
	
	//地面移动的方法
	public void move () {
		if(x<=-(w-700)) {
			x=0;
		}
		x--;
		
	}

}
