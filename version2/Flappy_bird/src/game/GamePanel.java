package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * ������
 * @author Haiyun
 *
 */
public class GamePanel extends JPanel {
	//����һ�����ڴ�ű���ͼƬ�ı��������ӣ�
	BufferedImage bg;
	//����һ�����ڴ�ŵ���ı���
	Ground ground;
	//����һ�����ڴ�����ӵı���
	Column column1;
	//����һ�����ڴ�ŵڶ������ӵı���
	Column column2;
	//����һ�����ڴ�ŵ��������ӵı���
	Column column3;
	//����һ��
	Bird bird;
	//��Ϸ׼��״̬
	boolean start;
	//������
	public GamePanel () {
		//���ñ���ɫ
		setBackground(Color.pink);
		//���ñ���ͼƬ ../Ϊ�˳���ǰ�ļ���
		bg=Tools.getImg("../img/����.png");
		//��ʼ���������
		ground = new Ground();
		//��ʼ�����Ӷ���
		column1=new Column(1);//x=300
		//��ʼ���ڶ�������
		column2=new Column(2);//x=545
		//��ʼ������������
		column3=new Column(3);
		//��ʼ�������
		bird=new Bird();
		//��ʼ����Ϸ״̬��û�п�ʼΪ׼��״̬����Ϊtrue��Ϊ��Ϸ����״̬��
		start=false;
		//��ʼ����������
		MouseAdapter adapter=new MouseAdapter() {
			//���������Ҫ��ʲô��д������ķ����ڲ�
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(start) {//����״̬
					//С������
					bird.moveUp();
				}else {//�ı���Ϸ״̬Ϊ����״̬
					start=true;
					//������Ϸ
					start();
				}
			}
		};
		this.addMouseListener(adapter);
	}
	//��Ϸ��ʼ�ķ���
	public void start() {
		//������Ϸ���е��߳�
		MyThread mt=new MyThread();
		//���߳�����ִ�е���Ϊװ�뵽�̶߳�����
		Thread t=new Thread(mt);
		//���߳������̵߳���
		t.start();//����cpu���Ը�������̷߳���ʱ��Ƭ����
	}
	
	//�����򻭰��ϻ������� g�൱�ڻ���
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//���Ʊ���ͼƬ����Ҫ���Ƶ�ͼƬ��x���꣬y���꣬nullȫ����䣩
		g.drawImage(bg,0,0,null);
		//��������ͼƬ
		g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
		//��������2ͼƬ
		g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
		//��������3ͼƬ
		g.drawImage(column3.img, column3.x, column3.y, column3.w, column3.h, null);
		//���Ƶ���ͼƬ
		g.drawImage(ground.img, ground.x, ground.y, null);
		//�������ͼƬ
		g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
	}
	
	//��Ϸ���е��߳�
	class MyThread implements Runnable{
		//�Ѹ��߳���Ҫ�ɵĻ�ŵ�run������
		@Override
		public void run() {
			while(true) {
				//�õ����ƶ�����
				ground.move();
				//�����ƶ�
				column1.move();
				//����2�ƶ�
				column2.move();
				//����3�ƶ�
				column3.move();
				//С���
				bird.fly();
				//С���������˶�
				bird.move();
				try {
					//ÿ�ƶ�һ����Ϣ1s
					Thread.sleep(30);
					//ˢ��
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
