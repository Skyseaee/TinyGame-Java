package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 柱子类
 */
public class Column {
    private BufferedImage Columeimg;
    private int x;
    private int y;

    private int ColumnHeight;
    private int ColumnWidth;

    private Random random = new Random();

    private final int Columngap = 80;

    public Column(int i)
    {
        //初始化柱子图片
        Columeimg = Tools.getBufferImage("resources/image/column.png");
        ColumnWidth = Columeimg.getWidth()/2;
        ColumnHeight = Columeimg.getHeight()/2;

        x = 300 + i*200;
        //设置y坐标（0~n-1）之间的随机数
        y = -random.nextInt(ColumnHeight+180-740+1);
    }

    public BufferedImage getColumeimg() {
        return Columeimg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColumnHeight() {
        return ColumnHeight;
    }

    public int getColumnWidth() {
        return ColumnWidth;
    }

    public int getColumngap() {
        return Columngap;
    }

    public void ColumnMove()
    {
        if(x<=-ColumnWidth)
        {
            y = -random.nextInt(ColumnHeight+180-740+1)-30*random.nextInt(1)+30*random.nextInt(1);
            x = 400;
        }
        else
            x--;
    }
}
