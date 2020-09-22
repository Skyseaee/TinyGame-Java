package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 工具类
 * @author Haiyun
 *
 */
public class Tools {
	/**
	 * 根据所给定的图片路径获取图片的方法
	 * @param path 所给定的图片路径
	 * @return
	 */
	public static BufferedImage getImg(String path) {
		//声明一张图片
		BufferedImage img=null;
		try {
			img=ImageIO.read(Tools.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}
