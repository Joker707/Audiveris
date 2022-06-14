package myAndroid.awt;



public class Edge {

    static final int INIT_PARTS = 4;
    static final int GROW_PARTS = 10;

    Curve curve;
    int ctag;
    int etag;
    double activey;
    int equivalence;

    public int getCurveTag() {
        return ctag;
    }

    public Curve getCurve() {
        return curve;
    }

    public int getEquivalence() {
        return equivalence;
    }

    public void setEquivalence(int eq) {
        equivalence = eq;
    }

    private Edge lastEdge;
    private int lastResult;
    private double lastLimit;

    public int compareTo(Edge other, double yrange[]) {
        if (other == lastEdge && yrange[0] < lastLimit) {
            if (yrange[1] > lastLimit) {
                yrange[1] = lastLimit;
            }
            return lastResult;
        }
        if (this == other.lastEdge && yrange[0] < other.lastLimit) {
            if (yrange[1] > other.lastLimit) {
                yrange[1] = other.lastLimit;
            }
            return 0-other.lastResult;
        }
        //long start = System.currentTimeMillis();
        int ret = curve.compareTo(other.curve, yrange);
        //long end = System.currentTimeMillis();
        /*
        System.out.println("compare: "+
                           ((System.identityHashCode(this) <
                             System.identityHashCode(other))
                            ? this+" to "+other
                            : other+" to "+this)+
                           " == "+ret+" at "+yrange[1]+
                           " in "+(end-start)+"ms");
         */
        lastEdge = other;
        lastLimit = yrange[1];
        lastResult = ret;
        return ret;
    }

    public boolean isActiveFor(double y, int etag) {
        return (this.etag == etag && this.activey >= y);
    }

    public void record(double yend, int etag) {
        this.activey = yend;
        this.etag = etag;
    }
}
