import java.util.*;

/**
 * LeetCode #103: Binary Tree Zigzag Level Order Traversal
 *
 * This solution performs a level-order traversal (BFS) and reverses the list of nodes
 * at every alternate level to achieve zigzag order.
 *
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(n) for the queue and result list
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true; // Controls direction of zigzag

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Traverse the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                currentLevel.add(node.val);

                // Add children for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse the current level if we are moving right to left
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; // Flip direction for next level
        }

        return result;
    }
}
