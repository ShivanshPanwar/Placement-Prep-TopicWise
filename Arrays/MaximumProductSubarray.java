// Problem: Maximum Product Subarray
// Link: https://leetcode.com/problems/maximum-product-subarray/
// Description: Find the contiguous subarray within an array that has the largest product.
// Approach: Use dynamic tracking of both max and min product at each step.
// Time Complexity: O(n), Space Complexity: O(1)

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currMax = nums[0]; // Stores the current maximum product
        int currMin = nums[0]; // Stores the current minimum product (because negative × negative = positive)
        int max = nums[0];     // Overall max product

        for (int i = 1; i < nums.length; i++) {
            int currElement = nums[i];
            int tempMax = currMax;

            // Update current max and min products including current element
            currMax = Math.max(currElement, Math.max(currMax * currElement, currMin * currElement));
            currMin = Math.min(currElement, Math.min(tempMax * currElement, currMin * currElement));

            // Update overall max
            max = Math.max(max, currMax);
        }

        return max;
    }
}
