package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton {
    int x, y, width, height;
    String text;

    public MyButton(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        g2.fillRect(x, y, width, height);

        g2.setColor(Color.WHITE);
        FontMetrics fm = g2.getFontMetrics();
        int stringWidth = fm.stringWidth(text);
        int stringHeight = fm.getAscent();

        int setX = x + (width - stringWidth) / 2;
        int setY = y + (height + stringHeight) / 2 - 2;

        g2.drawString(text, setX, setY);
    }

    public boolean contains(int mx, int my) {
        return mx >= x && mx <= x + width &&
                my >= y && my <= y + height;
    }

    private class CustomMouseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Play Clicked");
        }
    }
}