//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to compute the longest prefix which is also suffix (LPS) array for KMP
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        // Preprocessing the pattern to fill LPS array
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Function to check if two strings are rotations using KMP
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;  // Strings of different lengths cannot be rotations
        }
        
        // Concatenate s1 with itself
        String doubleS1 = s1 + s1;

        // Apply KMP to check if s2 is a substring of doubleS1
        int[] lps = computeLPSArray(s2);
        int i = 0, j = 0;

        while (i < doubleS1.length()) {
            if (s2.charAt(j) == doubleS1.charAt(i)) {
                i++;
                j++;

                // If we have matched all characters of s2
                if (j == s2.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS array to skip comparisons
                } else {
                    i++;
                }
            }
        }

        return false;
    }
}
