/**
 * Problem: Edit Distance (LeetCode #72)
 * -------------------------------------
 * Given two strings word1 and word2, find the minimum number of operations 
 * required to convert word1 to word2. 
 * Allowed operations: Insert, Delete, Replace.
 *
 * Approach:
 * - Use Dynamic Programming (DP) to build a 2D table where dp[i][j] 
 *   represents the minimum edit distance between word1[0..i-1] and word2[0..j-1].
 * - If characters match: dp[i][j] = dp[i-1][j-1]
 * - If not:
 *      Insert:  dp[i][j-1] + 1
 *      Delete:  dp[i-1][j] + 1
 *      Replace: dp[i-1][j-1] + 1
 *   Take the minimum of all three.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting empty strings
        for (int i = 0; i <= n; i++) dp[0][i] = i;  // insert operations
        for (int i = 0; i <= m; i++) dp[i][0] = i;  // delete operations

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
