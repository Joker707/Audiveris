package myAndroid.sun.java2d;


import static myAndroid.sun.java2d.StateTrackable.State.*;

public final class StateTrackableDelegate implements StateTrackable {

    public static final StateTrackableDelegate UNTRACKABLE_DELEGATE =
            new StateTrackableDelegate(UNTRACKABLE);


    public static final StateTrackableDelegate IMMUTABLE_DELEGATE =
            new StateTrackableDelegate(IMMUTABLE);

    private State theState;

    private StateTrackableDelegate(State state) {
        this.theState = state;
    }


    public static StateTrackableDelegate createInstance(State state) {
        switch (state) {
            case UNTRACKABLE:
                return UNTRACKABLE_DELEGATE;
            case STABLE:
                return new StateTrackableDelegate(STABLE);
            case DYNAMIC:
                return new StateTrackableDelegate(DYNAMIC);
            case IMMUTABLE:
                return IMMUTABLE_DELEGATE;
            default:
                throw new InternalError("unknown state");
        }
    }
}
