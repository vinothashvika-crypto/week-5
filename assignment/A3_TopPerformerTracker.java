import java.util.Arrays;

/**
 * Week 5 Assignment 3 - Top Performer Tracker (min, max and spread in one pass, no sorting)
 */
public class A3_TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0], max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
            if (scores[i] > max) max = scores[i];
        }
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(scores) + " -> \"" + findMinMaxSpread(scores) + "\"");
    }
}
