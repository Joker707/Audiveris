package myAndroid;

public class ColorProcessor extends ImageProcessor {



    protected int[] pixels;

    public ColorProcessor(BufferedImage bufferedImage) {
        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();
        pixels = new int[width * height];

    }


    public ColorProcessor(int width, int height, int[] pixels) {
        if (pixels!=null && width*height!=pixels.length)
            throw new IllegalArgumentException(WRONG_LENGTH);
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }


    public ImageProcessor duplicate() {
        int[] pixels2 = new int[width*height];
        System.arraycopy(pixels, 0, pixels2, 0, width*height);
        return new ColorProcessor(width, height, pixels2);
    }

    public Object getPixels() {
        return (Object)pixels;
    }
}
