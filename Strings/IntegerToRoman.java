// Problem: Integer to Roman
// Link: https://leetcode.com/problems/integer-to-roman/
// Description: Convert an integer to its Roman numeral representation.
// Approach: Greedy algorithm using predefined Roman numeral mappings.
// Time Complexity: O(1), Space Complexity: O(1)

import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        // Roman numeral mappings
        Map<Integer, String> roman = new HashMap<>();
        roman.put(1, "I");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(90, "XC");
        roman.put(100, "C");
        roman.put(400, "CD");
        roman.put(500, "D");
        roman.put(900, "CM");
        roman.put(1000, "M");

        // Descending order of values for greedy subtraction
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int value : values) {
            while (num >= value) {
                sb.append(roman.get(value));
                num -= value;
            }
        }

        return sb.toString();
    }
}
