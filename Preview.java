import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Preview {
    public Preview(BufferedImage bi) {
        JFrame frame = new JFrame("Preview");
        JPanel panel = new JPanel();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(bi.getWidth(), bi.getHeight());

        JLabel imageLabel = new JLabel(new ImageIcon(bi));
        panel.add(imageLabel);
        panel.setVisible(true);
        frame.add(panel);
        frame.setVisible(true);
    }
}
