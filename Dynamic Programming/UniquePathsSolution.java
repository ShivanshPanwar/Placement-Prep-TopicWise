// Problem: Unique Paths (LeetCode 62)
// Approach: Dynamic Programming (Bottom-Up)
// -----------------------------------------
// We create a DP table where dp[i][j] represents the number of unique paths
// from cell (i, j) to the bottom-right corner of the grid.
//
// Base cases:
// - The last row has only 1 path (move right only).
// - The last column has only 1 path (move down only).
//
// Transition:
// dp[i][j] = dp[i+1][j] + dp[i][j+1]
//
// Finally, dp[0][0] gives the total unique paths from the top-left to bottom-right.
//
// Time Complexity: O(m * n)  -> we fill every cell once
// Space Complexity: O(m * n) -> we use a 2D dp array

class UniquePathsSolution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the last row with 1 (only right moves possible)
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Fill the last column with 1 (only down moves possible)
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        // Fill the DP table bottom-up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0]; // result: number of unique paths
    }
}
