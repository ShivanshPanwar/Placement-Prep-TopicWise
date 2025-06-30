// Problem: 3Sum
// Link: https://leetcode.com/problems/3sum/
// Description: Given an integer array nums, return all unique triplets [a, b, c]
// such that a + b + c == 0, with no duplicate triplets in the result.
// Approach: Sort the array, then use a fixed pointer + two-pointer (left, right) approach.
//              - Skip duplicates for `i`, and for each `i`, use two-pointer scan to find pairs.
//              - Adjust pointers based on sum < 0 or > 0.
// Time Complexity: O(n²)
// Space Complexity: O(n) due to result list (Set for deduplication uses extra space)

package arrays.threesum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // sort array for two-pointer strategy
        
        Set<List<Integer>> resultSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Optimization: if current number > 0, no triplet can sum to zero
            if (nums[i] > 0) break;

            // Skip duplicate values for `i`
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Convert set to list for final output
        return new ArrayList<>(resultSet);
    }
}
