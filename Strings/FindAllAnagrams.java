// Problem: Find All Anagrams in a String
// Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Description: Return all start indices of p's anagrams in s.
// Approach: Sliding window with HashMaps to compare character frequency.
// Time Complexity: O(n), Space Complexity: O(1) — at most 26 keys in each map

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Step 1: Build frequency map for pattern p
        for (char c : p.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int j = 0; // left boundary of sliding window

        // Step 2: Slide over the string s
        for (int i = 0; i < s.length(); i++) {
            // Add current character to window map
            char currentChar = s.charAt(i);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            // Check if current window size matches pattern length
            if (i - j + 1 == p.length()) {
                // If maps match, we found an anagram
                if (windowMap.equals(targetMap)) {
                    result.add(j);
                }

                // Shrink window from the left
                char leftChar = s.charAt(j);
                if (windowMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if (windowMap.get(leftChar) == 0) {
                        windowMap.remove(leftChar);
                    }
                }

                j++; // Move left pointer forward
            }
        }

        return result;
    }
}
