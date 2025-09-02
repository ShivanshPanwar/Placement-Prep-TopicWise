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

/**
 * Approach: Morris Traversal (O(1) space)
 * 
 * The idea is to modify the tree in-place using a variation of Morris Traversal.
 * For each node, if it has a left child:
 *   - Find the rightmost node of the left subtree (predecessor)
 *   - Attach the current node's right subtree to the right of this predecessor
 *   - Move the left subtree to the right
 *   - Set the left child to null
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Each node is visited once.
 * 
 * Space Complexity: O(1), no extra space used (in-place transformation).
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;

                // Find the rightmost node of the left subtree
                while (temp.right != null) {
                    temp = temp.right;
                }

                // Connect the original right subtree to the rightmost node
                temp.right = curr.right;

                // Move the left subtree to the right and nullify the left
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to the next right node
            curr = curr.right;
        }
    }
}
