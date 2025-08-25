import java.util.*;

/**
 * LeetCode Problem: Longest Increasing Subsequence (LIS)
 * 
 * Approach:
 * 1. Remove duplicates from the input array and sort the unique elements 
 *    to create a strictly increasing sequence (arr2).
 * 2. Use Longest Common Subsequence (LCS) dynamic programming approach 
 *    between the original array (arr1) and the sorted unique array (arr2).
 * 
 * Time Complexity: O(n^2), where n is the length of the input array.
 * Space Complexity: O(n^2) for the DP table.
 */
public class LongestIncreasingSubsequence {

    /**
     * Main function to calculate the length of LIS.
     * @param nums input array of integers
     * @return length of the longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        // Step 1: Store unique integers in a HashSet
        HashSet<Integer> unique = new HashSet<>();
        for (int x : nums) {
            unique.add(x);
        }

        // Step 2: Create a sorted array of unique integers
        int[] arr2 = new int[unique.size()];
        int index = 0;
        for (int x : unique) {
            arr2[index++] = x;
        }
        Arrays.sort(arr2);

        // Step 3: Compute LCS between nums and arr2
        return lis(nums, arr2);
    }

    /**
     * Function to calculate LCS between two arrays.
     * @param arr1 original input array
     * @param arr2 sorted unique array
     * @return LCS length, which is LIS length
     */
    private int lis(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];

        // DP computation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
