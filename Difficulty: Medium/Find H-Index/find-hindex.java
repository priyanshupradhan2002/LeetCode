//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // Sort the array in non-decreasing order
        Arrays.sort(citations);
        
        // Iterate through the sorted array to find the h-index
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            // If the number of citations at the current index is greater than or equal to 
            // the number of papers left (n - i), then this index can be a potential h-index
            if (citations[i] >= n - i) {
                return n - i; // The h-index is n - i
            }
        }
        
        return 0; // If no valid h-index is found
    }
}