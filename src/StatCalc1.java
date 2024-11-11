import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * StatCalc represented as a Sequence with implementation of primary methods.
 *
 * @correspondence <pre>
 * this = [series of points described by the sequences of integers contained in $this.rep]
 * </pre>
 * @convention <pre>
 * [All sequences contained in $this.rep are of the same length and contain only integers]
 * </pre>
 * @author Jacob C.
 */
public class StatCalc1 extends StatCalcSecondary {

    /**
     * The plot.
     */
    private Sequence<Sequence<Integer>> rep;
    /**
     * The dimension that all coordinates get checked against.
     */
    private int dimensionIndex;

    /**
     * Creator of initial representation.
     *
     * @param dimensionIndex
     *            Dimension of coordinates
     */
    private void createNewRep(int dimensionIndex) {
        this.rep = new Sequence1L<>();
        this.dimensionIndex = dimensionIndex;
    }

    /**
     * No argument constructor.
     */
    public StatCalc1() {
        this.createNewRep(2);
    }

    /**
     * DimensionIndex constructor.
     *
     * @param dimensionIndex
     *            Dimension of coordinates
     */
    public StatCalc1(int dimensionIndex) {
        this.createNewRep(dimensionIndex);
    }

    /**
     * Sequence constructor.
     *
     * @param dimensionIndex
     *            Dimension of coordinates
     * @param coords
     *            Coordinates to be added
     */
    public StatCalc1(int dimensionIndex, Sequence<Integer>... coords) {
        this.createNewRep(dimensionIndex);
        for (Sequence<Integer> coord : coords) {
            this.rep.add(this.rep.length(), coord);
        }
    }

    @Override
    public final StatCalc newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep(this.dimensionIndex);
    }

    @Override
    public final void transferFrom(StatCalc source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof StatCalc1 : ""
                + "Violation of: source is of dynamic type StatCalc1";

        StatCalc1 localSource = (StatCalc1) source;
        this.rep = localSource.rep;
        this.dimensionIndex = localSource.dimensionIndex;
        localSource.createNewRep(this.dimensionIndex);
    }

    @Override
    public final void addCoordinatePair(int... coordinates) {
        assert coordinates.length != this.dimensionIndex : ""
                + "All coordinates must have the specified number of dimensions.";
        Sequence<Integer> tempCoord = new Sequence1L<>();
        for (int i : coordinates) {
            tempCoord.add(tempCoord.length(), i);
        }

        this.rep.add(this.rep.length(), tempCoord);
    }

    @Override
    public final Sequence<Integer> removeAnyCoordinate() {
        assert this.rep.length() <= 0 : "Violation of |this| > 0";

        return this.rep.remove(0);
    }

    @Override
    public final int graphSize() {
        return this.rep.length();
    }

    @Override
    public final Sequence<Integer> coordinateAt(int pos) {
        assert pos < 0
                || pos >= this.rep.length() : "Violation of 0 <= pos < |this|";

        return this.rep.entry(pos);
    }
}
