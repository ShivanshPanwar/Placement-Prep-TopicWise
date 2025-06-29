// Problem: Maximum Subarray (Kadane's Algorithm)
// Link: https://leetcode.com/problems/maximum-subarray/
// Description: Find the contiguous subarray with the largest sum.
// Approach: Kadane's Algorithm – track running sum and update maximum
// Time Complexity: O(n), Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize sum and max with the first element
        int sum = nums[0];
        int max = nums[0];

        // Loop through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            // Either continue the subarray or start fresh from current element
            sum = Math.max(nums[i], sum + nums[i]);

            // Update the global max if current sum is greater
            max = Math.max(max, sum);
        }

        return max;
    }
}
