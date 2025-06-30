// Problem: Find Peak Element
// Link: https://leetcode.com/problems/find-peak-element/
// Description:
//   Given an array `nums`, find any index `i` such that `nums[i]` is a peak.
//   A peak is defined as `nums[i] > nums[i+1]` and `nums[i] > nums[i-1]`, 
//   considering elements beyond the edges as negative infinity.
// Approach:
//   Use a modified binary search: compare `nums[mid]` with `nums[mid+1]`.
//   - If `nums[mid] > nums[mid+1]`, a peak lies in the left half (including `mid`).
//   - Else, it lies in the right half.
//   Continue until `left == right`.
// Time Complexity: O(log n), Space Complexity: O(1) :contentReference[oaicite:1]{index=1}

public class peakElement {
    /**
     * Finds a peak element's index in an unsorted array.
     *
     * @param nums input array
     * @return index of any peak element
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Descending slope => peak in left including mid
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                // Ascending slope => peak in right excluding mid
                left = mid + 1;
            }
        }

        return left;  // left == right, pointing at a peak
    }
}
