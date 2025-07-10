// LeetCode Style Problem:
// Given a binary string of even length, return the minimum number of changes
// needed to make the string "beautiful".

// A string is beautiful if it can be partitioned into one or more substrings such that:
// 1. Each substring has an even length.
// 2. Each substring contains only 1's or only 0's.

// Solution: We check each adjacent pair. If both characters are different,
// one change is required to make the pair uniform (either both 0 or both 1).

class Solution {
    public int minChanges(String s) {
        int count = 0;

        // Loop through the string in steps of 2
        for (int i = 0; i < s.length() - 1; i += 2) {
            // If the pair has different characters, one change is needed
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }

        // Return total changes needed
        return count;
    }
}
