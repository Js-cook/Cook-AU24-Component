import components.sequence.Sequence;

/**
 * StatCalc represented as a sequence of integer sequences.
 */
public interface StatCalc extends StatCalcKernel {
    /**
     * Reports the average of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension which will be averaged
     * @return the average of the specified dimension of each coordinate
     * @ensures mean >= 0 mean = [average of the coordinates of a dimension]
     */
    double mean(int dimensionIndex);

    /**
     * Reports the standard deviation of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension from which the standard deviation will be
     *            calculated
     * @return the standard deviation of the specified dimension of each
     *         coordinate
     * @ensures standardDeviation >= 0 standardDeviation = [standard deviation
     *          of the coordinates of a dimension]
     */
    double standardDeviation(int dimensionIndex);

    /**
     * Reports the maximum value of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension from which the maximum will be calculated
     * @return the maximum value of all the coordinates for the given dimension
     * @ensures max >= [all other coordinates' dimension value]
     */
    int max(int dimensionIndex);

    /**
     * Reports the minimum value of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension from which the maximum will be calculated
     * @return the minimum value of all the coordinates for the given dimension
     * @ensures min <= [all other coordinates' dimension value]
     */
    int min(int dimensionIndex);

    /**
     * Reports the euclidean distance between two given coordinates.
     *
     * @param pointA
     *            first point
     * @param pointB
     *            second point
     * @return the euclidean distance between the two points
     * @ensures distance = [the sum of (p - q)^2 where p and q represent the
     *          values of the nth dimension of the coordinates]
     */
    int distance(Sequence<Integer> pointA, Sequence<Integer> pointB);

    /**
     * Reports the coordinate coinciding with the midpoint between two given
     * coordinates.
     *
     * @param pointA
     *            first point
     * @param pointB
     *            second point
     * @return a coordinate representing the midpoint between pointA and pointB
     * @ensures coordinate = [the square root of the sum of (p - q)^2 where p
     *          and q represent the values of the nth dimension of the
     *          coordinates]
     */
    Sequence<Integer> midpoint(Sequence<Integer> pointA,
            Sequence<Integer> pointB);

}
