/**
 * LeetCode: Binary Tree Maximum Path Sum
 * 
 * Given a non-empty binary tree, find the maximum path sum. 
 * A path is defined as any sequence of nodes where each pair of 
 * adjacent nodes in the sequence has an edge connecting them. 
 * The path must contain at least one node and does not need 
 * to go through the root.
 * 
 * Example:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The path is [15,20,7] with sum 42.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BinaryTreeMaxPathSum {
    // Global variable to track the maximum path sum
    private int maxSum = Integer.MIN_VALUE;

    /**
     * Main function to find the maximum path sum in a binary tree.
     *
     * @param root The root node of the binary tree
     * @return The maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * DFS helper function that computes the maximum path sum starting 
     * from the current node and returns the maximum gain from either 
     * left or right subtree.
     *
     * @param root The current node
     * @return The maximum gain from this node to its parent
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Ignore negative path sums by taking max with 0
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        // Current path sum using both left and right children
        int currMax = leftMax + rightMax + root.val;

        // Update global maximum
        maxSum = Math.max(maxSum, currMax);

        // Return the maximum gain to parent
        return Math.max(leftMax, rightMax) + root.val;
    }
}
