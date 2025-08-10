public class MinEatingSpeed {
    /**
     * Approach:
     * 1. The eating speed (k) can range from 1 banana/hour to the size of the largest pile.
     * 2. We perform binary search over this range to find the minimum k that allows finishing
     *    all piles within h hours.
     * 3. For a given k (mid in binary search), compute the total hours needed:
     *      hours += ceil(pile / k) for each pile.
     *    This is computed efficiently as (pile + k - 1) / k to avoid floating-point math.
     * 4. If total hours <= h, try a smaller k (move right bound down).
     *    Otherwise, increase k (move left bound up).
     * 5. When left == right, we have found the smallest k satisfying the condition.
     *
     * Complexity:
     * - Let n = number of piles, m = max pile size.
     * - Time: O(n log m)
     *   (binary search over [1, m] takes log m steps, each step iterates over n piles)
     * - Space: O(1) (constant extra space)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum possible eating speed
        int right = 0; // maximum pile size

        // Find the largest pile to set the search range
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        // Binary search to find the smallest k
        while (left < right) {
            int mid = left + (right - left) / 2; // candidate speed
            int hours = 0;

            // Compute total hours needed at speed mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }

            if (hours <= h) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need faster speed
            }
        }
        return left;
    }
}
