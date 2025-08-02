import java.util.*;

/**
 * LeetCode Pascal's Triangle (Easy)
 *
 * Given an integer `numRows`, generate the first `numRows` of Pascal's Triangle.
 * In Pascal's Triangle, each number is the sum of the two numbers directly above it.
 */
class Solution {

    /**
     * Generates the first `numRows` of Pascal's Triangle.
     *
     * @param numRows The number of rows to generate.
     * @return A list of lists representing Pascal's Triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First row is always [1]
        triangle.add(Arrays.asList(1));

        // Generate rows from 2nd row onwards
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements of a row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two values from the previous row
                    int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(sum);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
