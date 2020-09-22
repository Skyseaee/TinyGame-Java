package GameApp;

import game.GameFrame;
import game.GamePanel;

import javax.swing.*;

public class GameApp {
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        GamePanel panel = new GamePanel();
        frame.add(panel);


        frame.setVisible(true);
        //panel.start();

    }
}
