import java.util.List;

public class WordBreakSolver {

    /**
     * Determines if the string s can be segmented into a space-separated 
     * sequence of one or more dictionary words.
     *
     * Approach:
     * - Use Dynamic Programming.
     * - dp[i] represents whether substring s[0:i) can be segmented.
     * - For each position i, check all j < i:
     *    If dp[j] is true and s[j:i) is in wordDict, set dp[i] = true.
     *
     * Time Complexity: O(n^2 * m), where n is length of s, m is average length to check contains.
     * Space Complexity: O(n) for dp array.
     *
     * @param s Input string to segment
     * @param wordDict List of words forming the dictionary
     * @return true if s can be segmented, false otherwise
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; // Empty string can always be segmented

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
