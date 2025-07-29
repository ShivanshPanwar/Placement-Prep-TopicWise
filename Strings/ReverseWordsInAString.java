/**
 * LeetCode 151: Reverse Words in a String
 *
 * Problem:
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The returned string should have words separated by a single space,
 * with no leading or trailing spaces.
 *
 * Approach:
 * 1. Use `trim()` to remove leading and trailing spaces.
 * 2. Split the string into words using `split("\\s+")`, which splits on one or more spaces.
 * 3. Reverse the array of words in-place using two pointers (i and j).
 * 4. Join the reversed words using a StringBuilder, appending a single space between them.
 * 5. Remove the last extra space using `deleteCharAt`.
 *
 * Time Complexity: O(n)
 *    - Splitting, reversing, and joining all take linear time.
 * Space Complexity: O(n)
 *    - Additional array of words and StringBuilder are used.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        // Split by one or more spaces after trimming
        String[] str = s.trim().split("\\s+");
        
        // Reverse the array of words in-place
        int i = 0, j = str.length - 1;
        while (i <= j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        
        // Join words into a single string
        StringBuilder sb = new StringBuilder();
        for (String st : str) {
            sb.append(st).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1); // remove trailing space
        
        return sb.toString();
    }
}
