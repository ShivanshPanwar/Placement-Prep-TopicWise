import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode #145: Binary Tree Postorder Traversal
 *
 * This class implements postorder traversal of a binary tree using both iterative and recursive approaches.
 * 
 * Postorder Traversal: Left -> Right -> Root
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    // Iterative Postorder Traversal using one stack and pointer nullification
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // If both left and right are null, process the node
            if (node.left == null && node.right == null) {
                result.add(stack.pop().val);
            } else {
                // Push right child first, then left child, nullify pointers to prevent re-processing
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }

        return result;
    }

    /*
    // Recursive Postorder Traversal (Alternative)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }
    */
}
