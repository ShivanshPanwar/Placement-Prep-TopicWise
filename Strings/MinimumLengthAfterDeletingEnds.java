public class MinimumLengthAfterDeletingEnds {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char matchChar = s.charAt(left);

            // Move left pointer inward
            while (left <= right && s.charAt(left) == matchChar) {
                left++;
            }

            // Move right pointer inward
            while (right >= left && s.charAt(right) == matchChar) {
                right--;
            }
        }

        return right - left + 1;
    }
}
