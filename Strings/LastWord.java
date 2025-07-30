/**
 * Problem: Length of Last Word
 * Link: https://leetcode.com/problems/length-of-last-word/
 *
 * ✅ Approach:
 * - Use two pointers (`right` and `left`) to scan the string from the end.
 * - Step 1: Skip all trailing spaces or non-letter characters.
 * - Step 2: Identify the last word by moving the left pointer until a non-letter is found.
 * - Step 3: Return the length as (right - left).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class LastWord {
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;

        // Skip trailing spaces and non-letter characters
        while (right >= 0 && !Character.isLetter(s.charAt(right))) {
            right--;
        }

        // Start from the end of the last word
        int left = right;

        // Move left pointer until a non-letter is found
        while (left >= 0 && Character.isLetter(s.charAt(left))) {
            left--;
        }

        // Length of last word = right - left
        return right - left;
    }
}
