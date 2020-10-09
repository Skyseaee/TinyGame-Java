package game;

/*
* 柱子类
*/

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Column {
    //柱子的图片
    BufferedImage img;
    //柱子出现的位置
    int x, y;
    //柱子的宽度和高度
    int w, h;
    //随机数对象
    Random random = new Random();
    //柱子的构造器
    public Column(int i) {
        img = Tools.getImg("../img/column.png");
        //获取图片的宽度、高度、xy坐标和距离
        w = img.getWidth()/2;
        h = img.getHeight()/2;
        x = 300 + 245*(i-1);
        y = -random.nextInt(h+146-644+1);
//        distance = 245;
    }

    public void move() {
        x--;
        if (x <= -w) {
            x = 545;
            y = -random.nextInt(h+146-644+1);
        }
    }
}
