package org.example.main;

import javax.swing.*;
import java.util.Objects;

public class GameFrame extends JFrame {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Horror Game");
        this.setIconImage(Objects.requireNonNull(setTitleIcon()).getImage());
        this.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);

        gamePanel.startThread();

        this.setVisible(true);
    }

    private ImageIcon setTitleIcon() {
        try {
            return new ImageIcon("src/main/resources/icon/MainIcon.png");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.err.println("Error loading icon");
        return null;
    }
}
