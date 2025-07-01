// Problem: Find Pivot Index
// Link: https://leetcode.com/problems/find-pivot-index/
// Description: Find the index where the sum of elements to the left is equal to the sum of elements to the right.
// Approach: Use total sum and track left sum while traversing
// Time Complexity: O(n), Space Complexity: O(1)

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Step 1: Compute total sum of the array
        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;

        // Step 2: Traverse and check if leftSum == rightSum at each index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1; // No pivot index found
    }
}
