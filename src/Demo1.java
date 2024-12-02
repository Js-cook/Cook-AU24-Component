import srcComponent.StatCalc;
import srcComponent.StatCalc1;

/**
 * Demo of statCalc component.
 */
public final class Demo1 {

    /**
     * Private constructor to prevent instantiation.
     */
    private Demo1() {
    }

    /**
     * Main method.
     *
     * @param args
     *            command line args.
     */
    public static void main(String[] args) {
        StatCalc s = new StatCalc1();
        int[] data = { 1, 2, 5, 7, 10, 4, 2, -9, 6, 0 };

        for (int i = 0; i < data.length - 1; i += 2) {
            s.addCoordinatePair(data[i], data[i + 1]);
        }

        System.out
                .println("Average of x-component of dataset is: " + s.mean(0));
        System.out
                .println("Average of y-component of dataset is: " + s.mean(1));

        System.out.println(
                "Max of the x-component of the dataset is: " + s.max(0));
        System.out.println(
                "Min of the x-component of the dataset is: " + s.min(0));
        System.out.println(
                "Range of the x-component is: " + (s.max(0) - s.min(0)));
    }
}
