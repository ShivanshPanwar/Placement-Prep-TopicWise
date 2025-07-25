// Problem: LeetCode 54 - Spiral Matrix
// Link: https://leetcode.com/problems/spiral-matrix/

import java.util.*;

public class SpiralMatrix {
    /**
     * Approach:
     * - We use four boundary pointers: top, bottom, left, right.
     * - Traverse the matrix in layers:
     *      1. Left → Right (along the top boundary), then move `top` down.
     *      2. Top → Bottom (along the right boundary), then move `right` left.
     *      3. Right → Left (along the bottom boundary), then move `bottom` up (if `top <= bottom`).
     *      4. Bottom → Top (along the left boundary), then move `left` right (if `left <= right`).
     * - Repeat until all boundaries cross, meaning all elements are covered.
     * - This method ensures each element is added to the result exactly once.
     *
     * Time Complexity: O(m * n), where m = number of rows and n = number of columns,
     *                  since each element is visited once.
     * Space Complexity: O(1) excluding the output list, as we use only boundary pointers.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, top = 0;
        int right = col - 1, bottom = row - 1;
        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {
            // 1. Traverse from left to right
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            // 2. Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // 3. Traverse from right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4. Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

}
