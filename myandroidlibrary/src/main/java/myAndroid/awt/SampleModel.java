package myAndroid.awt;


public class SampleModel {


    //sRGB in Android Bitmap
    public int numBands = 3;


    public int getNumBands() {
        return numBands;
    }



    public int[] getPixel(int x, int y, int[] iArray, DataBuffer data) {

        int[] pixels;

        if (iArray != null)
            pixels = iArray;
        else
            pixels = new int[numBands];

        for (int i = 0; i < numBands; i++) {
            pixels[i] = getSample(x, y, i, data);
        }

        return pixels;
    }
}
