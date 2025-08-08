/**

 * Approach:
 * - Binary Search on answer space [max(weights), sum(weights)]
 * - Greedily check if we can ship within 'days' using current capacity
 * - If yes, try smaller capacity; else increase capacity
 *
 * Time Complexity: O(N × log(S - M)), where
 *   - N is number of weights
 *   - S is sum of weights (right bound)
 *   - M is max weight (left bound)
 * Space Complexity: O(1)
 */

public class PackageShipper {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0, maxWeight = 0;

        // Determine binary search boundaries
        for (int w : weights) {
            totalWeight += w;
            maxWeight = Math.max(maxWeight, w);
        }

        while (maxWeight < totalWeight) {
            int capacity = maxWeight + (totalWeight - maxWeight) / 2;

            if (canShip(weights, days, capacity)) {
                totalWeight = capacity; // Try smaller capacity
            } else {
                maxWeight = capacity + 1; // Increase capacity
            }
        }

        return maxWeight;
    }

    // Helper to check if shipping is possible with given capacity
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0, dayCount = 1;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                currentLoad = 0;
                dayCount++;
            }
            currentLoad += w;
        }

        return dayCount <= days;
    }
}
