// Problem: Missing Number
// Link: https://leetcode.com/problems/missing-number/
// Description: Given an array containing n distinct numbers in the range [0, n], find the one number that is missing from the array.
// Approach: Use sum difference technique: total - actual sum
// Time Complexity: O(n), Space Complexity: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }
}
