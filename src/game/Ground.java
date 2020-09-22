package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 地面类
 */

public class Ground {
    private int x; //地面图片起始位置x
    private int y; //地面图片起始位置y
    private BufferedImage groundImage;
    private int groundHeight;  //地面图片高度
    private int groundWidth;

    //地面的构造器用来构造地面对象
    public Ground()
    {
        x = 0;
        groundImage = Tools.getBufferImage("resources/image/ground.png");
        //groundHeight = groundImage.getHeight();
        groundHeight = 180;
        groundWidth = groundImage.getWidth();
        y = 740 - groundHeight ;

    }

    public BufferedImage getGroundImage() {
        return groundImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void GroundMove()
    {
        if(x<=-(groundWidth-400))
            x=0;
        else
            x--;
    }


}
