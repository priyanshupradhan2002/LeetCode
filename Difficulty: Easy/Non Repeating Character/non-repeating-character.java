//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Create an array to store the frequency of each character.
        int[] frequency = new int[256]; // assuming ASCII characters
        
        // Count the frequency of each character in the string.
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)]++;
        }

        // Now, find the first character with frequency 1.
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }

        // If no non-repeating character is found, return '$'
        return '$';
    }
}
