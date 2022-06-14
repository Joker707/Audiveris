package myAndroid.awt;



public final class GeneralPath extends Path2D.Float {
    /**
     * Constructs a new empty single precision {@code GeneralPath} object
     * with a default winding rule of {@link #WIND_NON_ZERO}.
     *
     * @since 1.2
     */
    public GeneralPath() {
        super(WIND_NON_ZERO, INIT_SIZE);
    }

    /**
     * Constructs a new {@code GeneralPath} object with the specified
     * winding rule to control operations that require the interior of the
     * path to be defined.
     *
     * @param rule the winding rule
     * @see #WIND_EVEN_ODD
     * @see #WIND_NON_ZERO
     * @since 1.2
     */
    public GeneralPath(int rule) {
        super(rule, INIT_SIZE);
    }

    /**
     * Constructs a new {@code GeneralPath} object with the specified
     * winding rule and the specified initial capacity to store path
     * coordinates.
     * This number is an initial guess as to how many path segments
     * will be added to the path, but the storage is expanded as
     * needed to store whatever path segments are added.
     *
     * @param rule the winding rule
     * @param initialCapacity the estimate for the number of path segments
     *                        in the path
     * @see #WIND_EVEN_ODD
     * @see #WIND_NON_ZERO
     * @since 1.2
     */
    public GeneralPath(int rule, int initialCapacity) {
        super(rule, initialCapacity);
    }

    /**
     * Constructs a new {@code GeneralPath} object from an arbitrary
     * {@link Shape} object.
     * All of the initial geometry and the winding rule for this path are
     * taken from the specified {@code Shape} object.
     *
     * @param s the specified {@code Shape} object
     * @since 1.2
     */
    public GeneralPath(Shape s) {
        super(s, null);
    }

    GeneralPath(int windingRule,
                byte[] pointTypes,
                int numTypes,
                float[] pointCoords,
                int numCoords)
    {
        // used to construct from native

        this.windingRule = windingRule;
        this.pointTypes = pointTypes;
        this.numTypes = numTypes;
        this.floatCoords = pointCoords;
        this.numCoords = numCoords;
    }

    /*
     * JDK 1.6 serialVersionUID
     */
    private static final long serialVersionUID = -8327096662768731142L;
}
