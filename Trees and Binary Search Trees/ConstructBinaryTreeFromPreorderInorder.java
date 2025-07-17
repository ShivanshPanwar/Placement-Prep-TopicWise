// LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
// Time Complexity: O(N)
// Space Complexity: O(N) for hashmap + recursion stack

import java.util.HashMap;

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

public class ConstructBinaryTreeFromPreorderInorder {

    // HashMap to store value -> index mappings for inorder traversal
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    
    // Pointer to track current root in preorder array
    private int preorderIndex = 0;

    /**
     * Main function to build the binary tree.
     * @param preorder Preorder traversal of the tree
     * @param inorder Inorder traversal of the tree
     * @return Root of the constructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Populate hashmap for fast lookup of root index in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    /**
     * Recursive helper to build subtree from inorder[start..end]
     * @param preorder Preorder traversal array
     * @param start Start index in inorder traversal
     * @param end End index in inorder traversal
     * @return Root node of the current subtree
     */
    private TreeNode buildSubtree(int[] preorder, int start, int end) {
        // Base case: no elements to construct the subtree
        if (start > end) return null;

        // Pick current node from preorder and move index forward
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // If only one node, return it (leaf node)
        if (start == end) return root;

        // Index of root in inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Construct left and right subtrees
        root.left = buildSubtree(preorder, start, inorderIndex - 1);
        root.right = buildSubtree(preorder, inorderIndex + 1, end);

        return root;
    }
}
