//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) 
    {
        // code here
       int sum = 0;
        
        // Calculate the sum of all elements
        for (int num : arr) {
            sum += num;
        }
        
        // If the sum is odd, it's impossible to partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        // Target sum for each subset
        int target = sum / 2;
        
        // dp[i] will be true if a subset with sum i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Sum of 0 is always possible (by taking no elements)
        
        // Loop through each element in the array
        for (int num : arr) {
            // Update dp array in reverse order to avoid overwriting results
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        // If dp[target] is true, it means we can partition the array into two subsets with equal sum
        return dp[target];
        
    }
}