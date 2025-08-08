/**
 * Problem: Leetcode 567 - Permutation in String
 * 
 * Approach:
 * - Sliding Window + Frequency Count
 * - Maintain a window of size s1.length() over s2
 * - Use two frequency arrays to track character counts
 * - Compare frequencies at each step
 *
 * Time Complexity: O(n), where n = s2.length()
 * Space Complexity: O(1), constant space for 26 letters
 */

public class PermutationChecker {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < len1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) return true;

        // Slide the window
        for (int i = len1; i < len2; i++) {
            freq2[s2.charAt(i) - 'a']++; // Add new character
            freq2[s2.charAt(i - len1) - 'a']--; // Remove old character

            if (Arrays.equals(freq1, freq2)) return true;
        }

        return false;
    }
}
