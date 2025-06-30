// Problem: Merge Sorted Array
// Link: https://leetcode.com/problems/merge-sorted-array/
// Description: Merge two sorted integer arrays, nums1 (length m+n) and nums2 (length n),
//              into a single sorted array stored in-place within nums1.
// Approach: Use three pointers (i, j, k) starting from the ends of nums1's valid portion, nums2, 
//           and the full nums1 space, respectively. Place the larger value at position k and move backwards.
// Time Complexity: O(m + n) — linear merging due to two-pointer strategy :contentReference[oaicite:1]{index=1}
// Space Complexity: O(1) — in-place modification without extra arrays

import java.util.Arrays;

public class Solution {
    /**
     * Merges nums2 into nums1 in sorted order, modifying nums1 in-place.
     *
     * @param nums1 the array containing m valid elements followed by n spaces
     * @param m     the number of valid elements in nums1
     * @param nums2 the second sorted array
     * @param n     the number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;              // last valid element in nums1
        int j = n - 1;              // last element in nums2
        int k = m + n - 1;          // end position in nums1 for merged array

        // Merge from back to avoid overwriting nums1 contents
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
