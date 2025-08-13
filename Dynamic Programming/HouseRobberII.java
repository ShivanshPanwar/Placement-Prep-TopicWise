/**
 * Problem: House Robber II (LeetCode 213)
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, but adjacent houses 
 * have security systems connected, so robbing two adjacent houses will 
 * alert the police.
 * 
 * This time, the houses are arranged in a circle, meaning the first and 
 * last houses are also adjacent.
 * 
 * Goal: Return the maximum amount of money you can rob without alerting the police.
 */

class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge cases: if there's only 1 or 2 houses
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        /**
         * Approach:
         * Since the houses are in a circle, we cannot rob both the first and last house.
         * So, we consider two scenarios:
         * 1. Rob houses from index 0 to n-2 (exclude last house)
         * 2. Rob houses from index 1 to n-1 (exclude first house)
         * The answer is the maximum of these two scenarios.
         */

        // Scenario 1: Skip the last house
        int choice1 = helper(nums, 0, n - 2);

        // Scenario 2: Skip the first house
        int choice2 = helper(nums, 1, n - 1);

        return Math.max(choice1, choice2);
    }

    /**
     * Helper function to solve the linear version of House Robber problem
     * using space optimization.
     * 
     * @param nums   Array of money in each house
     * @param start  Start index of the range to rob
     * @param end    End index of the range to rob
     * @return       Maximum money that can be robbed in the given range
     */
    private int helper(int[] nums, int start, int end) {
        int prev2 = 0; // Max loot before previous house
        int prev1 = 0; // Max loot till previous house
        int ans = 0;

        for (int i = start; i <= end; i++) {
            ans = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }
}
