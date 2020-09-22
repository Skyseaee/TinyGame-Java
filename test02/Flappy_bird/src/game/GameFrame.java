package game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * ��Ϸ������
 * @author Haiyun
 *
 */
public class GameFrame extends JFrame {
	//������������ʼ������
	//Alt+/  ��ȫ����
	public GameFrame() {
		// ���óߴ�
		setSize(700, 730);
		//���þ�����ʾ
		setLocationRelativeTo(null);
		//���ùرմ����ͬʱ��ֹ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ñ���
		setTitle("Flappy Bird");
		//����Logoͼ��img/0.png
		setIconImage(Tools.getImg("../img/0.png"));
		
	}
	//java���������(һ������ֻ����һ�����)
	public static void main(String[] args) {
		//����һ���������
		GameFrame frame=new GameFrame();
		//����һ��������� Alt+�������ѡ�������ƶ�
		GamePanel panel=new GamePanel();
		//���������һ�黭��
		frame.add(panel);
		//��ʾ����
		frame.setVisible(true);
		//������Ϸ
//		panel.start();
	}

}
