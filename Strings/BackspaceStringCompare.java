class BackspaceStringCompare {
    /**
     * Compares two strings accounting for backspaces using extra space.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    // ✅ Method 1: StringBuilder Approach (O(n) Time, O(n) Space)
    // Helper to simulate typing with backspace
    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
  // ✅ Method 2: Optimized Two-Pointer Approach (O(n) Time, O(1) Space)
 /**
     * Compares two strings accounting for backspaces using two pointers.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;

        // Move from end to start of both strings
        while (i >= 0 || j >= 0) {
            // Find next valid char in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }

            // Find next valid char in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            // Compare current valid characters
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            // One string ended before the other
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
