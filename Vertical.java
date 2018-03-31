import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Vertical {
    public static void createImage(BufferedImage bi, int width, int height, int clusterSize, Color[] colors, Random r) throws IOException {
        Graphics2D g = (Graphics2D) bi.getGraphics();
        int counter = 0;
        for(int y = 0; y < height; y++) {
            int randomizer = (int)(Math.random() * clusterSize);
            for(int x = 0; x < width; x++) {
                Color newColor = colors[(int)((Math.random() * (colors.length)))];
                g.setColor(newColor);
                if(y == 0)
                    counter = 0;
                if(counter == 0 || randomizer == 0) {
                    g.drawLine(x, y, x, (y + clusterSize));
                    counter = clusterSize;
                }
                else
                    counter--;
            }
        }
        ImageIO.write(bi, "png", new File("out.png"));
    }
}
