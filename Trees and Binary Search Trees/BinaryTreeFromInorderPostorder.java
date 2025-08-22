
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
 * Approach:
 * - We know that the last element in postorder[] is always the root.
 * - Using inorder[], we can find the position of this root.
 * - All elements to the left of root in inorder[] are in the left subtree,
 *   and all elements to the right are in the right subtree.
 * - Recursively apply this logic to construct left and right subtrees.
 * - To optimize, we use a HashMap to store inorder indices for O(1) lookups.
 *
 * Complexity Analysis:
 * - Time Complexity: O(n) 
 *      (Each node is processed once, and hashmap gives O(1) index lookup)
 * - Space Complexity: O(n)
 *      (HashMap + recursion stack in worst case for skewed tree)
 */

import java.util.*;

class BinaryTreeFromInorderPostorder {

    // Map to store the index of each node in inorder traversal
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    
    // Global index tracker for postorder array
    private int postIndex;

    /**
     * Main function to build the tree from inorder and postorder traversal
     * 
     * @param inorder   Inorder traversal array (Left -> Root -> Right)
     * @param postorder Postorder traversal array (Left -> Right -> Root)
     * @return Root node of the reconstructed binary tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Step 1: Store each inorder value with its index for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Step 2: Initialize postIndex to point to the last element in postorder
        postIndex = postorder.length - 1;

        // Step 3: Build tree recursively
        return buildSubtree(postorder, 0, inorder.length - 1);
    }

    /**
     * Recursive helper function to build subtree
     * 
     * @param postorder Postorder traversal array
     * @param start     Start index in inorder array
     * @param end       End index in inorder array
     * @return Root node of the constructed subtree
     */
    private TreeNode buildSubtree(int[] postorder, int start, int end) {
        // Base case: no elements to construct subtree
        if (start > end) return null;

        // Step 1: Get the current root value from postorder
        int rootVal = postorder[postIndex--];

        // Step 2: Create the root node
        TreeNode root = new TreeNode(rootVal);

        // Step 3: If this is a leaf node, return it
        if (start == end) return root;

        // Step 4: Get index of root from inorder
        int inorderIndex = inorderMap.get(rootVal);

        // Step 5: Build right subtree first (since postorder processes right before left)
        root.right = buildSubtree(postorder, inorderIndex + 1, end);

        // Step 6: Build left subtree
        root.left = buildSubtree(postorder, start, inorderIndex - 1);

        return root;
    }
}

