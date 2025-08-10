public class ReverseStringKGroup {
    /**
     * Approach:
     * - Convert the string to a char array for in-place modifications.
     * - For every block of 2*k characters:
     *   1. Reverse the first k characters.
     *   2. If fewer than k characters remain, reverse all of them.
     * - Leave the next k characters unchanged, then repeat.
     *
     * Steps:
     * 1. Iterate with step size 2*k.
     * 2. Use a helper method reverseK(i, j, str) to reverse characters in range [i, j].
     * 3. Handle edge case when fewer than k characters remain at the end.
     *
     * Complexity:
     * - Time: O(n) → each character is reversed at most once.
     * - Space: O(n) → due to char[] copy of the string.
     *   (If done on StringBuilder, could be considered O(1) extra space aside from input.)
     */
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;

        for (int i = 0; i < n; i += 2 * k) {
            if (i + k - 1 < n) {
                reverseK(i, i + k - 1, str);
            } else {
                // Fewer than k characters remain
                reverseK(i, n - 1, str);
            }
        }
        return new String(str);
    }

    // Helper method to reverse characters between indices i and j
    private void reverseK(int i, int j, char[] str) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
