package myAndroid.ij;


public class TypeConverter {

    private static final int BYTE=0, RGB=3;
    private ImageProcessor ip;
    private int type;
    boolean doScaling = true;
    int width, height;


    public TypeConverter(ImageProcessor ip, boolean doScaling) {
        this.ip = ip;
        this.doScaling = doScaling;
        if (ip instanceof ByteProcessor)
            type = BYTE;
        else
            type = RGB;
        width = ip.getWidth();
        height = ip.getHeight();
    }



    public ImageProcessor convertToByte() {
        switch (type) {
            case BYTE:
                return ip;
            case RGB:
                return convertRGBToByte();
            default:
                return null;
        }
    }


    ByteProcessor convertRGBToByte() {
        int[] pixels32 = (int[])ip.getPixels();
        double[] w = ColorProcessor.getWeightingFactors();
        if (((ColorProcessor)ip).getRGBWeights()!=null)
            w = ((ColorProcessor)ip).getRGBWeights();
        double rw=w[0], gw=w[1], bw=w[2];
        byte[] pixels8 = new byte[width*height];
        int c, r, g, b;
        for (int i=0; i < width*height; i++) {
            c = pixels32[i];
            r = (c&0xff0000)>>16;
            g = (c&0xff00)>>8;
            b = c&0xff;
            pixels8[i] = (byte)(r*rw + g*gw + b*bw + 0.5);
        }
        return new ByteProcessor(width, height, pixels8, null);
    }
}
