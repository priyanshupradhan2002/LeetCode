class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};  // Count of 'a', 'b', and 'c'
        int left = 0, total = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;  // Increase count of current character

            // When all 'a', 'b', and 'c' exist in the window, count valid substrings
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += s.length() - right; // All substrings from left to end are valid
                count[s.charAt(left) - 'a']--; // Shrink window from left
                left++;
            }
        }
        return total;
    }
}
