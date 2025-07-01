// Problem: Longest Substring Without Repeating Characters
// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Description: Find the length of the longest substring without repeating characters.
// Approach: Sliding window with HashSet to track unique characters in the current window
// Time Complexity: O(n), Space Complexity: O(min(n, m)) where m is the character set size

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0; // Sliding window pointers
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (i < s.length()) {
            // If character already exists in the current window
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++; // Shrink window from the left
            }

            // Add current character and expand window
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, i - j + 1); // Update max length
            i++;
        }

        return maxLen;
    }
}
