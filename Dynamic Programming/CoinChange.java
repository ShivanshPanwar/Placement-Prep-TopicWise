import java.util.Arrays;

class CoinChange {
    /**
     * Coin Change Problem (LeetCode 322)
     * ----------------------------------
     * Approach: Dynamic Programming (Bottom-Up / Tabulation)
     *
     * Idea:
     * - Use a DP array where dp[i] = minimum coins needed to form amount i.
     * - Initialize with a sentinel value (amount + 1, acting as "infinity").
     * - dp[0] = 0 since 0 coins are needed to form amount 0.
     * - For each amount i, try every coin and update dp[i] accordingly.
     *
     * Time Complexity: O(amount × n) 
     *   - n = number of coins
     *   - For each amount, we iterate over all coins.
     *
     * Space Complexity: O(amount) 
     *   - We only store results for each amount up to target.
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;  // sentinel "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0;  // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
