import java.util.*;

/**
 * Problem: LeetCode 52 - N-Queens II
 Link: https://leetcode.com/problems/n-queens-ii/
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Approach:
 * - Use backtracking to place queens row by row.
 * - For each row, try placing a queen in every column, but only if:
 *      1. No other queen is in the same column (vertical check),
 *      2. No queen is on the left diagonal,
 *      3. No queen is on the right diagonal.
 * - If a position is safe, place the queen and recursively attempt to place queens in the next row.
 * - When all n rows are filled, increment the solution count.
 * - After exploring a column, backtrack by removing the queen (resetting the board cell).
 *
 * Complexity Analysis:
 * - Time Complexity: O(N!) 
 *      - Each row requires checking for valid positions, and recursion explores all valid permutations.
 * - Space Complexity: O(N^2) 
 *      - Board of size n x n for queen placements.
 *      - Recursion stack of depth O(N).
 */
public class NQueensII {
    boolean[][] board;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return helper(0, n);
    }

    // Checks if a queen can be placed at board[row][col]
    private boolean canPlaceQueen(int row, int col) {
        // Check vertical column
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }
        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    // Recursive helper to place queens row by row
    private int helper(int row, int n) {
        int count = 0;
        if (row == n) {
            return 1; // Found a valid arrangement
        }

        for (int col = 0; col < board[0].length; col++) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = true;
                count += helper(row + 1, n);
                board[row][col] = false; // Backtrack
            }
        }
        return count;
    }
}
