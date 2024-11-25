//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) 
    {
           if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // Initialize the variables to track the maximum and minimum product up to the current index
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            // If the current element is negative, swap maxProduct and minProduct
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            // Calculate the maximum and minimum products at the current index
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);
            
            // Update the result with the maximum product found so far
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}