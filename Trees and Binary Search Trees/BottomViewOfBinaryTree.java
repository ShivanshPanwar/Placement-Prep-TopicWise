// GFG: Bottom View of Binary Tree
// Time Complexity: O(N), Space Complexity: O(N)
// Approach: BFS with horizontal distance tracking using TreeMap

import java.util.*;

// Node class is assumed to be defined as:
/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    
    static class Pair {
        Node node;
        int hd; // Horizontal distance from root

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>(); // Sorted horizontal distance to node value
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;

            // Always update the value at the horizontal distance for bottom view
            map.put(hd, curr.data);

            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }
}
