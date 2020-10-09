package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
* 工具类*/

public class Tools {
    //根据给定的图片路径获取图片的方法
    public static BufferedImage getImg(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Tools.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
