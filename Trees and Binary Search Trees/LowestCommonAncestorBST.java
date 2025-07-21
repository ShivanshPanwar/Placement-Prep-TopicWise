/**
 * Problem: LeetCode 235 - Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Approach:
 * - Since the tree is a Binary Search Tree (BST), we can use its properties:
 *      1. All values in the left subtree are smaller than the root.
 *      2. All values in the right subtree are greater than the root.
 * - Traverse the tree starting from the root:
 *      - If both p and q are smaller than the root, LCA must be in the left subtree.
 *      - If both p and q are greater than the root, LCA must be in the right subtree.
 *      - Otherwise, root is the split point, and hence the Lowest Common Ancestor.
 *
 * Complexity Analysis:
 * - Time Complexity: O(h), where h is the height of the BST.
 *      - Best case: O(log n) for a balanced BST.
 *      - Worst case: O(n) for a skewed BST.
 * - Space Complexity: O(1), iterative solution without extra space.
 */

class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val, qValue = q.val;

        while (root != null) {
            if (pValue < root.val && qValue < root.val) {
                root = root.left; // Both nodes lie in left subtree
            } else if (pValue > root.val && qValue > root.val) {
                root = root.right; // Both nodes lie in right subtree
            } else {
                return root; // Split point: one node is on each side or one equals root
            }
        }
        return null;
    }
}
