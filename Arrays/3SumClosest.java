// Problem: 3Sum Closest
// Link: https://leetcode.com/problems/3sum-closest/
// Description: Given an integer array nums and a target value, 
//   find three integers in nums such that their sum is closest to the target.
// Approach: Sort the array and use a fixed pointer plus two-pointer techniques
//   to efficiently scan possible sums.
//   - For each index i, use two pointers (start, end) to get closest triplet.
//   - Update the best sum when a closer one is found.
//   - Early return if exact target hit.
// Time Complexity: O(n²) — sorting is O(n log n), but dominant part is double loop :contentReference[oaicite:1]{index=1}.
// Space Complexity: O(1) extra space (ignoring input), O(log n) for in-place sort recursion stack.

package arrays.threesum;

import java.util.Arrays;

public class Solution {
    /**
     * @param nums   input array
     * @param target the target sum
     * @return the sum of three integers closest to target
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        // Initialize with sum of first three elements
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;

            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];

                // Update closest if current sum is nearer to target
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }

                // Return early if exact match found
                if (currSum == target) {
                    return currSum;
                }

                // Move pointers based on comparison
                if (currSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return closestSum;
    }
}
