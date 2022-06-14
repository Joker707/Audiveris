package myAndroid.ij;

import myAndroid.awt.BufferedImage;

public class ColorProcessor extends ImageProcessor {

    private static double rWeight=1d/3d, gWeight=1d/3d,	bWeight=1d/3d;

    private double[] weights;



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


    public static double[] getWeightingFactors() {
        double[] weights = new double[3];
        weights[0] = rWeight;
        weights[1] = gWeight;
        weights[2] = bWeight;
        return weights;
    }

    public double[] getRGBWeights() {
        return weights;
    }
}
