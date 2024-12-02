import components.sequence.Sequence;
import srcComponent.StatCalc;
import srcComponent.StatCalc1;

/**
 * Demo class that uses StatCalc.
 */
public final class GameStats {

    /**
     * Player name.
     */
    private String player;
    /**
     * Stat tracker.
     */
    private StatCalc statsRecorder;

    /**
     * Enum for different stat names.
     */
    private enum StatNames {
        GOALS, SAVES, ASSISTS
    }

    /**
     * Constructor.
     *
     * @param name
     *            player name
     */
    public GameStats(String name) {
        this.player = name;
        this.statsRecorder = new StatCalc1(3);
    }

    /**
     * Adds a new game to the recorder.
     *
     * @param stats
     *            game stats
     */
    public void addGame(int... stats) {
        this.statsRecorder.addCoordinatePair(stats);
    }

    /**
     * Reports the average for a given stat.
     *
     * @param statIdentifier
     *            Enum constant corresponding to a stat
     * @return The average of that stat
     */
    public double averageStat(StatNames statIdentifier) {
        // where statIdentifier would be the enum constant
        double avg = 0.0;
        switch (statIdentifier) {
            case GOALS: {
                avg = this.statsRecorder.mean(0);
            }
            case SAVES: {
                avg = this.statsRecorder.mean(1);
            }
            case ASSISTS: {
                avg = this.statsRecorder.mean(2);
            }
            default: {
                System.err.println("Something went wrong...");
            }
        }
        return avg;
    }

    /**
     * Reports the stats for a given game.
     * 
     * @param gameNumber
     *            Game number sequentially.
     * @return The stats as a sequence.
     */
    public Sequence<Integer> gameReport(int gameNumber) {
        return this.statsRecorder.coordinateAt(gameNumber);
    }
}
