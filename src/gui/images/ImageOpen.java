package gui.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

public class ImageOpen {

    public static void main(String[] args) throws IOException {
        Image image = ImageIO.read(new File("src/gui/images/testimage.png"));

        BufferedImage im2 = new BufferedImage(400,200, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = im2.getGraphics();
        g.setColor(new Color(234,34,234));
        g.fillRect(0,0,400,200);
        g.setColor(new Color(100, 234, 226));
        g.drawString("3458230",20,100);
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        g.setFont(new Font("Arial",Font.BOLD,20));
        byte[] butes = new byte[10];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write( im2,"png",os);

        frame.setTitle("My image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
               // g.drawImage(im2, 0, 0, null);
            }
        };

        frame.setLayout(new BorderLayout());
        frame.add(imagePanel, BorderLayout.CENTER);
    }

}
