import java.util.*;

class UniquePathsWithObstacles {
    /**
     * Problem:
     * Given a grid where some cells contain obstacles (1) and others are free (0),
     * return the number of unique paths from the top-left corner (0,0) 
     * to the bottom-right corner (m-1, n-1).
     * 
     * Constraints:
     * - You can only move either right or down at any step.
     * - If a cell has an obstacle, you cannot move through it.
     * 
     * Approach:
     * - Use Dynamic Programming (DP).
     * - dp[i][j] represents the number of unique paths to reach cell (i, j).
     * - Base Case: dp[0][0] = 1 if obstacleGrid[0][0] == 0, else return 0.
     * - First Row: If there’s no obstacle and the previous cell has a path, mark as 1.
     * - First Column: Same logic as the first row.
     * - Transition: 
     *      If obstacleGrid[i][j] == 1 → dp[i][j] = 0 (no path).
     *      Else → dp[i][j] = dp[i-1][j] + dp[i][j-1].
     * - Answer: dp[m-1][n-1].
     * 
     * Complexity:
     * - Time: O(m * n) → we iterate over all grid cells once.
     * - Space: O(m * n) for dp array.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Base case: If starting cell has obstacle → no path
        if (obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // Fill first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            }
        }

        // Fill first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle → no path
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
