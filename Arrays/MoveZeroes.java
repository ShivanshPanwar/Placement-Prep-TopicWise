// Problem: Move Zeroes
// Link: https://leetcode.com/problems/move-zeroes/
// Description: Move all 0s to the end while maintaining the relative order of non-zero elements.
// Time Complexity: O(n), Space Complexity: O(1)

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastIndex = 0;

        // Optimal approach: shift non-zero elements to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastIndex++] = nums[i];
            }
        }

        // Fill the remaining part with zeros
        for (int i = lastIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*
    // 2nd Approach: Bubble sort-style pushing zeroes to end (Less optimal)
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    // Swap zero with next non-zero
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    */
}
