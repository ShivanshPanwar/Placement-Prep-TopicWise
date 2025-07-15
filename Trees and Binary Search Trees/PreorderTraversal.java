import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode #144: Binary Tree Preorder Traversal
 *
 * This class provides both iterative and recursive approaches for performing
 * preorder traversal on a binary tree.
 *
 * Preorder Traversal: Root -> Left -> Right
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    // Iterative Preorder Traversal using Stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            // Push right child first so that left is processed first
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return result;
    }

    /*
    // Recursive Preorder Traversal (Alternative)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }
    */
}
