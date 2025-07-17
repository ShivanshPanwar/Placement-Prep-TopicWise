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

/**
 * Solution class to determine if a binary tree is symmetric.
 * Supports both recursive and iterative approaches.
 */
public class SymmetricTree {

    /**
     * Iterative approach to check tree symmetry using two queues.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root Root of the binary tree
     * @return true if the tree is symmetric, false otherwise
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root.left);
        q2.add(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            // Enqueue children in opposite order
            q1.add(node1.left);
            q2.add(node2.right);

            q1.add(node1.right);
            q2.add(node2.left);
        }

        return q1.isEmpty() && q2.isEmpty();
    }

    /**
     * Recursive approach to check tree symmetry.
     * Time Complexity: O(N)
     * Space Complexity: O(H) where H is the height of the tree
     *
     * @param root Root of the binary tree
     * @return true if the tree is symmetric, false otherwise
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    /**
     * Helper method for recursion to compare two nodes.
     */
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
