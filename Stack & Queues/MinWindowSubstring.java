/**
 * LeetCode Problem: Minimum Window Substring
 * 
 * Given two strings `s` and `t`, return the minimum window substring of `s`
 * such that every character in `t` is included in the window. 
 * If no such substring exists, return an empty string.
 * 
 * Time Complexity: O(|s| + |t|)
 * Space Complexity: O(1) (since the map size is fixed at 128 for ASCII)
 * 
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 */

class Solution {
    public String minWindow(String s, String t) {
        // Edge cases: if s or t is null, empty, or t is longer than s
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        // Initialize sliding window variables
        int count = t.length();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE, startIndex = 0;
        char[] chS = s.toCharArray();

        // Expand and contract the window
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }

            // When all characters from t are in the window
            while (count == 0) {
                // Update minimum window length
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // Shrink the window from the start
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        // Return the minimum window substring or empty string
        return minLen == Integer.MAX_VALUE ? "" : new String(chS, startIndex, minLen);
    }
}
