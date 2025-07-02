// Problem: Sort Characters By Frequency
// Link: https://leetcode.com/problems/sort-characters-by-frequency/
// Description: Return a string sorted by character frequency (most frequent first).
// Approach: Count frequency using HashMap, sort entries, and rebuild string.
// Time Complexity: O(n log k), where k is number of unique characters (at most 62)

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        if (s.length() <= 1) return s;

        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Sort the characters based on frequency (high to low)
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: Build result string using sorted entries
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            char ch = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
