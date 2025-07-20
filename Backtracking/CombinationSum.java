// Combination Sum - Backtracking Approach
// Problem: Find all unique combinations of candidates where the chosen numbers sum to the target.
// The same number may be chosen unlimited times.
// Time Complexity: O(2^n) in worst case (exponential), as each element can be included or excluded.
// Space Complexity: O(k) for recursion stack and temporary lists (k = average combination length).

import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        helper(candidates, target, 0, smallList, bigList);
        return bigList;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> smallList, List<List<Integer>> bigList) {
        if (target == 0) { // Found a valid combination
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        if (target < 0) { // Sum exceeded target
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            smallList.add(candidates[i]); // Choose current candidate
            helper(candidates, target - candidates[i], i, smallList, bigList); // Not i+1 because we can reuse same element
            smallList.remove(smallList.size() - 1); // Backtrack
        }
    }
}
