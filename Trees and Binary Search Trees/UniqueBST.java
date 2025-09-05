/**
 * Approach:
 * This problem is about finding the number of unique Binary Search Trees (BSTs) 
 * that can be formed with `n` distinct nodes labeled from 1 to n.
 *
 * The solution uses **Dynamic Programming** with the concept of **Catalan Numbers**.
 * 
 * - Let `dp[i]` represent the number of unique BSTs that can be formed using `i` nodes.
 * - Base Cases:
 *   dp[0] = 1 (empty tree)
 *   dp[1] = 1 (single node tree)
 * - Transition:
 *   For each number `i` (nodes count), consider each node `j` as root (from 0 to i-1):
 *     left subtree size = j
 *     right subtree size = i - j - 1
 *   Hence,
 *     dp[i] += dp[j] * dp[i - j - 1]
 *
 * This ensures we count all possible distributions of nodes in left and right subtrees.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }
}
