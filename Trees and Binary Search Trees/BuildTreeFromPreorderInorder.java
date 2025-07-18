/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal 
 * of a binary tree and inorder is the inorder traversal, construct and return the binary tree.
 *
 * Approach:
 * 1. Preorder traversal always gives the root node first.
 * 2. Using the root value, we find its position in the inorder array (this divides the tree into left and right subtrees).
 * 3. We recursively build the left and right subtrees using the corresponding parts of the inorder array.
 * 4. We maintain a HashMap (value -> index) for inorder traversal to find positions in O(1).
 *
 * Complexity Analysis:
 * - Time Complexity: O(n), because each node is processed once and we find the root index in O(1) using the map.
 * - Space Complexity: O(n), for the HashMap and recursion stack in the worst case.
 *
 * Example:
 * Input:
 * preorder = [3,9,20,15,7]
 * inorder  = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */

import java.util.HashMap;

public class BuildTreeFromPreorderInorder {

    // Map to quickly find the index of each node's value in the inorder traversal
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    // Global index to track the current position in the preorder array
    private int preorderIndex = 0;

    /**
     * Constructs a binary tree from given preorder and inorder traversals.
     *
     * @param preorder the preorder traversal of the binary tree
     * @param inorder  the inorder traversal of the binary tree
     * @return the root node of the reconstructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Populate the map with inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Recursively build the binary tree using helper
        return buildSubtree(preorder, 0, preorder.length - 1);
    }

    /**
     * Recursive helper method to construct the subtree.
     *
     * @param preorder the preorder traversal array
     * @param start    the starting index in inorder traversal
     * @param end      the ending index in inorder traversal
     * @return the root of the constructed subtree
     */
    private TreeNode buildSubtree(int[] preorder, int start, int end) {
        // Base case: no subtree to construct
        if (start > end) {
            return null;
        }

        // Select the current root value from preorder
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // If there's only one node, return it
        if (start == end) {
            return root;
        }

        // Find the index of root value in inorder traversal
        int inorderIndex = inorderIndexMap.get(rootValue);

        // Recursively build the left and right subtrees
        root.left = buildSubtree(preorder, start, inorderIndex - 1);
        root.right = buildSubtree(preorder, inorderIndex + 1, end);

        return root;
    }
}
