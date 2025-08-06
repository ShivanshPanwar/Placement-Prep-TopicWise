import java.util.HashMap;

public class LongestPalindromeLength {
    /**
     * Approach:
     * - Count the frequency of each character using a HashMap.
     * - For each character, we can use the even part of its frequency (x/2)*2.
     * - If there is any character with an odd count, we can place exactly one such character in the center.
     *
     * Time Complexity: O(n)
     * - We traverse the string once to build the frequency map, and then traverse the map.
     *
     * Space Complexity: O(1)
     * - The HashMap stores up to 52 characters (a-zA-Z), so it's constant space.
     */

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int length = 0;
        boolean isOdd = false;

        for (int freq : map.values()) {
            length += (freq / 2) * 2; // Add even part of the frequency
            if (freq % 2 == 1) {
                isOdd = true; // We can place one odd character in the middle
            }
        }

        return isOdd ? length + 1 : length;
    }
}
