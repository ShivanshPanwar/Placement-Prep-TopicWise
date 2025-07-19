/**
 * Description: Generates all possible combinations of k numbers chosen from 1 to n.
 *
 * Approach:
 *  - Use backtracking to build combinations incrementally.
 *  - At each step, add a number from `start` to `n` and recurse to build the next number.
 *  - When the temporary list reaches size `k`, add a deep copy to the result list.
 *
 * Time Complexity:
 *  - O(C(n, k) * k): There are C(n, k) combinations, and copying each combination costs O(k).
 *
 * Space Complexity:
 *  - O(k): The recursion stack and the current combination list use O(k) extra space.
 *
 * Example:
 *  Input: n = 4, k = 2
 *  Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationsGenerator {

    /**
     * Generates all combinations of k numbers out of the range [1, n].
     *
     * @param n The maximum number in the range.
     * @param k The number of elements in each combination.
     * @return A list of all possible combinations.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> bigList = new ArrayList<>();
        helper(1, n, k, bigList, new ArrayList<>());
        return bigList;
    }

    /**
     * Backtracking helper to generate combinations.
     *
     * @param start    The current number to consider adding.
     * @param n        The maximum number in the range.
     * @param k        The desired combination size.
     * @param bigList  The list storing all combinations.
     * @param smallList The current combination being built.
     */
    private void helper(int start, int n, int k, List<List<Integer>> bigList, List<Integer> smallList) {
      // 1. Base case
        if (smallList.size() == k) {
            bigList.add(new ArrayList<>(smallList));
            return;
        }
     // 2. Loop
        for (int i = start; i <= n; i++) {
    //  3. Modifications
            smallList.add(i);
            helper(i + 1, n, k, bigList, smallList);
    // 4. StackFall
            smallList.remove(smallList.size() - 1); // Backtrack
        }
    }
}
