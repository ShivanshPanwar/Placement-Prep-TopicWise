public class JumpGameGreedy {

    /**
     * Determines if it's possible to reach the last index in the array.
     * Each element represents the maximum jump length from that position.
     *
     * Greedy Strategy:
     * Track the number of steps you can still take.
     * Always try to extend the step count when a higher value is found.
     *
     * @param nums array of non-negative integers representing max jump lengths
     * @return true if you can reach the last index, otherwise false
     */
    public boolean canJump(int[] nums) {
        // Start with the maximum jump you can make from the first index
        int steps = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Use one step to move to the current index
            steps--;

            // If no steps left, we can't move further
            if (steps < 0) {
                return false;
            }

            // If current value allows a farther jump, update steps
            if (nums[i] > steps) {
                steps = nums[i];
            }
        }

        // If we exit the loop, it means we reached the end
        return true;
    }
}
