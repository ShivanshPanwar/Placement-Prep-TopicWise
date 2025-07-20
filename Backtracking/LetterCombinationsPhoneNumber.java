// Letter Combinations of a Phone Number - Recursive Backtracking Solution
// Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//
// Approach:
// - The problem requires generating all possible letter combinations that a string of digits can represent 
//   based on the mapping of digits to letters on a phone keypad.
// - We use recursion (divide and conquer):
//      1. Base case: if the input string is empty, return a list containing an empty string.
//      2. Take the first digit, get the corresponding letters, and generate all combinations
//         by appending each letter to the combinations generated from the rest of the digits.
// - Time Complexity: O(4^n * n), where n is the length of `digits`. In the worst case, each digit maps to 4 letters.
// - Space Complexity: O(n) for recursion stack depth.
//
// Example:
// Input: "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

import java.util.*;

class LetterCombinationsPhoneNumber {
    String keys[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        } else {
            return helper(digits);
        }
    }

    private List<String> helper(String digits) {
        // Base Case: when no digits left, return list with empty string
        if (digits.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add(""); // Acts as a seed for combination building
            return list;
        }

        char firstDigit = digits.charAt(0);  // e.g., '2'
        int index = firstDigit - '0';        // Convert char to int (2)
        String str = keys[index];            // Get corresponding string, e.g., "abc"

        // Recursive call for remaining digits
        List<String> oldList = helper(digits.substring(1));

        // Build new combinations by appending each character to all combinations of the remaining digits
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < oldList.size(); j++) {
                newList.add(str.charAt(i) + oldList.get(j));
            }
        }

        return newList;
    }
}
