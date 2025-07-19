/**
 * Description: Generates all possible subsets (the power set) of a given array using backtracking.
 * 
 * Approach:
 *  - Uses backtracking to explore all combinations of elements.
 *  - At each recursive call, the current subset (smallList) is added to the result (bigList).
 *  - For each element, we have two choices: include it or skip it.
 *  - The recursion explores all branches systematically by incrementing the index.
 *
 * Time Complexity:
 *  - O(N * 2^N): There are 2^N subsets and copying each subset into the result costs up to O(N).
 *
 * Space Complexity:
 *  - O(N): Auxiliary space used by the recursion stack and the current subset list.
 * 
 * Example:
 *  Input: nums = [1,2,3]
 *  Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
 */
import java.util.ArrayList;
import java.util.List;

public class SubsetsGenerator {

    /**
     * Generates all subsets of the given integer array.
     *
     * @param nums The input array of integers.
     * @return A list of all subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        helper(0, bigList, new ArrayList<>(), nums);
        return bigList;
    }

    /**
     * Helper method that uses backtracking to generate subsets.
     *
     * @param index     The current index in the nums array.
     * @param bigList   The list storing all generated subsets.
     * @param smallList The current subset being built.
     * @param nums      The input array of integers.
     */
    private void helper(int index, List<List<Integer>> bigList, List<Integer> smallList, int[] nums) {
      // fake base case
        if(smallList.size()>nums.length){
            return ;
        }
      
        bigList.add(new ArrayList<>(smallList));

        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in the current subset
            smallList.add(nums[i]);
            helper(i + 1, bigList, smallList, nums);
            // Backtrack: remove the last added element or simpy stack fall
            smallList.remove(smallList.size() - 1);
        }
    }
}
