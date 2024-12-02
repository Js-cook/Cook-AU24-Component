import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import srcComponent.StatCalc;
import srcComponent.StatCalc1;

/**
 * Abstract class test cases.
 */
public class StatCalcSecondaryTest {

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
            input.add(i, rand.nextInt(1000));
        }

        return input;
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest1() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        assertTrue(!newGraph.equals(null));
        assertEquals(testGraph, newGraph);
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        assertTrue(!newGraph.equals("hello there"));
        assertEquals(testGraph, newGraph);
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest3() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(2);

        assertTrue(!newGraph.equals(testGraph));
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest4() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = newGraph;

        assertTrue(newGraph.equals(testGraph));
    }

    /**
     * Equals test.
     */
    @Test
    public void equalsTest5() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        newGraph.addCoordinatePair(1);
        newGraph.addCoordinatePair(2);
        newGraph.addCoordinatePair(3);

        testGraph.addCoordinatePair(1);
        testGraph.addCoordinatePair(2);
        testGraph.addCoordinatePair(3);

        assertTrue(newGraph.equals(testGraph));
    }

    /**
     * toString test.
     */
    @Test
    public void toStringTest1() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        assertEquals("<>", newGraph.toString());
        assertEquals(testGraph, newGraph);
    }

    /**
     * toString test.
     */
    @Test
    public void toStringTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        newGraph.addCoordinatePair(1);

        testGraph.addCoordinatePair(1);

        assertEquals("<(1), >", newGraph.toString());
        assertEquals(testGraph, newGraph);
    }

    /**
     * toString test.
     */
    @Test
    public void toStringTest3() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        newGraph.addCoordinatePair(1);
        newGraph.addCoordinatePair(2);

        testGraph.addCoordinatePair(1);
        testGraph.addCoordinatePair(2);

        assertEquals("<(1), (2), >", newGraph.toString());
        assertEquals(testGraph, newGraph);
    }

    /**
     * hashCode test.
     */
    @Test
    public void hashCodeTest1() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        assertTrue(newGraph.hashCode() == testGraph.hashCode());
    }

    /**
     * hashCode test.
     */
    @Test
    public void hashCodeTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        newGraph.addCoordinatePair(1);

        assertTrue(newGraph.hashCode() != testGraph.hashCode());
    }

    /**
     * mean test.
     */
    @Test
    public void meanTest1() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        for (int i = 0; i < 3; i++) {
            newGraph.addCoordinatePair(i + 1);
            testGraph.addCoordinatePair(i + 1);
        }

        assertTrue(2.0 == newGraph.mean(0));
        assertEquals(testGraph, newGraph);
    }

    /**
     * mean test.
     */
    @Test
    public void meanTest2() {
        Sequence<Integer> seq1 = generateCoordinate(2);
        Sequence<Integer> seq2 = generateCoordinate(2);

        StatCalc newGraph = new StatCalc1(2, seq1, seq2);
        StatCalc testGraph = new StatCalc1(2, seq1, seq2);

        double mean = (seq1.entry(1) + seq2.entry(1)) / 2.0;

        assertTrue(mean == newGraph.mean(1));
        assertEquals(testGraph, newGraph);
    }

    /**
     * standard deviation test.
     */
    @Test
    public void standardDeviationTest1() {
        StatCalc newGraph = new StatCalc1(2);
        StatCalc testGraph = new StatCalc1(2);

        for (int i = 0; i < 3; i++) {
            newGraph.addCoordinatePair(i, 4 - i);
            testGraph.addCoordinatePair(i, 4 - i);
        }

        assertTrue(1.0 == newGraph.standardDeviation(0));
        assertEquals(testGraph, newGraph);
    }

    /**
     * standard deviation test.
     */
    @Test
    public void standardDeviationTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        int[] points = { 20, 40, 60 };

        for (int i = 0; i < 3; i++) {
            newGraph.addCoordinatePair(points[i]);
            testGraph.addCoordinatePair(points[i]);
        }

        assertTrue(20 == newGraph.standardDeviation(0));
        assertEquals(testGraph, newGraph);
    }

    /**
     * max test.
     */
    @Test
    public void maxTest1() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        int[] points = { 20, 40, 60 };

        for (int i = 0; i < 3; i++) {
            newGraph.addCoordinatePair(points[i]);
            testGraph.addCoordinatePair(points[i]);
        }

        assertTrue(60 == newGraph.max(0));
        assertEquals(testGraph, newGraph);
    }

    /**
     * max test.
     */
    @Test
    public void maxTest2() {
        StatCalc newGraph = new StatCalc1(2);
        StatCalc testGraph = new StatCalc1(2);

        int[] points = { 20, 40, 60 };

        for (int i = 0; i < 3; i++) {
            newGraph.addCoordinatePair(points[i], points[2 - i]);
            testGraph.addCoordinatePair(points[i], points[2 - i]);
        }

        assertTrue(60 == newGraph.max(1));
        assertEquals(testGraph, newGraph);
    }

    /**
     * min test.
     */
    @Test
    public void minTest1() {
        StatCalc newGraph = new StatCalc1(2);
        StatCalc testGraph = new StatCalc1(2);

        int[] points = { 20, 40, 60, 50, 10, -100 };

        for (int i = 0; i < points.length; i++) {
            newGraph.addCoordinatePair(points[i],
                    points[(points.length - 1) - i]);
            testGraph.addCoordinatePair(points[i],
                    points[(points.length - 1) - i]);
        }

        assertTrue(-100 == newGraph.min(1));
        assertEquals(testGraph, newGraph);
    }

    /**
     * min test.
     */
    @Test
    public void minTest2() {
        StatCalc newGraph = new StatCalc1(1);
        StatCalc testGraph = new StatCalc1(1);

        int[] points = { 20, 40, 60, 50, 10 };

        for (int i = 0; i < points.length; i++) {
            newGraph.addCoordinatePair(points[i]);
            testGraph.addCoordinatePair(points[i]);
        }

        assertTrue(10 == newGraph.min(0));
        assertEquals(testGraph, newGraph);
    }

    /**
     * distance test.
     */
    @Test
    public void distanceTest1() {
        Sequence<Integer> seq1 = new Sequence1L<>();
        Sequence<Integer> seq2 = new Sequence1L<>();

        for (int i = 0; i < 3; i++) {
            seq1.add(i, i + 1);
            seq2.add(i, i + 1);
        }

        StatCalc newGraph = new StatCalc1(3, seq1, seq2);
        StatCalc testGraph = new StatCalc1(3, seq1, seq2);

        assertTrue(0 == newGraph.distance(newGraph.coordinateAt(0),
                newGraph.coordinateAt(1)));
        assertEquals(testGraph, newGraph);
    }

    /**
     * distance test.
     */
    @Test
    public void distanceTest2() {
        Sequence<Integer> seq1 = new Sequence1L<>();
        Sequence<Integer> seq2 = new Sequence1L<>();

        seq1.add(0, 0);
        seq1.add(1, 2);

        seq2.add(0, 3);
        seq2.add(1, 6);

        StatCalc newGraph = new StatCalc1();
        StatCalc testGraph = new StatCalc1();

        assertTrue(5 == newGraph.distance(seq1, seq2));
        assertEquals(testGraph, newGraph);
    }

    /**
     * midpoint test.
     */
    @Test
    public void midpointTest1() {
        Sequence<Integer> seq1 = new Sequence1L<>();
        Sequence<Integer> seq2 = new Sequence1L<>();

        seq1.add(0, 0);
        seq1.add(1, 2);

        seq2.add(0, 3);
        seq2.add(1, 6);

        StatCalc newGraph = new StatCalc1();
        StatCalc testGraph = new StatCalc1();

        Sequence<Integer> result = seq1.newInstance();
        result.add(0, 1);
        result.add(1, 4);

        assertEquals(result, newGraph.midpoint(seq1, seq2));
        assertEquals(testGraph, newGraph);
    }

    /**
     * midpoint test.
     */
    @Test
    public void midpointTest2() {
        Sequence<Integer> seq1 = new Sequence1L<>();
        Sequence<Integer> seq2 = new Sequence1L<>();

        seq1.add(0, 0);
        seq1.add(1, 2);
        seq1.add(2, -4);
        seq1.add(3, 0);

        seq2.add(0, 3);
        seq2.add(1, 6);
        seq2.add(2, 5);
        seq2.add(3, 0);

        StatCalc newGraph = new StatCalc1(3);
        StatCalc testGraph = new StatCalc1(3);

        Sequence<Integer> result = seq1.newInstance();
        result.add(0, 1);
        result.add(1, 4);
        result.add(2, 0);
        result.add(3, 0);

        assertEquals(result, newGraph.midpoint(seq1, seq2));
        assertEquals(testGraph, newGraph);
    }
}
