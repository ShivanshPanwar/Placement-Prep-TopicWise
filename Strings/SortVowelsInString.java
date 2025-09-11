import java.util.*;

class SortVowelsInString {
    /**
     * Approach:
     * 1. Traverse the string and collect all vowels (a, e, i, o, u, A, E, I, O, U) into a list.
     * 2. Sort the list of vowels using Collections.sort().
     * 3. Rebuild the string:
     *    - If a character is a vowel, replace it with the next sorted vowel.
     *    - Otherwise, keep the character unchanged.
     *
     * Time Complexity:
     * - Extracting vowels: O(n)
     * - Sorting vowels: O(m log m), where m is the number of vowels (m ≤ n)
     * - Rebuilding the string: O(n)
     * - Total: O(n + m log m)
     *
     * Space Complexity:
     * - O(m) for storing vowels
     * - O(n) for StringBuilder result
     */
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Step 1: Extract vowels
        for (char ch : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowels.add(ch);
            }
        }

        // Step 2: Sort vowels
        Collections.sort(vowels);

        // Step 3: Rebuild string with sorted vowels
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                sb.append(vowels.get(i));
                i++;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
