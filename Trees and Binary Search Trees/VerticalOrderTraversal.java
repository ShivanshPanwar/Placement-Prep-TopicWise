import java.util.*;
import javafx.util.Pair; // If not using JavaFX, create your own Pair class

/**
 * LeetCode #987: Vertical Order Traversal of a Binary Tree
 * 
 * Approach:
 * - Use DFS to assign each node a column (distance) and row (level).
 * - Track nodes in a TreeMap with column as key and list of (row, value) pairs.
 * - After DFS, sort each column by row, then value if rows are equal.
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        List<List<Integer>> bigList = new ArrayList<>();

        if (root == null) return bigList;

        helper(map, root, 0, 0); // DFS traversal to fill map

        for (Integer key : map.keySet()) {
            List<Pair<Integer, Integer>> list = map.get(key);

            // Sort by level (row), then by value
            list.sort((a, b) -> 
                a.getKey().equals(b.getKey()) 
                    ? a.getValue() - b.getValue() 
                    : a.getKey() - b.getKey()
            );

            List<Integer> smallList = new ArrayList<>();
            for (Pair<Integer, Integer> pair : list) {
                smallList.add(pair.getValue());
            }

            bigList.add(smallList);
        }

        return bigList;
    }

    // DFS helper to fill TreeMap: distance (column) -> List of (level, value) pairs
    public void helper(TreeMap<Integer, List<Pair<Integer, Integer>>> map, TreeNode root, int level, int distance) {
        if (root == null) return;

        map.putIfAbsent(distance, new ArrayList<>());
        map.get(distance).add(new Pair<>(level, root.val));

        helper(map, root.left, level + 1, distance - 1);  // Left child
        helper(map, root.right, level + 1, distance + 1); // Right child
    }
}
