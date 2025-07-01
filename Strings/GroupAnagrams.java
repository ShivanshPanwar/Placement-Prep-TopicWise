// Problem: Group Anagrams
// Link: https://leetcode.com/problems/group-anagrams/
// Description: Group all strings that are anagrams of each other.
// Time Complexity: O(n * k log k) where n = number of words, k = max word length
// Space Complexity: O(n * k)
// Approach: Use a HashMap with sorted string as key and group anagrams together.

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert word to char array and sort it
            char[] ch = word.toCharArray();
            Arrays.sort(ch);

            // Sorted characters as key
            String key = new String(ch);

            // Add the word to its anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
