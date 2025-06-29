// Problem: Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Description: Find indices of the two numbers in the array that add up to a specific target.
// Approach: Sort + Two pointers + Track original indices
// Time Complexity: O(n log n), Space Complexity: O(n)

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Make a copy to preserve original indices after sorting
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        int val1 = 0, val2 = 0;

        // Two-pointer approach to find the pair
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                val1 = nums[i];
                val2 = nums[j];
                break;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        // Find original indices of val1 and val2
        int indx1 = -1, indx2 = -1;
        for (i = 0; i < copy.length; i++) {
            if (copy[i] == val1 && indx1 == -1) {
                indx1 = i;
            } else if (copy[i] == val2 && indx2 == -1) {
                indx2 = i;
            }
            if (indx1 != -1 && indx2 != -1) break;
        }

        return new int[]{indx1, indx2};
    }
}
