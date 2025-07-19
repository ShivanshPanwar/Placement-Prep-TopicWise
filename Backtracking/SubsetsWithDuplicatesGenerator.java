/**
 * Description: Generates all unique subsets (the power set) of a given array that may contain duplicates.
 *
 * Approach:
 *  - Sort the input array to ensure duplicates are adjacent.
 *  - Use backtracking to generate subsets, skipping duplicate elements at the same recursive level.
 *  - This avoids generating duplicate subsets without the need for extra `bigList.contains` checks.
 *
 * Time Complexity:
 *  - O(N * 2^N): There are 2^N subsets and copying each subset into the result costs up to O(N).
 *
 * Space Complexity:
 *  - O(N): Auxiliary space used by the recursion stack and the current subset list.
 *
 * Example:
 *  Input: nums = [1, 2, 2]
 *  Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicatesGenerator {

    /**
     * Generates all unique subsets of the given integer array that may contain duplicates.
     *
     * @param nums The input array of integers.
     * @return A list of all unique subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates
        helper(0, bigList, new ArrayList<>(), nums);
        return bigList;
    }

    /**
     * Helper method that uses backtracking to generate unique subsets.
     *
     * @param index     The current index in the nums array.
     * @param bigList   The list storing all generated unique subsets.
     * @param smallList The current subset being built.
     * @param nums      The input array of integers.
     */
    private void helper(int index, List<List<Integer>> bigList, List<Integer> smallList, int[] nums)
  {
       
        if(!bigList.contains(smallList)){
            bigList.add(new ArrayList<>(smallList));
        }

        for(int i=index;i<nums.length;i++){
            //if(!smallList.contains(nums[i])) instead by passing index+1
          
            // Include nums[i] in the current subset
                smallList.add(nums[i]);
                helper(i+1,bigList,smallList,nums);
                // stack fall or  Backtrack to remove the last added element
                smallList.remove(smallList.size()-1);
            }
        }
}
