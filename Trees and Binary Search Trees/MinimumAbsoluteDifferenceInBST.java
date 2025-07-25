// Problem: LeetCode 530 - Minimum Absolute Difference in BST
// Link: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

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

import java.util.*;

public class MinimumAbsoluteDifferenceInBST {

    /**
     * Approach 1: Recursive In-order Traversal
     * - Perform an in-order traversal (Left → Node → Right) since BST gives sorted values.
     * - Keep track of the previous node value and compute the difference with the current node.
     * - Maintain the minimum difference found so far.
     *
     * Time Complexity: O(n) - we visit all nodes once.
     * Space Complexity: O(h) - recursive stack, where h is the height of the tree.
     */
    private int minDifference = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return minDifference;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (prev != null) {
            minDifference = Math.min(minDifference, root.val - prev);
        }
        prev = root.val;

        helper(root.right);
    }

    /**
     * Approach 2: Iterative In-order Traversal
     * - Use a stack to simulate in-order traversal.
     * - Track previous node value and update the minimum difference.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(h) - for the stack.
     */
    public int getMinimumDifferenceIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer prevValue = null;
        int minDiff = Integer.MAX_VALUE;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (prevValue != null) {
                minDiff = Math.min(minDiff, current.val - prevValue);
            }
            prevValue = current.val;

            current = current.right;
        }

        return minDiff;
    }
}
