import java.util.Arrays;

/**
 * Week 5 Practice 2 - Duplicate Team Name Finder (nested loops, no Collections)
 */
public class P2_DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {   // only compare with later names
                if (teamNames[i].equals(teamNames[j])) {      // case-sensitive comparison
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"ByteForce", "CodeCrafters", "ByteForce"},
                {"ByteForce", "CodeCrafters", "NullPointers"}
        };
        for (String[] teams : inputs) {
            System.out.println(Arrays.toString(teams) + " -> \"" + findDuplicateTeam(teams) + "\"");
        }
    }
}
