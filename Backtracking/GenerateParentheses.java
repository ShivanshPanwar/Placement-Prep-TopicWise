import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * Approach:
 * - Use recursive backtracking to build all valid strings.
 * - Keep track of the count of opening and closing parentheses used so far.
 * - At each step:
 *      1. Add '(' if we still have opening parentheses available (opening < n).
 *      2. Add ')' if it won’t exceed the number of opening ones (closing < opening).
 * - When the length of the current string reaches 2 * n, add it to the result.
 *
 * Complexity Analysis:
 * - Time Complexity: O(4^n / √n)
 *      Catalan number Cn represents the number of valid combinations.
 *      Roughly grows as ~O(4^n / (n * √n)).
 * - Space Complexity: O(4^n / √n) for storing results + O(n) for recursion stack.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, 0, result, n, "");
        return result;
    }

    private void helper(int opening, int closing, int index, List<String> result, int n, String str) {
        // Base Case: if the constructed string has used all parentheses
        if (index == n * 2) {
            result.add(str);
            return;
        }

        // Try adding an opening parenthesis if we still have some left
        if (opening < n) {
            helper(opening + 1, closing, index + 1, result, n, str + '(');
        }

        // Try adding a closing parenthesis if it won't exceed the number of opening ones
        if (closing < opening) {
            helper(opening, closing + 1, index + 1, result, n, str + ')');
        }
    }
}
