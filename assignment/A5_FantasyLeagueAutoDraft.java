import java.util.Arrays;

/**
 * Week 5 Assignment 5 - Fantasy League Auto-Draft Ranking Engine
 *
 * Rules chosen (they reproduce the sample in the problem sheet):
 *   - Established players (experience only): matchesPlayed >= 10
 *   - Everyone else: matchesPlayed >= 5 AND not injured
 *   - Fantasy points used for ranking = batting average (higher ranks first)
 */
public class A5_FantasyLeagueAutoDraft {

    static final int EXPERIENCED_MATCHES = 10;
    static final int MIN_MATCHES_IF_FIT = 5;

    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() { return name; }
        public int getMatchesPlayed() { return matchesPlayed; }
        public double getBattingAverage() { return battingAverage; }
        public boolean isInjured() { return injured; }

        public double getFantasyPoints() {
            return battingAverage;
        }

        // Descending by fantasy points
        public int compareTo(Player other) {
            return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
        }
    }

    // Overload 1: experience-only rule for established players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCED_MATCHES;
    }

    // Overload 2: combined experience + fitness rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= MIN_MATCHES_IF_FIT && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[count++] = p;
            }
        }
        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable); // uses compareTo - no hand-written sort

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable[i].getName());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
