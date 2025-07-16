// GFG Problem: Left View of Binary Tree

/*
 * A Binary Tree node structure
 * class Node {
 *     int data;
 *     Node left, right;
 *
 *     Node(int item) {
 *         data = item;
 *         left = right = null;
 *     }
 * }
 */

import java.util.*;

class Solution {
    // Function to return the list containing elements of the left view of the binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        // Edge case: if the tree is empty
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Level order traversal using queue
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                // Add the first node of each level to the result (leftmost)
                if (i == 0) {
                    result.add(curr.data);
                }

                // Add left and right children to queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return result;
    }
}
