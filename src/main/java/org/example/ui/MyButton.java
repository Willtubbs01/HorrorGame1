package org.example.ui;

import java.awt.*;

public class MyButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;

    public MyButton(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.gray);
        g2.fillRect(x, y, width, height);
        FontMetrics fm = g2.getFontMetrics();
        int StringWidth = fm.stringWidth(text);
        int StringHeight = fm.getAscent();

        int setX = this.x + (this.width - StringWidth) / 2;
        int setY = this.y + (this.height + StringHeight) / 2;
        g2.setColor(Color.white);
        g2.drawString(text, setX, setY);

        g2.setColor(Color.green);
//        g2.drawLine(x, y/2 + y, x+width,  y/2 + y);
    }
}
