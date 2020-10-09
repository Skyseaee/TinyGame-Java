package game;

/*
* 地面类
*/

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    //起始点的坐标
    int x, y;
    //地面的图片
    BufferedImage img;
    //地面的宽度和高度
    int w, h;

    //地面的构造器
    public Ground() {
        //初始化地面图片
        try {
            img = ImageIO.read(getClass().getResource("../img/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取图片的高度
        h = img.getHeight();
        //获取图片的宽度
        w = img.getWidth();
        //初始化起点坐标
        x = 0;
        y = 644 - h;
    }

    //地面移动的方法
    public void move() {
        if (x <= -(w - 432)) {
            x = 0;
        }
        x--;
    }
}
