package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

/**
 *游戏窗体类
 */


public class GameFrame extends JFrame {
    //构造器初始化操作
    public GameFrame() {
        //设置尺寸
        setSize(432, 644);
        //设置居中显示
        setLocationRelativeTo(null);
        //设置关闭窗体的同时终止程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置程序标题
        setTitle("FlappyBirds v1.0");
        //设置LOGO
        setIconImage(Tools.getImg("../img/0.png"));
        }

    public static void main(String[] args) {
        //创建窗体对象
        GameFrame frame = new GameFrame();
        //创建画板对象
        GamePanel panel = new GamePanel();
        //在窗体类中添加画板
        frame.add(panel);
        //显示窗体
        frame.setVisible(true);
        //启动游戏
        panel.start();
    }
}
