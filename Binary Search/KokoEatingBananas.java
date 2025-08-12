/**
 * Problem: Koko Eating Bananas (LeetCode #875)
 * 
 * Given an array piles where piles[i] represents the number of bananas in the i-th pile,
 * and an integer h representing the total hours Koko has to eat all the bananas,
 * find the minimum integer k (bananas/hour) such that she can eat all bananas within h hours.
 * 
 * Approach:
 * - Use Binary Search between 1 and the maximum pile size to find the smallest eating speed k.
 * - For a given k, calculate the total hours required using ceiling division.
 * - If total hours <= h, try smaller k; otherwise, increase k.
 * 
 * Time Complexity: O(n log m)
 *    - n = number of piles
 *    - m = max pile size
 * Space Complexity: O(1)
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize binary search boundaries
        int left = 1; // Avoid division by zero
        int right = 0;

        // Find maximum pile size
        for (int bananas : piles) {
            right = Math.max(bananas, right);
        }

        // Binary search for minimum eating speed
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            // Calculate hours needed at speed mid
            for (int bananas : piles) {
                hours += (bananas + mid - 1) / mid; // Ceiling division
            }

            if (hours <= h) {
                right = mid; // Try smaller k
            } else {
                left = mid + 1; // Increase k
            }
        }

        return left; // Minimum k that works
    }
}
