/**
 * Class: UniquePermutationsGenerator
 * 
 * Problem Statement:
 * Given a collection of integers that might contain duplicates, return all possible 
 * unique permutations in any order.
 *
 * Approach:
 * 1. Sort the array to bring duplicates together.
 * 2. Use backtracking to build all permutations.
 * 3. Maintain a `visited` array to track used elements.
 * 4. Skip duplicates: if `nums[i] == nums[i-1]` and `nums[i-1]` is not visited, skip `nums[i]`.
 *    This ensures we do not generate duplicate permutations.
 *
 * Time Complexity: 
 * - O(N! * N) where N is the length of the array.
 *   - N! permutations and O(N) time to build each permutation.
 *
 * Space Complexity:
 * - O(N) for recursion depth and visited array + O(N! * N) for storing the results.
 */

import java.util.*;

public class UniquePermutationsGenerator {

    /**
     * Generates all unique permutations of the given integer array.
     * 
     * @param nums - input array of integers (may contain duplicates)
     * @return List of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates easily
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    /**
     * Recursive helper method for generating permutations using backtracking.
     *
     * @param result    - Master list storing all unique permutations
     * @param current   - Current permutation being constructed
     * @param nums      - Input array
     * @param visited   - Boolean array indicating if an element is used in current path
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        // Base case: when a full permutation is constructed
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip already visited elements
            if (visited[i]) continue;

            // Skip duplicates: ensure we only use the first occurrence if duplicates are adjacent
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            // Choose the current element
            visited[i] = true;
            current.add(nums[i]);

            // Recurse to build the rest of the permutation
            backtrack(result, current, nums, visited);

            // Backtrack: undo the choice
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
