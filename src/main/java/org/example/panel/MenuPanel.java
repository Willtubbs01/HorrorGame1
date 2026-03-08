package org.example.panel;

import org.example.main.GameFrame;
import org.example.main.GamePanel;
import org.example.ui.MyButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel {

    GamePanel gp;

    MyButton play;
    MyButton settings;
    MyButton exit;

    BufferedImage backgroundImage;
    float opacity = 0.035f;

    public MenuPanel(GamePanel gp) {

        this.gp = gp;

        setImage();
        setButtons();
    }

    public void update(){
        opacity = gp.rand.nextFloat()%0.035f;
    }

    private void setImage() {
        try
        {
//            BufferedImage temp = ImageIO.read(new File("src/main/resources/backgrounds/menuBackgroundImage.png"));

            backgroundImage = ImageIO.read(new File("src/main/resources/backgrounds/menuBackgroundImage.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setButtons() {
        int gap = 45;
        play = new MyButton(100, GameFrame.HEIGHT/3, 250, 60, "Play");
        exit =  new MyButton(play.getX(), play.getY() + play.getHeight() + gap, 250, 60, "Exit");
    }

    public void draw(Graphics2D g2) {
        AlphaComposite oldComposite = (AlphaComposite) g2.getComposite();
        AlphaComposite newComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g2.setComposite(newComposite);
        g2.drawImage(backgroundImage, 0, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);

        g2.setComposite(oldComposite);
        play.draw(g2);
        exit.draw(g2);
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (play.contains(mx, my)) {
            play.setButtonColor(Color.darkGray.darker());
            System.out.println("Play Clicked");
        }
        if (exit.contains(mx, my)) {
            exit.setButtonColor(Color.darkGray.darker());

        }
    }

    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (play.contains(mx, my)) {
            play.setButtonColor(Color.darkGray);
            gp.setPanelID(PanelID.PLAY);
        }
        if (exit.contains(mx, my)) {
            System.exit(0);
        }
    }

    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (play.contains(mx, my)) {
            play.setButtonColor(Color.darkGray);
            play.setButtonTextColor(Color.lightGray);
        } else {
            play.setButtonColor(Color.gray);
            play.setButtonTextColor(Color.WHITE);
        }

        if (exit.contains(mx, my)) {
            exit.setButtonColor(Color.darkGray);
            exit.setButtonTextColor(Color.lightGray);
        } else {
            exit.setButtonColor(Color.gray);
            exit.setButtonTextColor(Color.WHITE);
        }
    }
}
