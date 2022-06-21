package myAndroid.java.awt.image;

import android.graphics.Color;

public class WritableRaster extends Raster {



    public void setSample(int x, int y, int b, int s) {
        bitmap.setPixel(x, y, Color.rgb(s,s,s));
    }



    public void setPixel(int x, int y, int[] pixel) {
        bitmap.setPixel(x, y, Color.rgb(pixel[0], pixel[0], pixel[0]));
    }



}
