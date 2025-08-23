// Problem: Find the length of the Longest Common Subsequence (LCS) between two strings.
//
// Approach:
// 1. Use Dynamic Programming (DP) to build a table `dp[i][j]` that represents the 
//    LCS length of substrings text1[0..i-1] and text2[0..j-1].
// 2. Transition:
//    - If characters match: dp[i][j] = dp[i-1][j-1] + 1
//    - Else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
// 3. dp[m][n] will hold the final LCS length.
//
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
