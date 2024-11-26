//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // Function to find the maximum subarray sum using Kadane’s algorithm
    private int kadane(int arr[]) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Function to find the minimum subarray sum using a similar method to Kadane’s
    private int minKadane(int arr[]) {
        int minSoFar = arr[0];
        int minEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }

    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Case 1: Find the maximum sum using Kadane's algorithm (non-circular subarray)
        int maxKadane = kadane(arr);

        // Case 2: Find the total sum of the array and the minimum subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        // Case 3: Find the minimum subarray sum
        int minKadane = minKadane(arr);

        // If total sum is equal to minimum subarray sum, it means all elements are negative,
        // so we return the result of Kadane's algorithm (non-circular max sum).
        if (totalSum == minKadane) {
            return maxKadane;
        }

        // Case 4: Find the maximum circular subarray sum
        int maxCircular = totalSum - minKadane;

        // The result will be the maximum of the non-circular max and circular max sums
        return Math.max(maxKadane, maxCircular);
    }

}
