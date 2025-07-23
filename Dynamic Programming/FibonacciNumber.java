// Problem: LeetCode 509 - Fibonacci Number
// Link: https://leetcode.com/problems/fibonacci-number/

/**
 * Approaches:
 *
 * 1. Top-Down (Memoization):
 *    - Uses recursion with a cache (HashMap) to store already computed results.
 *    - Avoids redundant calculations by reusing results.
 *    - Time Complexity: O(n) — each Fibonacci number is computed once.
 *    - Space Complexity: O(n) — due to recursion stack + HashMap.
 *
 * 2. Bottom-Up (Tabulation):
 *    - Iteratively builds the Fibonacci sequence from 0 to n.
 *    - Stores all intermediate values in an array.
 *    - Time Complexity: O(n) — iterates once from 2 to n.
 *    - Space Complexity: O(n) — uses an array of size n+1.
 *
 * Note: The tabulation method is generally faster than memoization due to no recursion overhead.
 */

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    // Approach 2: Bottom-Up (Tabulation Method) — Faster than Memoization
    public int fib(int n) {
        if (n <= 1) return n;

        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

    /*
    // Approach 1: Top-Down (Memoization)
    Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, fib(n - 1) + fib(n - 2));
        return cache.get(n);
    }
    */
}
