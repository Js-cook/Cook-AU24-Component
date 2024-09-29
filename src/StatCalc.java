import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class StatCalc {

    private Sequence<Sequence<Integer>> rep;
    private int coordinateDimensions;

    private void createRep(int dimensions) {
        this.rep = new Sequence1L<>();
        this.coordinateDimensions = dimensions;
    }

    public StatCalc(int dimensions) {
        this.createRep(dimensions);
    }

    public void addCoordinatePair(int... coordinates) {
        assert coordinates.length == this.coordinateDimensions : "Given coordinates do not match set dimensions";

        Sequence<Integer> tempSequence = new Sequence1L<>();
        for (int coordinate : coordinates) {
            tempSequence.add(tempSequence.length(), coordinate);
        }

        this.rep.add(this.rep.length(), tempSequence);
    }

    public Sequence<Integer> removeAnyCoordinate() {
        Sequence<Integer> removedCoordinate = this.rep.remove(0);

        return removedCoordinate;
    }

    public int graphSize() {
        return this.rep.length();
    }

    public double mean(int dimensionIndex) {
        double runningSum = 0;
        for (Sequence<Integer> coordinateSet : this.rep) {
            runningSum += coordinateSet.entry(dimensionIndex);
        }

        return runningSum / this.graphSize();
    }

    public double standardDeviation(int dimensionIndex) {
        double mean = this.mean(dimensionIndex);
        double sumOfSquareDistToMean = 0;
        for (Sequence<Integer> coordinateSet : this.rep) {
            sumOfSquareDistToMean += Math.pow(
                    Math.abs(coordinateSet.entry(dimensionIndex) - mean), 2.0);
        }
        sumOfSquareDistToMean /= this.graphSize();
        return Math.sqrt(sumOfSquareDistToMean);
    }

    public int max(int dimensionIndex) {
        int tempMax = this.rep.entry(0).entry(dimensionIndex);
        for (Sequence<Integer> coordinateSet : this.rep) {
            if (coordinateSet.entry(dimensionIndex) > tempMax) {
                tempMax = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMax;
    }

    public int min(int dimensionIndex) {
        int tempMin = this.rep.entry(0).entry(dimensionIndex);
        for (Sequence<Integer> coordinateSet : this.rep) {
            if (coordinateSet.entry(dimensionIndex) < tempMin) {
                tempMin = coordinateSet.entry(dimensionIndex);
            }
        }

        return tempMin;
    }

    public int distance(Sequence<Integer> pointA, Sequence<Integer> pointB) {
        int sumOfSquaredTerms = 0;
        for (int i = 0; i < pointA.length(); i++) {
            sumOfSquaredTerms += Math.pow(pointA.entry(i) - pointB.entry(i), 2);
        }

        return (int) Math.sqrt(sumOfSquaredTerms);
    }
}
