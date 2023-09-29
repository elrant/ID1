package com.elrant.id1;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; // 16x16 pixels
    final int scale = 4;
    final int tileSize = originalTileSize * scale; // 64x64 pixels

    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = maxScreenColumns * tileSize;
    final int screenHeight = maxScreenRows * tileSize;

    Thread gameThread;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    public void startGameThread() {
        //if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        //}
    }
    @Override
    public void run() {
        while(gameThread != null) {
            System.out.println("Game thread running");
        }
    }
}
