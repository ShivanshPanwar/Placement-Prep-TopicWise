// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Description: Find the maximum profit you can achieve from a single buy and sell.
// Approach: Track the minimum price so far and calculate the maximum possible profit on the go.
// Time Complexity: O(n), Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Found a lower buying price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Sell here for max profit
            }
        }

        return maxProfit;
    }
}
