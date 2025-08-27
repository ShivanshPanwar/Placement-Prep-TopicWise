/**
 * Approach:
 * 
 * To delete a node from a Binary Search Tree (BST), there are three cases to handle:
 * 
 * 1. The node to be deleted is a leaf node (no children) - simply remove it by returning null.
 * 2. The node has only one child - replace the node with its child.
 * 3. The node has two children - replace the node's value with the smallest value in the right subtree (inorder successor), 
 *    then delete that smallest node from the right subtree.
 * 
 * The algorithm:
 * - Recursively traverse the tree to find the node with the given key.
 * - Apply the appropriate deletion strategy based on the node's children.
 */

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found - handle deletion
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node has two children
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
