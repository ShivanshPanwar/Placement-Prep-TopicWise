// Lowest Common Ancestor of a Binary Tree
// Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//
// Approach:
// - Use a recursive DFS traversal to find the lowest node in the tree that has both p and q as descendants.
// - Base cases:
//      1. If the current node is null → return null.
//      2. If the current node equals p or q → return the current node.
// - Recursively search in the left and right subtrees.
//      1. If both left and right subtrees return non-null, this node is the LCA.
//      2. If one side is null, return the other side.
// - Time Complexity: O(n) as we traverse each node once.
// - Space Complexity: O(h), where h is the height of the tree (due to recursion stack).

class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
