// Problem: LeetCode 198 - House Robber
// Link: https://leetcode.com/problems/house-robber/

/**
 * Approaches:
 *
 * 1. Top-Down (Memoization):
 *    - Recursively decide whether to rob the current house or skip it.
 *    - Use a cache array to store results for each index to avoid recomputation.
 *    - Transition:
 *        rob(i) = max(nums[i] + rob(i + 2), rob(i + 1))
 *      (rob the current house and skip the next, or skip the current house)
 *    - Time Complexity: O(n) — each house's result is computed once.
 *    - Space Complexity: O(n) — memoization array + recursion stack.
 *
 * 2. Bottom-Up (Tabulation):
 *    - Iteratively compute the maximum amount for each house.
 *    - Base cases:
 *        dp[0] = nums[0]
 *        dp[1] = max(nums[0], nums[1])
 *    - For i >= 2:
 *        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 */

import java.util.Arrays;

public class HouseRobber {

    // Approach 1: Top-Down (Memoization)
    public int robMemoization(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return helper(nums, cache, 0);
    }

    private int helper(int[] nums, int[] cache, int houseNo) {
        if (houseNo >= nums.length) return 0;
        if (cache[houseNo] != -1) return cache[houseNo];

        // Choice 1: Rob this house, then skip next
        int choice1 = nums[houseNo] + helper(nums, cache, houseNo + 2);

        // Choice 2: Skip this house, move to next
        int choice2 = helper(nums, cache, houseNo + 1);

        cache[houseNo] = Math.max(choice1, choice2);
        return cache[houseNo];
    }

    // Approach 2: Bottom-Up (Tabulation)
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
