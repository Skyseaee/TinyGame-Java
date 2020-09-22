package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 画板类
 */
public class GamePanel extends JPanel{
    //声明一个背景用于存放背景图片的变量（盒子）
    private static BufferedImage imagebg;
    private Ground ground;
    private Column column01;
    private Column column02;
    private Bird bird;
    private int gameState;

    private static final int READRSTATE = 0;
    private static final int STARTSTATE = 1;
    private static final int OVERSTATE = 2;

    public int gameSocre=0;


    public GamePanel()
    {
        try {
            imagebg = ImageIO.read(new FileInputStream("resources/img/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //初始化地面对象
        ground = new Ground();
        column01 = new Column(0);
        column02 = new Column(1);
        bird = new Bird();
        setGameState(READRSTATE);

        //添加鼠标监听器
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (gameState)
                {
                    case READRSTATE:
                        bird.birdMoveUp();
                        setGameState(STARTSTATE);
                        start();
                        break;
                    case STARTSTATE:
                        bird.birdMoveUp();
                        break;
                    case OVERSTATE:
                        ground = new Ground();
                        column01 = new Column(0);
                        column02 = new Column(1);
                        bird = new Bird();
                        bird.birdMoveUp();
                        gameSocre=0;
                        setGameState(READRSTATE);
                        repaint();
                        break;
                }
            }
        };
        addMouseListener(mouseAdapter);
    }

    //用来画板上绘制内容的方法 g相当于画笔
    @Override
    public void paint(Graphics g) {
        //g.setColor(Color.PINK);
        //int imageHeight = imagebg.getHeight();
        //int imageWitdh = imagebg.getWidth();
        g.drawImage(imagebg,0,0,null);
        //int count = 600 /imageWitdh + 2;
        /*for(int i=0;i<count;i++)
        {
            g.drawImage(imagebg,imageWitdh*i,600-imageHeight,null);
        }*/
        //g.drawImage(ground.getGroundImage(),ground.getX(),ground.getY(),null);
        //g.drawImage(column.getColumeimg(),column.getX(),column.getY(),null);、
        g.drawImage(column01.getColumeimg(),column01.getX(),column01.getY(),column01.getColumnWidth(),column01.getColumnHeight(),null);
        g.drawImage(column02.getColumeimg(),column02.getX(),column02.getY(),column02.getColumnWidth(),column02.getColumnHeight(),null);
        g.drawImage(ground.getGroundImage(),ground.getX(),ground.getY(),null);

        g.drawImage(bird.getBirdImage(),bird.getBirdX(),bird.getBirdY(),bird.getBirdWidth(),bird.getBirdHeight(),null);
        if(gameState==READRSTATE)
        {
            g.drawImage(Tools.getBufferImage("resources/image/start.png"),(400-432)/2,(740-644)/2,null);
        }
        //绘制游戏结束的图片
        if(gameState==OVERSTATE)
        {
            g.drawImage(Tools.getBufferImage("resources/image/gameover.png"),(400-432)/2,(740-604)/2,null);
        }

        //绘制分数
        Font font = new Font("微软雅黑",240,30);
        g.setFont(font);
        g.setColor(Color.PINK);
        g.drawString("分数："+" "+gameSocre,20,30);

    }

    //游戏运行线程
    class MyThread implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                ground.GroundMove();
                column01.ColumnMove();
                column02.ColumnMove();

                bird.birdWingMove();
                bird.birdMove();
                boolean birdCollide = bird.isCollide();
                if(birdCollide) {
                    setGameState(OVERSTATE);
                    return;//退出当前方法,break一次只能结束一种循环
                }
                if(bird.isCollide(column01)) {
                    setGameState(OVERSTATE);
                    return;//退出当前方法,break一次只能结束一种循环
                }

                if(bird.isCollide(column02)) {
                    setGameState(OVERSTATE);
                    return;//退出当前方法,break一次只能结束一种循环
                }
                //计算分数
                if(bird.getBirdX()==column01.getX()||bird.getBirdX()==column02.getX())
                {
                    gameSocre++;
                }
                //定义刷新率
                try {
                    Thread.sleep(1000/30);
                    //刷新
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //游戏开始的方法
    public void start()
    {
        //启动游戏运行的线程
       MyThread myThread = new MyThread();
       //将线程所有执行的任务装入线程对象中
       Thread thread = new Thread(myThread);
       thread.start();//告诉CPU可以给该线程分配时间片段了
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getGameSocre() {
        return gameSocre;
    }
}
