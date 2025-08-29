/**
 * Solution to find the largest square containing only 1's in a 2D binary matrix.
 * 
 * Approach:
 * - Use dynamic programming to build a DP table where dp[i][j] represents
 *   the side length of the largest square whose bottom-right corner is at (i-1, j-1) in the matrix.
 * - For each cell containing '1', dp[i][j] is the minimum of three neighbors (left, above, diagonal) + 1.
 * - Keep track of the maximum side length found during the iteration.
 * - Return the area of the largest square (maxSide * maxSide).
 */

public class MaximalSquareFinder {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    int left = dp[i][j-1];
                    int above = dp[i-1][j];
                    int diagonal = dp[i-1][j-1];
                    dp[i][j] = Math.min(left, Math.min(above, diagonal)) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
