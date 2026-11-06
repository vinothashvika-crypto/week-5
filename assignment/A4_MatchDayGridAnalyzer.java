/**
 * Week 5 Assignment 4 - Match Day Grid Analyzer (works with matches of different lengths)
 */
public class A4_MatchDayGridAnalyzer {

    // Only computes one match's average - the caller decides Power Surge vs Normal
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int m = 0; m < runsPerOver.length; m++) {
            String label = rowAverage(runsPerOver[m]) >= threshold ? "Power Surge" : "Normal";
            if (m > 0) result.append(" | ");
            result.append("Match ").append(m).append(": ").append(label);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
