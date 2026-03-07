package org.example.panel;

import org.example.ui.MyButton;

import java.awt.*;

public class MenuPanel {

    MyButton play;
    MyButton pause;
    MyButton stop;

    public MenuPanel() {
        setButtons();
    }

    private void setButtons() {
        play = new MyButton(100, 100, 100, 100, "Blah");
    }

    public void draw(Graphics2D g2) {
        play.draw(g2);
    }
}
