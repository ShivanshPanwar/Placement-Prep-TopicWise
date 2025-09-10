/**
 * Problem: Best Time to Buy and Sell Stock III
 * LeetCode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Approach:
 * We are allowed at most two transactions (buy + sell).
 *
 * - Maintain 4 states:
 *   1. buy1  -> Max profit after first buy
 *   2. sell1 -> Max profit after first sell
 *   3. buy2  -> Max profit after second buy (reinvest profit from sell1)
 *   4. sell2 -> Max profit after second sell
 *
 * - Iterate through prices and update these states:
 *   - buy1  = max(buy1, -price)
 *   - sell1 = max(sell1, buy1 + price)
 *   - buy2  = max(buy2, sell1 - price)
 *   - sell2 = max(sell2, buy2 + price)
 *
 * - Final answer is sell2 (max profit after at most two transactions).
 *
 * Time Complexity: O(n)   (single pass through prices)
 * Space Complexity: O(1)  (constant extra variables)
 */

class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);          // Best option after first buy
            sell1 = Math.max(sell1, buy1 + price);  // Best option after first sell
            buy2 = Math.max(buy2, sell1 - price);   // Best option after second buy
            sell2 = Math.max(sell2, buy2 + price);  // Best option after second sell
        }

        return sell2;
    }
}
