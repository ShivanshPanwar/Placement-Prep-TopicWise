// Problem: Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/
// Description:
//   Given an array `height` of non-negative integers, find two vertical lines
//   that together with the x-axis form a container, holding the maximum water.
// Approach:
//   Use two-pointer technique: initialize `left` at 0 and `right` at n-1.
//   At each step, compute area = (right - left) * min(height[left], height[right]).
//   Move the pointer at the shorter line inward—this is a greedy move based on proof that
//   moving the longer line can't increase the area since width shrinks and height is still limited.
// Time Complexity: O(n) — each pointer moves at most n steps :contentReference[oaicite:1]{index=1}
// Space Complexity: O(1) — uses only constant extra variables

public class Solution {
    /**
     * @param height array of non-negative integers
     * @return maximum water the container can hold
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int currArea = width * h;
            max = Math.max(max, currArea);

            // Advance the pointer at shorter line for chance to increase height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
