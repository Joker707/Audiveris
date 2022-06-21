package myAndroid.ij;


import myAndroid.java.awt.image.BufferedImage;
import myAndroid.java.awt.image.ColorModel;
import myAndroid.java.awt.image.WritableRaster;

import java.util.Objects;

public abstract class ImageProcessor {


    protected int roiX, roiY, roiWidth, roiHeight;
    protected int xMin, xMax, yMin, yMax;
    protected int width;
    protected int height;

    protected WritableRaster raster;

    protected BufferedImage image;

    protected ColorModel cm;

    protected ColorModel cm2;

    static final String WRONG_LENGTH = "width*height!=pixels.length";

    static final int INVERT=0, FILL=1, ADD=2, MULT=3, AND=4, OR=5,
            XOR=6, GAMMA=7, LOG=8, MINIMUM=9, MAXIMUM=10, SQR=11, SQRT=12, EXP=13, ABS=14, SET=15;

    int fgColor = 0;


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }



    public ByteProcessor convertToByteProcessor() {
        return convertToByteProcessor(true);
    }


    public void invert() {process(INVERT, 0.0);}


    private void process(int op, double value) {
        double SCALE = 255.0/Math.log(255.0);
        int v;

        int[] lut = new int[256];
        for (int i=0; i<256; i++) {
            switch(op) {
                case INVERT:
                    v = 255 - i;
                    break;
                case FILL:
                    v = fgColor;
                    break;
                case SET:
                    v = (int)value;
                    break;
                case ADD:
                    v = i + (int)value;
                    break;
                case MULT:
                    v = (int)Math.round(i * value);
                    break;
                case AND:
                    v = i & (int)value;
                    break;
                case OR:
                    v = i | (int)value;
                    break;
                case XOR:
                    v = i ^ (int)value;
                    break;
                case GAMMA:
                    v = (int)(Math.exp(Math.log(i/255.0)*value)*255.0);
                    break;
                case LOG:
                    if (i==0)
                        v = 0;
                    else
                        v = (int)(Math.log(i) * SCALE);
                    break;
                case EXP:
                    v = (int)(Math.exp(i/SCALE));
                    break;
                case SQR:
                    v = i*i;
                    break;
                case SQRT:
                    v = (int)Math.sqrt(i);
                    break;
                case MINIMUM:
                    if (i<value)
                        v = (int)value;
                    else
                        v = i;
                    break;
                case MAXIMUM:
                    if (i>value)
                        v = (int)value;
                    else
                        v = i;
                    break;
                default:
                    v = i;
            }
            if (v < 0)
                v = 0;
            if (v > 255)
                v = 255;
            lut[i] = v;
        }
        applyTable(lut);
    }


    public abstract void applyTable(int[] lut);





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
        if (cm == null) {
            return new ColorModel();
        } else {
            return cm;
        }
    }

    public abstract ImageProcessor duplicate();

    public abstract Object getPixels();
}
