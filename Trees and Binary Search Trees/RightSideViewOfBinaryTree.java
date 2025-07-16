// LeetCode Problem: Right Side View of Binary Tree

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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Edge case: if tree is empty
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level-order traversal (BFS)
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Traverse each level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // Capture the first node at each level (from the right)
                if (i == 0) {
                    result.add(curr.val);
                }

                // Push right child first, then left, to get rightmost view
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }

        return result;
    }
}
