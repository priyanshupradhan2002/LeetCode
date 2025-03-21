//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

             // Initialize current_sum and max_sum to the first element
        int currentSum = arr[0];
        int maxSum = arr[0];
        
        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Add current element to currentSum or start a new subarray if currentSum is negative
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            
            // Update maxSum with the maximum of previous maxSum and currentSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
