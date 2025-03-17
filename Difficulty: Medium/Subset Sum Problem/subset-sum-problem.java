//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // Initialize a DP array of size sum + 1
        boolean[] dp = new boolean[sum + 1];
        
        // There's always a subset with sum 0 (the empty subset)
        dp[0] = true;
        
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Traverse the DP array from right to left
            for (int j = sum; j >= arr[i]; j--) {
                // If dp[j - arr[i]] is true, then dp[j] should also be true
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        
        // Return the result for the given sum
        return dp[sum];
    }
}
