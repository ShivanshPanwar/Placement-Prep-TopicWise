/**
 * LeetCode 124. Binary Tree Maximum Path Sum
 *
 * Approach:
 * 1. Use DFS to compute the maximum path sum for any node.
 * 2. At each node, calculate the max contribution from its left and right children.
 *    - Negative sums are ignored (treated as 0).
 * 3. Update a global variable `maxSum` to store the maximum path sum found so far.
 * 4. Return the maximum gain of one branch (left or right) to propagate up the tree.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(h), where h is the height of the tree (stack space).
 */

class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // Ignore negative contributions
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        // Max path passing through this node
        int currentMax = root.val + leftMax + rightMax;

        // Update global maximum
        maxSum = Math.max(maxSum, currentMax);

        // Return max gain for one side path
        return root.val + Math.max(leftMax, rightMax);
    }
}
