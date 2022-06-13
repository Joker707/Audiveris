package myAndroid.ij;


import myAndroid.BufferedImage;
import myAndroid.ColorModel;
import myAndroid.TypeConverter;
import myAndroid.WritableRaster;

import java.util.Objects;

public abstract class ImageProcessor {

    protected int width;
    protected int height;

    protected WritableRaster raster;

    protected BufferedImage image;

    protected ColorModel cm;

    protected ColorModel cm2;

    static final String WRONG_LENGTH = "width*height!=pixels.length";


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }



    public ByteProcessor convertToByteProcessor() {
        return convertToByteProcessor(true);
    }





    public ByteProcessor convertToByteProcessor(boolean scale) {
        ByteProcessor bp = null;
        if (this instanceof ByteProcessor) {
            bp = (ByteProcessor) this.duplicate();
        } else {
            bp = (ByteProcessor)this.convertToByte(scale);
        }
        return bp;
    }


    public ImageProcessor convertToByte(boolean doScaling) {
        TypeConverter tc = new TypeConverter(this, doScaling);
        return tc.convertToByte();
    }


    public ColorModel getColorModel() {
        return Objects.requireNonNullElseGet(cm, ColorModel::new);
    }

    public abstract ImageProcessor duplicate();

    public abstract Object getPixels();
}
