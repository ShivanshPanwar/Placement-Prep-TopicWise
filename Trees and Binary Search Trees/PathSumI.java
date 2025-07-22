// Problem: LeetCode 112 - Path Sum
// Link: https://leetcode.com/problems/path-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Approach:
 * We recursively check if there exists a root-to-leaf path whose sum equals targetSum.
 * - Subtract the current node's value from targetSum and check left and right subtrees.
 * - Base case: if we reach a leaf node and targetSum == node's value, return true.
 *
 * Iterative approach (using Stack) can also be used to avoid recursion.
 *
 * Time Complexity: O(n) — we visit each node once.
 * Space Complexity: O(h) — recursion stack or stack size, where h is the tree height.
 */

import javafx.util.Pair;
import java.util.Stack;

public class PathSumI {

    // Recursive approach
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Leaf node check
        if (root.left == null && root.right == null && root.val == targetSum) return true;

        // Recur for left and right subtrees with updated targetSum
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /*
    // Iterative approach
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode currNode = curr.getKey();
            int sum = curr.getValue();

            if (currNode.left == null && currNode.right == null && targetSum == sum) {
                return true;
            }

            if (currNode.right != null) {
                stack.push(new Pair<>(currNode.right, sum + currNode.right.val));
            }
            if (currNode.left != null) {
                stack.push(new Pair<>(currNode.left, sum + currNode.left.val));
            }
        }
        return false;
    }
    */
}
