import java.util.Arrays;

/**
 * Week 5 Assignment 2 - Duplicate Player Pick Checker (nested loops, no Collections)
 */
public class A2_DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[][] lineups = {
                {"Kohli", "Bumrah", "Kohli", "Rohit"},
                {"Kohli", "Bumrah", "Rohit"}
        };
        for (String[] lineup : lineups) {
            System.out.println(Arrays.toString(lineup) + " -> \"" + findDuplicatePick(lineup) + "\"");
        }
    }
}
