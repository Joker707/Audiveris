package myAndroid.ij;


import myAndroid.java.awt.image.*;

public class ByteProcessor extends ImageProcessor {

    protected byte[] pixels;


    public ByteProcessor(int width, int height) {
        this(width, height, new byte[width*height], null);
    }


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




    public final int get(int x, int y) {return pixels[y*width+x]&0xff;}
    public final void set(int x, int y, int value) {pixels[y*width+x] = (byte)value;}
    public final int get(int index) {return pixels[index]&0xff;}
    public final void set(int index, int value) {pixels[index] = (byte)value;}
    public final float getf(int x, int y) {return pixels[y*width+x]&0xff;}
    public final void setf(int x, int y, float value) {pixels[y*width+x] = (byte)(value+0.5f);}
    public final float getf(int index) {return pixels[index]&0xff;}
    public final void setf(int index, float value) {pixels[index] = (byte)value;}


    public void applyTable(int[] lut) {
        int lineStart, lineEnd;
        for (int y=roiY; y<(roiY+roiHeight); y++) {
            lineStart = y * width + roiX;
            lineEnd = lineStart + roiWidth;
            for (int i=lineEnd; --i>=lineStart;)
                pixels[i] = (byte)lut[pixels[i]&0xff];
        }
    }



}
