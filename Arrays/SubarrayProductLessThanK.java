// Problem: Subarray Product Less Than K
// Link: https://leetcode.com/problems/subarray-product-less-than-k/
// Description: Count the number of contiguous subarrays where the product of all elements is less than k.
// Approach: Sliding window using two pointers and product.
// Time Complexity: O(n), Space Complexity: O(1)

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink window from the left until product < k
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' with starting index between 'left' and 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }
}
