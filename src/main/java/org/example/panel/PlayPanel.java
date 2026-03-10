package org.example.panel;

import org.example.main.GameFrame;
import org.example.main.GamePanel;
import org.example.ui.MyButton;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PlayPanel {

    private final GamePanel gp;
    private MyButton leftButton;
    private MyButton rightButton;

    private final int GAME_WIDTH;
    private final int GAME_HEIGHT;

    private double cameraX = 0;

    private int mouseX = GameFrame.WIDTH / 2;
    private int mouseY = GameFrame.HEIGHT / 2;

    private final int edgeZone = 160;
    private final double cameraSpeed = 6;

    // Fixed WORLD position
    private int leftButtonWorldX;
    private int leftButtonWorldY;
    private int rightButtonWorldX;
    private int rightButtonWorldY;

    public PlayPanel(GamePanel gp) {
        this.gp = gp;
        GAME_WIDTH = (int) (GameFrame.WIDTH * 1.2);
        GAME_HEIGHT = GameFrame.HEIGHT;

        setUpButtons();
    }

    private void setUpButtons() {
        int bWidth = 40;
        int bHeight = 40;

        leftButtonWorldX = 20;
        leftButtonWorldY = (GAME_HEIGHT - bHeight) / 2;

        rightButtonWorldX = GAME_WIDTH - bWidth - 20;
        rightButtonWorldY =  (GAME_HEIGHT - bHeight) / 2;

        // temp x/y here, real draw position gets updated each frame
        leftButton = new MyButton(0, 0, bWidth, bHeight, "");
        rightButton = new MyButton(0, 0, bWidth, bHeight, "");
    }

    public void update() {
        if (mouseX < edgeZone) {
            cameraX -= cameraSpeed;
        }

        if (mouseX > GameFrame.WIDTH - edgeZone) {
            cameraX += cameraSpeed;
        }

        if (cameraX < 0) {
            cameraX = 0;
        }

        double maxCameraX = GAME_WIDTH - GameFrame.WIDTH;
        if (cameraX > maxCameraX) {
            cameraX = maxCameraX;
        }

        // Convert button world position to screen position
        int buttonScreenLX = leftButtonWorldX - (int) cameraX;
        int buttonScreenLY = leftButtonWorldY;
        int buttonScreenRX = rightButtonWorldX - (int) cameraX;
        int buttonScreenRY = rightButtonWorldY;

        leftButton.setX(buttonScreenLX);
        leftButton.setY(buttonScreenLY);
        rightButton.setX(buttonScreenRX);
        rightButton.setY(buttonScreenRY);
    }

    public void draw(Graphics2D g2) {
        int tileSize = 10;
        int temp = 0;

        for (int i = 0; i < GAME_WIDTH; i += tileSize) {
            for (int j = 0; j < GAME_HEIGHT; j += tileSize) {
                if (temp % 2 == 0) {
                    g2.setColor(Color.GRAY);
                } else {
                    g2.setColor(Color.ORANGE);
                }

                int drawX = i - (int) cameraX;
                g2.fillRect(drawX, j, tileSize, tileSize);

                temp++;
            }
            temp++;
        }

        g2.setColor(Color.WHITE);
        g2.drawString("cameraX: " + (int) cameraX, 20, 20);
        g2.drawString("mouseX: " + mouseX, 20, 40);

        leftButton.draw(g2);
        rightButton.draw(g2);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (leftButton.contains(mx, my)) {
            System.out.println("Left button clicked");
        }
        if (rightButton.contains(mx, my)) {
            System.out.println("Right button clicked");
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}