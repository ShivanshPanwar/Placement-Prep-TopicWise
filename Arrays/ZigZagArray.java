// Problem: Convert the array into Zig-Zag fashion
// Description: Convert array into a form such that a < b > c < d > e < f ...
// Expected Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public static void zigZag(int[] arr) {
        // Flag true indicates "<" relation expected,
        // false indicates ">" relation expected.
        boolean flag = true;
        int temp = 0;
        
        for (int i = 0; i <= arr.length - 2; i++) {
            if (flag) {
                // "<" relation expected
                if (arr[i] > arr[i + 1]) {
                    // Swap if not in order
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                // ">" relation expected
                if (arr[i] < arr[i + 1]) {
                    // Swap if not in order
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            // Flip flag for next pair
            flag = !flag;
        }
    }
}
