/**
 * Week 5 Practice 4 - Hackathon Seating Grid Optimizer (works with jagged rows)
 */
public class P4_HackathonSeatingGridOptimizer {

    // Only computes one row's average - the caller decides the zone
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int value : row) sum += value;
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < seatingScores.length; r++) {
            double average = rowAverage(seatingScores[r]);
            String zone = average < threshold ? "Quiet Zone" : "Buzzing Zone";
            if (r > 0) result.append(" | ");
            result.append("Row ").append(r).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(seatingScores, 60));
    }
}
