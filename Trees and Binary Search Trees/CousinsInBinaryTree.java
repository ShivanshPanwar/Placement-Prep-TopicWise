import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution class to determine if two nodes in a binary tree are cousins.
 * 
 * Cousins are nodes that:
 * 1. Are on the same level (depth).
 * 2. Have different parents.
 * 
 * Approach:
 * - Perform level-order traversal (BFS) using a queue.
 * - For each level, check if both `x` and `y` are found.
 * - Also ensure they are not siblings (i.e., same parent).
 * 
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(N) for the queue in the worst case.
 */
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Check if x and y are siblings (same parent)
                if (curr.left != null && curr.right != null) {
                    int leftVal = curr.left.val;
                    int rightVal = curr.right.val;
                    if ((leftVal == x && rightVal == y) || (leftVal == y && rightVal == x)) {
                        return false; // They are siblings, not cousins
                    }
                }

                // Add children to queue and mark if x or y is found
                if (curr.left != null) {
                    queue.offer(curr.left);
                    if (curr.left.val == x) xFound = true;
                    if (curr.left.val == y) yFound = true;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    if (curr.right.val == x) xFound = true;
                    if (curr.right.val == y) yFound = true;
                }
            }

            // If both x and y are found at the same level, they are cousins
            if (xFound && yFound) {
                return true;
            }
            // If only one is found at this level, they can't be cousins
            if (xFound || yFound) {
                return false;
            }
        }

        return false;
    }
}
