//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        int start = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int[] odd = expandAroundCenter(s, i, i);
            // Even-length palindrome
            int[] even = expandAroundCenter(s, i, i + 1);

            // Update longest palindrome if needed
            if (odd[1] > maxLength) {
                start = odd[0];
                maxLength = odd[1];
            }
            if (even[1] > maxLength) {
                start = even[0];
                maxLength = even[1];
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // `left` and `right` move one step extra, so correct the indices
        return new int[]{left + 1, right - left - 1};
    }
}
