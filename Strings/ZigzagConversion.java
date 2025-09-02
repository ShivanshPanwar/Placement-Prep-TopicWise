public class ZigzagConversion {

    /**
     * Approach:
     * Use an array of StringBuilder to represent rows.
     * Iterate over characters of input string, appending each char to a "row" StringBuilder.
     * Move down the rows until the last row, then move back up to the first row,
     * repeating this zigzag pattern.
     * Finally, concatenate all rows to form the converted string.
     *
     * Time Complexity: O(n), where n is the length of the input string.
     *                  We iterate over the string once.
     * Space Complexity: O(n), for storing characters in StringBuilder arrays.
     *
     * @param s input string
     * @param numRows number of rows in zigzag pattern
     * @return converted string after zigzag transformation
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;  // edge case: no zigzag needed
        
        StringBuilder[] arr = new StringBuilder[numRows];
        
        // Initialize each row's StringBuilder
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        
        boolean goingDown = false;
        int row = 0;
        
        for (char ch : s.toCharArray()) {
            arr[row].append(ch);
            
            // Change direction when reaching first or last row
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down
            row += goingDown ? 1 : -1;
        }
        
        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : arr) {
            result.append(sb);
        }
        
        return result.toString();
    }
}
