package org.example.ui;

import org.example.main.GamePanel;
import org.example.panel.PanelID;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_ESCAPE) {
            GamePanel.panelID = PanelID.MENU;
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
