package org.example.main;

import org.example.panel.MenuPanel;
import org.example.panel.PanelID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {

    PanelID panelID;
    MenuPanel menuPanel = new MenuPanel();

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
        });
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(panelID == PanelID.MENU) {
            menuPanel.draw(g2);
        }

        g2.dispose();
    }
}
