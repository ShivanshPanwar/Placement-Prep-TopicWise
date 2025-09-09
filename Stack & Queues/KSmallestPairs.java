import java.util.*;

/**
 * Problem: Find k pairs with the smallest sums.
 * 
 * Approach:
 * 1. Use a Min-Heap (PriorityQueue) to always get the next smallest sum pair.
 * 2. Start by pushing (nums1[i], nums2[0]) for all i < k (or nums1.length).
 * 3. Repeatedly extract the smallest pair (i, j) from the heap:
 *      - Add (nums1[i], nums2[j]) to the result.
 *      - Push the next element in the same row: (i, j+1) if it exists.
 * 4. Repeat until we collect k pairs or the heap is empty.
 * 
 * Time Complexity: O(k log n)
 *   - Each heap operation (offer/poll) takes O(log n), where n = min(k, nums1.length).
 *   - We perform at most k extractions, so total is O(k log n).
 * 
 * Space Complexity: O(n)
 *   - Heap stores at most min(k, nums1.length) elements at any time.
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Min-Heap: stores {sum, index in nums1, index in nums2}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Push first element of each row (nums1[i] + nums2[0])
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract the k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Push next element in the same row (i, j+1)
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

            k--;
        }

        return result;
    }
}
