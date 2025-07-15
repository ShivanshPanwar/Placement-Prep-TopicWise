import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * TreeNode represents a node in a binary tree.
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

/**
 * TreeBasic provides interactive binary tree creation and traversal methods.
 * This program is helpful for understanding tree construction and DFS/BFS traversals.
 * 
 * Supported Features:
 * - Recursive tree construction
 * - In-order, Post-order, Level-order traversal
 * - Pretty tree structure printing
 * 
 * Developed as part of Data Structures preparation for placement.
 */
public class TreeBasic {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Builds a binary tree recursively using console input.
     * Input -1 for null nodes.
     * 
     * @return TreeNode root of the constructed tree
     */
    public static TreeNode createTree() {
        System.out.print("Enter node value (-1 for NULL): ");
        int data = scanner.nextInt();
        if (data == -1) return null;

        TreeNode node = new TreeNode(data);
        System.out.println("Enter left child of " + data + ":");
        node.left = createTree();

        System.out.println("Enter right child of " + data + ":");
        node.right = createTree();

        return node;
    }

    /**
     * Performs in-order traversal (Left, Root, Right).
     *
     * @param root Root of the tree
     */
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * Performs post-order traversal (Left, Right, Root).
     *
     * @param root Root of the tree
     */
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * Performs level-order traversal (Breadth-First Search).
     *
     * @param root Root of the tree
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    /**
     * Pretty prints the binary tree in a tree-like structure.
     *
     * @param root Root of the tree
     * @param prefix Prefix for formatting
     * @param isLeft Indicates if the current node is a left child
     */
    public static void formattedTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) {
            System.out.println(prefix + (isLeft ? "|-- NULL" : "└── NULL"));
            return;
        }

        System.out.println(prefix + (isLeft ? "|-- " : "└── ") + root.data);
        formattedTree(root.left, prefix + (isLeft ? "|   " : "    "), true);
        formattedTree(root.right, prefix + (isLeft ? "|   " : "    "), false);
    }

    /**
     * Main method for execution.
     * Allows user to build a tree and visualize it with traversals.
     */
    public static void main(String[] args) {
        TreeNode root = createTree();

        System.out.println("\n📌 Formatted Binary Tree Structure:");
        formattedTree(root, "", true);

        System.out.println("\n✅ In-Order Traversal:");
        inOrder(root);

        System.out.println("\n\n✅ Post-Order Traversal:");
        postOrder(root);

        System.out.println("\n\n✅ Level-Order Traversal:");
        levelOrder(root);
    }
}
