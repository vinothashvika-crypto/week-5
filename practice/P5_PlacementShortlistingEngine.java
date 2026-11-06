import java.util.Arrays;

/**
 * Week 5 Practice 5 - Placement Drive Shortlisting & Ranking Engine
 *
 * Rules chosen (they reproduce the sample in the problem sheet):
 *   - CGPA-only quick filter:   cgpa >= 7.0
 *   - Borderline combined rule: cgpa >= 6.5 AND codingScore >= 60
 *   - Composite score = cgpa * 10 + codingScore * 0.5
 */
public class P5_PlacementShortlistingEngine {

    static final double CGPA_CUTOFF = 7.0;
    static final double BORDERLINE_CGPA = 6.5;
    static final int BORDERLINE_CODING = 60;

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public String getName() { return name; }
        public double getCgpa() { return cgpa; }
        public int getCodingScore() { return codingScore; }

        public double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        // Higher composite score comes first (descending order)
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    // Overload 1: CGPA-only quick filter
    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_CUTOFF;
    }

    // Overload 2: combined check for borderline CGPA
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= BORDERLINE_CGPA && codingScore >= BORDERLINE_CODING;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        Candidate[] shortlisted = new Candidate[candidates.length];
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[count++] = c;
            }
        }
        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted); // uses compareTo - no hand-written sort

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(shortlisted[i].getName())
                    .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
