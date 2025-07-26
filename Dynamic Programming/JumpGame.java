/**
 * LeetCode 55: Jump Game
 *
 * Approach: Top-Down Dynamic Programming with Memoization
 *
 * We use recursion with memoization to determine if we can reach the last index.
 * At each position, we try all possible jumps (1 to nums[index]) and check if any
 * leads to the end. We store results in `cache` to avoid recomputation:
 *  - cache[i] = 1 means index `i` can reach the end.
 *  - cache[i] = -1 means index `i` cannot reach the end.
 *
 * Time Complexity: O(n^2) in the worst case (for each index, we may try up to nums[i] jumps),
 * but with memoization many subproblems are skipped.
 * Space Complexity: O(n) for the recursion stack and memoization array.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] cache = new int[nums.length]; // 0 = unknown, 1 = reachable, -1 = not reachable
        return canReach(nums, 0, cache);
    }

    private boolean canReach(int[] nums, int index, int[] cache) {
        // Base case: reached the last index
        if (index == nums.length - 1) {
            return true;
        }

        // Return memoized result if available
        if (cache[index] != 0) {
            return cache[index] == 1;
        }

        int maxJump = nums[index];
        // Try all jumps from current position
        for (int step = 1; step <= maxJump; step++) {
            if (canReach(nums, index + step, cache)) {
                cache[index] = 1; // Mark as reachable
                return true;
            }
        }

        cache[index] = -1; // Mark as not reachable
        return false;
    }
}
