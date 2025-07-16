// GFG: Top View of Binary Tree
// Time Complexity: O(N), Space Complexity: O(N)
// Approach: BFS traversal using TreeMap to store the first node at each horizontal distance

import java.util.*;

/*
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {

    static class Pair {
        Node node;
        int hd; // Horizontal Distance from root

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return a list of nodes visible from the top view (left to right)
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>(); // Sorted by horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;

            // Only add the first encountered node at each horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

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
