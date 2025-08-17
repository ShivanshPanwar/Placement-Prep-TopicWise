import java.util.*;

public class TriangleMinimumPathSum {

    /**
     * Approach:
     * - Use bottom-up Dynamic Programming with space optimization.
     * - Start from the last row of the triangle and copy it into a dp array.
     * - For each row (from bottom to top), update dp[j] as:
     *      dp[j] = triangle[i][j] + min(dp[j], dp[j+1])
     *   This ensures dp[j] always contains the minimum path sum from (i, j) to the bottom.
     * - Finally, dp[0] will contain the minimum path sum starting from the top.
     *
     * Complexity:
     * - Time: O(n^2), where n is the number of rows in the triangle
     *   (since we process each element once).
     * - Space: O(n), as we only use a single 1D dp array of size equal to the last row.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        // dp array to store the minimum path sums
        int[] dp = new int[n];

        // Copy the last row into dp
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }

        // Start from the second-last row and move upwards
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        // dp[0] will contain the minimum path sum
        return dp[0];
    }
}
