/**
 * SearchMatrixII
 * 
 * Problem:
 * Given an m x n matrix where each row is sorted in ascending order from left to right 
 * and each column is sorted in ascending order from top to bottom, 
 * write an efficient algorithm to search for a target value.
 * 
 * Approach:
 * - Use the "staircase search" method starting from the top-right corner.
 * - At each step:
 *      If the current element == target → return true.
 *      If the current element > target → move left (colIndex--).
 *      If the current element < target → move down (rowIndex++).
 * - This works because:
 *      From the top-right corner, moving left decreases the value,
 *      and moving down increases the value.
 * 
 * Time Complexity: O(m + n)  // At most m + n steps in worst case
 * Space Complexity: O(1)     // No extra space used
 */

public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowIndex = 0;         // Start at first row
        int colIndex = cols - 1;  // Start at last column (top-right corner)

        // Loop until we go out of matrix bounds
        while (rowIndex < rows && colIndex >= 0) {
            int element = matrix[rowIndex][colIndex];

            if (element == target) {
                return true; // Found target
            } else if (element < target) {
                rowIndex++; // Move down (need larger value)
            } else {
                colIndex--; // Move left (need smaller value)
            }
        }
        return false; // Target not found
    }
}
