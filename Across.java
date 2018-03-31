import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Across {
    public static void createImage(BufferedImage bi, int width, int height, int clusterSize, Color[] colors) throws IOException {
        Graphics2D g = (Graphics2D) bi.getGraphics();
        for(int y = 0; y < height; y++) {
            int counter = 0;
            for(int x = 0; x < width; x++) {
                int randomizer = (int)(Math.random() * clusterSize);
                Color newColor = colors[(int)((Math.random() * (colors.length)))];
                g.setColor(newColor);
                if(counter == 0 || randomizer == 0) {
                    g.drawLine(x, y, x + (clusterSize), y);
                    counter = clusterSize;
                }
                else
                    counter--;
            }
        }
        ImageIO.write(bi, "png", new File("out.png"));
    }
}
