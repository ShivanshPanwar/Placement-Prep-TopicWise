// LeetCode 740: Delete and Earn
// Link: https://leetcode.com/problems/delete-and-earn/

/**
 * Approach:
 * This problem is similar to "House Robber".
 * - If you choose a number i, you must delete i-1 and i+1.
 * - First, convert nums[] into points[], where points[i] = i * frequency of i.
 * - Now the problem reduces to: maximize sum by either:
 *      1. Taking points[i] + solution of i-2 (skip i-1)
 *      2. Skipping i and taking solution of i-1.
 *
 * We solve this using recursion with memoization (Top-Down DP).
 *
 * Time Complexity: O(n + m) 
 *      - n = nums.length to build points[]
 *      - m = max(nums) to compute DP
 * Space Complexity: O(m) for points[] + O(m) for dp[] + recursion stack
 */

class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        // Step 1: Find the maximum number in nums
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Step 2: Create points array where points[i] = total points earned by taking all i's
        int[] points = new int[max + 1];
        for (int x : nums) {
            points[x] += x;
        }

        // Step 3: Memoization array
        Integer[] dp = new Integer[max + 1];

        // Step 4: Solve using helper function
        return helper(points, max, dp);
    }

    private int helper(int[] points, int i, Integer[] dp) {
        // Base cases
        if (i == 0) return points[0];
        if (i == 1) return Math.max(points[0], points[1]);

        // Return already computed result
        if (dp[i] != null) return dp[i];

        // Choice 1: Skip i -> take solution up to i-1
        // Choice 2: Take i -> add points[i] and skip i-1 (move to i-2)
        dp[i] = Math.max(helper(points, i - 1, dp), helper(points, i - 2, dp) + points[i]);
        return dp[i];
    }
}
