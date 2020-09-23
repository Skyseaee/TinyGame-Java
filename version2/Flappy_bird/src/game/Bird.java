package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * С����
 * @author Haiyun
 *
 */
public class Bird {
	//���ͼƬ
	BufferedImage img;
	//x����
	int x;
	//y����
	int y;
	//��Ŀ��
	int w;
	//��ĸ߶�
	int h;
	//����װһ��ͼƬ��
	List<BufferedImage> list;
	//���ٶ�
	double v0;
	//ʱ�����������ƶ���ʱ�䣩
	double t;
	//����
	double s;
	//����
	double g;
	
	//��Ĺ������������������
	public Bird() {
		//��ȡ���ͼƬ
		img=Tools.getImg("../img/0.png");
		//��ȡ��Ŀ��
		w=img.getWidth()*2/3;
		//��ȡ��ĸ߶�
		h=img.getHeight()*2/3;
		//x
		x=100;
		//y
		y=200;
		//��ʼ��װͼƬ������
		list=new ArrayList<BufferedImage>();
		//�����������ͼƬ
//		list.add(Tools.getImg("../img/0.png"));
		for(int i=0;i<8;i++) {
			list.add(Tools.getImg("../img/"+i+".png"));
		}
		//��ʼ�����ٶ�
		v0=3;
		//ʱ��
		t=0.2;
		//����
		s=0;
		//����
		g=10;
	}
	//��ĳ������
	int index=0;//����±�����ȡͼƬ
	public void fly() {
//		if(index>=8) {
//			index=0;
//		}
		//��list������ȡ��
		img=list.get(index%list.size());
		index++;
	}
	//С��������˶�
	public void move() {
		//����С�����׵ľ���
		s=v0*t;
		//�õ�С�����׵���ߵĵ�y����
		y=y-(int)s;
		//�����С�񵽴���ߵ���ٶ�
		double v2=v0-g*t;
		//��ߵ���ٶȾ���С������ĳ��ٶ�
		v0=v2;
	}
	//С�������˶�
	public void moveUp() {
		v0=30;
	}
}
