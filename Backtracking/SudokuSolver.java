/**
 * LeetCode 37: Sudoku Solver
 *
 * Approach:
 * - Uses Backtracking (DFS) to fill the empty cells of the Sudoku board.
 * - We iterate over each cell. If a cell is empty ('.'), we try placing digits '1' to '9'.
 * - For each digit, we check if it is valid in the current row, column, and 3x3 subgrid.
 * - If valid, we place the digit and recursively attempt to solve the rest of the board.
 * - If the board cannot be solved with that digit, we backtrack and try the next one.
 * - When we reach beyond the last cell, the Sudoku is solved.
 *
 * Time Complexity:
 * - In the worst case, O(9^(m)) where m is the number of empty cells.
 *   Each empty cell has up to 9 possibilities, though pruning reduces the search space.
 * - In practice, it runs fast due to constraints and early pruning.
 *
 * Space Complexity:
 * - O(1) extra space (the board is modified in place).
 * - O(n^2) recursion stack in the worst case (n = 9), effectively constant.
 */

class SudokuSolver {
    private char[][] board;
    private final int SIZE = 9;

    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0, 0); // Start the backtracking process
    }

    private boolean solve(int row, int col) {
        // Move to the next row when the column limit is reached
        if (col == SIZE) {
            row++;
            col = 0;
        }

        // If we've filled all rows, the board is solved
        if (row == SIZE) {
            return true;
        }

        // Skip non-empty cells
        if (board[row][col] != '.') {
            return solve(row, col + 1);
        }

        // Try placing digits 1–9
        for (int num = 1; num <= SIZE; num++) {
            char digit = (char) (num + '0');
            if (isValid(row, col, digit)) {
                board[row][col] = digit;
                if (solve(row, col + 1)) {
                    return true; // Continue solving
                }
                // Backtrack
                board[row][col] = '.';
            }
        }

        return false; // No valid number fits here
    }

    // Check if placing a digit is valid
    private boolean isValid(int row, int col, char digit) {
        return !usedInRow(row, digit) &&
               !usedInCol(col, digit) &&
               !usedInSubGrid(row, col, digit);
    }

    private boolean usedInRow(int row, char digit) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == digit) return true;
        }
        return false;
    }

    private boolean usedInCol(int col, char digit) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == digit) return true;
        }
        return false;
    }

    private boolean usedInSubGrid(int row, int col, char digit) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) return true;
            }
        }
        return false;
    }
}
