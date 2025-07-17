// LeetCode 543: Diameter of Binary Tree
// Time Complexity: O(N)
// Space Complexity: O(H) where H is height (due to recursion stack)

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

class Solution {
    private int diameter = 0;

    // ✅ Recursive DFS approach to calculate diameter
    public int diameterOfBinaryTree(TreeNode root) {
        computeHeight(root);
        return diameter;
    }

    // Helper function to compute height and update diameter
    private int computeHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);

        // Diameter at current node = leftHeight + rightHeight
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ✅ Optional: Iterative BFS + Parent Mapping (Less preferred in interviews)
    public int diameterOfBinaryTreeIterative(TreeNode root) {
        if (root == null) return 0;

        // Step 1: Find the farthest node from root using BFS
        TreeNode farthest = bfs(root);

        // Step 2: From the farthest node, find the farthest again — this gives diameter
        return bfsDepth(farthest);
    }

    // Standard BFS to get farthest node
    private TreeNode bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return node;
    }

    // BFS that returns depth from starting node (i.e., one endpoint of diameter)
    private int bfsDepth(TreeNode start) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int depth = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.add(curr.left)) queue.offer(curr.left);
                if (curr.right != null && visited.add(curr.right)) queue.offer(curr.right);
            }
        }

        return depth;
    }
}
