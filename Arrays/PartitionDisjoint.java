class PartitionDisjoint {
    /**
     * Approach:
     * 1. We need to partition the array into two contiguous subarrays: left and right,
     *    such that every element in left <= every element in right.
     * 2. We maintain:
     *      - leftMax: the maximum value in the left partition so far
     *      - max: the maximum value seen so far in the whole array
     *      - partitionIndex: the index where the left partition ends
     * 3. While iterating:
     *      - Update the overall max at each step
     *      - If the current number is smaller than leftMax, it means this element
     *        must be part of the left partition. We update partitionIndex to current index
     *        and set leftMax = max (extend left partition)
     * 4. At the end, partitionIndex + 1 gives the size of the left partition.
     *
     * Complexity:
     * Time Complexity: O(n) – single pass through the array
     * Space Complexity: O(1) – constant extra variables
     */
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int max = nums[0];
        int partitionIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);

            if (leftMax > nums[i]) {
                partitionIndex = i;
                leftMax = max;
            }
        }
        return partitionIndex + 1;
    }
}
