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

    private Color buttonColor;
    private Color textColor;

    private int borderWidth;


    public MyButton(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        buttonColor = Color.gray;
        textColor = Color.WHITE;
        borderWidth = 4;
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.darkGray);
        g2.fillRect(x-borderWidth, y-borderWidth, width+borderWidth*2, height+borderWidth*2);
        g2.setColor(buttonColor);
        g2.fillRect(x, y, width, height);

        g2.setColor(textColor);
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

    public void setButtonColor(Color color) {
        buttonColor = color;
    }

    public void setButtonTextColor(Color color) {
        textColor = color;
    }



    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    private class CustomMouseListener implements ActionListener, MouseMotionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Play Clicked");
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int  mx = e.getX();
            int my = e.getY();

            System.out.println(mx + " " + my);

        }
    }
}