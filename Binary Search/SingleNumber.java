/**
 * LeetCode Problem: Single Element in a Sorted Array
 * 
 * Given a sorted array where every element appears exactly twice 
 * except for one element that appears only once, 
 * find that single element in O(log n) time and O(1) space.
 * 
 * Approach:
 * Binary Search - At every step, we ensure that we are looking 
 * at the "first" index of a pair (even index). 
 * If nums[mid] == nums[mid + 1], then the single element lies 
 * in the right half; otherwise, it lies in the left half.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class SingleNumber {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even (points to first in a pair)
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair starts at mid, single element is in right half
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } 
            // Otherwise, single element is in left half
            else {
                high = mid;
            }
        }

        // Low will point to the single element
        return nums[low];
    }
}
