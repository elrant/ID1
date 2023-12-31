package team.elrant.id1.tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import team.elrant.id1.utils.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResource("/tile/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResource("/tile/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResource("/tile/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawTile(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, gp.tileSize * 2, 0, gp.tileSize, gp.tileSize, null);

    }
}