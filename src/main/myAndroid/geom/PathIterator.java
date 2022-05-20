package myAndroid.geom;

import java.lang.annotation.Native;

public interface PathIterator {

    @Native
    public static final int WIND_EVEN_ODD       = 0;


    @Native public static final int WIND_NON_ZERO       = 1;


    @Native public static final int SEG_MOVETO          = 0;


    @Native public static final int SEG_LINETO          = 1;


    @Native public static final int SEG_QUADTO          = 2;


    @Native public static final int SEG_CUBICTO         = 3;


    @Native public static final int SEG_CLOSE           = 4;


    public int getWindingRule();


    public boolean isDone();


    public void next();


    public int currentSegment(float[] coords);


    public int currentSegment(double[] coords);
}

