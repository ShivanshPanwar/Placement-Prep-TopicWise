// Problem: Trapping Rain Water
// Link: https://leetcode.com/problems/trapping-rain-water/
// Description:
//   Given an elevation map represented by non-negative integers, compute how much water it can trap after raining.
// Approach:
//   Use a two-pointer strategy:
//     - `left` and `right` start at ends, with `leftMax` and `rightMax` tracking max heights seen.
//     - Move the pointer at the lower height inward, trapping water: (currentMax - height[pos]).
// Time Complexity: O(n), single pass through array ([takeuforward](turn0search2); [Medium](turn0search3); [ProgrammersCareer](turn0search12))
// Space Complexity: O(1), constant extra space

public class Solution {
    /**
     * Calculates total trapped water between bars.
     *
     * @param height elevation map as integer array
     * @return total volume of trapped water
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
