package game;

/*
*画板类
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {
    //声明背景图片变量
    BufferedImage bg;
    //声明地面变量
    Ground ground;
    //声明柱子变量
    Column column1;
    Column column2;
    //声明鸟变量
    Bird bird;

    //构造器
    public GamePanel() {
        //设置背景色
        setBackground(Color.red);
        //设置背景图片
        bg = Tools.getImg("../img/bg.png");
        //初始化地面对象
        ground = new Ground();
        //初始化柱子对象
        column1 = new Column(1);
        column2 = new Column(2);
        //初始化鸟对象
        bird = new Bird();
    }

    //游戏开始的方法
    public void start() {
        while (true) {
            //地面移动
            ground.move();
            //柱子移动
            column1.move();
            column2.move();
            //小鸟飞行
            bird.fly();;
            try {
                Thread.sleep(30);
                //刷新
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //在画板上绘制内容的方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制背景图片
        g.drawImage(bg, 0,0, null);
        //绘制柱子图片
        g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
        //绘制柱子图片
        g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
        //绘制地面图片
        g.drawImage(ground.img, ground.x, ground.y, null);
        //绘制小鸟
        g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
    }
}
