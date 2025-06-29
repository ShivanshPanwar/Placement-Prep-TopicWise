// Problem: Rotate Array
// Rotate the array to the right by k steps, where k is non-negative.
// Example: Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Approach: Reverse the entire array, then reverse first k elements, then reverse the rest

class Solution {
    public void rotate(int[] nums, int k) {
        // Take modulo to ensure k is within the bounds of array length
        k = k % nums.length;

        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse elements in the array between two indices
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
