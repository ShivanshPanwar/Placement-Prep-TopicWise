/**
 * Removes all occurrences of 'val' from the array in-place,
 * returns the new length of the modified array.
 *
 * @param nums the input array to modify
 * @param val the element to remove completely
 * @return the number of elements remaining after removal
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
