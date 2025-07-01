// Problem: Reverse Vowels of a String
// Link: https://leetcode.com/problems/reverse-vowels-of-a-string/
// Description: Reverse only the vowels in a given string.
// Approach: Two-pointer approach using StringBuilder to swap characters
// Time Complexity: O(n), Space Complexity: O(n) due to StringBuilder

public class ReverseVowels {
    public String reverseVowels(String s) {
        int low = 0, high = s.length() - 1;
        StringBuilder str = new StringBuilder(s); // Since Strings are immutable in Java

        while (low <= high) {
            boolean isLowVowel = "aeiouAEIOU".indexOf(str.charAt(low)) != -1;
            boolean isHighVowel = "aeiouAEIOU".indexOf(str.charAt(high)) != -1;

            if (isLowVowel && isHighVowel) {
                // Swap the vowels
                char temp = str.charAt(low);
                str.setCharAt(low, str.charAt(high));
                str.setCharAt(high, temp);
                low++;
                high--;
            } else if (!isHighVowel) {
                high--;
            } else {
                low++;
            }
        }

        return str.toString();
    }
}
