package myAndroid.sun.java2d;

public interface StateTrackable {



    public static enum State {

        IMMUTABLE,

        STABLE,

        DYNAMIC,

        UNTRACKABLE,
    };
}
