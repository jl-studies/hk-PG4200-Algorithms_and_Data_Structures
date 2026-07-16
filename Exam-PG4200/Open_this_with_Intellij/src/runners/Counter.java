package runners;

public class Counter {
    public static int numberOfSwaps = 0;
    public static int numberOfComparisons = 0;
    public static int numberOfMergers = 0;
    public static long start = 0;
    public static long stop = 0;


    public static void resetCounter() {
        numberOfSwaps = 0;
        numberOfComparisons = 0;
        numberOfMergers = 0;
    }

    public static void timerStart() {
        start = System.nanoTime();
    }

    public static void timerStop() {
        stop = System.nanoTime() - start;
        System.out.println("Seconds used: " + (stop / 1_000_000.0));
    }

    public static void comparisonsSwapsMergers() {
        System.out.println("Number of swaps: " + numberOfSwaps + " | " + "Number of comparisons: " + numberOfComparisons + " | " + "Number of mergers: " + numberOfMergers);
    }
}