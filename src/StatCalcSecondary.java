import components.sequence.Sequence;

/**
 *
 */
public abstract class StatCalcSecondary implements StatCalc {

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        for (int i = 0; i < this.graphSize(); i++) {
            result.append("(");
            for (int j = 0; i < this.coordinateAt(i).length(); j++) {
                result.append(this.coordinateAt(i).entry(j) + ", ");
            }
            result.append("), ");
        }
        result.append(">");

        return result.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = true;

        if (obj == null || !(obj instanceof StatCalc)) {
            isEqual = false;
        }

        if (obj instanceof StatCalc) {
            StatCalc castedObj = (StatCalc) obj;
            for (int i = 0; i < this.graphSize() && isEqual; i++) {
                Sequence<Integer> coordinateSet = castedObj.coordinateAt(i);
                if (!this.coordinateAt(i).equals(coordinateSet)) {
                    isEqual = false;
                }
            }
        }

        return isEqual;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.graphSize(); i++) {
            hash += this.coordinateAt(i).hashCode();
        }

        return hash;
    }

    /**
     * Reports the average of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension which will be averaged
     * @return the average of the specified dimension of each coordinate
     * @ensures mean >= 0 mean = [average of the coordinates of a dimension]
     */
    @Override
    public double mean(int dimensionIndex) {
        int startingSize = this.graphSize();
        int runningSum = 0;

        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> currentCoordinate = this.coordinateAt(i);
            runningSum += currentCoordinate.entry(dimensionIndex);
        }

        return (double) runningSum / startingSize;
    }

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
    @Override
    public double standardDeviation(int dimensionIndex) {
        double mean = this.mean(dimensionIndex);
        double sumOfSquareDistToMean = 0;
        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> coordinateSet = this.coordinateAt(i);
            sumOfSquareDistToMean += Math.pow(
                    Math.abs(coordinateSet.entry(dimensionIndex) - mean), 2.0);
        }
        sumOfSquareDistToMean /= this.graphSize();
        return Math.sqrt(sumOfSquareDistToMean);
    }

    /**
     * Reports the maximum value of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension from which the maximum will be calculated
     * @return the maximum value of all the coordinates for the given dimension
     * @ensures max >= [all other coordinates' dimension value]
     */
    @Override
    public int max(int dimensionIndex) {
        int tempMax = this.coordinateAt(0).entry(dimensionIndex);
        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> coordinateSet = this.coordinateAt(i);
            if (coordinateSet.entry(dimensionIndex) > tempMax) {
                tempMax = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMax;
    }

    /**
     * Reports the minimum value of a given dimension.
     *
     * @param dimensionIndex
     *            the dimension from which the maximum will be calculated
     * @return the minimum value of all the coordinates for the given dimension
     * @ensures min <= [all other coordinates' dimension value]
     */
    @Override
    public int min(int dimensionIndex) {
        int tempMin = this.coordinateAt(0).entry(dimensionIndex);
        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> coordinateSet = this.coordinateAt(i);
            if (coordinateSet.entry(dimensionIndex) < tempMin) {
                tempMin = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMin;
    }

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
    @Override
    public int distance(Sequence<Integer> pointA, Sequence<Integer> pointB) {
        int sumOfSquaredTerms = 0;
        for (int i = 0; i < pointA.length(); i++) {
            sumOfSquaredTerms += Math.pow(pointA.entry(i) - pointB.entry(i), 2);
        }

        return (int) Math.sqrt(sumOfSquaredTerms);
    }

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
    @Override
    public Sequence<Integer> midpoint(Sequence<Integer> pointA,
            Sequence<Integer> pointB) {
        Sequence<Integer> midpoint = pointA.newInstance();

        for (int i = 0; i < pointA.length(); i++) {
            midpoint.add(i, (pointA.entry(i) + pointB.entry(i)) / 2);
        }

        return midpoint;
    }
}
