package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * ������
 * @author Haiyun
 *
 */
public class Column {
	//���ӵ�ͼƬ
	BufferedImage img;
	//x����
	int x;
	//y����
	int y;
	//���ӵĿ��
	int w;
	//���ӵĸ߶�
	int h;
	//���Ӽ�ļ��
	int distance;
	//����һ�����������
	Random ran=new Random();
	//��������ʼ���������Ӷ���i��ʾ�ڼ������ӣ�
	public Column(int i) {
		//��ʼ������ͼƬ
		img=Tools.getImg("../img/column.png");
		//��ȡͼƬ�Ŀ��
		w=img.getWidth();
		//��ȡͼƬ�ĸ߶�
		h=img.getHeight();
		//��ʼ�����Ӽ��
		distance=311;
		//����x����
		x=544+311*(i-1);
//		if(i==1) {
//			x=300;
//		}else if(x==2) {
//			x=300+distance;
//		}
		//����y���꣨0-n-1�����������λ������ʱ��y=-308
		y=-208-ran.nextInt(201);
	}
	//�����ƶ�
	public void move() {
		x--;
		if(x<=-w) {
			x=544+distance;
		}
	}

}
