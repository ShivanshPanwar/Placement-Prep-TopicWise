// Problem: Isomorphic Strings
// Link: https://leetcode.com/problems/isomorphic-strings/
// Description: Two strings are isomorphic if the characters in one string can be replaced 
//              to get the second string, with each character mapping to only one other character.
// Approach: Use two HashMaps to ensure one-to-one character mapping in both directions.
// Time Complexity: O(n), Space Complexity: O(1) since the character set is fixed (ASCII)

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>(); // Maps characters from s to t
        HashMap<Character, Character> map2 = new HashMap<>(); // Maps characters from t to s

        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i); // character from string s
            char t1 = t.charAt(i); // corresponding character from string t

            // Check mapping from s -> t
            if (map1.containsKey(s1)) {
                if (map1.get(s1) != t1) {
                    return false; // Mapping mismatch
                }
            } else {
                map1.put(s1, t1); // Map s1 to t1
            }

            // Check mapping from t -> s
            if (map2.containsKey(t1)) {
                if (map2.get(t1) != s1) {
                    return false; // Reverse mapping mismatch
                }
            } else {
                map2.put(t1, s1); // Map t1 to s1
            }
        }

        return true; // Strings are isomorphic
    }
}
