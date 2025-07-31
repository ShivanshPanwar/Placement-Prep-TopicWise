/**
 * Problem: LeetCode 231 - Power of Two
 * Link: https://leetcode.com/problems/power-of-two/
 * 
 * Approach:
 * - Try all powers of 2 from 2^1 to 2^30 (as 2^31 > Integer.MAX_VALUE).
 * - Use Math.pow to compute powers and compare with the input n.
 * - Special case: return true if n == 1 (i.e., 2^0).
 * 
 * Note: Although this works, a more optimal solution uses bit manipulation:
 *   return n > 0 && (n & (n - 1)) == 0;
 * 
 * Time Complexity: O(1) — loop runs at most 30 times.
 * Space Complexity: O(1)
 */

import java.util.*;

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int ans = 1;
        int base = 2;

        if (n == 1) {
            return true;
        }

        for (int i = 1; i <= 30; i++) {
            ans = (int) Math.pow(base, i);
            if (ans == n) {
                return true;
            }
        }

        return false;
    }
}
