// Problem: Reverse String
// Link: https://leetcode.com/problems/reverse-string/
// Description: Reverse the characters in a character array in-place.
// Approach: Two-pointer technique (swap from both ends)
// Time Complexity: O(n), Space Complexity: O(1)

public class ReverseString {
    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;

        while (low <= high) {
            // Swap characters
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;

            low++;
            high--;
        }
    }
}
