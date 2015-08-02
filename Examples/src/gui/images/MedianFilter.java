package gui.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by igor on 14.07.2015.
 */
public class MedianFilter {

    public static void medianFilter(BufferedImage image) {
        //int[] rgbRaster = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        WritableRaster raster = image.getRaster();

        for(int h = 1; h < raster.getHeight()-1; h++) {
            for(int w = 1; w < raster.getWidth()-1; w++) {
                //System.out.println(Arrays.toString(raster.getPixel(w,h, new int[]{0, 0, 0})));
                int[] pxp = raster.getPixel(w-1,h, new int[]{0, 0, 0});
                int[] pxm = raster.getPixel(w,h, new int[]{0, 0, 0});
                int[] pxn = raster.getPixel(w+1,h, new int[]{0, 0, 0});
                int[] narr = {0,0,0};

                for(int i =0;i<3;i++) {
                    narr[i] = (pxp[i]+pxm[i]+pxn[i])/3;
                }
                raster.setPixel(w,h, narr );
            }
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {


        JFrame frame = new JFrame();
        frame.setSize(800,300);

        frame.setTitle("My image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        final BufferedImage def = ImageIO.read(new File("src/gui/images/testimage.png"));
        final BufferedImage image = ImageIO.read(new File("src/gui/images/testimage.png"));
        medianFilter(image);


        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        };

        JPanel defPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(def, 0, 0, null);
            }
        };

        frame.setLayout(new BorderLayout());


        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,defPanel, imagePanel);
        sp.setDividerLocation(400);
        frame.add(sp, BorderLayout.CENTER);


        frame.setVisible(true);
    }
}
