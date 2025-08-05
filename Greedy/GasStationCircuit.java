// Problem: Gas Station (Leetcode 134)
// Approach: Greedy Algorithm
 // Implemented a linear-time greedy algorithm to find the valid starting gas station.
// Checks if total gas is enough before attempting the solution.
// Resets the start index when current gas falls below zero.
// Time Complexity: O(n)
 // Space Complexity: O(1)

class GasStationCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0, totCost = 0;

        // Step 1: Check if completing the circuit is even possible
        for (int i = 0; i < gas.length; i++) {
            totGas += gas[i];
            totCost += cost[i];
        }
        if (totCost > totGas) return -1; // Not possible

        // Step 2: Try to find the starting index
        int currGas = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];

            // If gas drops below 0, this cannot be the start
            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        return start;
    }
}
