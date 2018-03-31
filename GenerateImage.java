import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GenerateImage {
    public static void createImage(boolean preview, int width, int height, int clusterSize, int angle, Color color1, Color color2, Color color3, Color color4, String inputSeed, String mode) throws IOException {
        int seed;
        Random r;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Color[] colors = {color1, color2, color3, color4};
        width = bi.getWidth();
        height = bi.getHeight();

        if(inputSeed.equals("")) {
            r = new Random();
            seed = r.nextInt((999999999 - 0) + 1);
            r = new Random(seed);
        }
        else {
            r = new Random(Integer.parseInt(inputSeed));
        }

        switch(modeSwitch(mode)) {
            case 0:
                Snow.createImage(preview, bi, width, height, clusterSize, colors, r);
                break;
            case 1:
                Line.createImage(preview, bi, width, height, clusterSize, angle, colors, r);
                break;
            case 2:
                Rectangles.createImage(preview, bi, width, height, clusterSize, colors, r);
                break;
            case 3:
                Circles.createImage(preview, bi, width, height, clusterSize, colors, r);
        }
    }

    private static int modeSwitch(String s) {
        if (s.equals("Snow"))
            return 0;
        else if (s.equals("Lines"))
            return 1;
        else if(s.equals("Rectangles"))
            return 2;
        else
            return 3;
    }
}
