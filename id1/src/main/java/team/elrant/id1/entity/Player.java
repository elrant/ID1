package team.elrant.id1.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import team.elrant.id1.GamePanel;
import team.elrant.id1.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        }
        if (keyHandler.downPressed) {
            y += speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
