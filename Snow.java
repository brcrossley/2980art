import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Snow {
    public static void createImage(boolean preview, BufferedImage bi, int width, int height, int clusterSize, Color[] colors, Random r) throws IOException {
        Graphics2D g = (Graphics2D) bi.getGraphics();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color newColor = colors[r.nextInt(colors.length)];
                g.setColor(newColor);
                g.drawLine(x,y, x + 1,y + 1);
            }
        }
        if(!preview)
            FileChooser.chooseFile(bi);
        else
            new Preview(bi);
    }
}
