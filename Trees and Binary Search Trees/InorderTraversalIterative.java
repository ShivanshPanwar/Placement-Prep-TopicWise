import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode #94: Binary Tree Inorder Traversal (Iterative)
 *
 * This solution uses an iterative approach with a stack
 * to perform inorder traversal on a binary tree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit node
            current = stack.pop();
            nodeValues.add(current.val);

            // Traverse right subtree
            current = current.right;
        }

        return nodeValues;
    }

    /*
    // Recursive alternative:
    public void inorder(TreeNode root, List<Integer> nodeValues) {
        if (root != null) {
            inorder(root.left, nodeValues);
            nodeValues.add(root.val);
            inorder(root.right, nodeValues);
        }
    }
    */
}
