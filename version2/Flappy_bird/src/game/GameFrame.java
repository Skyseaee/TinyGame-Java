package game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 游戏窗体类
 * @author Haiyun
 *
 */
public class GameFrame extends JFrame {
	//构造器用来初始化操作
	//Alt+/  补全代码
	public GameFrame() {
		// 设置尺寸
		setSize(700, 730);
		//设置居中显示
		setLocationRelativeTo(null);
		//设置关闭窗体的同时终止程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置标题
		setTitle("Flappy Bird");
		//设置Logo图标img/0.png
		setIconImage(Tools.getImg("../img/0.png"));
		
	}
	//java程序主入口(一个程序只能有一个入口)
	public static void main(String[] args) {
		//创建一个窗体对象
		GameFrame frame=new GameFrame();
		//创建一个画板对象 Alt+方向键：选中上下移动
		GamePanel panel=new GamePanel();
		//向窗体内添加一块画板
		frame.add(panel);
		//显示窗体
		frame.setVisible(true);
		//启动游戏
//		panel.start();
	}

}
