// LeetCode #69: Sqrt(x)
// Approach: Binary Search to find the integer part of the square root

public class SqrtUsingBinarySearch {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long ans = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                ans = mid;       // store the floor value
                start = mid + 1; // move right
            } else {
                end = mid - 1;   // move left
            }
        }

        return (int) ans;
    }
}
