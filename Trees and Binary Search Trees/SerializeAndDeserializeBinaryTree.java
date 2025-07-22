// Problem: LeetCode 297 - Serialize and Deserialize Binary Tree
// Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Approach:
 * We use Preorder Traversal (Root -> Left -> Right) for serialization.
 * - For each node, append its value followed by a comma.
 * - For null nodes, append "null,".
 *
 * For deserialization, we:
 * - Split the string into values.
 * - Process the values sequentially using a Queue.
 * - Recreate the tree recursively: if value is "null", return null; else create a node and build its subtrees.
 *
 * Time Complexity: O(n), where n = number of nodes (each node is processed once in both serialization and deserialization).
 * Space Complexity: O(n) for storing the serialized data and recursion stack.
 */

import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String nodeData = queue.poll();
        if (nodeData.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(nodeData));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
