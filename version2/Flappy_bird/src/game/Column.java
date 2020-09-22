package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 柱子类
 * @author Haiyun
 *
 */
public class Column {
	//柱子的图片
	BufferedImage img;
	//x坐标
	int x;
	//y坐标
	int y;
	//柱子的宽度
	int w;
	//柱子的高度
	int h;
	//柱子间的间距
	int distance;
	//声明一个随机数对象
	Random ran=new Random();
	//构造器初始化构造柱子对象（i表示第几根柱子）
	public Column(int i) {
		//初始化柱子图片
		img=Tools.getImg("../img/column.png");
		//获取图片的宽度
		w=img.getWidth();
		//获取图片的高度
		h=img.getHeight();
		//初始化柱子间距
		distance=311;
		//设置x坐标
		x=544+311*(i-1);
//		if(i==1) {
//			x=300;
//		}else if(x==2) {
//			x=300+distance;
//		}
		//设置y坐标（0-n-1的随机整数）位于中心时，y=-308
		y=-208-ran.nextInt(201);
	}
	//柱子移动
	public void move() {
		x--;
		if(x<=-w) {
			x=544+distance;
		}
	}

}
