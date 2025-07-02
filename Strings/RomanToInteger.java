// Problem: Roman to Integer
// Link: https://leetcode.com/problems/roman-to-integer/
// Description: Convert a Roman numeral to an integer.
// Approach: Traverse the string and subtract if the current symbol is smaller than the next one.
// Time Complexity: O(n), Space Complexity: O(1)

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;

        // Step 1: Define Roman numeral values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        // Step 2: Traverse the string
        for (int i = 0; i < s.length() - 1; i++) {
            int current = roman.get(s.charAt(i));
            int next = roman.get(s.charAt(i + 1));

            if (current < next) {
                result -= current; // Subtractive case (e.g., IV = 5 - 1)
            } else {
                result += current; // Add normally
            }
        }

        // Step 3: Add the value of the last Roman character
        return result + roman.get(s.charAt(s.length() - 1));
    }
}
