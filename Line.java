import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Line {
    public static void createImage(boolean preview, BufferedImage bi, int width, int height, int clusterSize, int angle, Color[] colors, Random r) throws IOException {
        Graphics2D g = (Graphics2D) bi.getGraphics();
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHints(rh);

        //adjust angle
        if(angle >= 180)
            angle = angle % 180;

        for(int y = 0; y < height; y++) {
            int counter = 0;
            for(int x = 0; x < width; x++) {
                int randomizer = r.nextInt(clusterSize);
                Color newColor = colors[r.nextInt(colors.length)];
                g.setColor(newColor);
                if(counter == 0 || randomizer == 0 || bi.getRGB(x,y) == 0) {
                    if(angle <= 180)
                        g.drawLine(x, y, (int)(x + (clusterSize) * Math.cos(Math.toRadians(angle))), (int)(y + (clusterSize) * Math.sin(Math.toRadians(angle))));
                    else
                        g.drawLine((int)(x + (clusterSize) * Math.cos(Math.toRadians(angle))), (int)(y + (clusterSize) * Math.sin(Math.toRadians(angle))), x, y);
                    counter = clusterSize;
                }
                else
                    counter--;
            }
        }
        if(!preview)
            ImageIO.write(bi, "png", new File("out.png"));
        else
            new Preview(bi);
    }
}
