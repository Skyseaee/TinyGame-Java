package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird {
    private BufferedImage birdImage;
    private int birdX;
    private int birdY;

    private int birdHeight;
    private int birdWidth;

   // private GamePanel gamePanel;

    private List<BufferedImage> birdImageList;

    private double birdV0;//鸟竖直方向的初速度
    private double t;//时间间隔
    private double s;//移动距离
    private double g;//重力

    public Bird()
    {
        birdImage = Tools.getBufferImage("resources/image/0.png");
        birdY = 740/2 - 100; //740是游戏窗口设定的高度
        birdX = 100;
        birdHeight = birdImage.getHeight()/2;
        birdWidth = birdImage.getWidth()/2;

        //gamePanel = new GamePanel();

        //初始化图片数组
        birdImageList = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            birdImageList.add(Tools.getBufferImage("resources/image/"+i+".png"));
        }
        //初始化初速度
        birdV0 = 3;
        t = 0.15;
        s = 0;
        g = 5;

    }

    public int getBirdHeight() {
        return birdHeight;
    }

    public int getBirdWidth() {
        return birdWidth;
    }

    public BufferedImage getBirdImage() {
        return birdImage;
    }

    public int getBirdX() {
        return birdX;
    }

    public int getBirdY() {
        return birdY;
    }

    private int index = 0; //循环调用小鸟的图片组，形成动态形式
    public void birdWingMove()
    {
//        if(index>=8)
//            index=0;
        birdImage = birdImageList.get(index%birdImageList.size());
        index++;
    }

    public void birdMove()
    {
        birdY -= (int)(birdV0*t-g*t*t/2);
        birdV0 -= g*t;
    }

    public void birdMoveUp()
    {
        birdV0 = 20;
    }

    public boolean isCollide()
    {
        if(birdY<=0||birdY>=740-birdHeight-180) //180为地面高度，即如果小鸟飞出上方界面或小鸟撞到地面时
            return true;
        return false;//没撞到
    }

  /*  public void drawCollideRect(Graphics g,Column column)
    {
        g.fillRect(column.getX(),column.getY(),column.getColumnWidth(),);
    }*/
    public boolean isCollide(Column column)  //小鸟撞到柱子
    {
       if(birdX>=column.getX()-birdWidth&&birdX<=column.getX()+column.getColumnWidth())
        {
            if(birdY>column.getY()+column.getColumnHeight()/2-column.getColumngap()/2
                    &&birdY<column.getY()+column.getColumnHeight()/2+column.getColumngap()/2-birdHeight)
                return false;
            return true;
        }
        return false;
    }

}
