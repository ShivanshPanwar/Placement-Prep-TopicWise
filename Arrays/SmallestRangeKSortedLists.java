// LeetCode: Smallest Range Covering Elements from K Lists
// Problem: You are given k sorted integer lists. Find the smallest range that includes at least one number from each of the k lists.

import java.util.*;

class SmallestRangeKSortedLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        // Min-heap to keep track of the minimum element across the lists
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Track the current maximum value in the heap
        int maxValue = Integer.MIN_VALUE;

        // Initialize heap with the first element of each list
        for (int i = 0; i < k; ++i) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[] {val, i, 0}); // {value, rowIndex, colIndex}
            maxValue = Math.max(maxValue, val);
        }

        // Result range
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Process the heap until any list gets exhausted
        while (!minHeap.isEmpty()) {
            int[] minElement = minHeap.poll();
            int minValue = minElement[0];
            int row = minElement[1];
            int col = minElement[2];

            // Update the smallest range
            if (maxValue - minValue < rangeEnd - rangeStart) {
                rangeStart = minValue;
                rangeEnd = maxValue;
            }

            // Move to the next element in the current list
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                minHeap.offer(new int[] {nextVal, row, col + 1});
                maxValue = Math.max(maxValue, nextVal);
            } else {
                break; // One list is exhausted; cannot cover all lists
            }
        }

        return new int[] {rangeStart, rangeEnd};
    }
}
