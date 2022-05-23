package myAndroid;

import android.graphics.*;


import java.util.Hashtable;

public class BufferedImage {

    public int width;
    public int height;

    public Bitmap bitmap;

    public WritableRaster raster;

    public WritableRaster writableRaster;

    private int imageType = TYPE_CUSTOM;

    public SampleModel sampleModel;

    public ColorModel colorModel;

    public static final int TYPE_CUSTOM = 0;

    public static final int TYPE_INT_RGB = 1;

    public static final int TYPE_INT_ARGB = 2;

    public static final int TYPE_INT_ARGB_PRE = 3;

    public static final int TYPE_INT_BGR = 4;

    public static final int TYPE_3BYTE_BGR = 5;

    public static final int TYPE_4BYTE_ABGR = 6;

    public static final int TYPE_4BYTE_ABGR_PRE = 7;

    public static final int TYPE_USHORT_565_RGB = 8;

    public static final int TYPE_USHORT_555_RGB = 9;

    public static final int TYPE_BYTE_GRAY = 10;

    public static final int TYPE_USHORT_GRAY = 11;

    public static final int TYPE_BYTE_BINARY = 12;

    public static final int TYPE_BYTE_INDEXED = 13;

    // add methods with Bitmap instead of BufferedImage
    // (and Sample/Color models with number of bands == 3)


    public BufferedImage(int width, int height, int imageType) {
        this.width = width;
        this.height = height;
        this.imageType = imageType;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    }

    public BufferedImage (ColorModel cm,
                          WritableRaster raster,
                          boolean isRasterPremultiplied,
                          Hashtable<?,?> properties) {



        // get data from raster(?)

        bitmap = Bitmap.createBitmap();

        // we gonna do something here

    }

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


    public int getType() {
        return imageType;
    }



    public WritableRaster getRaster() {
        return writableRaster;
    }


    public Bitmap getBitmap() {
        return bitmap;
    }


    public Raster getData() {

        // REMIND : this allocates a whole new tile if raster is a
        // subtile.  (It only copies in the requested area)
        // We should do something smarter.
        int width = raster.getWidth();
        int height = raster.getHeight();
        int startX = raster.getMinX();
        int startY = raster.getMinY();
        WritableRaster wr =
                Raster.createWritableRaster(raster.getSampleModel(),
                        new Point(raster.getSampleModelTranslateX(),
                                raster.getSampleModelTranslateY()));

        Object tdata = null;

        for (int i = startY; i < startY+height; i++)  {
            tdata = raster.getDataElements(startX,i,width,1,tdata);
            wr.setDataElements(startX,i,width,1, tdata);
        }
        return wr;
    }








    public int getRGB(int x, int y) {
        return colorModel.getRGB(bitmap.getPixel(x,y));
    }


    public void setRGB(int x, int y, int rgb) {
        bitmap.setPixel(x, y, rgb);
    }



    public Bitmap invert(Bitmap src) {
        int height = src.getHeight();
        int width = src.getWidth();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        ColorMatrix matrixGrayscale = new ColorMatrix();
        ColorMatrix matrixInvert = new ColorMatrix();

        matrixGrayscale.setSaturation(0);
        matrixInvert.set(new float[]
                {
                        -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
                        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
                });
        matrixInvert.preConcat(matrixGrayscale);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixInvert);
        paint.setColorFilter(filter);

        canvas.drawBitmap(src, 0, 0, paint);
        return bitmap;
    }

}
