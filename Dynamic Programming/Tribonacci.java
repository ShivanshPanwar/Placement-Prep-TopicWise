public class Tribonacci {

    /**
     * Approach 1: Memoization (Top-Down DP)
     * 
     * Recursively computes Tribonacci numbers and caches results.
     * T(n) = T(n-1) + T(n-2) + T(n-3)
     * 
     * Time Complexity: O(n) - each number computed once.
     * Space Complexity: O(n) - recursion stack + memo array.
     */
    public int tribonacciMemo(int n) {
        int[] memo = new int[n + 1];
        // Initialize with -1 (meaning "not computed")
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // If already computed, return cached value
        if (memo[n] != -1) return memo[n];

        // Compute and store result
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        return memo[n];
    }

    /**
     * Approach 2: Tabulation (Bottom-Up DP)
     * 
     * Iteratively fills an array from base cases up to n.
     * 
     * Time Complexity: O(n) - loop runs n-2 times.
     * Space Complexity: O(n) - to store Tribonacci values.
     */
    public int tribonacciTabulation(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    /**
     * Approach 3: Space Optimized Tabulation
     * 
     * Uses only three variables to store the last three Tribonacci values.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - constant space.
     */
    public int tribonacciOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return c;
    }
}
