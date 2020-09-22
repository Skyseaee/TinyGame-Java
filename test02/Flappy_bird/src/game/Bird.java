package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 小鸟类
 * @author Haiyun
 *
 */
public class Bird {
	//鸟的图片
	BufferedImage img;
	//x坐标
	int x;
	//y坐标
	int y;
	//鸟的宽度
	int w;
	//鸟的高度
	int h;
	//用来装一组图片的
	List<BufferedImage> list;
	//初速度
	double v0;
	//时间间隔（网上移动的时间）
	double t;
	//距离
	double s;
	//重力
	double g;
	
	//鸟的构造器用来创建鸟对象
	public Bird() {
		//获取鸟的图片
		img=Tools.getImg("../img/0.png");
		//获取鸟的宽度
		w=img.getWidth()*2/3;
		//获取鸟的高度
		h=img.getHeight()*2/3;
		//x
		x=100;
		//y
		y=200;
		//初始化装图片的容器
		list=new ArrayList<BufferedImage>();
		//向容器中添加图片
//		list.add(Tools.getImg("../img/0.png"));
		for(int i=0;i<8;i++) {
			list.add(Tools.getImg("../img/"+i+".png"));
		}
		//初始化初速度
		v0=3;
		//时间
		t=0.2;
		//举例
		s=0;
		//重力
		g=10;
	}
	//鸟的翅膀动起来
	int index=0;//标记下标来获取图片
	public void fly() {
//		if(index>=8) {
//			index=0;
//		}
		//对list总数量取余
		img=list.get(index%list.size());
		index++;
	}
	//小鸟的落体运动
	public void move() {
		//计算小鸟上抛的距离
		s=v0*t;
		//得到小鸟上抛到最高的的y坐标
		y=y-(int)s;
		//计算出小鸟到达最高点的速度
		double v2=v0-g*t;
		//最高点的速度就是小鸟下落的初速度
		v0=v2;
	}
	//小鸟上抛运动
	public void moveUp() {
		v0=30;
	}
}
