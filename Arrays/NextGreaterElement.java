// Problem: Next Greater Element
// Description: For each element in the array, find the next greater element to its right.
// If there is no greater element, store -1.
// Example: Input: [4, 5, 2, 10] → Output: [5, 10, 10, -1]
// Time Complexity: O(n), Space Complexity: O(n)
// Approach: Use a stack to keep track of next greater elements efficiently.

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stack to store indices

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            // If stack is empty, there is no greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push this element for the next iteration
            stack.push(nums[i]);
        }

        return result;
    }
}
