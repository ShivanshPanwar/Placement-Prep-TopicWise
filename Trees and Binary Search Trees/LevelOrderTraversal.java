import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode #102: Binary Tree Level Order Traversal
 *
 * This class provides a method to perform level-order traversal (BFS) on a binary tree.
 * It returns a list of lists, where each inner list contains all the node values at a specific level.
 *
 * Time Complexity: O(n) - where n is the number of nodes in the binary tree
 * Space Complexity: O(n) - for storing output and queue
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: If root is null, return empty list
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  // Start with root node

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at current level
            List<Integer> currentLevel = new ArrayList<>();

            // Traverse all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);

                // Add left and right children to queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // Add the current level to the final result
            result.add(currentLevel);
        }

        return result;
    }
}
