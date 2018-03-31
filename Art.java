import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Art {

    Random rand = new Random();
    String seed = Integer.toString(rand.nextInt(999999));

    public Art() {
        String[] colors = {"Red", "Yellow", "Blue", "Green", "Orange", "Gray", "Light Gray", "Black"};
        String[] modes = {"Snow", "Lines", "Rectangles", "Circles"};

        //set up frame
        JFrame frame = new JFrame("Art");
        JPanel panel = new JPanel();
        frame.setSize(230, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //JLabels
        JLabel widthLabel = new JLabel("Width:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel clusterSizeLabel = new JLabel("Cluster Size: ");
        JLabel angleLabel = new JLabel("Angle: ");
        JLabel color1Label = new JLabel("Color 1:");
        JLabel r1Label = new JLabel("R:");
        JLabel g1Label = new JLabel("G:");
        JLabel b1Label = new JLabel("B:");
        JLabel r2Label = new JLabel("R:");
        JLabel g2Label = new JLabel("G:");
        JLabel b2Label = new JLabel("B:");
        JLabel r3Label = new JLabel("R:");
        JLabel g3Label = new JLabel("G:");
        JLabel b3Label = new JLabel("B:");
        JLabel r4Label = new JLabel("R:");
        JLabel g4Label = new JLabel("G:");
        JLabel b4Label = new JLabel("B:");
        JLabel color2Label = new JLabel("Color 2:");
        JLabel color3Label = new JLabel("Color 3:");
        JLabel color4Label = new JLabel("Color 4:");
        final JLabel seedLabel = new JLabel("Seed:");
        JLabel modeLabel = new JLabel("Mode:");
        //JTextFields
        final JTextField widthField = new JTextField("500", 3);
        final JTextField heightField = new JTextField("500", 3);
        final JTextField clusterSizeField = new JTextField("10", 3);
        final JTextField angleField = new JTextField("0", 3);
        final JTextField r1Field = new JTextField("255", 3);
        final JTextField g1Field = new JTextField("0", 3);
        final JTextField b1Field = new JTextField("0", 3);
        final JTextField r2Field = new JTextField("0", 3);
        final JTextField g2Field = new JTextField("255", 3);
        final JTextField b2Field = new JTextField("0", 3);
        final JTextField r3Field = new JTextField("0", 3);
        final JTextField g3Field = new JTextField("0", 3);
        final JTextField b3Field = new JTextField("255", 3);
        final JTextField r4Field = new JTextField("0", 3);
        final JTextField g4Field = new JTextField("0", 3);
        final JTextField b4Field = new JTextField("0", 3);
        final JTextField seedField = new JTextField("", 9);
        //JComboBoxes
        final JComboBox color1Box = new JComboBox(colors);
        color1Box.setSelectedIndex(0);
        final JComboBox color2Box = new JComboBox(colors);
        color2Box.setSelectedIndex(1);
        final JComboBox color3Box = new JComboBox(colors);
        color3Box.setSelectedIndex(2);
        final JComboBox color4Box = new JComboBox(colors);
        color4Box.setSelectedIndex(3);
        final JComboBox modeBox = new JComboBox(modes);
        modeBox.setSelectedIndex(0);
        //buttons
        JButton createBtn = new JButton("Create Image!");
        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int r1 = Integer.parseInt(r1Field.getText());
                    int b1 = Integer.parseInt(b1Field.getText());
                    int g1 = Integer.parseInt(g1Field.getText());
                    int r2 = Integer.parseInt(r2Field.getText());
                    int g2 = Integer.parseInt(g2Field.getText());
                    int b2 = Integer.parseInt(b2Field.getText());
                    int r3 = Integer.parseInt(r3Field.getText());
                    int g3 = Integer.parseInt(g3Field.getText());
                    int b3 = Integer.parseInt(b3Field.getText());
                    int r4 = Integer.parseInt(r4Field.getText());
                    int g4 = Integer.parseInt(g4Field.getText());
                    int b4 = Integer.parseInt(b4Field.getText());
                    if(seedField.getText().equals(""))
                        GenerateImage.createImage(false, Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()), Integer.parseInt(clusterSizeField.getText()), Integer.parseInt(angleField.getText()), getColorFromRGB(r1, g1, b1), getColorFromRGB(r2, g2, b2), getColorFromRGB(r3, g3, b3), getColorFromRGB(r4, g4, b4), seed.toString(), modeBox.getSelectedItem().toString());
                    else
                        GenerateImage.createImage(false, Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()), Integer.parseInt(clusterSizeField.getText()), Integer.parseInt(angleField.getText()), getColorFromRGB(r1, g1, b1), getColorFromRGB(r2, g2, b2), getColorFromRGB(r3, g3, b3), getColorFromRGB(r4, g4, b4), seedField.getText(), modeBox.getSelectedItem().toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton previewBtn = new JButton("Preview Image");
        previewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int r1 = Integer.parseInt(r1Field.getText());
                    int b1 = Integer.parseInt(b1Field.getText());
                    int g1 = Integer.parseInt(g1Field.getText());
                    int r2 = Integer.parseInt(r2Field.getText());
                    int g2 = Integer.parseInt(g2Field.getText());
                    int b2 = Integer.parseInt(b2Field.getText());
                    int r3 = Integer.parseInt(r3Field.getText());
                    int g3 = Integer.parseInt(g3Field.getText());
                    int b3 = Integer.parseInt(b3Field.getText());
                    int r4 = Integer.parseInt(r4Field.getText());
                    int g4 = Integer.parseInt(g4Field.getText());
                    int b4 = Integer.parseInt(b4Field.getText());
                    if(seedField.getText().equals(""))
                        GenerateImage.createImage(true, Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()), Integer.parseInt(clusterSizeField.getText()), Integer.parseInt(angleField.getText()), getColorFromRGB(r1, g1, b1), getColorFromRGB(r2, g2, b2), getColorFromRGB(r3, g3, b3), getColorFromRGB(r4, g4, b4), seed.toString(), modeBox.getSelectedItem().toString());
                    else
                        GenerateImage.createImage(true, Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()), Integer.parseInt(clusterSizeField.getText()), Integer.parseInt(angleField.getText()), getColorFromRGB(r1, g1, b1), getColorFromRGB(r2, g2, b2), getColorFromRGB(r3, g3, b3), getColorFromRGB(r4, g4, b4), seedField.getText(), modeBox.getSelectedItem().toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //add to frame
        frame.add(panel);
        panel.add(widthLabel);
        panel.add(widthField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(clusterSizeLabel);
        panel.add(clusterSizeField);
        panel.add(angleLabel);
        panel.add(angleField);
        panel.add(color1Label);
        panel.add(r1Label);
        panel.add(r1Field);
        panel.add(g1Label);
        panel.add(g1Field);
        panel.add(b1Label);
        panel.add(b1Field);
        //panel.add(color1Box);
        panel.add(color2Label);
        panel.add(r2Label);
        panel.add(r2Field);
        panel.add(g2Label);
        panel.add(g2Field);
        panel.add(b2Label);
        panel.add(b2Field);
        //panel.add(color2Box);
        panel.add(color3Label);
        panel.add(r3Label);
        panel.add(r3Field);
        panel.add(g3Label);
        panel.add(g3Field);
        panel.add(b3Label);
        panel.add(b3Field);
        //panel.add(color3Box);
        panel.add(color4Label);
        panel.add(r4Label);
        panel.add(r4Field);
        panel.add(g4Label);
        panel.add(g4Field);
        panel.add(b4Label);
        panel.add(b4Field);
        //panel.add(color4Box);
        panel.add(modeLabel);
        panel.add(modeBox);
        panel.add(seedLabel);
        panel.add(seedField);
        panel.add(createBtn);
        panel.add(previewBtn);
        panel.setVisible(true);
        frame.setVisible(true);
    }

    private Color getColorFromRGB(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public static void main(String[] args) throws IOException {
        new Art();
    }
}