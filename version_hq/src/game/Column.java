package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 柱子类
 * @author keira
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
	//安全间隙
	int gap;
	//声明一个随机数对象
	Random ran=new Random();
	//构造器初始化构造柱子对象（i表示第几根柱子）
	public Column(int i) {
		img=Tools.getImg("../img/column.png");
		distance=300;
		w = 65;
		h =700;
		x =800+300*(i-1);
		//设置y坐标（0-n-1的随机整数）位于中心时，y=-308
		y=-ran.nextInt(120);
		//初始化安全间隙
		gap=90;
	}
	//柱子移动
	public void move() {
		x--;
		if(x<=-65) {
			x=300+distance;
		}
	}

}