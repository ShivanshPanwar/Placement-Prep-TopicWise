// LeetCode: Maximum Sum of Pairs With Equal Digit Sum
// Problem: Given an array of integers, return the maximum sum of a pair of numbers such that both have the same digit sum.

import java.util.*;

class MaximumSumWithEqualDigitSum {
    public int maximumSum(int[] nums) {
        // Map to store list of numbers with same digit sum
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int x : nums) {
            int sum = 0, temp = x;
            while (temp > 0) {
                sum += (temp % 10);
                temp /= 10;
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(x);
        }

        int maxSum = -1;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            if (list.size() >= 2) {
                Collections.sort(list);
                int size = list.size();
                maxSum = Math.max(maxSum, list.get(size - 1) + list.get(size - 2));
            }
        }

        return maxSum;
    }

    /*
    // Optimal approach using fixed-size digit sum map
    public int maximumSum(int[] nums) {
        int[] mp = new int[82]; // Max digit sum = 9*9 = 81
        Arrays.fill(mp, -1);
        int ans = -1;

        for (int num : nums) {
            int sumDigits = 0, temp = num;
            while (temp > 0) {
                sumDigits += temp % 10;
                temp /= 10;
            }

            if (mp[sumDigits] != -1)
                ans = Math.max(ans, num + mp[sumDigits]);

            mp[sumDigits] = Math.max(mp[sumDigits], num);
        }

        return ans;
    }
    */
}
