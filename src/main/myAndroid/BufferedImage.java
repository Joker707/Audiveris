package myAndroid;

public class BufferedImage {

    public int width;
    public int height;

    public SampleModel sampleModel;

    public ColorModel colorModel;


    // add methods with Bitmap instead of BufferedImage
    // (and Sample/Color models with number of bands == 3)


    public SampleModel getSampleModel() {
        return sampleModel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ColorModel getColorModel() {
        return colorModel;
    }

}
