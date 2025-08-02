// Class to calculate the maximum profit from stock prices using a greedy approach
class BuySellStockII {

    /**
     * Calculates the maximum profit by buying and selling stocks multiple times.
     * 
     * Approach:
     * - Traverse the array of prices.
     * - If the price today is higher than yesterday, buy yesterday and sell today.
     * - Sum all such profitable differences to maximize total profit.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param prices Array representing the stock price on each day
     * @return Maximum profit achievable
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Accumulate profit if there's an increase in price
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
