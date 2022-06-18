package myAndroid.java.awt.image;


import android.graphics.Bitmap;
import android.graphics.Color;
import myAndroid.java.awt.Point;

public class Raster {



    public Bitmap bitmap;

    protected SampleModel sampleModel;

    protected DataBuffer dataBuffer;

    public DataBuffer getDataBuffer() {
        return dataBuffer;
    }



    public int[] getPixel(int x, int y, int[] iArray) {
        int pixel = bitmap.getPixel(x,y);
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);
        return new int[] {red, green, blue};
    }



    public static WritableRaster createWritableRaster(SampleModel sm,
                                                      DataBuffer db,
                                                      Point location)
    {
        return null;
    }





}

