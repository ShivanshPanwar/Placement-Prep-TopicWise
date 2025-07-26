import java.util.*;

/**
 * LeetCode 1072: Flip Columns For Maximum Number of Equal Rows
 *
 * Approach:
 * - We want the maximum number of rows that can become equal after flipping any number of columns.
 * - The trick is to notice that if two rows are "equivalent" (i.e., either they are identical or exact inverses),
 *   they can be made equal by flipping the necessary columns.
 * - For each row:
 *      - If the first element is 0, keep the row as is.
 *      - If the first element is 1, flip all bits (row[i] XOR 1) to create a normalized pattern.
 * - Count the frequency of each normalized pattern using a HashMap.
 * - The maximum frequency value corresponds to the maximum equal rows achievable.
 *
 * Time Complexity: O(m * n) — m rows and n columns, as each cell is processed once.
 * Space Complexity: O(m * n) — storing normalized row patterns in the HashMap.
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patFreq = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }

        return Collections.max(patFreq.values());
    }
}
