package org.example.panel;

import org.example.ui.MyButton;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MenuPanel {

    MyButton play;
    MyButton pause;
    MyButton stop;

    public MenuPanel() {




        setButtons();
    }

    private void setButtons() {
        play = new MyButton(100, 100, 100, 60, "Blah");
    }

    public void draw(Graphics2D g2) {
        play.draw(g2);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (play.contains(mx, my)) {
            System.out.println("Play Clicked");
        }
    }
}
