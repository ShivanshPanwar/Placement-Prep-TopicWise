/**
 * Top K Frequent Elements
 * -----------------------
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in ANY order.
 *
 * Example:
 *   Input: nums = [1,1,1,2,2,3], k = 2
 *   Output: [1,2]
 *
 * Approach:
 *   1. Count the frequency of each number using a HashMap.
 *   2. Use a Min-Heap (PriorityQueue) of size k to store elements by frequency.
 *   3. If heap size exceeds k, remove the least frequent element.
 *   4. Extract elements from the heap for the final result.
 *
 * Time Complexity: O(n log k)  (n = number of elements, k = top elements to return)
 * Space Complexity: O(n)
 */

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap to store entries by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        // Step 3: Maintain only top k elements in heap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove least frequent element
            }
        }

        // Step 4: Extract results from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
