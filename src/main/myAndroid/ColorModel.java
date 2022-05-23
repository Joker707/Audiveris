package myAndroid;

import android.graphics.Color;

public class ColorModel {


    public boolean supportsAlpha;

    public boolean hasAlpha() {
        return supportsAlpha;
    }

    public int getRGB(int pixel) {
        return (getAlpha(pixel) << 24)
                | (getRed(pixel) << 16)
                | (getGreen(pixel) << 8)
                | (getBlue(pixel) << 0);
    }

    private int getBlue(int pixel) {
        return Color.blue(pixel);
    }

    private int getGreen(int pixel) {
        return Color.green(pixel);
    }

    private int getRed(int pixel) {
        return Color.red(pixel);
    }

    private int getAlpha(int pixel) {
        return Color.alpha(pixel);
    }


}
