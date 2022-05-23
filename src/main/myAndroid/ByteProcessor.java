package myAndroid;

import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.image.SampleModel;

public class ByteProcessor extends ImageProcessor {

    protected byte[] pixels;

    public ImageProcessor duplicate() {
        ImageProcessor ip2 = createProcessor(width, height);
        byte[] pixels2 = (byte[])ip2.getPixels();
        System.arraycopy(pixels, 0, pixels2, 0, width*height);
        return ip2;
    }

    public ImageProcessor createProcessor(int width, int height) {
        ImageProcessor ip2;
        ip2 =  new ByteProcessor(width, height, new byte[width*height], getColorModel());
        if (baseCM!=null)
            ip2.setMinAndMax(min, max);
        ip2.setInterpolationMethod(interpolationMethod);
        return ip2;
    }


    public BufferedImage getBufferedImage() {
        if (isDefaultLut()) {
            java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_BYTE_GRAY);
            Graphics g = bi.createGraphics();
            g.drawImage(createImage(), 0, 0, null);
            return bi;
        } else
            return (BufferedImage)createBufferedImage();
    }


    Image createBufferedImage() {
        if (raster==null) {
            SampleModel sm = getIndexSampleModel();
            DataBuffer db = new DataBufferByte(pixels, width*height, 0);
            raster = Raster.createWritableRaster(sm, db, null);
        }
        if (image==null || cm!=cm2) {
            if (cm==null) cm=getDefaultColorModel();
            image = new BufferedImage(cm, raster, false, null);
            cm2 = cm;
        }
        return image;
    }

    Image createImage() {
        return createBufferedImage();
    }


    public Object getPixels() {
        return (Object)pixels;
    }




}
