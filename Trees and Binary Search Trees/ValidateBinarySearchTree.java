// LeetCode 98: Validate Binary Search Tree
// Link: https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Approach 1: Recursive DFS with range validation
 * ------------------------------------------------
 * - For each node, maintain a valid range (min, max).
 * - Check if the node's value lies strictly between min and max.
 * - Recursively validate left and right subtrees with updated ranges:
 *      - Left subtree: max value becomes current node value.
 *      - Right subtree: min value becomes current node value.
 * 
 * Why use long for min/max?
 * - To handle edge cases where node values equal Integer.MIN_VALUE or Integer.MAX_VALUE.
 * - Prevents incorrect comparisons due to overflow.
 * 
 * Time Complexity: O(n), where n is the number of nodes (each node visited once).
 * Space Complexity: O(h), where h is the tree height (recursion stack).
 */
class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;

        // Current node must be strictly within the range
        if (root.val <= min || root.val >= max) return false;

        // Validate left and right subtrees
        return helper(root.left, min, root.val) &&
               helper(root.right, root.val, max);
    }
}

/**
 * Approach 2: Iterative Inorder Traversal
 * ----------------------------------------
 * - Inorder traversal of a BST yields a strictly increasing sequence.
 * - Perform iterative inorder traversal using a stack.
 * - Keep track of the previous node value; ensure current > previous.
 * 
 * Time Complexity: O(n) (each node is processed once).
 * Space Complexity: O(h), where h is the tree height (stack).
 */
class ValidateBinarySearchTreeIterative {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        long prev = Long.MIN_VALUE;

        while (current != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            // Check if current node's value is greater than the previous node's value
            if (current.val <= prev) return false;
            prev = current.val;

            // Move to right subtree
            current = current.right;
        }

        return true;
    }
}
