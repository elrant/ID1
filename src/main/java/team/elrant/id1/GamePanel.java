package team.elrant.id1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;
import team.elrant.id1.entity.Player;
import team.elrant.id1.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // 16x16 pixels
    final int scale = 4;
    public final int tileSize = originalTileSize * scale; // 64x64 pixels

    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = maxScreenColumns * tileSize;
    final int screenHeight = maxScreenRows * tileSize;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandler);

    int FPS = 60;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        // if (gameThread == null) {
        gameThread = new Thread(this);
        gameThread.start();
        // }
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // The amount of time in nanoseconds between each frame
        double delta = 0; // The amount of time until the next frame
        long lastTime = System.nanoTime(); // The time since the game started
        long currentTime; // The current time
        long timer = 0; // The amount of time since the last time the FPS was printed
        int drawCount = 0; // The number of frames drawn since the last time the FPS was printed

        while (gameThread != null) { // While the game is running

            currentTime = System.nanoTime(); // Get the current time

            // Add the time since the last frame to the delta
            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime); // Add the time since the last frame to the timer
            lastTime = currentTime; // Update the last time

            if (delta >= 1) { // If it's time to draw a new frame

                update();

                repaint();

                delta--;

                drawCount++;
            }

            if (timer >= 1000000000) { // If it's been a second since the last time the FPS was printed

                System.out.println("FPS: " + drawCount);

                drawCount = 0;

                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileManager.drawTile(g2);
        player.draw(g2);
        
        g2.dispose();
    }
}
