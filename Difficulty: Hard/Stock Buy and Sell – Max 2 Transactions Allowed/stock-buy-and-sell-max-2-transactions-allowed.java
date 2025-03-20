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
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        
        // If there are fewer than two prices, no transaction is possible.
        if (n == 0) return 0;
        
        // Arrays to store the maximum profit at each point
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];
        
        // Initialize variables
        int minPrice = prices[0];
        int maxProfitSoFar = 0;
        
        // Calculate leftProfit (maximum profit achievable up to each day)
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPrice);
            leftProfit[i] = maxProfitSoFar;
        }
        
        // Initialize variables for rightProfit
        int maxPrice = prices[n - 1];
        maxProfitSoFar = 0;
        
        // Calculate rightProfit (maximum profit achievable from each day)
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfitSoFar = Math.max(maxProfitSoFar, maxPrice - prices[i]);
            rightProfit[i] = maxProfitSoFar;
        }
        
        // Now find the maximum possible profit by considering one transaction before and one after each day
        int maxTotalProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            maxTotalProfit = Math.max(maxTotalProfit, leftProfit[i] + rightProfit[i + 1]);
        }
        
        // The final answer is the maximum profit either from a single transaction or from two transactions
        return Math.max(maxTotalProfit, rightProfit[0]);
    }
}
