/*
* Given an input string (s) and a pattern (p), implement wildcard matching 
 * with support for '?' and '*':
 *   - '?' Matches any single character.
 *   - '*' Matches any sequence of characters (including empty sequence).
 * 
 * Approach:
 * We use Dynamic Programming (DP) where dp[i][j] represents whether the 
 * first i characters of s match the first j characters of p.
 * 
 * Steps:
 * 1. Initialize a DP table of size (m+1) x (n+1), where m = s.length, n = p.length.
 * 2. Base Case: dp[0][0] = true (empty string matches empty pattern).
 * 3. Handle leading '*' in the pattern for row 0.
 * 4. Fill the DP table:
 *    - If current characters match or pattern has '?', carry over dp[i-1][j-1].
 *    - If pattern has '*', dp[i][j] = dp[i-1][j] (use '*' to match current char)
 *      OR dp[i][j-1] (use '*' as empty).
 *    - Else, set false.
 * 5. Return dp[m][n] as the final answer.
 * 
 * Time Complexity:  O(m * n), where m = s.length(), n = p.length()
 * Space Complexity: O(m * n), as we maintain a DP table.
 */

import java.util.*;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string and empty pattern
        dp[0][0] = true;

        // Handle patterns starting with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
