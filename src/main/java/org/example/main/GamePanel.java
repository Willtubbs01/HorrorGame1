package org.example.main;

import org.example.panel.MenuPanel;
import org.example.panel.PanelID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    public Random rand = new Random();

    PanelID panelID;
    MenuPanel menuPanel = new MenuPanel(this);

    public GamePanel() {
        panelID = PanelID.MENU;

        this.setLayout(null);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (panelID == PanelID.MENU) {
                    menuPanel.mousePressed(e);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (panelID == PanelID.MENU) {
                    menuPanel.mouseReleased(e);
                }
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (panelID == PanelID.MENU) {
                    menuPanel.mouseMoved(e);
                }
            }
        });
    }

    private void update(){
        if(PanelID.MENU == panelID){
            menuPanel.update();
        }
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(panelID == PanelID.MENU) {
            menuPanel.draw(g2);
        }

        g2.dispose();
    }

    @Override
    public void run() {


        double drawInterval = 1000000000.0 / 60.0;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopThread() {
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPanelID(PanelID panelID) {
        this.panelID = panelID;
    }
}
