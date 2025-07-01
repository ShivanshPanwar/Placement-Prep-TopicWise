// Problem: Word Pattern
// Link: https://leetcode.com/problems/word-pattern/
// Description: Given a pattern and a string, check if the string follows the same pattern.
// Time Complexity: O(n), Space Complexity: O(n)
// Approach: Use two HashMaps to maintain a bijective relationship between characters and words.

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // If the lengths don’t match, pattern can't be followed
        if (pattern.length() != words.length) {
            return false;
        }

        // Create two maps to maintain a two-way mapping
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check character to word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Pattern mismatch
                }
            } else {
                charToWord.put(c, word);
            }

            // Check word to character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Word already mapped to another character
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true; // Pattern matches
    }
}
