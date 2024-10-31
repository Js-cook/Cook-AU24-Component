import components.sequence.Sequence;
import components.standard.Standard;

/***
 * StatCalc kernel with primary methods.
 */
public interface StatCalcKernel extends Standard<Sequence> {

    /**
     * Adds a set of coordinates to {@code this}.
     *
     * @param coordinates
     *            array of integers representing the set of coordinates
     * @updates this
     * @requires |coordinates| = the dimension size specified in constructor
     *           call
     * @ensures this = #this * coordinates
     */
    void addCoordinatePair(int... coordinates);

    /**
     * Removes an arbitrary coordinate from {@code this}.
     *
     * @requires |this| > 0
     * @updates this
     * @return the coordinate
     * @ensures removeAnyCoordinate is in this #this = this *
     *          removeAnyCoordinate
     */
    Sequence<Integer> removeAnyCoordinate();

    /**
     * Reports the total number of coordinates stored in the graph.
     *
     * @return the total coordinates
     * @ensures graphSize = |this|
     */
    int graphSize();

    /**
     * Reports the coordinate at a given position in the graph.
     *
     * @param pos
     *            the position of the desired coordinate
     * @requires 0 <= pos < |this|
     * @return the coordinate
     * @ensures coordinateAt = [coordinate at the given position]
     */
    Sequence<Integer> coordinateAt(int pos);
}
