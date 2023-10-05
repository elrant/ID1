package team.elrant.id1.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import team.elrant.id1.GamePanel;
import team.elrant.id1.KeyHandler;
import team.elrant.id1.utils.ResourceLoader;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
        loadPlayerSprites();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
                y -= speed;
            }
            if (keyHandler.downPressed) {
                direction = "down";
                y += speed;
            }
            if (keyHandler.leftPressed) {
                direction = "left";
                x -= speed;
            }
            if (keyHandler.rightPressed) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter == 12) {
                if (spriteNum == 2)
                    spriteNum = 1;
                else if (spriteNum == 1) {
                    spriteNum = 2;
                }
                spriteCounter = 0;
            }

            if (wasStill) {
                spriteNum = 2;
                wasStill = false;
            }

        } else {
            spriteNum = 1;
            spriteCounter = 0;
            wasStill = true;
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void loadPlayerSprites() {
        try {
            up1 = ImageIO.read(getClass().getResource("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResource("/player/up2.png"));
            down1 = ImageIO.read(getClass().getResource("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResource("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResource("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResource("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResource("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResource("/player/right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
