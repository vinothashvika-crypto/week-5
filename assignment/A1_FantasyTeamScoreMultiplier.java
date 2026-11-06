import java.util.Arrays;

/**
 * Week 5 Assignment 1 - Fantasy Team Score Multiplier (modifies the caller's array directly)
 */
public class A1_FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;        // Captain: 2x
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5; // Vice-Captain: 1.5x
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        System.out.println("Before: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("After applyMultipliers(scores, 1, 3): " + Arrays.toString(scores));
    }
}
