/*
 Approach:
 ---------
 We need to find the length of the longest common substring between two strings s1 and s2.
 
 ✅ Key Idea:
 - Use Dynamic Programming (DP) with a 2D table.
 - dp[i][j] represents the length of the longest common substring 
   ending at s1[i-1] and s2[j-1].
 - Transition:
     If s1[i-1] == s2[j-1]:
         dp[i][j] = dp[i-1][j-1] + 1
     Else:
         dp[i][j] = 0
 - Keep track of the maximum value in dp (that’s our answer).
 
 ✅ Complexity:
 - Time: O(m * n), where m = length of s1, n = length of s2
 - Space: O(m * n) for the DP table
   (can be optimized to O(min(m,n)) if needed)
*/

class LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        LongestCommonSubstring solver = new LongestCommonSubstring();
        String s1 = "abc";
        String s2 = "abd";
        
        int result = solver.longestCommonSubstr(s1, s2);
        System.out.println("Longest Common Substring length: " + result); // Output: 2
    }
}
