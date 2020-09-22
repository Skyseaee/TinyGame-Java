package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 游戏窗体类
 */
public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame()
    {
        setSize(400,740);
        setTitle("FlappyBird");
        //set Logo
        try {
            setIconImage(ImageIO.read(new BufferedInputStream(new FileInputStream
                    ("./resources/img/0.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);//相对整个窗口居中
        setResizable(false);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
