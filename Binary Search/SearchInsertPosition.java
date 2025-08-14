/**
 * LeetCode 35: Search Insert Position
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                high = mid - 1;
            }
        }

        // If not found, low will be the insert position
        return low;
    }
}
