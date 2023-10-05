package team.elrant.id1.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {

    public static BufferedImage loadImage(String resourcePath) {
        try (InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream != null) {
                return ImageIO.read(inputStream);
            } else {
                System.err.println("Resource not found: " + resourcePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}