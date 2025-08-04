// Greedy solution to Jump Game II problem on LeetCode
// Time Complexity: O(n), Space Complexity: O(1)

class JumpGameII {
    public int jump(int[] nums) {
        
        // Edge case: if array has 1 or fewer elements, no jump needed
        if (nums.length <= 1) {
            return 0;
        }

        // Initialize steps we can take, minimum jumps, and max reachable index
        int steps = nums[0];
        int minSteps = 1;
        int maxReach = nums[0];

        // Traverse the array starting from index 1
        for (int i = 1; i < nums.length; i++) {

            // If we reach the end of array, return jumps made
            if (i == nums.length - 1) {
                return minSteps;
            }

            // Update the farthest we can reach from this index
            maxReach = Math.max(maxReach, nums[i] + i);

            // Use a step to move forward
            steps--;

            // If no more steps left
            if (steps == 0) {
                minSteps++; // Take another jump
                steps = maxReach - i; // Recalculate steps from current index

                // If we can't move forward from here, return -1 (shouldn't happen in valid input)
                if (steps <= 0) return -1;
            }
        }

        return -1;
    }
}
