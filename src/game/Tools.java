package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Tools {
    /**
     * 根据所给定的路径返回指定的图片
     * @param path
     * @return
     */
    public static BufferedImage getBufferImage(String path)
    {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
