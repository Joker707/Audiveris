package myAndroid.java.awt.image;


import static myAndroid.sun.java2d.StateTrackable.State.UNTRACKABLE;

public class DataBufferByte extends DataBuffer {

    byte[] data;

    byte[][] bankdata;

    public DataBufferByte(byte[] dataArray, int size, int offset) {
        super(UNTRACKABLE, TYPE_BYTE, size, 1, offset);
        data = dataArray;
        bankdata = new byte[1][];
        bankdata[0] = data;
    }



}
