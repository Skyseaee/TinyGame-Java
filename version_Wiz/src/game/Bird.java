package game;

/*
* 小鸟类
* */

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird {
    //小鸟的图片
    BufferedImage img;
    //小鸟的初始坐标
    int x, y;
    //小鸟的宽度和高度
    int w, h;
    //存储小鸟图片的list
    List<BufferedImage> list;
    //小鸟的储速度
    double v0;
    //向上飞的时间
    double t;
    //距离
    double s;
    //重力加速度
    double g;
    //小鸟的构造器
    public Bird() {
        img = Tools.getImg("../img/0.png");
        x = 100;
        y = 200;
        w = img.getWidth()/2;
        h = img.getHeight()/2;
        //初始化图片list
        list = new ArrayList<BufferedImage>();
        //添加小鸟图片
        for (int i = 0; i < 8; i++) {
            list.add(Tools.getImg("../img/"+ i +".png"));
        }
        //初始化速度
        v0 = 3;
        //时间
        t = 0.2;
        //距离
        s = 0.1;
        //重力加速度
        g = 5;
    }

    //切换小鸟图片的方法
    int index = 0; //图片的索引
    public void fly() {
        img = list.get(index%list.size());
        index++;
    }
}
