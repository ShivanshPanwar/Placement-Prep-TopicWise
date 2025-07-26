/**
 * LeetCode 867: Transpose Matrix
 *
 * Approach:
 * - A transpose of a matrix flips it over its diagonal, switching the row and column indices.
 * - Create a new matrix `ans` of size [number of columns][number of rows].
 * - Iterate through the original matrix, and for each element at (i, j),
 *   place it in (j, i) in the new matrix.
 *
 * Time Complexity: O(m * n) — we visit every element once.
 * Space Complexity: O(m * n) — for the new transposed matrix.
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
