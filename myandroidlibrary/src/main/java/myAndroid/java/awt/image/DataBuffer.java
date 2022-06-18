package myAndroid.java.awt.image;


import myAndroid.sun.java2d.StateTrackable;
import myAndroid.sun.java2d.StateTrackableDelegate;

public class DataBuffer {


    public static final int TYPE_BYTE  = 0;

    protected int dataType;

    protected int banks;

    protected int offset;

    protected int size;

    protected int offsets[];

    /* The current StateTrackable state. */
    StateTrackableDelegate theTrackable;


    DataBuffer(StateTrackable.State initialState,
               int dataType, int size, int numBanks, int offset)
    {
        this.theTrackable = StateTrackableDelegate.createInstance(initialState);
        this.dataType = dataType;
        this.banks = numBanks;
        this.size = size;
        this.offset = offset;
        this.offsets = new int[numBanks];
        for (int i = 0; i < numBanks; i++) {
            this.offsets[i] = offset;
        }
    }
}
