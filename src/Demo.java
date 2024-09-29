import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class Demo {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        StatCalc newPlot = new StatCalc(2);

        newPlot.addCoordinatePair(1, 2);
        newPlot.addCoordinatePair(3, 4);
        newPlot.addCoordinatePair(5, 6);

        out.println(newPlot.mean(0));
        out.println(newPlot.max(1));
        out.println(newPlot.min(0));
        out.println(newPlot.graphSize());

        out.close();
    }
}
