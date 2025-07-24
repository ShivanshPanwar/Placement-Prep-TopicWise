// LeetCode 240: Search a 2D Matrix II
// Link: https://leetcode.com/problems/search-a-2d-matrix-ii/

/**
 * Approach:
 * - Start from the top-right element.
 * - If current element equals target → found, return true.
 * - If current element > target → move left (col--).
 * - If current element < target → move down (row++).
 * 
 * Time Complexity: O(m + n), where m = number of rows, n = number of columns.
 * Space Complexity: O(1) (no extra space used).
 */
class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int element = matrix[row][col];

            if (element == target) {
                return true;
            } else if (element > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        return false;
    }
}
