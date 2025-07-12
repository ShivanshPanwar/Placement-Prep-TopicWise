import java.util.PriorityQueue;

public class KthLargestElement_PriorityQueue {
    public int findKthLargest(int[] nums, int k) {
        // Min Heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse through all numbers
        for (int num : nums) {
            minHeap.offer(num); // Add current number to min heap

            // If size exceeds k, remove the smallest element (heap top)
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Top of the min heap is the Kth largest element
        return minHeap.peek();
    }
