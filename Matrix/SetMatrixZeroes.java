// Problem: LeetCode 73 - Set Matrix Zeroes
// Link: https://leetcode.com/problems/set-matrix-zeroes/

public class SetMatrixZeroes {
    /**
     * Approach:
     * - We need to set entire rows and columns to zero if any element is zero.
     * - To achieve this without affecting other elements during iteration, we:
     *      1. Use two boolean arrays: `row[]` and `col[]` to mark which rows and columns need to be zeroed.
     *      2. First pass: Traverse the matrix. If matrix[i][j] == 0, mark `row[i] = true` and `col[j] = true`.
     *      3. Second pass: Traverse again. If `row[i]` or `col[j]` is true, set `matrix[i][j] = 0`.
     * - This ensures all required rows and columns are zeroed without disturbing the marking process.
     *
     * Time Complexity: O(m * n), where m = number of rows and n = number of columns.
     * Space Complexity: O(m + n) for the additional `row[]` and `col[]` arrays.
     */
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // First pass: identify rows and columns that should be zeroed
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Second pass: update matrix based on markers
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
