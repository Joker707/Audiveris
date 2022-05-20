package myJava.awt.image;


import java.awt.*;
import java.awt.image.*;
import java.awt.image.ColorModel;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.awt.image.WritableRenderedImage;
import java.util.Vector;

public class BufferedImage implements WritableRenderedImage, Transparency {


    private final java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage();

    public ColorModel getColorModel() {
        return bufferedImage.getColorModel();
    }

    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }

    public Object getProperty(String name) {
        return bufferedImage.getProperty(name);
    }

    public String toString() {
        return bufferedImage.toString();
    }

    public Vector<RenderedImage> getSources() {
        return bufferedImage.getSources();
    }

    public String[] getPropertyNames() {
        return bufferedImage.getPropertyNames();
    }

    public int getMinX() {
        return bufferedImage.getMinX();
    }

    public int getMinY() {
        return bufferedImage.getMinY();
    }

    public SampleModel getSampleModel() {
        return bufferedImage.getSampleModel();
    }

    public int getNumXTiles() {
        return bufferedImage.getNumXTiles();
    }

    public int getNumYTiles() {
        return bufferedImage.getNumYTiles();
    }

    public int getMinTileX() {
        return bufferedImage.getMinTileX();
    }

    public int getMinTileY() {
        return bufferedImage.getMinTileY();
    }

    public int getTileWidth() {
        return bufferedImage.getTileWidth();
    }

    public int getTileHeight() {
        return bufferedImage.getTileHeight();
    }

    public int getTileGridXOffset() {
        return bufferedImage.getTileGridXOffset();
    }

    public int getTileGridYOffset() {
        return bufferedImage.getTileGridYOffset();
    }

    public Raster getTile(int tileX, int tileY) {
        return bufferedImage.getTile(tileX, tileY);
    }

    public Raster getData() {
        return bufferedImage.getData();
    }

    public Raster getData(Rectangle rect) {
        return bufferedImage.getData(rect);
    }

    public WritableRaster copyData(WritableRaster outRaster) {
        return bufferedImage.copyData(outRaster);
    }

    public void setData(Raster r) {
        bufferedImage.setData(r);
    }

    public void addTileObserver(TileObserver to) {
        bufferedImage.addTileObserver(to);
    }

    public void removeTileObserver(TileObserver to) {
        bufferedImage.removeTileObserver(to);
    }

    public boolean isTileWritable(int tileX, int tileY) {
        return bufferedImage.isTileWritable(tileX, tileY);
    }

    public Point[] getWritableTileIndices() {
        return bufferedImage.getWritableTileIndices();
    }

    public boolean hasTileWriters() {
        return bufferedImage.hasTileWriters();
    }

    public WritableRaster getWritableTile(int tileX, int tileY) {
        return bufferedImage.getWritableTile(tileX, tileY);
    }

    public void releaseWritableTile(int tileX, int tileY) {
        bufferedImage.releaseWritableTile(tileX, tileY);
    }

    public int getTransparency() {
        return bufferedImage.getTransparency();
    }
}
