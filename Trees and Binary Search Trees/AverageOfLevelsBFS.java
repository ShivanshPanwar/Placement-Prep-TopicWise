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
 */

import java.util.*;

public class AverageOfLevelsBFS {

    /**
     * Computes the average value of nodes on each level in a binary tree.
     * Approach: Breadth-First Search (Level Order Traversal).
     *
     * @param root the root of the binary tree
     * @return a list of average values for each level
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        // Edge case: if the tree is empty
        if (root == null) {
            return averages;
        }

        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse each level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at current level
            double sum = 0.0;

            // Process all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                // Add child nodes of current node to the queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // Compute average and add to the result list
            averages.add(sum / levelSize);
        }

        return averages;
    }
}
