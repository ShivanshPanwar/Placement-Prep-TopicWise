/**
 * LeetCode 71: Simplify Path
 *
 * Problem:
 * Given an absolute path for a Unix-style file system, convert it to a simplified canonical path.
 *
 * Approach:
 * 1. Split the input string by "/" to extract all parts.
 * 2. Use a Stack<String> to process directory names:
 *    - Skip empty strings ("") and current directory (".") since they don't change the path.
 *    - For "..", go one level up by popping from the stack (if not empty).
 *    - For any other name, push it onto the stack as a valid directory.
 * 3. Rebuild the canonical path from the stack:
 *    - Iterate through the stack and append each directory preceded by a "/" to a StringBuilder.
 *    - If the stack is empty, the path is root "/".
 *
 * Important Points:
 * - Consecutive slashes are treated as one.
 * - "." means current directory, so it is ignored.
 * - ".." means go up one directory (pop from stack).
 * - Any other string (including "...", "....") is a valid directory name.
 *
 * Time Complexity: O(n)
 *    - We iterate through all parts once, each stack operation is O(1).
 * Space Complexity: O(n)
 *    - In the worst case, all parts are valid directories stored in the stack.
 */

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : parts) {
            if (str.equals("") || str.equals(".")) {
                // skip empty parts and current directory references
                continue;
            } else if (str.equals("..")) {
                // go up one level if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // push valid directory name
                stack.push(str);
            }
        }

        // Build canonical path from stack
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // If stack is empty, return root "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
