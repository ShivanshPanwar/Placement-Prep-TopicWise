public class MinimumPathSum {

    /**
     * Approach:
     * - This problem is solved using Dynamic Programming (DP).
     * - Create a dp matrix of the same size as the input grid.
     * - dp[i][j] will store the minimum path sum to reach cell (i, j).
     * - Base cases:
     *      - dp[0][0] = grid[0][0] (starting point)
     *      - Fill the first row and first column as they can only be reached from one direction.
     * - Transition:
     *      dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
     *   This ensures that we always take the optimal (minimum sum) path.
     *
     * Complexity:
     * - Time: O(m * n), where m = rows and n = columns (we visit each cell once).
     * - Space: O(m * n), since we use a 2D dp matrix.
     *   (Can be optimized to O(n) using a 1D dp array.)
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Initialize starting cell
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The bottom-right cell has the minimum path sum
        return dp[m - 1][n - 1];
    }
}
