/**
 * LeetCode 4: Median of Two Sorted Arrays
 *
 * Approach:
 * - We are given two sorted arrays nums1 and nums2.
 * - First, merge them into a single sorted array using a two-pointer approach:
 *      - i -> pointer for nums1
 *      - j -> pointer for nums2
 *      - k -> pointer for merged array
 * - Compare elements from both arrays and place the smaller one into merged[].
 * - Once one array is exhausted, append the remaining elements of the other array.
 * - Finally, find the median of the merged sorted array:
 *      - If length is odd, median is the middle element.
 *      - If length is even, median is the average of the two middle elements.
 *
 * Time Complexity: O(m + n)
 *      - We traverse both arrays once to merge them.
 * Space Complexity: O(m + n)
 *      - We use an extra merged array to store all elements.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays into one
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Append remaining elements from nums1 (if any)
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        // Append remaining elements from nums2 (if any)
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        // Find and return median of the merged array
        return findMedian(merged);
    }

    /**
     * Helper method to find median of a sorted array.
     * @param arr - merged sorted array
     * @return median value as double
     */
    private double findMedian(int[] arr) {
        int n = arr.length;
        // Odd length: middle element
        if (n % 2 != 0) {
            return arr[n / 2];
        }
        // Even length: average of two middle elements
        return (arr[n / 2] + arr[(n / 2) - 1]) / 2.0;
    }
}
