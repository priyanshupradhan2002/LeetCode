//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        
        // Traverse both strings from the end to the beginning
        while (i >= 0 || j >= 0 || carry != 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0; // Get current bit of s1 or 0 if out of bounds
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0; // Get current bit of s2 or 0 if out of bounds
            
            // Sum the bits and carry
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2); // Append the sum's bit (0 or 1)
            carry = sum / 2; // Update the carry for the next addition
            
            // Move to the next bits
            i--;
            j--;
        }
        
        // Reverse the result to get the correct order
        result.reverse();
        
        // Remove leading zeros, if any
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        // If all bits are 0, we should return "0"
        if (startIndex == result.length()) {
            return "0";
        }
        
        // Return the result after removing leading zeros
        return result.substring(startIndex).toString();
    }
}