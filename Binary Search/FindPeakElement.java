// Problem: Leetcode 162 - Find Peak Element
// Approach: Binary Search (Efficient O(log n) approach)

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        // Binary Search Logic:
        // A peak is an element that is greater than its neighbors.
        // If mid > mid+1, it means the peak lies in the left half (including mid).
        // If mid < mid+1, it means the peak lies in the right half.

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check slope direction
            if (nums[mid] > nums[mid + 1]) {
                // Descending slope — potential peak on the left
                high = mid;
            } else {
                // Ascending slope — move right
                low = mid + 1;
            }
        }

        // At this point, low == high and pointing to a peak element
        return low;
    }
}
