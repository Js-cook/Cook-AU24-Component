import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import srcComponent.StatCalc;
import srcComponent.StatCalc1;

/**
 * Kernel implementation test cases.
 */
public class StatCalcKernelTest {

    /**
     * Helper function for generating semi-random coordinates.
     *
     * @param dimensions
     *            The desired number of dimensions
     * @return A semi-random coordinate of the given dimensions
     */
    public static Sequence<Integer> generateCoordinate(int dimensions) {
        Sequence<Integer> input = new Sequence1L<>();
        Random rand = new Random();

        for (int i = 0; i < dimensions; i++) {
            input.add(i, rand.nextInt(Integer.MAX_VALUE));
        }

        return input;
    }

    /**
     * no arg constructor test.
     */
    @Test
    public void noArgConstructorTest1() {
        StatCalc newGraph = new StatCalc1();
        StatCalc testGraph = new StatCalc1();

        assertEquals(0, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * dimensionindex constructor test.
     */
    @Test
    public void dimensionIndexConstructorTest1() {
        StatCalc newGraph = new StatCalc1(3);
        StatCalc testGraph = new StatCalc1(3);

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * dimensionindex constructor test.
     */
    @Test
    public void dimensionIndexConstructorTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        assertEquals(0, newGraph.graphSize());
        assertEquals(1, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * dimensionindex constructor test.
     */
    @Test
    public void dimensionIndexConstructorTest3() {
        StatCalc newGraph = new StatCalc1(Integer.MAX_VALUE);
        StatCalc testGraph = new StatCalc1(Integer.MAX_VALUE);

        assertEquals(0, newGraph.graphSize());
        assertEquals(Integer.MAX_VALUE, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * sequence constructor test.
     */
    @Test
    public void sequenceConstructorTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);
        Sequence<Integer> seq2 = generateCoordinate(3);
        Sequence<Integer> seq3 = generateCoordinate(3);
        Sequence<Integer> seq4 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1, seq2, seq3, seq4);
        StatCalc testGraph = new StatCalc1(3, seq1, seq2, seq3, seq4);

        assertEquals(seq1, newGraph.coordinateAt(0));
        assertEquals(seq2, newGraph.coordinateAt(1));
        assertEquals(seq3, newGraph.coordinateAt(2));
        assertEquals(seq4, newGraph.coordinateAt(3));

        assertEquals(4, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * sequence constructor test.
     */
    @Test
    public void sequenceConstructorTest2() {
        Sequence<Integer> seq1 = generateCoordinate(2);

        StatCalc newGraph = new StatCalc1(2, seq1);
        StatCalc testGraph = new StatCalc1(2, seq1);

        assertEquals(seq1, newGraph.coordinateAt(0));

        assertEquals(1, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * newInstance test.
     */
    @Test
    public void newInstanceTest1() {
        StatCalc newGraph = new StatCalc1();
        StatCalc testGraph = new StatCalc1();

        StatCalc newInstGraph = newGraph.newInstance();

        assertEquals(newGraph, newInstGraph);
        assertEquals(0, newInstGraph.graphSize());
        assertEquals(2, newInstGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * newInstance test.
     */
    @Test
    public void newInstanceTest2() {
        Sequence<Integer> seq1 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1);
        StatCalc testGraph = new StatCalc1(3, seq1);

        StatCalc newInstGraph = newGraph.newInstance();

        assertEquals(0, newInstGraph.graphSize());
        assertEquals(2, newInstGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * clear test.
     */
    @Test
    public void clearTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1);
        StatCalc testGraph = new StatCalc1(3);

        newGraph.clear();

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * clear test.
     */
    @Test
    public void clearTest2() {

        StatCalc newGraph = new StatCalc1();
        StatCalc testGraph = new StatCalc1();

        newGraph.clear();

        assertEquals(0, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());
        assertEquals(testGraph, newGraph);
    }

    /**
     * transferFrom test.
     */
    @Test
    public void transferFromTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);
        Sequence<Integer> seq2 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1, seq2);
        StatCalc testGraph = new StatCalc1(3);

        Sequence<Integer> coord1 = newGraph.coordinateAt(0);
        Sequence<Integer> coord2 = newGraph.coordinateAt(1);

        StatCalc receiver = new StatCalc1(3);
        receiver.transferFrom(newGraph);

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(2, receiver.graphSize());
        assertEquals(3, receiver.dimensions());
        assertEquals(coord1, receiver.coordinateAt(0));
        assertEquals(coord2, receiver.coordinateAt(1));

        assertEquals(testGraph, newGraph);
    }

    /**
     * transferFrom test.
     */
    @Test
    public void transferFromTest2() {
        Sequence<Integer> seq1 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1);
        StatCalc testGraph = new StatCalc1(3);

        Sequence<Integer> coord = newGraph.coordinateAt(0);

        StatCalc receiver = new StatCalc1(3);
        receiver.transferFrom(newGraph);

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(1, receiver.graphSize());
        assertEquals(3, receiver.dimensions());
        assertEquals(coord, receiver.coordinateAt(0));

        assertEquals(testGraph, newGraph);
    }

    /**
     * addCoordinatePair test.
     */
    @Test
    public void addCoordinatePairTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);
        Sequence<Integer> seq2 = new Sequence1L<>();
        for (int i = 0; i < 3; i++) {
            seq2.add(i, i + 1);
        }

        StatCalc newGraph = new StatCalc1(3, seq1);
        StatCalc testGraph = new StatCalc1(3, seq1, seq2);

        newGraph.addCoordinatePair(1, 2, 3);

        assertEquals(2, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(seq1, newGraph.coordinateAt(0));
        assertEquals(seq2, newGraph.coordinateAt(1));

        assertEquals(testGraph, newGraph);
    }

    /**
     * addCoordinatePair test.
     */
    @Test
    public void addCoordinatePairTest2() {
        Sequence<Integer> seq2 = new Sequence1L<>();
        for (int i = 0; i < 3; i++) {
            seq2.add(i, i + 1);
        }

        StatCalc newGraph = new StatCalc1(3);
        StatCalc testGraph = new StatCalc1(3, seq2);

        newGraph.addCoordinatePair(1, 2, 3);

        assertEquals(1, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(seq2, newGraph.coordinateAt(0));

        assertEquals(testGraph, newGraph);
    }

    /**
     * removeAnyCoordinate test.
     */
    @Test
    public void removeAnyCoordinateTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);
        Sequence<Integer> seq2 = generateCoordinate(3);
        Sequence<Integer> seq3 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1, seq2, seq3);

        Sequence<Integer> coord = newGraph.removeAnyCoordinate();

        StatCalc testGraph;
        if (coord.equals(seq1)) {
            testGraph = new StatCalc1(3, seq2, seq3);
        } else if (coord.equals(seq2)) {
            testGraph = new StatCalc1(3, seq1, seq3);
        } else if (coord.equals(seq3)) {
            testGraph = new StatCalc1(3, seq1, seq2);
        } else {
            testGraph = new StatCalc1();
            assert false : "Removed coordinate was not restored";
        }

        assertEquals(2, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * removeAnyCoordinate test.
     */
    @Test
    public void removeAnyCoordinateTest2() {
        Sequence<Integer> seq1 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1);

        Sequence<Integer> coord = newGraph.removeAnyCoordinate();
        assertEquals(seq1, coord);

        StatCalc testGraph = new StatCalc1(3);

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * graphSize test.
     */
    @Test
    public void graphSizeTest1() {
        Sequence<Integer> seq1 = generateCoordinate(3);

        StatCalc newGraph = new StatCalc1(3, seq1);

        StatCalc testGraph = new StatCalc1(3, seq1);

        assertEquals(1, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * graphSize test.
     */
    @Test
    public void graphSizeTest2() {
        StatCalc newGraph = new StatCalc1(3);

        StatCalc testGraph = new StatCalc1(3);

        assertEquals(0, newGraph.graphSize());
        assertEquals(3, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * dimension test.
     */
    @Test
    public void dimensionTest1() {
        StatCalc newGraph = new StatCalc1();

        StatCalc testGraph = new StatCalc1();

        assertEquals(0, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * dimension test.
     */
    @Test
    public void dimensionTest2() {
        StatCalc newGraph = new StatCalc1(2000);

        StatCalc testGraph = new StatCalc1(2000);

        assertEquals(0, newGraph.graphSize());
        assertEquals(2000, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * coordinateAt test.
     */
    @Test
    public void coordinateAtTest1() {
        Sequence<Integer> seq1 = generateCoordinate(2);
        Sequence<Integer> seq2 = generateCoordinate(2);
        Sequence<Integer> seq3 = generateCoordinate(2);

        StatCalc newGraph = new StatCalc1(2, seq1, seq2, seq3);
        StatCalc testGraph = new StatCalc1(2, seq1, seq2, seq3);

        assertEquals(seq2, newGraph.coordinateAt(1));

        assertEquals(3, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * coordinateAt test.
     */
    @Test
    public void coordinateAtTest2() {
        Sequence<Integer> seq1 = generateCoordinate(2);
        Sequence<Integer> seq2 = generateCoordinate(2);
        Sequence<Integer> seq3 = generateCoordinate(2);

        StatCalc newGraph = new StatCalc1(2, seq1, seq2, seq3);
        StatCalc testGraph = new StatCalc1(2, seq1, seq2, seq3);

        assertEquals(seq3, newGraph.coordinateAt(2));

        assertEquals(3, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }

    /**
     * coordinateAt test.
     */
    @Test
    public void coordinateAtTest3() {
        Sequence<Integer> seq1 = generateCoordinate(2);

        StatCalc newGraph = new StatCalc1(2, seq1);
        StatCalc testGraph = new StatCalc1(2, seq1);

        assertEquals(seq1, newGraph.coordinateAt(0));

        assertEquals(1, newGraph.graphSize());
        assertEquals(2, newGraph.dimensions());

        assertEquals(testGraph, newGraph);
    }
}
