/**
 * Approach:
 * This is a modified binary search for a rotated sorted array.
 * 
 * Steps:
 * 1. Use binary search to find the target.
 * 2. At each step, check if the left half (nums[low] to nums[mid]) is sorted.
 *    - If sorted, see if the target lies within it; if yes, move `high` left, else move `low` right.
 * 3. Otherwise, the right half (nums[mid] to nums[high]) is sorted.
 *    - If the target lies in this half, move `low` right; else move `high` left.
 * 4. Repeat until `low > high` or target is found.
 * 
 * Time Complexity: O(log n)  
 * Space Complexity: O(1)
 */
public class RotatedArraySearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
