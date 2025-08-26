 * 📌 Problem:
 * Given three strings s1, s2, and s3, determine the minimum number of character deletions
 * needed (from the end of strings) to make their prefixes equal. If they don't start
 * with the same character, return -1.
 *
 * ✅ Approach:
 * - First, check if all three strings start with the same character. If not, return -1.
 * - Then, iterate through the strings simultaneously to find the longest common prefix.
 * - For each character match, subtract 3 from the total length (1 from each string).
 * - Return the remaining length as the total number of deletions required.
 *
 * 💡 Time Complexity: O(n), where n = min(length of s1, s2, s3)
 * 💡 Space Complexity: O(1)
 */

public class MinimumOperationsToEqualPrefix {
    public int findMinimumOperations(String s1, String s2, String s3) {
        // Early exit if any string doesn't start with the same character
        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0) || s2.charAt(0) != s3.charAt(0)) {
            return -1;
        }

        // Total number of characters across all strings
        int totalLen = s1.length() + s2.length() + s3.length();

        // Length of the shortest string among the three
        int len = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        // Find longest common prefix length
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                totalLen -= 3; // Matching character found in all strings
            } else {
                break; // Prefix mismatch found
            }
        }

        return totalLen; // Return total operations needed to make prefixes equal
    }
}
