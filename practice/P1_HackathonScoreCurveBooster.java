import java.util.Arrays;

/**
 * Week 5 Practice 1 - Hackathon Score Curve Booster
 * Modifies the caller's array in place (arrays are passed by reference).
 */
public class P1_HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        System.out.println("Before: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("After curveScores(scores, 10): " + Arrays.toString(scores));
    }
}
