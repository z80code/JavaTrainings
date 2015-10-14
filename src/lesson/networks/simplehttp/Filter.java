package lesson.networks.simplehttp;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Created by igor on 14.10.2015.
 */
public class Filter {
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


}
