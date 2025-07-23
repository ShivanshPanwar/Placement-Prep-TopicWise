// Problem: LeetCode 70 - Climbing Stairs
// Link: https://leetcode.com/problems/climbing-stairs/

/**
 * Approaches:
 *
 * 1. Bottom-Up (Tabulation):
 *    - Uses an iterative DP array where dp[i] represents the number of distinct ways to reach step i.
 *    - Base cases:
 *        dp[0] = 1 (1 way to stay at the ground)
 *        dp[1] = 1 (1 way to reach the first step)
 *    - For each step i >= 2:
 *        dp[i] = dp[i - 1] + dp[i - 2]
 *      (we can reach i from i-1 by taking 1 step or from i-2 by taking 2 steps).
 *    - Time Complexity: O(n) — we compute values for all steps up to n.
 *    - Space Complexity: O(n) — DP array of size n+1.
 *
 * 2. Top-Down (Memoization):
 *    - Solves the problem recursively with memoization to store already computed results.
 *    - Base cases:
 *        climb(0) = 1
 *        climb(1) = 1
 *    - For n >= 2:
 *        climb(n) = climb(n - 1) + climb(n - 2)
 *    - Time Complexity: O(n) — each subproblem solved once.
 *    - Space Complexity: O(n) — memoization array + recursion stack.
 */

import java.util.Arrays;

public class ClimbingStairs {

    // Approach 1: Bottom-Up (Tabulation)
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*
    // Approach 2: Top-Down (Memoization)
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climb(n, memo);
    }

    private int climb(int n, int[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n]; // already computed

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }
    */
}
