//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        // Arrays.sort(arr);
        // int min=arr[0];
        // int max=arr[arr.length-1];
        // return ((max-k)-(min+k));
        
         // Sort the array to make the comparison easier
        Arrays.sort(arr);

        int n = arr.length;

        // Initialize the difference with the difference between max and min elements
        int diff = arr[n - 1] - arr[0];

        // Traverse the array and calculate the possible minimum difference
        for (int i = 1; i < n; i++) {
            // Calculate the potential max and min heights after operations
            int maxHeight = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            int minHeight = Math.min(arr[0] + k, arr[i] - k);

            // Update the minimum difference
            diff = Math.min(diff, maxHeight - minHeight);
        }

        return diff;
    }
}