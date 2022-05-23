package myAndroid;



public abstract class ImageProcessor {

    protected int width;
    protected int height;

    protected BufferedImage image;

    static final String WRONG_LENGTH = "width*height!=pixels.length";


    public ByteProcessor convertToByteProcessor() {
        return convertToByteProcessor(true);
    }


    public ByteProcessor convertToByteProcessor(boolean scale) {
        ByteProcessor bp = null;
        if (this instanceof ByteProcessor) {
            bp = (ByteProcessor) this.duplicate();
        }
        return bp;
    }

    public abstract ImageProcessor duplicate();

    public abstract Object getPixels();
}
