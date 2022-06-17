package myAndroid.ij;


import myAndroid.java.awt.image.*;

public class ByteProcessor extends ImageProcessor {

    protected byte[] pixels;


    public ByteProcessor(int width, int height, byte[] pixels, ColorModel cm) {
        if (pixels != null && width * height != pixels.length)
            throw new IllegalArgumentException(WRONG_LENGTH);
        this.width = width;
        this.height = height;
        this.pixels = pixels;
        this.cm = cm;
    }

    public ImageProcessor duplicate() {
        ImageProcessor ip2 = createProcessor(width, height);
        byte[] pixels2 = (byte[])ip2.getPixels();
        System.arraycopy(pixels, 0, pixels2, 0, width * height);
        return ip2;
    }

    public ImageProcessor createProcessor(int width, int height) {
        ImageProcessor ip2;
        ip2 =  new ByteProcessor(width, height, new byte[width * height], getColorModel());
        return ip2;
    }


    public BufferedImage getBufferedImage() {
        return createBufferedImage();
    }


    BufferedImage createBufferedImage() {
        if (raster == null) {
//            SampleModel sm = getIndexSampleModel();
            SampleModel sm = new SampleModel();
            DataBuffer db = new DataBufferByte(pixels, width * height, 0);
            raster = Raster.createWritableRaster(sm, db, null);
        }
        if (image == null) {
            if (cm == null) {
                cm = new ColorModel();
            }
            image = new BufferedImage(cm, raster, false, null);
            cm2 = cm;
        }
        return image;
    }

    BufferedImage createImage() {
        return createBufferedImage();
    }


    public Object getPixels() {
        return (Object)pixels;
    }




}
