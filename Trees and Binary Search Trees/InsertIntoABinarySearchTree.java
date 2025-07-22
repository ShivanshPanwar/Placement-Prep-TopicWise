// Problem: LeetCode 701 - Insert into a Binary Search Tree
// Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
 *
 * Approach:
 * We insert a new node into the BST while maintaining BST properties.
 *
 * Recursive Approach:
 * - Base case: if root is null, create and return a new node.
 * - Recur left if val < root.val; else recur right.
 * - Return root to preserve tree connections.
 *
 * Iterative Approach:
 * - Traverse the tree until the correct null position is found.
 * - Insert the new node without recursion.
 *
 * Time Complexity: O(h), where h is the tree height (O(log n) for balanced BST, O(n) for skewed tree).
 * Space Complexity: 
 * - Recursive: O(h) for call stack.
 * - Iterative: O(1).
 */

public class InsertIntoABinarySearchTree {

    // Recursive approach
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val); // insertion point found
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val); // insert into left subtree
        } else {
            root.right = insertIntoBST(root.right, val); // insert into right subtree
        }

        return root; // return root to keep tree connections intact
    }

    // Iterative approach
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    current = current.right;
                }
            }
        }

        return root;
    }
}
