/**
 * Problem: LeetCode 202 - Happy Number
 * Link: https://leetcode.com/problems/happy-number/
 * 
 * Approach:
 * - Use a HashSet to detect cycles.
 * - Repeatedly replace the number with the sum of the squares of its digits.
 * - If the sum becomes 1, the number is happy.
 * - If the sum is already in the set, a cycle is detected — not a happy number.
 * 
 * Time Complexity: O(logN) per iteration, with typically O(1) overall iterations due to cycle behavior.
 * Space Complexity: O(logN) for the set storing intermediate results.
 */

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            int sum = 0;

            // Compute sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            if (sum == 1) {
                return true; // It's a happy number
            }

            if (set.contains(sum)) {
                return false; // Cycle detected
            }

            set.add(sum);
            n = sum;
        }
    }
}
