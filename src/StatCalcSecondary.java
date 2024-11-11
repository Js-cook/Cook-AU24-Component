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

    @Override
    public final double mean(int dimensionIndex) {
        int startingSize = this.graphSize();
        int runningSum = 0;

        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> currentCoordinate = this.coordinateAt(i);
            runningSum += currentCoordinate.entry(dimensionIndex);
        }

        return (double) runningSum / startingSize;
    }

    @Override
    public final double standardDeviation(int dimensionIndex) {
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

    @Override
    public final int max(int dimensionIndex) {
        int tempMax = this.coordinateAt(0).entry(dimensionIndex);
        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> coordinateSet = this.coordinateAt(i);
            if (coordinateSet.entry(dimensionIndex) > tempMax) {
                tempMax = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMax;
    }

    @Override
    public final int min(int dimensionIndex) {
        int tempMin = this.coordinateAt(0).entry(dimensionIndex);
        for (int i = 0; i < this.graphSize(); i++) {
            Sequence<Integer> coordinateSet = this.coordinateAt(i);
            if (coordinateSet.entry(dimensionIndex) < tempMin) {
                tempMin = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMin;
    }

    @Override
    public final int distance(Sequence<Integer> pointA, Sequence<Integer> pointB) {
        int sumOfSquaredTerms = 0;
        for (int i = 0; i < pointA.length(); i++) {
            sumOfSquaredTerms += Math.pow(pointA.entry(i) - pointB.entry(i), 2);
        }

        return (int) Math.sqrt(sumOfSquaredTerms);
    }

    @Override
    public final Sequence<Integer> midpoint(Sequence<Integer> pointA,
            Sequence<Integer> pointB) {
        Sequence<Integer> midpoint = pointA.newInstance();

        for (int i = 0; i < pointA.length(); i++) {
            midpoint.add(i, (pointA.entry(i) + pointB.entry(i)) / 2);
        }

        return midpoint;
    }
}
