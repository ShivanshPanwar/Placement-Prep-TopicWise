/**
 * Leetcode Problem: 80. Remove Duplicates from Sorted Array II
 * 
 * Approach:
 * - We use a two-pointer strategy to remove extra duplicates in a sorted array,
 *   allowing at most two occurrences of each unique element.
 * - Pointer `k` keeps track of the index where the next allowed element should be placed.
 * - We iterate from the 3rd element onwards and compare with the element at index `k - 2`.
 *   - If they are not equal, it means this is at most the second occurrence, so we place it at `nums[k]`.
 *   - Otherwise, we skip it to maintain at most two occurrences.
 * 
 * Time Complexity: O(n), where n is the size of the input array.
 * Space Complexity: O(1), constant space as we modify in-place.
 */

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int k = 2; // Start from index 2, since first two elements are always allowed
        for (int i = 2; i < nums.length; i++) {
            // Check if current number is not equal to the element two places behind in result
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k; // Return the length of modified array
    }
}
