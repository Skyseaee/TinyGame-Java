package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.tools.Tool;

/**
 * 画板类
 * @author Haiyun
 *
 */
public class GamePanel extends JPanel {
	//声明一个用于存放背景图片的变量（盒子）
	BufferedImage bg;
	//声明一个用于存放地面的变量
	Ground ground;
	//声明一个用于存放柱子的变量
	Column column1;
	//声明一个用于存放第二根柱子的变量
	Column column2;
	//声明一个用于存放第三根柱子的变量
	Column column3;
	//声明一个
	Bird bird;
	//游戏准备状态
	boolean start;
	//游戏结束状态
	boolean gameover;
	//分数
	static int score;
	//构造器
	public GamePanel () {
		//设置背景色
		setBackground(Color.pink);
		//设置背景图片 ../为退出当前文件夹
		bg=Tools.getImg("../img/背景.png");
		//初始化地面对象
		ground = new Ground();
		//初始化柱子对象
		column1=new Column(1);//x=300
		//初始化第二根柱子
		column2=new Column(2);//x=545
		//初始化第三根柱子
		column3=new Column(3);
		//初始化鸟对象
		bird=new Bird();
		//初始化游戏状态（没有开始为准备状态，若为true则为游戏运行状态）
		start=false;
		//初始化游戏结束状态（游戏没有结束，若为true则为游戏运行状态）
		gameover=false;
		//初始化分数
		score=0;
		//初始化鼠标监听器
		MouseAdapter adapter=new MouseAdapter() {
			//鼠标点击后需要做什么就写到下面的方法内部
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(start==false) {//运行状态
					//改变游戏状态为运行状态
					start=true;
					//启动游戏
					start();
				}else if(gameover){
					//游戏回到准备状态
					start=false;
					gameover=false;
					//重置游戏中的所有对象
					//初始化地面对象
					ground = new Ground();
					//初始化柱子对象
					column1=new Column(1);//x=300
					//初始化第二根柱子
					column2=new Column(2);//x=545
					//初始化第三根柱子
					column3=new Column(3);
					//初始化鸟对象
					bird=new Bird();
					//初始化分数
					score=0;
					//刷新
					repaint();
				}else {
					//小鸟上抛
					bird.moveUp();
									}
			}
		};
		this.addMouseListener(adapter);
	}
	//游戏开始的方法
	public void start() {
		//启动游戏运行的线程
		MyThread mt=new MyThread();
		//将线程所有执行的认为装入到线程对象中
		Thread t=new Thread(mt);
		//将线程纳入线程调度
		t.start();//告诉cpu可以给我这个线程分配时间片段了
	}
	
	//用来向画板上绘制内容 g相当于画笔
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制背景图片（需要绘制的图片，x坐标，y坐标，null全部填充）
		g.drawImage(bg,0,0,null);
		//绘制柱子图片
		g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
		//绘制柱子2图片
		g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
		//绘制柱子3图片
		g.drawImage(column3.img, column3.x, column3.y, column3.w, column3.h, null);
		//绘制地面图片
		g.drawImage(ground.img, ground.x, ground.y, null);
		//绘制鸟的图片
		g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
		//绘制准备状态的图片
		if(start==false) {
			g.drawImage(Tools.getImg("../img/start.png"),134,43,null);
		}
		//绘制游戏结束的图片
		if(gameover) {
			g.drawImage(Tools.getImg("../img/gameover.png"),134,63,null);
		}
		//创建一个字体对象
		Font f=new Font("宋体",200,30);
		//将字体设置到画笔上
		g.setFont(f);
		//给画笔设置颜色
		g.setColor(Color.red);
		//绘制字符串
		g.drawString("分数："+score, 30, 50);
	}
	
	//游戏运行的线程
	class MyThread implements Runnable{
		//把该线程需要干的活放到run方法中
		@Override
		public void run() {
			while(true) {
				//让地面移动起来
				ground.move();
				//柱子移动
				column1.move();
				//柱子2移动
				column2.move();
				//柱子3移动
				column3.move();
				//小鸟飞
				bird.fly();
				//小鸟做落体运动
				bird.move();
				//检测小鸟是否与顶部碰撞
				boolean boo1=bird.hit();
				//检测小鸟是否与柱子1 发生了碰撞
				boolean boo2=bird.hit(column1);
				//检测小鸟是否与柱子2发生了碰撞
				boolean boo3=bird.hit(column2);
				//检测小鸟是否与柱子3发生了碰撞
				boolean boo4=bird.hit(column3);
				//若发生碰撞则游戏结束
				if(boo1||boo2||boo3||boo4) {
					//更改游戏状态
					gameover=true;
					//窗体内的对象全部静止
					return;//结束当前方法，break结束当前循环
				}
				//计算分数
				if(bird.x==column1.x+column1.w||bird.x==column2.x+column2.w||bird.x==column3.x+column3.w) {
					score++;
				}
				try {
					//每移动一次休息1s
					Thread.sleep(30);
					//刷新
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
