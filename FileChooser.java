import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FileChooser {
    public static void chooseFile(BufferedImage bi) {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle("Save Art");
        jFileChooser.setSelectedFile(new File("out.png"));
        int retrival = jFileChooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(bi, "png", jFileChooser.getSelectedFile());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
