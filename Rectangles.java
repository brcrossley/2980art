import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Rectangles {
    public static void createImage(boolean preview, BufferedImage bi, int width, int height, int clusterSize, Color[] colors, Random r) throws IOException {
        Graphics2D g = (Graphics2D) bi.getGraphics();
        int xCounter = clusterSize;
        int yCounter = clusterSize;
        for(int y = 0; y < height; y++) {
            if(y != 0)
                yCounter--;
            if(yCounter == 0)
                yCounter = clusterSize;

            for(int x = 0; x < width; x++) {
                Color newColor = colors[r.nextInt(colors.length)];
                g.setColor(newColor);
                if(xCounter == clusterSize && yCounter == clusterSize)
                    g.fillRect(x, y, clusterSize, clusterSize);
                xCounter--;
                if(xCounter == 0)
                    xCounter = clusterSize;
            }
        }
        if(!preview)
            FileChooser.chooseFile(bi);
        else
            new Preview(bi);
    }
}
