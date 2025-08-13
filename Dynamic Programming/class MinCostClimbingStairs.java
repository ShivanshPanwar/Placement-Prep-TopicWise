/**
 * Problem: Min Cost Climbing Stairs (LeetCode 746)
 * 
 * You are given an integer array cost where cost[i] is the cost of the i-th step.
 * Once you pay the cost, you can climb either one or two steps.
 * 
 * You can start from step 0 or step 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * ----------------------------------------------------
 * Approach:
 * ----------------------------------------------------
 * 1. This is a Dynamic Programming (DP) problem.
 * 2. Let dp[i] represent the minimum cost to reach step i.
 * 3. Base cases:
 *      - dp[0] = 0 → cost to stand on ground (before step 0) is 0.
 *      - dp[1] = 0 → cost to start at step 1 without climbing is also 0.
 * 4. Transition:
 *      - To reach step i, you can either:
 *          a) Take 1 step from (i-1) → dp[i-1] + cost[i-1]
 *          b) Take 2 steps from (i-2) → dp[i-2] + cost[i-2]
 *        Choose the minimum of these two options:
 *        dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
 * 5. Final answer is dp[n], where n is cost.length (the "top" position).
 * 
 * ----------------------------------------------------
 * Complexity Analysis:
 * ----------------------------------------------------
 * Time Complexity:  O(n)  → One pass through the array
 * Space Complexity: O(n)  → DP array of size n+1
 */

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // dp[i] stores minimum cost to reach step i
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        // Fill dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(
                dp[i - 1] + cost[i - 1], // From step (i-1)
                dp[i - 2] + cost[i - 2]  // From step (i-2)
            );
        }

        return dp[n];
    }
}
