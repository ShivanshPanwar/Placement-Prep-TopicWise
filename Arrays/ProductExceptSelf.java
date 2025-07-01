// Problem: Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/
// Description: Return an array where each element is the product of all elements except itself.
// Constraint: Do not use division and solve in O(n) time.
// Approach: Use prefix and suffix arrays to calculate product on both sides.
// Time Complexity: O(n), Space Complexity: O(n)

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        // Fill left[] such that left[i] contains product of all elements to the left of i
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        // Fill right[] such that right[i] contains product of all elements to the right of i
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Multiply left and right for the final result
        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}
