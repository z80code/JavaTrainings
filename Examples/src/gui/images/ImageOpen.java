package gui.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.io.IOException;

public class ImageOpen {

    public static void main(String[] args) throws IOException {
        Image image = ImageIO.read(new File("src/gui/images/testimage.png"));


        JFrame frame = new JFrame();
        frame.setSize(400,300);

        frame.setTitle("My image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        };

        frame.setLayout(new BorderLayout());
        frame.add(imagePanel, BorderLayout.CENTER);
    }

}
