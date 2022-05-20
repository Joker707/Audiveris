package myJava.awt.image;

public class WritableRaster {
    private final WritableRaster writableRaster = new WritableRaster();

    public DataBuffer getDataBuffer() {
        return writableRaster.getDataBuffer();
    }

}
