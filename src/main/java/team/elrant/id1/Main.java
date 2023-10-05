package team.elrant.id1;

import javax.swing.JFrame;

import team.elrant.id1.utils.GamePanel;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("ID1");
        GamePanel gamePanel = new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("ID1");

        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);

        window.setVisible(true);
        gamePanel.startGameThread();
    }
}