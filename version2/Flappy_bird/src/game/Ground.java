package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * �ĵ�ע�Ϳ�ݼ� shift+alt+j
 * 
 *������ 
 * 
 * @author Haiyun
 *
 */
public class Ground {
	//x����
	int x;
	//y����
	int y;
	//�����ͼƬ
	BufferedImage img;
	//����Ŀ��
	int w;
	//����ĸ߶�
	int h;
	
	//����Ĺ�������������������
	public Ground() {
		//�ȳ�ʼ������ͼƬ
		img=Tools.getImg("../img/ground.png");
		//��ȡͼƬ�߶�
		h=158;
		//��ȡͼƬ���
		w=img.getWidth();
		//��ʼ��x
		x=0;
		//��ʼ��y
		y=730-h;
		
	}
	
	//�����ƶ��ķ���
	public void move () {
		if(x<=-(w-700)) {
			x=0;
		}
		x--;
		
	}

}
