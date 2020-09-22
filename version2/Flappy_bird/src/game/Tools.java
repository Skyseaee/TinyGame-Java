package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ������
 * @author Haiyun
 *
 */
public class Tools {
	/**
	 * ������������ͼƬ·����ȡͼƬ�ķ���
	 * @param path ��������ͼƬ·��
	 * @return
	 */
	public static BufferedImage getImg(String path) {
		//����һ��ͼƬ
		BufferedImage img=null;
		try {
			img=ImageIO.read(Tools.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

}
